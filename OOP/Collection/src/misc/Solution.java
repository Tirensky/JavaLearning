package misc;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static List<Integer> numbers = new ArrayList<>();
    private static List<String> names = new ArrayList<>();
    private static List<String> numbersAndNames = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
            names.add("NameNo." + i);
            numbersAndNames.add(numbers.get(i) + " - " + names.get(i));
        }
        for (String numberAndName : numbersAndNames) {
            System.out.println(numberAndName);
        }
    }
}
