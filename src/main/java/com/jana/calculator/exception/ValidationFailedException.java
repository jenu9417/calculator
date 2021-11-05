package com.jana.calculator.exception;

/**
 * 
 * Exception class denoting an error scenario, while doing input validation operation.<br>
 * Extends {@link Exception} class
 *
 * @author Janardhanan V S
 *
 */
public class ValidationFailedException extends Exception {

	private static final long serialVersionUID = -3757684301953983862L;

	public ValidationFailedException() {
        super();
    }
    
    public ValidationFailedException(String message) {
        super(message);
    }
    
    public ValidationFailedException(Throwable cause) {
        super(cause);
    }
    
    public ValidationFailedException(String message, Throwable cause) {
        super(message, cause);
    }

}
