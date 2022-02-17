package implementations;

import interfaces.LinkedList;

import java.util.Iterator;

public class SinglyLinkedList<E> implements LinkedList<E> {
    Node<E> head;
    Node<E> tail;
    int size = 0;

    @Override
    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        if (this.head != null) {
            newNode.next = this.head;
            this.head.prev = newNode;
        } else {
            this.tail = newNode;
        }

        this.head = newNode;
        size++;
    }

    @Override
    public void addLast(E element) {
        Node<E> node = this.tail;
        Node<E> newNode = new Node<>(element);
        if (node == null) {
            this.head = newNode;
        } else {
            newNode.prev = node;
            node.next = newNode;
        }
        this.tail = newNode;
        size++;
    }

    @Override
    public E removeFirst() {
        E result = this.head.element;
        this.head = this.head.next;
        size--;
        return result;
    }

    @Override
    public E removeLast() {
        if (tail != null) {
            Node<E> lastNode = tail;
            lastNode.prev.next = null;
            size--;
            return lastNode.element;
        }
        return null;
    }

    @Override
    public E getFirst() {
        return this.head.element;
    }

    @Override
    public E getLast() {
        return this.tail.element;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> node = head;

            @Override
            public boolean hasNext() {
                return node.next != null;
            }

            @Override
            public E next() {
                E result = node.element;
                node = node.next;
                return result;
            }
        };
    }

//    private Node<E> getLastNode() {
//        if (this.head == null) return null;
//        Node<E> node = this.head;
//        while (node.next != null) {
//            node = node.next;
//        }
//        return node;
//    }

    class Node<E> {

        public Node(E element) {
            this.element = element;
        }

        public Node() {
        }

        E element;
        Node<E> prev;
        Node<E> next;
    }
}