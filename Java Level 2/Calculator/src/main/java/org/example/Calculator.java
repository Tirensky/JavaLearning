package org.example;

public class Calculator {
    public static double add(double... numbers) {
        double result = 0;
        for (double number : numbers)
            result += number;
        return result;
    }

    public static double subtract(double... numbers) {
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++)
            result -= numbers[i];
        return result;
    }

    public static double multiply(double... numbers) {
        double result = 1;
        for (double number : numbers) {
            result *= number;
        }
        return result;
    }

    public static double divide(double... numbers) {
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++)
            try {
                result /= numbers[i];
            } catch (ArithmeticException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        return result;
    }

    public static double power(double num, int pow) {
        if (pow == 0) return 1;
        if (pow < 0) return power(1 / num, Math.abs(pow));
        return pow % 2 == 0 ? power(num * num, pow / 2) : num * power(num * num, pow / 2);
    }
}