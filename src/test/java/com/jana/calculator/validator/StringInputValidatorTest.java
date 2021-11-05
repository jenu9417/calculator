package com.jana.calculator.validator;

import org.junit.Assert;
import org.junit.Test;

import com.jana.calculator.exception.ValidationFailedException;

public class StringInputValidatorTest {

	@Test
	public void testValidatePositiveFlow() throws ValidationFailedException {
		InputValidator validator = new StringInputValidator();
		validator.validate("2+2*2/2-1");
		Assert.assertTrue(true);
	}
	
	@Test(expected = ValidationFailedException.class)
	public void testValidateEmptyString() throws ValidationFailedException {
		InputValidator validator = new StringInputValidator();
		validator.validate("");
	}
	
	@Test(expected = ValidationFailedException.class)
	public void testValidateWhitespaceOnlyString() throws ValidationFailedException {
		InputValidator validator = new StringInputValidator();
		validator.validate("    ");
	}

	@Test(expected = ValidationFailedException.class)
	public void testValidateNullString() throws ValidationFailedException {
		InputValidator validator = new StringInputValidator();
		validator.validate(null);
	}

}

