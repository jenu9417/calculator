package com.jana.calculator.operator;

import org.junit.Assert;
import org.junit.Test;

public class SubtractTest {

	@Test
	public void testSubtractPositiveNumbers() {
		Subtract opr = new Subtract();
		Float result = opr.operate(Float.valueOf(4), Float.valueOf(2));
		Assert.assertEquals(Float.valueOf(2), result);
	}
	
	@Test
	public void testSubtractNegativeNumbers() {
		Subtract opr = new Subtract();
		Float result = opr.operate(Float.valueOf(-1), Float.valueOf(-2));
		Assert.assertEquals(Float.valueOf(1), result);
	}
	
	@Test
	public void testSubtractDecimalNumbers() {
		Subtract opr = new Subtract();
		Float result = opr.operate(Float.valueOf("-1.5"), Float.valueOf("-2.5"));
		Assert.assertEquals(Float.valueOf(1), result);
	}

}
