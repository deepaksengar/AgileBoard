package executorclient;

import java.util.Set;

import agileboard.Board;
import agileboard.Card;
import agileboard.Column;
import agileboard.Iteration;
import agileboard.IterationMove;
import agileboard.StatusClass;

public class ExecutorClient {

	public static void main(String[] args){
		Set<Column> columnsForBoard = StatusClass.initializeColumns();
		
		Board board = new Board(columnsForBoard);
		Iteration iteration = board.getCurrentIteration();
		
		Card c1 = new Card("C1", "This is C1 card.", 5);
		Card c2 = new Card("C2", "This is C2 card.", 15);
		
		Card[] cards = {c1,c2} ;
		
		for(Card c: cards){
			iteration.addCard(c);
		}
		
		iteration.moveCard(c1, "done");
		iteration.moveCard(c2, "done");
		
		for(IterationMove move: iteration.getMoves()){
			Card c = move.getCard();
			System.out.println(c.getTitle() + " " + c.getDescription() + " Estimate Points : " + c.getEstimatePoints() + " , Current Column : " + c.getCurrentColumnId() + " ");
		}
		
		System.out.println(iteration.velocity());
		
	}
}
