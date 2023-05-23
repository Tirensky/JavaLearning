package man;

public class Solution {
    static String sentence = "It's Igor. He is 30 years old. His height is 179.9cm. He works as a Java developer.";

    public static void main(String[] args) {
        String name = sentence.substring(5, 9);
        String post = sentence.substring(sentence.length() - 15, sentence.length() - 1);
        int age = Integer.parseInt(sentence.substring(17, 19));
        double height = Double.parseDouble(sentence.substring(45, 50));

        Man man = new Man(name, post, age, height);
        System.out.println(man);
    }
}
