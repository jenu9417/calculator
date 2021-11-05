package com.jana.calculator.tokenizer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.jana.calculator.exception.TokenizeFailedException;

public class RegexTokenizerTest {

	@Test
	public void testTokenizeExpressionWithNumbersAndOperatorsWithDefaultRegex() throws TokenizeFailedException {
		String expression = "2+2*2/5-1";
		Tokenizer tokenizer = new RegexTokenizer();
		List<String> tokens = tokenizer.tokenize(expression);
		List<String> expectedTokens = Arrays.asList("2","+","2","*","2","/","5","-","1");
		Assert.assertEquals(expectedTokens, tokens);
	}
	
	@Test
	public void testTokenizeExpressionWithNumberAloneWithDefaultRegex() throws TokenizeFailedException {
		String expression = "2";
		Tokenizer tokenizer = new RegexTokenizer();
		List<String> tokens = tokenizer.tokenize(expression);
		List<String> expectedTokens = Arrays.asList("2");
		Assert.assertEquals(expectedTokens, tokens);
	}
	
	@Test
	public void testTokenizeExpressionWithDecimalNumberAloneWithDefaultRegex() throws TokenizeFailedException {
		String expression = "2.54";
		Tokenizer tokenizer = new RegexTokenizer();
		List<String> tokens = tokenizer.tokenize(expression);
		List<String> expectedTokens = Arrays.asList("2.54");
		Assert.assertEquals(expectedTokens, tokens);
	}
	
	@Test
	public void testTokenizeExpressionWithSpecialCharsAloneWithDefaultRegex() throws TokenizeFailedException {
		String expression = "+-*/";
		Tokenizer tokenizer = new RegexTokenizer();
		List<String> tokens = tokenizer.tokenize(expression);
		List<String> expectedTokens = Arrays.asList("+","-","*","/");
		Assert.assertEquals(expectedTokens, tokens);
	}
	
	@Test
	public void testTokenizeExpressionWithAlphabetWithDefaultRegex() throws TokenizeFailedException {
		String expression = "2+A+2*2/5-1";
		Tokenizer tokenizer = new RegexTokenizer();
		List<String> tokens = tokenizer.tokenize(expression);
		List<String> expectedTokens = Arrays.asList("2","+","A","+","2","*","2","/","5","-","1");
		Assert.assertEquals(expectedTokens, tokens);
	}
	
	@Test
	public void testTokenizeExpressionWithNumbersAndOperatorsWithCustomRegex() throws TokenizeFailedException {
		String expression = "2 ^ 2 * 2 / 5 - 1";
		String regex = "\\d+";
		Tokenizer tokenizer = new RegexTokenizer(regex, true);
		List<String> tokens = tokenizer.tokenize(expression);
		List<String> expectedTokens = Arrays.asList("","^","*","/","-");
		Assert.assertEquals(expectedTokens, tokens);
	}
	
	@Test(expected = TokenizeFailedException.class)
	public void testTokenizeFailed() throws TokenizeFailedException {
		String expression = null;
		Tokenizer tokenizer = new RegexTokenizer();
		tokenizer.tokenize(expression);
	}

}
