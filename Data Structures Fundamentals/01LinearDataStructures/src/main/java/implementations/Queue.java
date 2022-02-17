package implementations;

import interfaces.AbstractQueue;
import interfaces.LinkedList;

import java.util.Iterator;

public class Queue<E> implements AbstractQueue<E> {

    private final LinkedList<E> list = new SinglyLinkedList<>();

    @Override
    public void offer(E element) {
        this.list.addLast(element);
    }

    @Override
    public E poll() {
        checkEmpty();
        return this.list.removeFirst();
    }

    @Override
    public E peek() {
        checkEmpty();
        return this.list.getFirst();
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return this.list.iterator();
    }

    private void checkEmpty() {
        if (this.list.isEmpty()) throw new IllegalStateException();
    }
}
