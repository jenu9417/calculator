package com.jana.calculator.exception;

/**
 * 
 * Exception class denoting an error scenario, while executing tokenizing operation.<br>
 * Extends {@link Exception} class
 *
 * @author Janardhanan V S
 *
 */
public class TokenizeFailedException extends Exception {
	
	private static final long serialVersionUID = -2894838867466976731L;

	public TokenizeFailedException() {
        super();
    }
    
    public TokenizeFailedException(String message) {
        super(message);
    }
    
    public TokenizeFailedException(Throwable cause) {
        super(cause);
    }
    
    public TokenizeFailedException(String message, Throwable cause) {
        super(message, cause);
    }

}
