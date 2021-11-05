package com.jana.calculator.tokenizer;

import java.util.Arrays;
import java.util.List;

import com.jana.calculator.exception.TokenizeFailedException;

/**
 * 
 * Implements {@link Tokenizer} interface.<br>
 * Provides the implementation logic for converting expression string to tokens,
 * based on regex pattern based splitting.
 * <br><br>
 * Uses the {@code DEFAULT_TOKEN_REGEX } to tokenize expression into numbers and operators unless user overrides.
 * Ignores whitespace present in the expression by default.
 * <br><br>
 * DEFAULT_TOKEN_REGEX = "(?<=[^\\d.])|(?=[^\\d.]|\\s{2,})"
 * <br><br>
 * <b>Eg:</b>
 * <br>
 * Input Expression : 2 + 2 * 2 / 3 -1 <br>
 * Token List : [ 2, +, 2, *, 2, /, 3, -, 1 ]
 *
 *
 * @author Janardhanan V S
 *
 */
public class RegexTokenizer implements Tokenizer {
	
	private final String tokenRegex;
	
	private final boolean ignoreWhitespace;
	
	private static final String DEFAULT_TOKEN_REGEX = "(?<=[^\\d.])|(?=[^\\d.]|\\s{2,})";
	
	private static final boolean DEFAULT_IGNORE_WHITE_SPACE = true;

	public RegexTokenizer() {
		this(DEFAULT_TOKEN_REGEX, DEFAULT_IGNORE_WHITE_SPACE);
	}
	
	public RegexTokenizer(String tokenRegex, boolean removeWhitespace) {
		this.tokenRegex = tokenRegex;
		this.ignoreWhitespace = removeWhitespace;
	}
	
	@Override
	public List<String> tokenize(String exp) throws TokenizeFailedException {
		try {
			String expression = exp;
			if(ignoreWhitespace) {
				expression = expression.replaceAll("\\s+", "");
			}
			String[] tokens = expression.split(tokenRegex);
			return Arrays.asList(tokens);
		} catch(Exception e) {
			String failureMessage = String.format("Tokenizing failed! Err: %s", e.getMessage());
			throw new TokenizeFailedException(failureMessage, e);
		}
	}

}
