package com.jana.calculator.operator;

import org.junit.Assert;
import org.junit.Test;

import com.jana.calculator.exception.UnknownOperatorException;

public class OperatorFactoryTest {

	@Test
	public void testGetForAddOperator() throws UnknownOperatorException {
		Operator operator = OperatorFactory.get("+");
		Assert.assertTrue(operator instanceof Add);
	}
	
	@Test
	public void testGetForSubtractOperator() throws UnknownOperatorException {
		Operator operator = OperatorFactory.get("-");
		Assert.assertTrue(operator instanceof Subtract);
	}
	
	@Test
	public void testGetForMultiplyOperator() throws UnknownOperatorException {
		Operator operator = OperatorFactory.get("*");
		Assert.assertTrue(operator instanceof Multiply);
	}
	
	@Test
	public void testGetForDivideOperator() throws UnknownOperatorException {
		Operator operator = OperatorFactory.get("/");
		Assert.assertTrue(operator instanceof Divide);
	}
	
	@Test(expected = UnknownOperatorException.class)
	public void testGetForUnknownOperator() throws UnknownOperatorException {
		OperatorFactory.get("A");
	}
	
	@Test(expected = UnknownOperatorException.class)
	public void testGetForEmptyOperator() throws UnknownOperatorException {
		OperatorFactory.get("");
	}

}
