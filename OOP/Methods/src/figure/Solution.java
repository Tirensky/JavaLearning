package figure;

public class Solution {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();

        rectangle.setSides(42, 12);

        System.out.println("P = " + rectangle.perimeter());
        System.out.println("S = " + rectangle.area());
    }
}
