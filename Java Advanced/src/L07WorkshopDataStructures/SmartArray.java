package L07WorkshopDataStructures;

import javax.lang.model.util.Elements;

public class SmartArray {
    private static final int INITIAL_CAPACITY = 8;
    private int size = 0;
    private int[] elements;

    public SmartArray() {
        this.elements = new int[INITIAL_CAPACITY];
    }

    public void add(int number) {
        if (this.elements.length == size) {
            this.elements = grow();
        }
        this.elements[this.size++] = number;
    }

    private int[] grow() {
        int[] newElements = new int[this.elements.length * 2];
        System.arraycopy(this.elements, 0, newElements, 0, elements.length);
        return newElements;
    }


    public int get(int index) {
        validateIndex(index);
        return this.elements[index];
    }

    public int remove(int index) {
        int element = this.get(index);
        if (this.size - 1 - index >= 0) {
            System.arraycopy(this.elements, index + 1, this.elements, index, this.size - 1 - index);
        }

        this.elements[--this.size] = 0;
        if (size >= INITIAL_CAPACITY && size <= this.elements.length / 2) {
            this.elements = shrink();
        }
        return element;
    }

    private int[] shrink() {
        int[] newElements = new int[this.elements.length / 2];
        System.arraycopy(this.elements, 0, newElements, 0, newElements.length);
        return newElements;
    }

    private void validateIndex(int index) {
        if (index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException(index);
        }
    }

    public int size() {
        return this.size;
    }
}
