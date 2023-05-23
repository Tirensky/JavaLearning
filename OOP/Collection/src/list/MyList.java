package list;

public interface MyList {
    String get(int index);

    boolean add(String s);

    boolean remove(int index);

    boolean remove(String s);

    int size();

    void clear();
}
