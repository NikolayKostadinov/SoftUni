package implementations;

import interfaces.AbstractBinarySearchTree;

public class BinarySearchTree<E extends Comparable<E>> implements AbstractBinarySearchTree<E> {
    private Node<E> root;
    private Node<E> leftChild;
    private Node<E> rightChild;

    public BinarySearchTree() {
    }

    public BinarySearchTree(Node<E> root) {
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
        if (getRoot() == null) {
            this.root = new Node<>(element);
        } else {
            Node<E> current = this.root;
            Node<E> prev = current;
            while (current != null) {
                prev = current;
                if (less(element, current.value)){
                    current = current.leftChild;
                } else if(greater(element, current.value)){
                    current = current.rightChild;
                } else {
                    return;
                }
            }

            if (less(element, prev.value)){
                prev.leftChild = new Node<>(element);
            } else if (greater(element, prev.value)){
                prev.rightChild = new Node<>(element);
            }
        }
    }

    @Override
    public boolean contains(E element) {
        Node<E> current = this.root;
        while (current != null){
            if (less(element, current.value)){
                current = current.leftChild;
            } else if(greater(element, current.value)){
                current = current.rightChild;
            } else {
               break;
            }
        }
        return current != null;
    }

    @Override
    public AbstractBinarySearchTree<E> search(E element) {
        Node<E> current = this.root;
        while (current != null){
            if (less(element, current.value)){
                current = current.leftChild;
            } else if(greater(element, current.value)){
                current = current.rightChild;
            } else {
                return new BinarySearchTree<>(current);
            }
        }
        return null;
    }

    @Override
    public Node<E> getRoot() {
        return this.root;
    }

    @Override
    public Node<E> getLeft() {
        return this.leftChild;
    }

    @Override
    public Node<E> getRight() {
        return this.rightChild;
    }

    @Override
    public E getValue() {
        return this.root.value;
    }

    private boolean less(E first, E second) {
        return first.compareTo(second) < 0;
    }

    private boolean greater(E first, E second) {
        return first.compareTo(second) > 0;
    }
}
