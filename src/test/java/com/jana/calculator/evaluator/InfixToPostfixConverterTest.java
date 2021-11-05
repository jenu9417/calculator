package com.jana.calculator.evaluator;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.jana.calculator.evaluator.InfixEvaluator.InfixToPostfixConverter;
import com.jana.calculator.exception.TokenizeFailedException;
import com.jana.calculator.exception.UnknownOperatorException;
import com.jana.calculator.tokenizer.RegexTokenizer;

public class InfixToPostfixConverterTest {

	@Test
	public void testConvertPositiveFlow() throws UnknownOperatorException, TokenizeFailedException {
		List<String> infixTokens = new RegexTokenizer().tokenize("2+2/2*2-3+1");
		List<String> postfixTokens = InfixToPostfixConverter.convert(infixTokens);
		List<String> expectedTokens = Arrays.asList("2", "2", "2", "/", "2", "*", "+", "3", "-", "1", "+");
		Assert.assertEquals(expectedTokens, postfixTokens);
	}

	@Test(expected = UnknownOperatorException.class)
	public void testConvertWithUnknownOperator() throws TokenizeFailedException, UnknownOperatorException {
		List<String> infixTokens = new RegexTokenizer().tokenize("2+A+2/2*2-3+1");
		InfixToPostfixConverter.convert(infixTokens);
	}
	
	@Test
	public void testConvertWithEmptyExpression() throws TokenizeFailedException, UnknownOperatorException {
		List<String> infixTokens = Arrays.asList();
		List<String> postfixTokens = InfixToPostfixConverter.convert(infixTokens);
		List<String> expectedTokens = Arrays.asList();
		Assert.assertEquals(expectedTokens, postfixTokens);
	}
	
}
