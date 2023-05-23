package box;

public class Solution {
    public static void main(String[] args) {
        Box box = new Box(10, 20, 30);
        BoxWeight boxWeight = new BoxWeight(12.4);
        BoxWeight newBoxWeight = new BoxWeight(boxWeight, boxWeight);
        System.out.println(newBoxWeight);
    }
}
