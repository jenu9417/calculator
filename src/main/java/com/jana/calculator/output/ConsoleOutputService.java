package com.jana.calculator.output;

import com.jana.calculator.exception.OutputFailedException;

/**
 * 
 * Implements {@link OutputService} interface.<br>
 * Provides the implementation logic for displaying output to console via {@link System.out} stream.
 *
 * @author Janardhanan V S
 *
 */
public class ConsoleOutputService implements OutputService {

	@Override
	public void displayOutput(String... output) throws OutputFailedException {
		try {
			for (String line : output) {
				System.out.println(line);
			}
		} catch (Exception e) {
			String failureMessage = String.format("Output failed! Err: %s", e.getMessage());
			throw new OutputFailedException(failureMessage, e);
		}
	}

}
