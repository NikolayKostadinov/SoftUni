package interfaces;

import java.util.List;
import java.util.function.Consumer;

public interface AbstractBinaryTree<E> {
    E getKey();
    AbstractBinaryTree<E> getLeftChild();
    AbstractBinaryTree<E> getRightChild();
    void setKey(E key);
    String asIndentedPreOrder(int indent);
    List<AbstractBinaryTree<E>> preOrder();
    List<AbstractBinaryTree<E>> inOrder();
    List<AbstractBinaryTree<E>> postOrder();
    void forEachInOrder(Consumer<E> consumer);
}
