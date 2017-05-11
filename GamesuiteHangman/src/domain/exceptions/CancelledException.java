package domain.exceptions;

public class CancelledException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Exception for when user clicks the cancel button in a JOptionPane
	 * 
	 * @param message
	 */
	public CancelledException(String message) {
		super(message);
	}
}
