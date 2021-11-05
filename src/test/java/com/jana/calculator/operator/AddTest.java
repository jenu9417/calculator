package com.jana.calculator.operator;

import org.junit.Assert;
import org.junit.Test;

public class AddTest {

	@Test
	public void testAddPositiveNumbers() {
		Add opr = new Add();
		Float result = opr.operate(Float.valueOf(1), Float.valueOf(2));
		Assert.assertEquals(Float.valueOf(3), result);
	}
	
	@Test
	public void testAddNegativeNumbers() {
		Add opr = new Add();
		Float result = opr.operate(Float.valueOf(-1), Float.valueOf(-2));
		Assert.assertEquals(Float.valueOf(-3), result);
	}
	
	@Test
	public void testAddDecimalNumbers() {
		Add opr = new Add();
		Float result = opr.operate(Float.valueOf("-1.5"), Float.valueOf("-2.5"));
		Assert.assertEquals(Float.valueOf(-4), result);
	}

}
