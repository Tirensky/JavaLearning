package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    final double DELTA = 0.001;
    double expected;
    double actual;

    @Test
    public void addTest() {
        expected = 45;
        actual = Calculator.add(10, 15, 20);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void subtractTest() {
        expected = 7.5;
        actual = Calculator.subtract(30, 20, 2.5);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void multipleTest() {
        expected = 768;
        actual = Calculator.multiply(2, 4, 8, 12);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void divideTest() {
        expected = 10;
        actual = Calculator.divide(100, 2, 5);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void powerTest() {
        expected = 0.25;
        actual = Calculator.power(2, -2);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void infiniteByDivisionTest() {
        expected = 1.0 / 0.0;
        actual = Calculator.divide(100, 2, 0);
        assertEquals(expected, actual);
    }
}