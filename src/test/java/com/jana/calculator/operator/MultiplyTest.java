package com.jana.calculator.operator;

import org.junit.Assert;
import org.junit.Test;

public class MultiplyTest {

	@Test
	public void testMultiplyPositiveNumbers() {
		Multiply opr = new Multiply();
		Float result = opr.operate(Float.valueOf(4), Float.valueOf(2));
		Assert.assertEquals(Float.valueOf(8), result);
	}
	
	@Test
	public void testMultiplyNegativeNumbers() {
		Multiply opr = new Multiply();
		Float result = opr.operate(Float.valueOf(1), Float.valueOf(-2));
		Assert.assertEquals(Float.valueOf(-2), result);
	}
	
	@Test
	public void testMultiplyDecimalNumbers() {
		Multiply opr = new Multiply();
		Float result = opr.operate(Float.valueOf("1.5"), Float.valueOf("-2.5"));
		Assert.assertEquals(Float.valueOf("-3.75"), result);
	}
	
	@Test
	public void testMultiplyWithZero() {
		Multiply opr = new Multiply();
		Float result = opr.operate(Float.valueOf(2), Float.valueOf(0));
		Assert.assertEquals(Float.valueOf(0), result);
	}

}
