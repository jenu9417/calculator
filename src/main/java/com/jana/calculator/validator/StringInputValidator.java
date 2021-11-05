package com.jana.calculator.validator;

import com.jana.calculator.exception.ValidationFailedException;

/**
 * 
 * Implements {@link InputValidator} interface.<br>
 * Provides the implementation logic for validating input string using various validation rules.
 * <br><br>
 * The following rules are validated:<br>
 * a) The input string should not be null<br>
 * b) The input string should not be empty<br>
 * c) The input string should not be whitespace only
 * <br><br>
 * <b>Eg:</b>
 * <br>
 * "2+2"  -  Valid<br>
 * ""     -  Invalid<br>
 * "   "  -  Invalid<br>
 * null   -  Invalid<br>
 *
 * @author Janardhanan V S
 *
 */
public class StringInputValidator implements InputValidator {
	
	@Override
	public void validate(String input) throws ValidationFailedException {
		if(!isValidString(input)) {
			throw new ValidationFailedException("Validation failed! Input cannot be null or empty");
		}
	}
	
	private static boolean isValidString(String input) {
		if(input == null || input.trim().isEmpty()) {
			return false;
		}
		return true;
	}

}
