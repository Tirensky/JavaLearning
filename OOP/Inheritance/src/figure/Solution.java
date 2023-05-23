package figure;

public class Solution {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5, 10);
        Triangle triangle = new Triangle(10);
        System.out.println("S(rectangle) = " + rectangle.area());
        System.out.println("S(triangle)  = " + triangle.area());
    }
}
