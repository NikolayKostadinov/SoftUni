package implementations;

import interfaces.AbstractQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

public class BiPriorityQueue<E extends Comparable<E>> implements AbstractQueue<E> {

    public static final int HEAP_TOP_INDEX = 0;
    private final List<E> elements;
    private final BiFunction<E, E, Boolean> heapProperty;

    public BiPriorityQueue() {
        this(new ArrayList<>(),
                //for MinHeap must be "<"
                (first, second) -> first.compareTo(second) > 0);
    }

    public BiPriorityQueue(List<E> nodes, BiFunction<E, E, Boolean> heapProperty) {
        this.elements = nodes;
        this.heapProperty = heapProperty;
    }

    @Override
    public int size() {
        return this.elements.size();
    }

    @Override
    public void add(E element) {
        this.elements.add(element);
        heapifyUp(size() - 1);
    }

    private void heapifyUp(int index) {
        while (index > 0 && isHeapifyUpFulfilled(index)) {
            E buff = get(index);
            Collections.swap(elements, index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private E get(int index) {
        return this.elements.get(index);
    }

    @Override
    public E peek() {
        ensureNotEmpty();
        return get(HEAP_TOP_INDEX);
    }

    private void ensureNotEmpty() {
        if (size() == 0) throw new IllegalStateException();
    }

    @Override
    public E poll() {
        ensureNotEmpty();
        E result = get(HEAP_TOP_INDEX);
        Collections.swap(this.elements, HEAP_TOP_INDEX, size() - 1);
        this.elements.remove(size() - 1);
        heapifyDown(HEAP_TOP_INDEX);
        return result;
    }

    private void heapifyDown(int index) {
        while ((index < size() / 2) && this.heapProperty.apply(get(left(index)), get(index))) {
            int left = left(index);
            int right = right(index);
            int child = left;

            if (right < size() && this.heapProperty.apply(get(right), get(left))) {
                child = right;
            }

            Collections.swap(this.elements, index, child);
            index = child;
        }

    }

    private Boolean isHeapifyUpFulfilled(int index) {
        return heapProperty.apply(get(index), get(getParentIndex(index)));
    }

    public int left(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    public int right(int parentIndex) {
        return parentIndex * 2 + 2;
    }

    public int getParentIndex(int index) {
        return (index - 1) / 2;
    }
}
