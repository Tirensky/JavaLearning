package box;

public class Main {
    public static void main(String[] args) {
        Box box1 = new Box(10, 15, 20);
        Box box2 = new Box(30, 30, 30);

//        volumeOf(box1);
//        volumeOf(box2);

        Box box3 = new Box(10);
        Box box4 = box3.increseBox(3);

        printVolumeOf(box3);
        printVolumeOf(box4);

        switch (box3.compareTo(box4)) {
            case -1 -> System.out.println("This box is bigger");
            case 0 -> System.out.println("Boxes are equal");
            case 1 -> System.out.println("Our box is bigger");
        }
    }

    private static void printVolumeOf(Box box) {
        System.out.println("V = " + box.volume());
    }
}
