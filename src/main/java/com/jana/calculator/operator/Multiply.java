package com.jana.calculator.operator;

/**
 * 
 * Implements {@link Operator} interface.<br>
 * Provides the implementation logic for performing multiplication operation on two Float numbers.
 * <br><br>
 * Operator Priority : {@code 1}
 * 
 * @author Janardhanan V S
 *
 */
public class Multiply implements Operator {
	
	private final String operator;

	private final int priority;
	
	public Multiply() {
		this.operator = OperatorConstants.MULTIPLY;
		this.priority = 1;
	}

	public String getOperator() {
		return operator;
	}

	public int getPriority() {
		return priority;
	}

	public Float operate(Float opr1, Float opr2) {
		return opr1 * opr2;
	}

}
