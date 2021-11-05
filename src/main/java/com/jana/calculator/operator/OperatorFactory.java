package com.jana.calculator.operator;

import com.jana.calculator.exception.UnknownOperatorException;

/**
 *
 * Factory class used to generate various {@code Operator} instances.
 * <br><br>
 * Raises {@link UnknownOperatorException} when a corresponding implementation is not found.
 *
 * @author Janardhanan V S
 *
 */
public class OperatorFactory {
	
	/**
	 * The method {@code get()} returns the {@code Operator} instance corresponding 
	 * to the operator string value provided
	 * 
	 * @param operator - a string denoting the operator
	 * @return an instance of {@link Operator}
	 * @throws UnknownOperatorException
	 */
	public static Operator get(String operator) throws UnknownOperatorException {
		switch (operator) {
		case OperatorConstants.ADD:
			return new Add();
		case OperatorConstants.SUBTRACT:
			return new Subtract();
		case OperatorConstants.MULTIPLY:
			return new Multiply();
		case OperatorConstants.DIVIDE:
			return new Divide();
		default:
			throw new UnknownOperatorException("Unknown Operator : " + operator);
		}
	}

}
