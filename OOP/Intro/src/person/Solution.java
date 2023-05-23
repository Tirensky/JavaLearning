package person;

public class Solution {
    public static void main(String[] args) {
        Person person1 = new Person("Alex", 24, 67.8f);
        Person person2 = new Person("Katty", 30, 65f);
        Person person3 = new Person("Richard", 42, 81.3f);

        averageAgeOf(person1, person2, person3);
    }

    private static void averageAgeOf(Person... people) {
        int sum = 0;
        for (Person person : people)
            sum += person.getAge();
        System.out.println("Average age: " + (sum / people.length));
    }
}
