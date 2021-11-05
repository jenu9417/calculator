package com.jana.calculator.operator;

/**
*
* The {@code Operator} interface should be implemented by the classes
* which intends to provide an implementation for a binary argument operator. 
* 
* @author Janardhanan V S
*
*/
public interface Operator {
	
	/**
	 * The method {@code getPriority()} returns the priority value of the operator.
	 * 
	 * @return - an integer value denoting priority of operator
	 */
	int getPriority();
	
	/**
	 * The method {@code operate()} takes two Float values are args and performs 
	 * the corresponding operation on them. 
	 * 
	 * @param opr1 - operand 1
	 * @param opr2 - operand 2
	 * @return - a float value representing the result of the operation
	 */
	Float operate(Float opr1, Float opr2);
	
	/**
	 * The method {@code getOperator()} returns the string representation of the operator.
	 * 
	 * @return - a string denoting the operator
	 */
	String getOperator();

}
