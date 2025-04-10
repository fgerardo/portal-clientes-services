package mx.com.allianz.exception;

public class NotFoundException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7760843943701025373L;

	public NotFoundException(String message) {
        super(message);
    }
}
