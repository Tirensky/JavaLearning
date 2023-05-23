package user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Max", 22));
        users.add(new User("John", 17));
        users.add(new User("Andrew", 33));
        users.add(new User("Jack", 44));
        users.add(new User("Nick", 80));
        users.add(new User("Alice", 46));
        users.add(new User("Alex", 35));
        users.add(new User("Helen", 11));

        int[] array = {3, 1, 3, 5, 14};
        Stream.of(array)
                        .forEach(arr -> System.out.println(Arrays.toString(arr)));

        users.stream()
//                .sorted((u1, u2) -> Integer.compare(u2.getAge(), u1.getAge()))
//                .limit(3)
//                .forEach(System.out::println);
                .filter(user -> user.getFirstname().contains("l"))
                .findAny()
                .ifPresentOrElse(System.out::println, () -> System.out.println("User not found!"));


    }
}
