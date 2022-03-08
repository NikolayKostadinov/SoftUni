package interfaces;

public interface Heap<E extends Comparable<E> & Modify<E>> {
    int size();
    void add(E element);
    E peek();
    E poll();

    void decrease(E element, long score);

    void increase(E element, long score);
}
