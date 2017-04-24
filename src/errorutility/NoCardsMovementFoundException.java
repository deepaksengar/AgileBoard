package errorutility;

public class NoCardsMovementFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public NoCardsMovementFoundException(String message){
		super(message);
	}

}
