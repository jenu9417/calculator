package com.jana.calculator.core;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jana.calculator.evaluator.InfixEvaluator;
import com.jana.calculator.input.InputService;
import com.jana.calculator.input.SystemPropertiesInputService;
import com.jana.calculator.output.ConsoleOutputService;
import com.jana.calculator.output.OutputService;
import com.jana.calculator.tokenizer.RegexTokenizer;
import com.jana.calculator.tokenizer.Tokenizer;
import com.jana.calculator.validator.InputValidator;
import com.jana.calculator.validator.StringInputValidator;

public class CalculatorTest {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	
	@Before
	public void setUp() {
	    System.setOut(new PrintStream(outputStreamCaptor));
	}

	@Test
	public void testExecuteForSimpleExpression() {
		String expression = "2+4*2/4-1";
		setInput(expression);
		Calculator calculator = initCalculator();
		calculator.execute();

		String expected = "3.0";
		Assert.assertEquals(expected, outputStreamCaptor.toString().trim());
	}
	
	@Test
	public void testExecuteFoExpressionWithDecimalNumbers() {
		String expression = "2.5+7.5/3+1.5";
		setInput(expression);
		Calculator calculator = initCalculator();
		calculator.execute();

		String expected = "6.5";
		Assert.assertEquals(expected, outputStreamCaptor.toString().trim());
	}
	
	@Test
	public void testExecuteFoExpressionWithVeryLargeNumbers() {
		String expression = "100000000000000000000000000000000000000000000000000000000000.5+1";
		setInput(expression);
		Calculator calculator = initCalculator();
		calculator.execute();

		String expected = "Infinity";
		Assert.assertEquals(expected, outputStreamCaptor.toString().trim());
	}
	
	@Test
	public void testExecuteForEmptyExpression() {
		String expression = "";
		setInput(expression);
		Calculator calculator = initCalculator();
		calculator.execute();

		String expected = "Validation failed! Input cannot be null or empty";
		Assert.assertEquals(expected, outputStreamCaptor.toString().trim());
	}
	
	@Test
	public void testExecuteForUnknownOperatorExpression() {
		String expression = "2+A+2/3";
		setInput(expression);
		Calculator calculator = initCalculator();
		calculator.execute();

		String expected = "Expression evaluation failed! Err: Unknown Operator : A";
		Assert.assertEquals(expected, outputStreamCaptor.toString().trim());
	}
	
	private void setInput(String input) {
		System.setProperty("input", input);
	}

	private Calculator initCalculator() {
		InputService inputService = new SystemPropertiesInputService();
		InputValidator inputValidator = new StringInputValidator();
		Tokenizer tokenizer = new RegexTokenizer();
		OutputService outputService = new ConsoleOutputService();

		Calculator calculator = new Calculator(inputService, inputValidator, tokenizer, outputService);
		calculator.setEvaluatorStrategy(new InfixEvaluator());
		
		return calculator;
	}
	
	@After
	public void tearDown() {
	    System.setOut(standardOut);
	}

}
