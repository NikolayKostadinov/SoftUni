package implementations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

public class Heap<E extends Comparable<E>> implements interfaces.Heap<E> {
    public static final int HEAP_TOP_INDEX = 0;
    private final List<E> elements;
    private final BiFunction<E,E,Boolean> heapProperty;

    public Heap() {
        this(new ArrayList<>(),
                //for MinHeap must be "<"
                (first, second) -> first.compareTo(second) > 0);
    }

    public Heap(List<E> nodes, BiFunction<E,E,Boolean> heapProperty) {
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
        while (index > 0 && isHeapifyUpFulfilled(index)){
            E buff = getNode(index);
            Collections.swap(elements, index, getParentIndex(index));
            index = getParentIndex(index);
        };
    }

    private E getNode(int index) {
        return this.elements.get(index);
    }

    @Override
    public E peek() {
        if (size()== 0) throw new IllegalStateException();
        return getNode(HEAP_TOP_INDEX);
    }

    private Boolean isHeapifyUpFulfilled(int index) {
        return heapProperty.apply(getNode(index), getNode(getParentIndex(index)));
    }

    public int getLeftIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    public int getRightIndex(int parentIndex) {
        return parentIndex * 2 + 2;
    }

    public int getParentIndex(int index) {
        return (index - 1) / 2;
    }
}
