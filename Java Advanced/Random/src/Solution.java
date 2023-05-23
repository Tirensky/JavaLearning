import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        Random rnd = new Random();
        String result = String.format(
                "Random number is %s. Try again.",
                rnd.nextInt(90) + 10);
        System.out.println(result);
    }
}
