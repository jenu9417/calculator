package com.jana.calculator.input;

import com.jana.calculator.exception.InputFailedException;

/**
*
* The {@code InputService} interface should be implemented by the classes
* which intends to provide an input retrieval implementation. 
* 
* @author Janardhanan V S
*
*/
public interface InputService {
	
	/**
	 * The {@code getInput} method, retrieves the user input and returns as a string
	 * 
	 * @return a {@code String} denoting input expression
	 * @throws InputFailedException
	 */
	String getInput()throws InputFailedException;

}
