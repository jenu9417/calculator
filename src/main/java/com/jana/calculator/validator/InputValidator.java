package com.jana.calculator.validator;

import com.jana.calculator.exception.ValidationFailedException;

/**
*
* The {@code InputValidator} interface should be implemented by the classes
* which intends to provide input validation implementation. 
* 
* @author Janardhanan V S
*
*/
public interface InputValidator {
	
	/**
	 * The {@code validate} method validates whether the given input string 
	 * conforms to the input validation rules specified.
	 * 
	 * @param input - a string denoting input expression
	 * @throws ValidationFailedException
	 */
	void validate(String input) throws ValidationFailedException;

}
