package animal;

public class Solution {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.setCounter(4);
        dog.setBreed("Bulldog");
        dog.setName("Chopper");
        dog.run();

        System.out.println(dog.about());
    }
}
