package com.jana.calculator.evaluator;

import java.util.List;
import java.util.Stack;

import com.jana.calculator.exception.EvaluationFailedException;
import com.jana.calculator.operator.Operator;
import com.jana.calculator.operator.OperatorFactory;
import com.jana.calculator.utils.TypeChecker;

/**
 * 
 * Implements {@link EvaluatorStrategy} interface.<br>
 * Provides the implementation logic for Postfix expression evaluation.<br>
 * 
 * <br>
 * <b>Eg:</b> <br>
 * Postfix Expression : 2 4 2 / + 1 - <br>
 * Tokenized Input : [ 2, 4, 2, /, +, 1, -] <br>
 * Evaluation Result : 3
 *
 * @author Janardhanan V S
 *
 */
public class PostfixEvaluator implements EvaluatorStrategy {

	public Float evaluate(List<String> tokens) throws EvaluationFailedException {
		Stack<Float> numberStack = new Stack<>();
		Float finalValue = null;
		try {
			for (String token : tokens) {
				if (TypeChecker.isFloat(token)) {
					Float floatNum = Float.parseFloat(token);
					numberStack.add(floatNum);
				} else {
					Operator operator = OperatorFactory.get(token);
					Float operand2 = numberStack.pop();
					Float operand1 = numberStack.pop();
					Float result = operator.operate(operand1, operand2);
					numberStack.add(result);
				}
			}

			if (!numberStack.isEmpty()) {
				finalValue = numberStack.pop();
			}
		} catch (Exception e) {
			String failureMessage = String.format("Expression evaluation failed! Err: %s", e.getMessage());
			throw new EvaluationFailedException(failureMessage, e);
		}

		return finalValue;
	}

}
