package com.jana.calculator.exception;

/**
 * 
 * Exception class denoting an error scenario, while executing evaluation operation.<br>
 * Extends {@link Exception} class
 *
 * @author Janardhanan V S
 *
 */
public class EvaluationFailedException extends Exception {

	private static final long serialVersionUID = -3757684301953983862L;

	public EvaluationFailedException() {
        super();
    }
    
    public EvaluationFailedException(String message) {
        super(message);
    }
    
    public EvaluationFailedException(Throwable cause) {
        super(cause);
    }
    
    public EvaluationFailedException(String message, Throwable cause) {
        super(message, cause);
    }

}
