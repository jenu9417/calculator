package com.jana.calculator.evaluator;

import java.util.List;

import com.jana.calculator.exception.EvaluationFailedException;

/**
 *
 * The {@code EvaluatorStrategy} interface should be implemented by the classes
 * which intends to provide an expression evaluation implementation. 
 * 
 * @author Janardhanan V S
 *
 */
public interface EvaluatorStrategy {
	
	/**
	 * The {@code evaluate} method accepts tokens as input, does the evaluation and returns
	 * the final result of the evaluation as a {@code Float} value.
	 * 
	 * @param tokens - list of tokens
	 * @return a {@code Float} value representing the final result.
	 * @throws EvaluationFailedException
	 */
	Float evaluate(List<String> tokens) throws EvaluationFailedException;

}
