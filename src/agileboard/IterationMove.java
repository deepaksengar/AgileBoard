package agileboard;

public class IterationMove {
	
	private Card card;
	private String fromColumnName;
	
	public IterationMove(Card card, String prevColumn){
		this.setCard(card);
		this.setFromColumnName(prevColumn);
	}
	
	
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public String getFromColumnName() {
		return fromColumnName;
	}
	public void setFromColumnName(String fromColumnName) {
		this.fromColumnName = fromColumnName;
	}

}
