package errorutility;

public class NoSuchStatusExistException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public NoSuchStatusExistException(String status){
		super("Status : " + status +  " does not exist. ");
	}
	
	public NoSuchStatusExistException(){
		super("Status does not exist.");
	}

}
