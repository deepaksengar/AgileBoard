package agileboard;

public class IterationMove {
	
	private Card card;
	private String fromColumnId;
	
	public IterationMove(Card card, String prevColumn){
		this.setCard(card);
		this.setFromColumnId(prevColumn);
	}
	
	
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public String getFromColumnId() {
		return fromColumnId;
	}
	public void setFromColumnId(String fromColumnId) {
		this.fromColumnId = fromColumnId;
	}

}
