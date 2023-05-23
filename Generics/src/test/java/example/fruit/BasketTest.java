package example.fruit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasketTest {
    private final double DELTA = 0.001;

    @Test
    public void sandBox() {
        Basket<Apple> apples = new Basket<>();
        Basket<Orange> oranges = new Basket<>();
        Basket<Fruit> fruits = new Basket<>();

        for (int i = 0; i < 10; i++) {
            apples.add(new Apple());
            oranges.add(new Orange());
        }

        assertEquals(10, apples.getMass(), DELTA);
        assertEquals(15, oranges.getMass(),DELTA);

        assertEquals(1, oranges.compare(apples));

        Basket.transfer(apples, fruits);
        Basket.transfer(oranges, fruits);

        assertEquals(25, fruits.getMass(), DELTA);
        assertEquals(0f, apples.getMass(), DELTA);
        assertEquals(0f, oranges.getMass(), DELTA);
    }
}