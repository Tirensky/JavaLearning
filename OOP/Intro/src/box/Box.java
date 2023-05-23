package box;

public class Box {
    private double width, height, length;

    public Box() {
        this(0, 0, 0);
    }

    public Box(double width, double height, double length) {
        setDimension(width, height, length);
    }

    public double getWidth() {
        return width;
    }

    public final void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public final void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public final void setLength(double length) {
        this.length = length;
    }

    private void setDimension(double width, double height, double length) {
        setWidth(width);
        setHeight(height);
        setLength(length);
    }
}
