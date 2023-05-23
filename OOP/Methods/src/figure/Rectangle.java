package figure;

public class Rectangle {
    private double length, width;

    public Rectangle() {
        this(0, 0);
    }

    public Rectangle(double length, double width) {
        setSides(length, width);
    }

    public void setSides(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double perimeter() {
        return (length + width) * 2;
    }

    public double area() {
        return length * width;
    }
}
