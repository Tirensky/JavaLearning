package example.box;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoxTest {
    private final double DELTA = 0.001;

    @Test
    public void sandBox() {
        /*Box<Integer> box1 = new Box<>(20);
        Box<Integer> box2 = new Box<>(10);

//        int num1 = 0;
//        int num2 = 0;
//        if (box1.getObj() instanceof Integer) num1 = (int) box1.getObj();
//        if (box2.getObj() instanceof Integer) num1 = (int) box2.getObj();

        int expected = 30;
        int actual = box1.getObj() + box2.getObj();
        assertEquals(expected, actual);*/

        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integers.add(i);
        }

        List<Number> numbers = new ArrayList<>();
        Box.transfer(integers, numbers);
        assertEquals(0, integers.size());
        assertEquals(10, numbers.size());

    }
}