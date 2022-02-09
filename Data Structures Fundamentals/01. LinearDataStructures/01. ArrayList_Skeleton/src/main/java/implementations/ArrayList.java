package implementations;

import interfaces.List;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayList<E> implements List<E> {
    public static final int NOT_FOUND = -1;
    public static final int INITIAL_SIZE = 4;
    private Object[] elements;
    private int size;

    public ArrayList() {
        this.elements = new Object[INITIAL_SIZE];
        size = 0;
    }

    public ArrayList(Object[] elements) {
        this.elements = elements;
        size = this.elements.length;
    }

    @Override
    public boolean add(E element) {
        if (isElementsFull()) {
            this.elements = grow();
        }
        elements[this.size++] = element;
        return true;
    }

    @Override
    public boolean add(int index, E element) {
        checkIndex(index);
        if (isElementsFull()) {
            this.elements = grow();
        }
        this.size++;
        System.arraycopy(this.elements, index, this.elements, index + 1, size - index);
        this.elements[index] = element;
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        this.checkIndex(index);
        return (E) this.elements[index];
    }

    @Override
    @SuppressWarnings("unchecked")
    public E set(int index, E element) {
        this.checkIndex(index);
        E oldElement = (E) this.elements[index];
        this.elements[index] = element;
        return oldElement;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        this.checkIndex(index);
        E removedElement = (E) this.elements[index];
        if (size - index >= 0) {
            System.arraycopy(elements, index + 1, elements, index, size - index);
        }
        elements[size - 1] = null;
        this.size--;
        ensureCapacity();
        return removedElement;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int indexOf(E element) {
        int result = NOT_FOUND;
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(element)) {
                result = i;
                break;
            }
        }

        return result;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator<>() {
            private int ix;

            @Override
            public boolean hasNext() {
                return this.ix < size();
            }

            @Override
            public E next() {
                return get(ix++);
            }

            @Override
            public boolean hasPrevious() {
                return this.ix > 0;
            }

            @Override
            public E previous() {
                return get(ix--);
            }

            @Override
            public int nextIndex() {
                return ix++;
            }

            @Override
            public int previousIndex() {
                return ix--;
            }

            @Override
            public void remove() {
                ArrayList.this.remove(ix);
            }

            @Override
            public void set(E e) {
                elements[ix] = e;
            }

            @Override
            public void add(E e) {
                ArrayList.this.add(ix, e);
            }
        };
    }

    private boolean isElementsFull() {
        return this.size >= this.elements.length;
    }

    private Object[] grow() {
            return Arrays.copyOf(this.elements, this.elements.length * 2);
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(
                    String.format("Index out of bounds: %d for size: %d", index, this.size)
            );
        }
    }

    private void ensureCapacity() {
        if (this.size < this.elements.length / 3) {
            this.elements = shrink();
        }
    }

    private Object[] shrink() {
        return Arrays.copyOf(this.elements, this.elements.length / 2);
    }
}
