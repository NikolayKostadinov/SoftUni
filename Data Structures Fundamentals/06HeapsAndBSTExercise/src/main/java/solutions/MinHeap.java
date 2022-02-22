package solutions;

import interfaces.Decrease;
import interfaces.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinHeap<E extends Comparable<E> & Decrease<E>> implements Heap<E> {

    public static final int TOP_ELEMENT_INDEX = 0;
    private final List<E> elements;

    public MinHeap() {
        this.elements = new ArrayList<>();
    }

    @Override
    public int size() {
        return this.elements.size();
    }

    @Override
    public void add(E element) {
        this.elements.add(element);
        this.heapifyUp(this.elements.size() - 1);
    }

    private void heapifyUp(int index) {
        while (index > 0 && (greater(getParent(index), index))) {
            Collections.swap(this.elements, index, getParent(index));
            heapifyUp(getParent(index));
        }
    }

    private boolean greater(int first, int secons) {
        return this.elements.get(first).compareTo(this.elements.get(secons)) > 0;
    }

    @Override
    public E peek() {
        ensureNotEmpty();
        return this.elements.get(TOP_ELEMENT_INDEX);
    }

    @Override
    public E poll() {
        ensureNotEmpty();
        E result = this.elements.get(TOP_ELEMENT_INDEX);
        int lastIndex = this.elements.size() - 1;
        Collections.swap(this.elements, TOP_ELEMENT_INDEX, lastIndex);
        this.elements.remove(lastIndex);
        heapifyDown(TOP_ELEMENT_INDEX);
        return result;
    }

    private void heapifyDown(int index) {
        while (getLeftChildIndex(index) < this.elements.size() && greater(index, getLeftChildIndex(index))) {
            int childIndex = getLeftChildIndex(index);
            int rightChildIndex = getRightChildIndex(index);
            if (childIndex < this.elements.size() && greater(childIndex, rightChildIndex)) {
                childIndex = rightChildIndex;
            }

            Collections.swap(this.elements, childIndex, index);
            index = childIndex;
        }
    }

    @Override
    public void decrease(E element) {
        int index = this.elements.indexOf(element);
        this.elements.get(index).decrease();
        this.heapifyUp(index);
    }

    private int getLeftChildIndex(int index) {
        return (index * 2) + 1;
    }

    private int getRightChildIndex(int index) {
        return (index * 2) + 2;
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    private void ensureNotEmpty() {
        if (this.elements.isEmpty()) {
            throw new IllegalStateException("Illegal call to peek on empty heap");
        }
    }
}
