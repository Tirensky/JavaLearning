package predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 0; i < 1000; i++) {
            numbers.add(rnd.nextInt(101) + 100);
        }

        numbers.stream()
                .filter(integer -> integer % 2 == 0 && integer % 5 == 0)
                .map(Math::sqrt)
                .map(sqrt -> "√" + sqrt)
                .forEach(System.out::println);
    }
}
