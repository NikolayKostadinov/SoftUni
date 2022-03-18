package implementations;

import interfaces.AbstractBinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BinaryTree<E> implements AbstractBinaryTree<E> {
    BinaryTree<E> left;
    BinaryTree<E> right;
    private E key;

    public BinaryTree(E key, BinaryTree<E> left, BinaryTree<E> right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    @Override
    public E getKey() {
        return this.key;
    }

    @Override
    public void setKey(E key) {
        this.key = key;
    }

    @Override
    public AbstractBinaryTree<E> getLeft() {
        return this.left;
    }

    @Override
    public AbstractBinaryTree<E> getRight() {
        return this.right;
    }

    @Override
    public String asIndentedPreOrder(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(getIndent(indent)).append(key);
        if (left != null) {
            sb.append(System.lineSeparator()).append(left.asIndentedPreOrder(indent + 2));
        }
        if (right != null) {
            sb.append(System.lineSeparator()).append(right.asIndentedPreOrder(indent + 2));
        }
        return sb.toString();
    }

    private String getIndent(int indent) {
        StringBuilder indt = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            indt.append(" ");
        }
        return indt.toString();
    }

    @Override
    public List<AbstractBinaryTree<E>> preOrder() {
        List<AbstractBinaryTree<E>> nodes = new ArrayList<>();
        preOrder(this, nodes);
        return nodes;
    }

    //Tree Copy
    private void preOrder(AbstractBinaryTree<E> node, List<AbstractBinaryTree<E>> nodes) {
        if (node == null) return;
        nodes.add(node);
        preOrder(node.getLeft(), nodes);
        preOrder(node.getRight(), nodes);
    }

    @Override
    public List<AbstractBinaryTree<E>> inOrder() {
        List<AbstractBinaryTree<E>> nodes = new ArrayList<>();
        inOrder(this, nodes);
        return nodes;
    }

    // Sorted elements
    private void inOrder(AbstractBinaryTree<E> node, List<AbstractBinaryTree<E>> nodes) {
        if (node == null) return;
        inOrder(node.getLeft(), nodes);
        nodes.add(node);
        inOrder(node.getRight(), nodes);
    }

    @Override
    public List<AbstractBinaryTree<E>> postOrder() {
        List<AbstractBinaryTree<E>> nodes = new ArrayList<>();
        postOrder(this, nodes);
        return nodes;
    }

    // HeapifyUp
    private void postOrder(AbstractBinaryTree<E> node, List<AbstractBinaryTree<E>> nodes) {
        if (node == null) return;
        postOrder(node.getLeft(), nodes);
        postOrder(node.getRight(), nodes);
        nodes.add(node);
    }

    @Override
    public void forEachInOrder(Consumer<E> consumer) {
        inOrder().forEach(x -> consumer.accept(x.getKey()));
    }
}
