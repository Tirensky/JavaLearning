package args;

public class MyMath {
    private static final double PI = 3.14;

    public static int square(int i) {
        return i * i;
    }

    public static double area(double radius) {
        return PI * radius * radius;
    }

    public static int sum(int... numbers) {
        int sum = 0;
        for (int number : numbers)
            sum += number;
        return sum;
    }
}
