package com.jana.calculator.input;

import com.jana.calculator.exception.InputFailedException;

/**
 * 
 * Implements {@link InputService} interface.<br>
 * Provides the implementation logic for retrieving user input from
 * Java System Properties.
 * <br><br>
 * By default the class uses the key : [{@code input}] to retrieve the input property.<br>
 * User can override this behaviour by providing the key at instance creation.
 * <br><br>
 * <b>Eg:</b>
 * <br>
 * java -jar -Dinput=2+2 /path/to/jar 
 *
 *
 * @author Janardhanan V S
 *
 */
public class SystemPropertiesInputService implements InputService {
	
	private final String inputKey;
	
	private static final String DEFAULT_INPUT_KEY="input";
	
	public SystemPropertiesInputService() {
		this.inputKey = DEFAULT_INPUT_KEY;
	}
	
	public SystemPropertiesInputService(String inputKey) {
		this.inputKey = inputKey;
	}

	@Override
	public String getInput() throws InputFailedException {
		try {
			return System.getProperty(inputKey);
		} catch(Exception e) {
			String failureMessage = String.format("Input failed! Err: %s", e.getMessage());
			throw new InputFailedException(failureMessage, e);
		}
	}

}
