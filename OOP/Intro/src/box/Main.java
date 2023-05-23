package box;

public class Main {
    public static void main(String[] args) {
        Box box1 = new Box();
        setDimensionTo(box1, 11.3, 10.2, 15);
        volumeOf(box1);

        Box box2 = new Box(5, 5, 5);
        volumeOf(box2);

        Box box3 = new Box(10, 10, 10);
        volumeOf(box3);

        Box box4 = box3;
        box4.setHeight(100);
        volumeOf(box3);
    }

    private static void volumeOf(Box box) {
        System.out.println("V = " + (box.getWidth() * box.getHeight() * box.getLength()));
    }

    private static void setDimensionTo(Box box, double width, double height, int length) {
        box.setWidth(width);
        box.setHeight(height);
        box.setLength(length);
    }
}
