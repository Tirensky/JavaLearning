package example.box;

import java.util.List;

public class Box<E extends Number> {
    private E obj;
    private E[] array;

    public Box(E obj) {
        setObj(obj);
    }

    public Box(E... array) {
        setArray(array);
    }

    public E[] getArray() {
        return array;
    }

    public void setArray(E... array) {
        this.array = array;
    }

    public E getObj() {
        return obj;
    }

    public void setObj(E obj) {
        this.obj = obj;
    }

    public double avg() {
        double result = 0;
        for (E el : array) {
            result += el.doubleValue();
        }
        return result / array.length;
    }

    public static <U> void transfer(List<? extends U> src, List<? super U> dest) {
        dest.addAll(src);
        src.clear();
    }

    public static <U> U getFirstElement(List<U> list) {
        return list.get(0);
    }

    public int compare(Box<?> rBox) {
        return Double.compare(avg(), rBox.avg());
    }
}
