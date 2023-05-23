package figure;

public class Rectangle extends Figure {

    public Rectangle(double dimension) {
        this(dimension, dimension);
    }

    public Rectangle(double a, double b) {
        super(a, b);
    }

    @Override
    public double area() {
        return getSideA() * getSideB();
    }

}
