package agileboard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

import errorutility.CardMoveNotAllowed;
import errorutility.NoCardsMovementFoundException;

public class Iteration {
	
	private List<Card> cards = new ArrayList<>();
	private Set<Column> columns = new HashSet<>();
	
	private Stack<IterationMove> moves = new Stack<>();
	
	public void addCard(Card card){
		addCard(card, StatusClass.START);
	}
	
	private void addCard(Card card, String colId){
		card.setCurrentColumnId(colId);
		this.getCards().add(card);
	}

	public int velocity(){
		int points = 0;
		points = cards.stream().filter(card->StatusClass.DONE.equals(card.getCurrentColumnId())).mapToInt(card -> card.getEstimatePoints()).sum();
		
		return points;
	}
	
	public void undoLastMove(){
		IterationMove lastMove = getMoves().pop();
		
		if(lastMove == null){
			throw new NoCardsMovementFoundException("No cards found to move.");
		}
		
		Column toColumn = getColumn(lastMove.getFromColumnName());
		
		int cardEstimates = lastMove.getCard().getEstimatePoints();
		
		isMoveAllowed(toColumn, cardEstimates);
		
		lastMove.getCard().setCurrentColumnId(toColumn.getId());
		
	}
	
	public void moveCard(Card card, String toColumn){
		String fromColumn = card.getCurrentColumnId();
		
		Column newCol = getColumn(toColumn);
		int newPoints = card.getEstimatePoints();
		
		isMoveAllowed(newCol, newPoints);
		
		card.setCurrentColumnId(toColumn);
		
		getMoves().push(new IterationMove(card, fromColumn));
		
	}

	private void isMoveAllowed(Column toColumn, int additionalPoints) {
		int colLimit = toColumn.getLimit();
		int currentEstimates = getCurrentEstimatesPointsForColumn(toColumn);
		if(colLimit > 0 && colLimit <= (currentEstimates + additionalPoints)){
			throw new CardMoveNotAllowed("Cannot move. Defined Limit : " + colLimit + " , Exceeds current estimate points allocation : " + (currentEstimates+additionalPoints));
		}
	}
	
	private int getCurrentEstimatesPointsForColumn(Column toColumn) {
		
		return cards.stream().filter(card->toColumn.getId().equals(card.getCurrentColumnId())).mapToInt(card -> card.getEstimatePoints()).sum();
	}

	public Column getColumn(String id){
		Column column = ((Map<String,Column>)  getColumns().stream().collect(Collectors.toMap(col -> col.getId().toUpperCase(), col->col))).get(id.toUpperCase()); 
		return column;
	}
	
	public void updateColumnLimit(String id, int newLimit){
		Column column = ((Map<String,Column>)  getColumns().stream().collect(Collectors.toMap(col -> col.getId().toUpperCase(), col->col))).get(id.toUpperCase()); 
		getColumns().remove(column);
		column.setLimit(newLimit);
		getColumns().add(column);
	}


	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public Stack<IterationMove> getMoves() {
		return moves;
	}

	public Set<Column> getColumns() {
		return columns;
	}

	public void setColumns(Set<Column> columns) {
		this.columns = columns;
	}

}
