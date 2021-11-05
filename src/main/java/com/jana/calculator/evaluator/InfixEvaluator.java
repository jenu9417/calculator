package com.jana.calculator.evaluator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.jana.calculator.exception.EvaluationFailedException;
import com.jana.calculator.exception.UnknownOperatorException;
import com.jana.calculator.operator.Operator;
import com.jana.calculator.operator.OperatorFactory;
import com.jana.calculator.utils.TypeChecker;

/**
 * 
 * Implements {@link EvaluatorStrategy} interface.<br>
 * Provides the implementation logic for Infix expression evaluation.<br>
 * Serves as an adapter class which links with the postfix evaluator. <br>
 * 
 * <br>
 * <b>Eg:</b> <br>
 * Infix Expression : 2 + 4 / 2 - 1 <br>
 * Tokenized Input : [ 2, +, 4, /, 2, -, 1 ] <br>
 * Evaluation Result : 3
 *
 * @author Janardhanan V S
 *
 */
public class InfixEvaluator implements EvaluatorStrategy {

	private PostfixEvaluator postfixEvaluator;

	public InfixEvaluator() {
		this.postfixEvaluator = new PostfixEvaluator();
	}

	@Override
	public Float evaluate(List<String> tokens) throws EvaluationFailedException {
		try {
			List<String> postfixTokens = InfixToPostfixConverter.convert(tokens);
			return this.postfixEvaluator.evaluate(postfixTokens);
		} catch (Exception e) {
			String failureMessage = String.format("Expression evaluation failed! Err: %s", e.getMessage());
			throw new EvaluationFailedException(failureMessage, e);
		}
	}

	/**
	 *
	 * Provides the logic to convert an infix expression to postfix expression.<br>
	 * Uses {@code Shunting Yard Algorithm} for conversion logic.
	 * 
	 * <br>
	 * <br>
	 * <b>Eg:</b> <br>
	 * Infix Expression : 2 + 4 / 2 - 1 <br>
	 * Infix Tokens : [ 2, +, 4, /, 2, -, 1 ] <br>
	 * Postfix Tokens : [ 2, 4, 2, /, +, 1, -]
	 *
	 * @author Janardhanan V S
	 *
	 */
	static class InfixToPostfixConverter {

		/**
		 * 
		 * Converts infix tokens to postfix tokens.
		 * 
		 * @param infixTokens - list of tokens denoting infix expression
		 * @return a list of tokens denoting corresponding postfix expression
		 * @throws UnknownOperatorException
		 */
		static List<String> convert(List<String> infixTokens) throws UnknownOperatorException {
			List<String> postfixTokens = new ArrayList<>();
			Stack<Operator> operatorStack = new Stack<>();
			int index = 0;
			while (index < infixTokens.size()) {
				String token = infixTokens.get(index);
				if (TypeChecker.isFloat(token)) {
					postfixTokens.add(token);
					index++;
				} else {
					Operator operator = OperatorFactory.get(token);
					if (operatorStack.isEmpty() || (operatorStack.peek().getPriority() < operator.getPriority())) {
						operatorStack.push(operator);
						index++;
					} else {
						Operator poppedOperator = operatorStack.pop();
						postfixTokens.add(poppedOperator.getOperator());
					}
				}
			}

			while (!operatorStack.isEmpty()) {
				Operator poppedOperator = operatorStack.pop();
				postfixTokens.add(poppedOperator.getOperator());
			}

			return postfixTokens;
		}

	}

}
