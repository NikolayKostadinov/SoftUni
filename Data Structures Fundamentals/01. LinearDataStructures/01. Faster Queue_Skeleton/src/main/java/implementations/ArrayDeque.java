package implementations;

import interfaces.Deque;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;

public class ArrayDeque<E> implements Deque<E> {

    private final int DEFAULT_CAPACITY = 7;
    private int head;
    private int tail;
    private int size;

    private Object[] elements;

    public ArrayDeque() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.head = this.DEFAULT_CAPACITY / 2;
        this.tail = this.head;
    }

    @Override
    public void add(E element) {
        ensureCapacity();
        this.elements[tail++] = element;
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
        ensureCapacity();
        this.elements[--head] = element;
        size++;
    }

    @Override
    public void insert(int index, E element) {
        checkIndex(index);
        ensureCapacity();
        int rightStartElementIndex = this.head + index;
        System.arraycopy(this.elements, rightStartElementIndex, this.elements, rightStartElementIndex + 1, size - index);
        this.elements[this.head + index] = element;
        this.tail++;
        size++;
    }

    @Override
    public void set(int index, E element) {
        checkIndex(index);
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
                .filter(e -> e != null && object.equals((E)e))
                .map(e-> (E)e)
                .findFirst().orElse(null);
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E element = (E) this.elements[this.head + index];
        int rightStartElementIndex = this.head + index + 1;
        System.arraycopy(this.elements, rightStartElementIndex, this.elements, rightStartElementIndex - 1, size - index-1);
        this.elements[--tail] = null;
        size--;
        return element;
    }

    @Override
    public E remove(Object object) {
        for (int i = this.head; i < this.tail; i++) {
            if (elements[i].equals(object)) {
                return remove(this.head - i);
            }
        }
        return null;
    }

    @Override
    public E removeFirst() {
        E element = (E) this.elements[this.head];
        this.elements[this.head++] = null;
        size--;
        return element;
    }

    @Override
    public E removeLast() {
        E element = (E) this.elements[--this.tail];
        this.elements[this.tail] = null;
        size--;
        return element;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int capacity() {
        return this.elements.length;
    }

    @Override
    public void trimToSize() {
        int leftElementIndex = this.head - (size - 1);
        Object[] newElements = new Object[size];
        System.arraycopy(this.elements,this.head, newElements, 0, size);
        this.elements = newElements;
        this.head = 0;
        this.tail = this.elements.length;
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

    @Override
    public String toString() {
       return Arrays.stream(this.elements)
               .map(x->x == null ? "_":x.toString())
               .collect(Collectors.joining(" "));
    }

    private void ensureCapacity() {
        if (this.tail == this.elements.length || this.head == 0) {
            grow();
        }
    }

    private void grow() {
        Object[] newElements = new Object[this.elements.length * 2];
        System.arraycopy(this.elements, this.head, newElements, (newElements.length / 2) - size / 2 - 1, this.size);
        this.head = (newElements.length / 2) - size / 2 - 1;
        this.tail = head + size;
        this.elements = newElements;
    }

    private void checkIndex(int index) {
        if (0 > index || index > size)
            throw new IndexOutOfBoundsException();
    }
}
