package predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 0; i < 100; i++) {
            numbers.add(rnd.nextInt(1000));
        }

//        List<Integer> filtered = filter(numbers, n -> n % 2 == 0);
//        System.out.println(filtered);

//        List<String> mapped = map(filtered);
//        System.out.println(mapped);

        List<String> list = numbers.stream()
                .filter(integer -> integer % 2 == 0)
                .map(String::valueOf)
                .filter(string -> string.endsWith("0"))
                .map(string -> string + "!")
                .toList();

        System.out.println(list);
    }

    private static List<String> map(List<Integer> numbers) {
        List<String> result = new ArrayList<>();
        for (int number : numbers) {
            result.add("'" + number + '\'');
        }
        return result;
    }

    private static List<Integer> filter(List<Integer> list, MyPredicate predicate) {
        List<Integer> result = new ArrayList<>();
        for (int i : list) {
            if (predicate.passBy(i)) result.add(i);
        }
        return result;
    }
}
