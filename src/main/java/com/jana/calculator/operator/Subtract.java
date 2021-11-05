package com.jana.calculator.operator;

/**
 * 
 * Implements {@link Operator} interface.<br>
 * Provides the implementation logic for performing subtraction operation on two Float numbers.
 * <br><br>
 * Operator Priority : {@code 0}
 * 
 * @author Janardhanan V S
 *
 */
public class Subtract implements Operator {
	
	private final String operator;

	private final int priority;
	
	public Subtract() {
		this.operator = OperatorConstants.SUBTRACT;
		this.priority = 0;
	}

	public String getOperator() {
		return operator;
	}

	public int getPriority() {
		return priority;
	}

	public Float operate(Float opr1, Float opr2) {
		return opr1 - opr2;
	}

}
