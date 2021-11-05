package com.jana.calculator.input;

import org.junit.Assert;
import org.junit.Test;

import com.jana.calculator.exception.InputFailedException;

public class SystemPropertiesInputServiceTest {

	@Test
	public void testGetInputWithValidStringSet() throws InputFailedException {
		String expression = "2+2";
		System.setProperty("input", expression);
		InputService inputService = new SystemPropertiesInputService();
		String input = inputService.getInput();
		Assert.assertEquals(expression, input);
	}
	
	@Test
	public void testGetInputWithEmptyStringSet() throws InputFailedException {
		String expression = "";
		System.setProperty("input", expression);
		InputService inputService = new SystemPropertiesInputService();
		String input = inputService.getInput();
		Assert.assertEquals(expression, input);
	}
	
	@Test
	public void testGetInputWithNoSystemPropertySet() throws InputFailedException {
		InputService inputService = new SystemPropertiesInputService();
		String input = inputService.getInput();
		Assert.assertEquals("", input);
	}
	
	@Test(expected = InputFailedException.class)
	public void testGetInputFailed() throws InputFailedException {
		InputService inputService = new SystemPropertiesInputService(null);
		inputService.getInput();
	}

}
