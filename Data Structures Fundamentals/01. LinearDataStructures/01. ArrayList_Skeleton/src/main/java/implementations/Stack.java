package implementations;

import interfaces.AbstractStack;
import interfaces.LinkedList;

import java.util.Iterator;

public class Stack<E> implements AbstractStack<E> {
    private LinkedList<E> list = new SinglyLinkedList<>();
    @Override
    public void push(E element) {
        this.list.addFirst(element);
    }

    @Override
    public E pop() {
        checkEmpty();
        return list.removeFirst();
    }

    @Override
    public E peek() {
        checkEmpty();
        return list.getFirst();
    }

    private void checkEmpty() {
        if (this.list.isEmpty()) throw new IllegalStateException();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
}
