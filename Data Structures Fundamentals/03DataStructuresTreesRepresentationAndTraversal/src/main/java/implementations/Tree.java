package implementations;

import interfaces.AbstractTree;

import java.util.*;

public class Tree<E> implements AbstractTree<E> {

    private E key;
    private List<Tree<E>> children;
    private Tree<E> parent;

    public Tree(E key, Tree<E>... children) {
        this.key = key;
        this.children = new ArrayList<>();
        for (Tree<E> child : children) {
            this.children.add(child);
            child.parent = this;
        }
    }

    @Override
    public List<E> orderBfs() {
        List<E> result = new ArrayList<>();
        if (this.key != null) {
            Deque<Tree<E>> queue = new ArrayDeque<>();
            queue.offer(this);
            while (!queue.isEmpty()) {
                Tree<E> currentTree = queue.poll();
                result.add(currentTree.key);
                currentTree.children
                        .forEach(ch -> queue.offer(ch));
            }
        }
        return result;
    }

    public List<E> orderDfs() {
        List<E> order = new ArrayList<>();
        this.dfs(this, order);
        return order;
    }

    private void dfs(Tree<E> tree, List<E> order) {
        tree.children.forEach(ch -> dfs(ch, order));
        order.add(tree.key);
    }

    @Override
    public void addChild(E parentKey, Tree<E> child) {
        Tree<E> parent = findNodeByKey(parentKey);
        child.parent = parent;
        parent.children.add(child);
    }

    private Tree<E> findNodeByKey(E parentKey) {
        Deque<Tree<E>> queue = new ArrayDeque<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            Tree<E> currentTree = queue.poll();
            if (currentTree.key.equals(parentKey)) {
                return currentTree;
            }
            currentTree.children
                    .forEach(ch -> queue.offer(ch));
        }
        return null;
    }

    @Override
    public void removeNode(E nodeKey) {
        Tree<E> node = findNodeByKey(nodeKey);

        if (node == null) {
            throw new IllegalArgumentException();
        }

        if (node.parent != null) {
            node.parent.children.remove(node);
        } else {
            node.key = null;
        }
    }

    @Override
    public void swap(E firstKey, E secondKey) {
        Tree<E> firstNode = findNodeByKey(firstKey);
        Tree<E> secondNode = findNodeByKey(secondKey);

        if (firstNode == null || secondNode == null) {
            throw new IllegalArgumentException();
        }

        if (isRoot(firstNode)) {
            firstNode.key = secondNode.key;
            firstNode.children = secondNode.children;
        } else if (isRoot(secondNode)) {
            secondNode.key = firstKey;
            secondNode.children = firstNode.children;
        } else {

            Tree<E> firstParent = firstNode.parent;
            Tree<E> secondParent = secondNode.parent;

            int firstIndex = firstParent.children.indexOf(firstNode);
            int secondIndex = secondParent.children.indexOf(secondNode);
            firstParent.children.set(firstIndex, secondNode);
            secondParent.children.set(secondIndex, firstNode);

            firstNode.parent = secondParent;
            secondNode.parent = firstParent;
        }
    }

    private boolean isRoot(Tree<E> node) {
        return node.parent == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tree<?> tree = (Tree<?>) o;
        return key.equals(tree.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}



