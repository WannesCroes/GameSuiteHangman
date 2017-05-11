package domain.exceptions;

public class DomainException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Exception for Domain errors
	 * 
	 * @param message
	 */
	public DomainException(String message) {
		super(message);
	}

}
