package com.jana.calculator.operator;

/**
 * 
 * Implements {@link Operator} interface.<br>
 * Provides the implementation logic for performing division operation on two Float numbers.
 * <br><br>
 * Operator Priority : {@code 1}
 * <br><br>
 * <b>Note:</b>
 * Division by zero generates {@link Float.POSITIVE_INFINITY} as result for positive dividend
 * and {@link Float.NEGATIVE_INFINITY} for negative dividend.
 * 
 * @author Janardhanan V S
 *
 */
public class Divide implements Operator {
	
	private final String operator;

	private final int priority;
	
	public Divide() {
		this.operator = OperatorConstants.DIVIDE;
		this.priority = 1;
	}

	public String getOperator() {
		return operator;
	}

	public int getPriority() {
		return priority;
	}

	public Float operate(Float opr1, Float opr2) {
		return opr1 / opr2;
	}

}
