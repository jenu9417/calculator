package com.jana.calculator.exception;

/**
 * 
 * Exception class denoting an error scenario, while executing input operation.<br>
 * Extends {@link Exception} class
 *
 * @author Janardhanan V S
 *
 */
public class InputFailedException extends Exception {
	
	private static final long serialVersionUID = 6168995798107226981L;

	public InputFailedException() {
        super();
    }
    
    public InputFailedException(String message) {
        super(message);
    }
    
    public InputFailedException(Throwable cause) {
        super(cause);
    }
    
    public InputFailedException(String message, Throwable cause) {
        super(message, cause);
    }

}
