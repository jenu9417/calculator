package com.jana.calculator.utils;

import org.junit.Assert;
import org.junit.Test;

public class TypeCheckerTest {

	@Test
	public void testIsFloatWithFloatNumber() {
		String value = "0.5";
		Assert.assertTrue(TypeChecker.isFloat(value));
	}
	
	@Test
	public void testIsFloatWithNegativeFloatNumber() {
		String value = "-0.5";
		Assert.assertTrue(TypeChecker.isFloat(value));
	}
	
	@Test
	public void testIsFloatWithIntegerNumber() {
		String value = "5";
		Assert.assertTrue(TypeChecker.isFloat(value));
	}
	
	@Test
	public void testIsFloatWithNegativeIntegerNumber() {
		String value = "-5";
		Assert.assertTrue(TypeChecker.isFloat(value));
	}
	
	@Test
	public void testIsFloatWithZero() {
		String value = "0";
		Assert.assertTrue(TypeChecker.isFloat(value));
	}
	
	@Test
	public void testIsFloatWithInvalidCharacter() {
		String value = "A";
		Assert.assertFalse(TypeChecker.isFloat(value));
	}


}
