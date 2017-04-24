package errorutility;

public class CardMoveNotAllowed extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public CardMoveNotAllowed(String message){
		super("Card move not allowed. " + message);
	}
	
	public CardMoveNotAllowed(){
		this("");
	}

}