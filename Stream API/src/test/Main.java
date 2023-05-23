package test;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Float> numbers = new ArrayList<>();
        int size = 50_000_000;

        for (int i = 0; i < size; i++) {
            numbers.add((float) i);
        }

        long before = System.currentTimeMillis();
        numbers.stream()
                .map(number -> Math.sin(0.2f + number / 5)
                * Math.cos(0.2f + number / 5)
                * Math.cos(0.4f + number / 2))
                .toList();
        long after = System.currentTimeMillis();

        System.out.println("Time: " + (after - before));
    }
}
