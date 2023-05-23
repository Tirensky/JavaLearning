package box;

public class Box {
    private double width, height, length;

    public Box() {
        this(0, 0, 0);
    }

    public Box(double dimension) {
        this(dimension, dimension, dimension);
    }

    public Box(Box box) {
        this(box.width, box.height, box.length);
    }

    public Box(Box b1, Box b2) {
        this(b1.width + b2.width, b1.height + b2.height, b1.length + b2.length);
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

    public final void setDimension(double width, double height, double length) {
        setWidth(width);
        setHeight(height);
        setLength(length);
    }

    public double volume() {
        return width * height * length;
    }

    public int compareTo(Box rBox) {
        return Double.compare(volume(), rBox.volume());
    }

    public Box increseBox(int i) {
        return new Box(width * i, height * i, length * i);
    }

    public Box mergeTo(Box rBox) {
        return new Box(width + rBox.width, height + rBox.height, length + rBox.length);
    }

    @Override
    public String toString() {
        return "Width: " + width +
                "\nHeight: " + height +
                "\nLength: " + length;
    }
}
