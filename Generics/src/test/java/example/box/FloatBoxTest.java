package example.box;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloatBoxTest {
    @Test
    public void sandBox() {
        FloatBox<String, Integer, Float> box1 = new FloatBox<>("Str1", 2, 3.5f);
        FloatBox<String, Integer, Float> box2 = new FloatBox<>("Str2", 5, 6.5f);

        float expected = 17;
        float actual = box1.getIntValue() + box2.getIntValue() + box1.getFltValue() + box2.getFltValue();

        assertEquals(expected, actual);
    }
}