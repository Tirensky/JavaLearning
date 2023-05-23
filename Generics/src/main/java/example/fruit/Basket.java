package example.fruit;

import java.util.ArrayList;
import java.util.List;

public class Basket<B extends Fruit> {
    private List<B> fruits;

    public Basket() {
        fruits = new ArrayList<>();
    }

    public float getMass() {
        float mass = 0;
        for (B fruit : fruits) {
            mass += fruit.getWeight();
        }
        return mass;
    }

    public void add(B fruit) {
        fruits.add(fruit);
    }

    public int compare(Basket<?> rBasket) {
        return Float.compare(getMass(), rBasket.getMass());
    }

    public static <F extends Fruit> void transfer(Basket<? extends F> src, Basket<? super F> dest) {
        dest.fruits.addAll(src.fruits);
        src.fruits.clear();
    }
}
