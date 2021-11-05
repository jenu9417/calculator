package com.jana.calculator.exception;

/**
 * 
 * Exception class denoting an error scenario, while executing output operation.<br>
 * Extends {@link Exception} class
 *
 * @author Janardhanan V S
 *
 */
public class OutputFailedException extends Exception {
	
	private static final long serialVersionUID = 6168995798107226981L;

	public OutputFailedException() {
        super();
    }
    
    public OutputFailedException(String message) {
        super(message);
    }
    
    public OutputFailedException(Throwable cause) {
        super(cause);
    }
    
    public OutputFailedException(String message, Throwable cause) {
        super(message, cause);
    }

}
