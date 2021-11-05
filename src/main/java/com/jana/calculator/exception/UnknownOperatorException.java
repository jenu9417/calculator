package com.jana.calculator.exception;

/**
 * 
 * Exception class denoting an error scenario, where an unknown operator 
 * without an implementation was encountered.<br>
 * Extends {@link Exception} class
 *
 * @author Janardhanan V S
 *
 */
public class UnknownOperatorException extends Exception {

	private static final long serialVersionUID = 2738614937716731968L;
	
    public UnknownOperatorException() {
        super();
    }
    
    public UnknownOperatorException(String message) {
        super(message);
    }
    
    public UnknownOperatorException(Throwable cause) {
        super(cause);
    }
    
    public UnknownOperatorException(String message, Throwable cause) {
        super(message, cause);
    }

}
