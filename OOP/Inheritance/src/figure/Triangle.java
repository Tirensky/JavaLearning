package figure;

public class Triangle extends Figure {
    private double sideC;

    public Triangle(double dimension) {
        this(dimension, dimension, dimension);
    }

    public Triangle(double a, double b, double c) {
        super(a, b);
        sideC = c;
    }

    @Override
    public double area() {
        double p = (getSideA() + getSideB() + sideC) / 2;
        return Math.sqrt(p * (p - getSideA()) * (p - getSideB()) * (p - sideC));
    }
}
