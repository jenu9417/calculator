package com.jana.calculator.operator;

import org.junit.Assert;
import org.junit.Test;

public class DivideTest {

	@Test
	public void testDividePositiveNumbers() {
		Divide opr = new Divide();
		Float result = opr.operate(Float.valueOf(4), Float.valueOf(2));
		Assert.assertEquals(Float.valueOf(2), result);
	}

	@Test
	public void testDivideNegativeNumbers() {
		Divide opr = new Divide();
		Float result = opr.operate(Float.valueOf(4), Float.valueOf(-2));
		Assert.assertEquals(Float.valueOf(-2), result);
	}

	@Test
	public void testDivideDecimalNumbers() {
		Divide opr = new Divide();
		Float result = opr.operate(Float.valueOf("-3.75"), Float.valueOf("3"));
		Assert.assertEquals(Float.valueOf("-1.25"), result);
	}

	@Test
	public void testDivideZero() {
		Divide opr = new Divide();
		Float result = opr.operate(Float.valueOf(0), Float.valueOf(2));
		Assert.assertEquals(Float.valueOf(0), result);
	}
	
	@Test
	public void testDivideByZero() {
		Divide opr = new Divide();
		Float result = opr.operate(Float.valueOf(2), Float.valueOf(0));
		Assert.assertEquals(Float.valueOf(Float.POSITIVE_INFINITY), result);
	}
	
	@Test
	public void testNegativeNumberDivideByZero() {
		Divide opr = new Divide();
		Float result = opr.operate(Float.valueOf(-2), Float.valueOf(0));
		Assert.assertEquals(Float.valueOf(Float.NEGATIVE_INFINITY), result);
	}

}
