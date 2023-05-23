package figure;

public abstract class Figure {
    private double sideA, sideB;

    public Figure(double a, double b) {
        sideA = a;
        sideB = b;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public abstract double area();
}
