package box;

public class BoxWeight extends Box {
    private double weight;

    public BoxWeight() {
        super();
        setWeight(0);
    }

    public BoxWeight(double dimension) {
        super(dimension);
        setWeight(dimension);
    }

    public BoxWeight(BoxWeight bw) {
        this(bw.getWidth(), bw.getHeight(), bw.getLength(), bw.weight);
    }

    public BoxWeight(BoxWeight bw1, BoxWeight bw2) {
        this(bw1.getWidth() + bw2.getWidth(), bw1.getHeight() + bw2.getHeight(),
                bw1.getLength() + bw2.getLength(), bw1.weight + bw2.weight);
    }

    public BoxWeight(double width, double height, double length, double weight) {
        setDimension(width, height, length, weight);
    }

    public double getWeight() {
        return weight;
    }

    public final void setWeight(double weight) {
        this.weight = weight;
    }

    public final void setDimension(double width, double height, double length, double weight) {
        super.setDimension(width, height, length);
        setWeight(weight);
    }

    @Override
    public String toString() {
        return super.toString() + "\nWeight: " + weight;
    }
}
