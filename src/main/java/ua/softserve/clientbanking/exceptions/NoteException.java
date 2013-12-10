package ua.softserve.clientbanking.exceptions;

@SuppressWarnings("serial")
public class NoteException extends RuntimeException {
	/**
	 * Default constructor
	 */
	public NoteException() {
		super();
	}

	/**
	 * A constructor with a message
	 *
	 * @param message an error message
	 */
	public NoteException(String message) {
		super(message);
	}

	/**
	 * A wrapping constructor with a message
	 *
	 * @param message an error message
	 * @param cause the throwable being wrapped
	 */
	public NoteException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * A wrapping constructor
	 *
	 * @param cause the throwable being wrapped
	 */
	public NoteException(Throwable cause) {
		super(cause);
	}

}
