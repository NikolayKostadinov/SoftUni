package implementations;

import interfaces.AbstractBinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class BinaryTree<E> implements AbstractBinaryTree<E> {
    private E key;
    private final BinaryTree<E> leftChild;
    private final BinaryTree<E> rightChild;

    public BinaryTree(E key, BinaryTree<E> left, BinaryTree<E> right) {
        this.key = key;
        this.leftChild = left;
        this.rightChild = right;
    }

    @Override
    public E getKey() {
        return this.key;
    }

    @Override
    public AbstractBinaryTree<E> getLeftChild() {
        return this.leftChild;
    }

    @Override
    public AbstractBinaryTree<E> getRightChild() {
        return this.rightChild;
    }

    @Override
    public void setKey(E key) {
        this.key = key;
    }

    @Override
    public String asIndentedPreOrder(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(repeat(indent, " ")).append(this.key);
        if (this.leftChild != null) {
            sb.append(System.lineSeparator()).append(this.leftChild.asIndentedPreOrder(indent + 2));
        }
        if (this.rightChild != null) {
            sb.append(System.lineSeparator()).append(this.rightChild.asIndentedPreOrder(indent + 2));
        }

        return sb.toString();
    }

    @Override
    public List<AbstractBinaryTree<E>> preOrder() {
        return preOrder(this);
    }

    private List<AbstractBinaryTree<E>> preOrder(BinaryTree<E> node) {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        if (node != null) {
            result.add(node);
            result.addAll(preOrder(node.leftChild));
            result.addAll(preOrder(node.rightChild));
        }

        return result;
    }

    @Override
    public List<AbstractBinaryTree<E>> inOrder() {
        return inOrder(this);
    }

    private List<AbstractBinaryTree<E>> inOrder(BinaryTree<E> node) {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        if (node != null) {
            result.addAll(inOrder(node.leftChild));
            result.add(node);
            result.addAll(inOrder(node.rightChild));
        }

        return result;
    }

    @Override
    public List<AbstractBinaryTree<E>> postOrder() {
        return postOrder(this);
    }

    private List<AbstractBinaryTree<E>> postOrder(BinaryTree<E> node) {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        if (node != null) {
            result.addAll(postOrder(node.leftChild));
            result.addAll(postOrder(node.rightChild));
            result.add(node);
        }

        return result;
    }

    @Override
    public void forEachInOrder(Consumer<E> consumer) {
        if (this.leftChild != null){
            this.leftChild.forEachInOrder(consumer);
        }
        consumer.accept(this.getKey());
        if (this.rightChild != null){
            this.rightChild.forEachInOrder(consumer);
        }
    }

    private String repeat(int indent, String str) {
        String[] repeated = new String[indent];
        return Arrays.stream(repeated)
                .map(x -> x = str)
                .collect(Collectors.joining(""));
    }
}
