package com.privalia.presentation.integration.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.privalia.presentation.Calculator;
import com.privalia.presentation.ICalculator;

public class CalculatorTest {

	@Test
	public void testSum() {
		ICalculator calculator = new Calculator();
		assertTrue(calculator.sum(2, 3) == 5);
	}

	@Test
	public void testSubstract() {
		ICalculator calculator = new Calculator();
		assertTrue(calculator.substract(2, 2) == 0);
	}

	@Test
	public void testMultiply() {
		ICalculator calculator = new Calculator();
		assertTrue(calculator.multiply(5, 5) == 25);
	}

	@Test
	public void testDivide() {
		ICalculator calculator = new Calculator();
		assertTrue(calculator.divide(4, 2) == 2);
	}

}
