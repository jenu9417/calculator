package com.jana.calculator.tokenizer;

import java.util.List;

import com.jana.calculator.exception.TokenizeFailedException;

/**
*
* The {@code Tokenizer} interface should be implemented by the classes
* which intends to provide a mechanism to convert expression string to tokens. 
* 
* @author Janardhanan V S
*
*/
public interface Tokenizer {
	
	/**
	 * The {@code tokenize} method, splits the expression string into multiple tokens.
	 * 
	 * @param expression - a string representing the expression
	 * @return a list of tokens denoting the expression
	 * @throws TokenizeFailedException
	 */
	List<String> tokenize(String expression) throws TokenizeFailedException;

}
