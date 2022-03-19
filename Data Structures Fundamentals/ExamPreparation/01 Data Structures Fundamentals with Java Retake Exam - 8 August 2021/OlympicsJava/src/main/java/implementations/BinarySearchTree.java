package implementations;

import interfaces.AbstractBinarySearchTree;

import java.util.function.Consumer;

public class BinarySearchTree<E extends Comparable<E>> implements AbstractBinarySearchTree<E> {
    private Node<E> root;
    private Node<E> left;
    private Node<E> right;

    private int size = 0;

    public BinarySearchTree() {
    }

    private BinarySearchTree(Node<E> root) {
        this.copy(root);
    }

    private void copy(Node<E> node) {
        if (node == null) return;
        this.insert(node.value);
        this.copy(node.leftChild);
        this.copy(node.rightChild);
    }


    @Override
    public void insert(E element) {
        size++;
        Node<E> newNode = new Node<>(element);
        if (this.root == null) {
            this.root = newNode;
        } else {
            Node<E> current = this.root;
            Node<E> prev = current;
            while (current != null) {
                prev = current;
                if (less(newNode, current )) {
                    current = current.leftChild;
                } else if (greater(newNode, current)) {
                    current = current.rightChild;
                } else if (equals(newNode, current)){
                    throw new IllegalArgumentException();
                }
            }

            if (less(newNode, prev)){
                prev.leftChild = newNode;
            }else if (greater(newNode, prev)){
                prev.rightChild = newNode;
            }
        }
    }

    private boolean equals(Node<E> node1, Node<E> node2) {
        return node1.value.compareTo(node2.value) == 0;
    }

    private boolean less(Node<E> node1, Node<E> node2) {
        return node1.value.compareTo(node2.value) < 0;
    }

    private boolean greater(Node<E> node1, Node<E> node2) {
        return node1.value.compareTo(node2.value) > 0;
    }

    @Override
    public boolean contains(E element) {
        Node<E> node = new Node<>(element);
        Node<E> current = this.root;
        while (current != null) {
            if (less(node, current )) {
                current = current.leftChild;
            } else if (greater(node, current)) {
                current = current.rightChild;
            } else if (equals(node, current)){
                return true;
            }
        }
        return false;
    }

    @Override
    public AbstractBinarySearchTree<E> search(E element) {
        Node<E> node = new Node<>(element);
        Node<E> current = this.root;
        while (current != null) {
            if (less(node, current )) {
                current = current.leftChild;
            } else if (greater(node, current)) {
                current = current.rightChild;
            } else if (equals(node, current)){
                return new BinarySearchTree<>(current);
            }
        }
        return null;
    }

    @Override
    public E searchElement(E element) {
        Node<E> node = new Node<>(element);
        Node<E> current = this.root;
        while (current != null) {
            if (less(node, current )) {
                current = current.leftChild;
            } else if (greater(node, current)) {
                current = current.rightChild;
            } else if (equals(node, current)){
                return current.value;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Node<E> getRoot() {
        return this.root;
    }

    @Override
    public Node<E> getLeft() {
        return this.left;
    }

    @Override
    public Node<E> getRight() {
        return this.right;
    }

    @Override
    public E getValue() {
        return this.root.value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void forEachInOrder(Consumer<E> consumer) {
        forEachInOrder(this.root, consumer);
    }

    private void forEachInOrder(Node<E> node, Consumer<E> consumer) {
        if (node.leftChild != null) {
            forEachInOrder(node.leftChild,consumer);
        }

        consumer.accept(node.value);

        if (node.rightChild != null) {
            forEachInOrder(node.rightChild, consumer);
        }
    }
}
