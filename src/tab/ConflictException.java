package tab;

public class ConflictException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConflictException(String reason, Object object1, Object object2) {
		super("There is a conflict between " + object1 + " and " + object2 + ". " + reason);
	}
}
