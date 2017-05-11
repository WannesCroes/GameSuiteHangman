package domain.exceptions;

public class DatabaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Exception for Database errors
	 * 
	 * @param message
	 */
	public DatabaseException(String message) {
		super(message);
	}
}