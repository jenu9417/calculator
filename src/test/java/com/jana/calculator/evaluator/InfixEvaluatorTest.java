package com.jana.calculator.evaluator;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.jana.calculator.exception.EvaluationFailedException;
import com.jana.calculator.exception.TokenizeFailedException;
import com.jana.calculator.tokenizer.RegexTokenizer;

public class InfixEvaluatorTest {

	@Test
	public void testEvaluatePositiveFlow() throws EvaluationFailedException, TokenizeFailedException {
		EvaluatorStrategy evaluatorStrategy = new InfixEvaluator();
		List<String> tokens = new RegexTokenizer().tokenize("2+2*2/2-2");
		Float result = evaluatorStrategy.evaluate(tokens);
		Assert.assertEquals(Float.valueOf(2), result);
	}

	@Test
	public void testEvaluateNegativeNumberAsOutput() throws EvaluationFailedException, TokenizeFailedException {
		EvaluatorStrategy evaluatorStrategy = new InfixEvaluator();
		List<String> tokens = new RegexTokenizer().tokenize("5/2-3");
		Float result = evaluatorStrategy.evaluate(tokens);
		Assert.assertEquals(Float.valueOf("-0.5"), result);
	}

	@Test(expected = EvaluationFailedException.class)
	public void testExpressionWithInvalidCharacter() throws EvaluationFailedException, TokenizeFailedException {
		EvaluatorStrategy evaluatorStrategy = new InfixEvaluator();
		List<String> tokens = new RegexTokenizer().tokenize("5A/2-3");
		evaluatorStrategy.evaluate(tokens);
	}

	@Test
	public void testEvaluateAdd() throws EvaluationFailedException, TokenizeFailedException {
		EvaluatorStrategy evaluatorStrategy = new InfixEvaluator();
		List<String> tokens = new RegexTokenizer().tokenize("2+2");
		Float result = evaluatorStrategy.evaluate(tokens);
		Assert.assertEquals(Float.valueOf(4), result);
	}

	@Test
	public void testEvaluateSubtract() throws EvaluationFailedException, TokenizeFailedException {
		EvaluatorStrategy evaluatorStrategy = new InfixEvaluator();
		List<String> tokens = new RegexTokenizer().tokenize("2-2");
		Float result = evaluatorStrategy.evaluate(tokens);
		Assert.assertEquals(Float.valueOf(0), result);
	}

	@Test
	public void testEvaluateMultiply() throws EvaluationFailedException, TokenizeFailedException {
		EvaluatorStrategy evaluatorStrategy = new InfixEvaluator();
		List<String> tokens = new RegexTokenizer().tokenize("2*2");
		Float result = evaluatorStrategy.evaluate(tokens);
		Assert.assertEquals(Float.valueOf(4), result);
	}

	@Test
	public void testEvaluateDivide() throws EvaluationFailedException, TokenizeFailedException {
		EvaluatorStrategy evaluatorStrategy = new InfixEvaluator();
		List<String> tokens = new RegexTokenizer().tokenize("2/2");
		Float result = evaluatorStrategy.evaluate(tokens);
		Assert.assertEquals(Float.valueOf(1), result);
	}

}
