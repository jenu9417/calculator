package com.jana.calculator.utils;

/**
 * 
 * Utility class which provides easy access methods for Type Checking
 * 
 * @author Janardhanan V S
 *
 */
public class TypeChecker {
		
	/**
	 * The method {@code isFloat} checks if the string given corresponds to a Float number,
	 * either with or without decimal.
	 * 
	 * @param value - a string representing the value to be checked
	 * @return a boolean value denoting whether the value denotes float or not
	 */
	public static boolean isFloat(String value) {
		try {
			Float.parseFloat(value);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
