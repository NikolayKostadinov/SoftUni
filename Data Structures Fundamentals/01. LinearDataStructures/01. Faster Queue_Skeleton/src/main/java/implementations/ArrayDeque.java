package implementations;

import interfaces.Deque;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;

public class ArrayDeque<E> implements Deque<E> {

    private final int DEFAULT_CAPACITY = 7;
    private int head;
    private int size;

    private Object[] elements;

    public ArrayDeque() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.head = this.DEFAULT_CAPACITY / 2;
    }

    public int getLeftTail() {
        return this.head - size;
    }

    public int getRightTail() {
        return this.head + size;
    }

    @Override
    public void add(E element) {
        ensureCapacity();
        this.elements[getLeftTail()] = element;
        this.elements[getRightTail()] = element;
        size++;
    }

    @Override
    public void addLast(E element) {
        add(element);
    }

    @Override
    public void push(E element) {
        add(element);
    }

    @Override
    public void offer(E element) {
        add(element);
    }


    @Override
    public void addFirst(E element) {
        insert(0, element);
    }

    @Override
    public void insert(int index, E element) {
        checkIndex(index);
        ensureCapacity();
        System.arraycopy(this.elements, getLeftTail() + 1, this.elements, getLeftTail() , size - index);
        int rightStartElementIndex = this.head + index;
        System.arraycopy(this.elements, rightStartElementIndex, this.elements, rightStartElementIndex + 1, size - index);
        this.elements[this.head - index] = element;
        this.elements[this.head + index] = element;
        size++;
    }

    @Override
    public void set(int index, E element) {
        checkIndex(index);
        this.elements[this.head - index] = element;
        this.elements[this.head + index] = element;
    }

    @Override
    public E peek() {
        return get(size-1);
    }

    @Override
    public E poll() {
        return removeFirst();
    }

    @Override
    public E pop() {
        return removeLast();
    }

    @Override
    @SuppressWarnings("unchecked cast")
    public E get(int index) {
        checkIndex(index);
        return (E) this.elements[this.head + index];
    }

    @Override
    @SuppressWarnings("unchecked cast")
    public E get(Object object) {
        return Arrays.stream(this.elements)
                .limit(this.elements.length / 2)
                .filter(e -> e.equals(object))
                .map(e -> (E) e)
                .findFirst().orElse(null);
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E element = (E) this.elements[this.head + index];
        System.arraycopy(this.elements, getLeftTail()+1, this.elements, getLeftTail() + 2, size - index-1);
        int rightStartElementIndex = this.head + index + 1;
        System.arraycopy(this.elements, rightStartElementIndex, this.elements, rightStartElementIndex - 1, size - index-1);
        this.elements[getLeftTail() + 1 ] = null;
        this.elements[getRightTail() - 1 ] = null;
        size--;
        return element;
    }

    @Override
    public E remove(Object object) {
        for (int i = this.head; i > this.getLeftTail(); i--) {
            if (elements[i].equals(object)) {
                return remove(this.head - i);
            }
        }
        return null;
    }

    @Override
    public E removeFirst() {
        return this.remove(0);
    }

    @Override
    public E removeLast() {
        return this.remove(size-1);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int capacity() {
        return this.elements.length / 2 + 1;
    }

    @Override
    public void trimToSize() {
        int leftElementIndex = this.head - (size - 1);
        Object[] newElements = new Object[size*2-1];
        System.arraycopy(this.elements,leftElementIndex, newElements, 0, newElements.length);
        this.elements = newElements;
        this.head = newElements.length / 2;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int position = 0;
            @Override
            public boolean hasNext() {
                return this.position < size;
            }

            @Override
            public E next() {
                return get(this.position++);
            }
        };
    }

    private void ensureCapacity() {
        if (this.size == this.capacity()) {
            grow();
        }
    }

    @Override
    public String toString() {
       return Arrays.stream(this.elements)
               .map(x->x == null ? "_":x.toString())
               .collect(Collectors.joining(" "));
    }

    private void grow() {
        Object[] newElements = new Object[this.elements.length * 2 + 1];
        System.arraycopy(this.elements, 0, newElements, (newElements.length / 2 + 1) - size, this.elements.length);
        this.head = newElements.length / 2;
        this.elements = newElements;
    }

    private void checkIndex(int index) {
        if (0 > index || index > size - 1)
            throw new IndexOutOfBoundsException();
    }
}
