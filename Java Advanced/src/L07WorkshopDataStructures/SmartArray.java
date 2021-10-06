package L07WorkshopDataStructures;

import javax.lang.model.util.Elements;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class SmartArray {
    private static final int INITIAL_CAPACITY = 8;
    private int size = 0;
    private int[] elements;

    public SmartArray() {
        this.elements = new int[INITIAL_CAPACITY];
    }

    public void add(int element) {
        if (this.elements.length == size) {
            this.elements = grow();
        }
        this.elements[this.size++] = element;
    }

    public void add(int index, int element) {
        validateIndex(index);
        int lastElement = this.elements[this.size - 1];

        if (this.size - 1 - index > 0) {
            System.arraycopy(this.elements, index, this.elements, index + 1, this.size - 1 - index);
        }

        this.elements[index] = element;
        this.add(lastElement);
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

        if (this.size == 0) {
            this.elements = new int[INITIAL_CAPACITY];
        }

        if (size >= INITIAL_CAPACITY && size <= this.elements.length / 4) {
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

    public boolean contains(int element) {
        return IntStream.range(0, this.size)
                .anyMatch(i -> this.elements[i] == element);
    }

    public void forEach(Consumer<Integer> consumer){
        IntStream.range(0, this.size)
                .mapToObj(i->this.elements[i])
                .forEach(consumer);
    }


}
