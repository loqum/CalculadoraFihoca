package com.privalia.presentation.integration.test;





import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.privalia.presentation.Calculator;
import com.privalia.presentation.ICalculator;

public class CalculatorTest {
	
	ICalculator calculator = new Calculator();

	@Test
	public void testSum() {
		assertTrue(calculator.sum(4, 4) ==8);
	}

	@Test
	public void testSubstract() {
		assertTrue(calculator.substract(4, 2) ==2);
	}

	@Test
	public void testMultiply() {
		assertTrue(calculator.multiply(4, 2) ==8);
	}

	@Test
	public void testDivide() {
		assertTrue(calculator.divide(8, 2) ==4);
	}

}
