package com.jana.calculator.output;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jana.calculator.exception.OutputFailedException;

public class ConsoleOutputServiceTest {
	
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@Before
	public void setUp() {
	    System.setOut(new PrintStream(outputStreamCaptor));
	}

	@Test
	public void testDisplayOutputWithValidString() throws OutputFailedException {
		String value = "This is output";
		OutputService outputService = new ConsoleOutputService();
		outputService.displayOutput(value);
		Assert.assertEquals(value, outputStreamCaptor.toString().trim());
	}
	
	@Test
	public void testDisplayOutputWithEmptyString() throws OutputFailedException {
		String value = "";
		OutputService outputService = new ConsoleOutputService();
		outputService.displayOutput(value);
		Assert.assertEquals(value, outputStreamCaptor.toString().trim());
	}
	
	@Test
	public void testDisplayOutputWithNullString() throws OutputFailedException {
		String value = null;
		OutputService outputService = new ConsoleOutputService();
		outputService.displayOutput(value);
		Assert.assertEquals("null", outputStreamCaptor.toString().trim());
	}
	
	@Test
	public void testDisplayOutputWithNoArgs() throws OutputFailedException {
		OutputService outputService = new ConsoleOutputService();
		outputService.displayOutput();
		Assert.assertEquals(0, outputStreamCaptor.size());
	}
	
	@Test(expected = OutputFailedException.class)
	public void testDisplayOutputFailed() throws OutputFailedException, FileNotFoundException {
		System.setOut(null);
		OutputService outputService = new ConsoleOutputService();
		outputService.displayOutput("Test");
	}
	
	@After
	public void tearDown() {
	    System.setOut(standardOut);
	}

}
