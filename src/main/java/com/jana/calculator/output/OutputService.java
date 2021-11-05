package com.jana.calculator.output;

import com.jana.calculator.exception.OutputFailedException;

/**
*
* The {@code OutputService} interface should be implemented by the classes
* which intends to provide an output display implementation. 
* 
* @author Janardhanan V S
*
*/
public interface OutputService {
	
	/**
	 * The {@code displayOutput} method, displays the output.
	 * 
	 * @param output - a variable arg parameter which denotes output strings
	 * @throws OutputFailedException
	 */
	void displayOutput(String ...output) throws OutputFailedException;

}
