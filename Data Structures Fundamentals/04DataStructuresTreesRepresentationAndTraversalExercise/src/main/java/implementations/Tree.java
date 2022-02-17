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
        if (children != null) {
            for (Tree<E> child : children) {
                this.children.add(child);
                child.parent = this;
            }
        }
    }

    @Override
    public void setParent(Tree<E> parent) {
        this.parent = parent;
    }

    @Override
    public void addChild(Tree<E> child) {
        this.children.add(child);
    }

    @Override
    public Tree<E> getParent() {
        return this.parent;
    }

    @Override
    public E getKey() {
        return this.key;
    }

    @Override
    public String getAsString() {
        return printNode(this, "").trim();
    }

    private String printNode(Tree<E> node, String indentation) {
        StringBuilder sb = new StringBuilder();
        sb.append(indentation).append(node.getKey()).append(System.lineSeparator());
        for (Tree<E> child : node.children) {
            sb.append(printNode(child, indentation + "  "));
        }
        return sb.toString();
    }

    @Override
    public List<E> getLeafKeys() {
        List<E> leafKeys = new ArrayList<>();
        getLeafKeys(this, leafKeys);
        return leafKeys;
    }

    private void getLeafKeys(Tree<E> node, List<E> leafKeys) {
        if (node.children.isEmpty()) {
            leafKeys.add(node.key);
        } else {
            for (Tree<E> child : node.children) {
                getLeafKeys(child, leafKeys);
            }
        }
    }

    @Override
    public List<E> getMiddleKeys() {
        List<E> middleKeys = new ArrayList<>();
        getMiddleKeys(this, middleKeys);
        return middleKeys;
    }

    private void getMiddleKeys(Tree<E> node, List<E> middleKeys) {
        Deque<Tree<E>> queue = new ArrayDeque<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Tree<E> currentNode = queue.poll();
            if (currentNode.getParent() != null && !currentNode.children.isEmpty()) {
                middleKeys.add(currentNode.key);
            }
            for (Tree<E> child : currentNode.children) {
                queue.offer(child);
            }
        }
    }

    @Override
    public Tree<E> getDeepestLeftmostNode() {
        Deque<Node<E>> nodeStack = new ArrayDeque<>();
        getDeepestNode(this, 0, nodeStack);
        return nodeStack.peek().tree;
    }

    private void getDeepestNode(Tree<E> node, int i, Deque<Node<E>> nodeStack) {
        i++;
        for (Tree<E> child : node.children) {
            getDeepestNode(child, i, nodeStack);
        }
        Node<E> currentDeepestNode = nodeStack.peek();
        if (nodeStack.isEmpty() || i > nodeStack.peek().deep) {
            nodeStack.push(new Node<>(i, node));
        }
    }

    @Override
    public List<E> getLongestPath() {
        List<E> longestPath = new ArrayList<>();
        getLongestPath(this, longestPath, new ArrayList<E>());

        return longestPath;
    }

    private void getLongestPath(Tree<E> node, List<E> longestPath, ArrayList<E> currentPath) {
        currentPath.add(node.getKey());
        for (Tree<E> child : node.children) {
            getLongestPath(child, longestPath, currentPath);
        }
        if (currentPath.size() > longestPath.size()) {
            longestPath.clear();
            currentPath.forEach(longestPath::add);
        }
        currentPath.remove(currentPath.size() - 1);
    }


    @Override
    public List<List<E>> pathsWithGivenSum(int sum) {
        List<List<E>> paths = new ArrayList<>();
        findPathsWithSum(sum, this, paths, new ArrayList<E>());
        return paths;
    }

    private void findPathsWithSum(int sum, Tree<E> node, List<List<E>> paths, List<E> currentPath) {
        currentPath.add(node.getKey());
        if (sum == currentPath.stream().mapToInt(x -> (Integer) x).sum()) {
            paths.add(List.copyOf(currentPath));
        }
        for (Tree<E> child : node.children) {
            findPathsWithSum(sum, child, paths, currentPath);
        }

        currentPath.remove(currentPath.size()-1);
    }


    @Override
    public List<Tree<E>> subTreesWithGivenSum(int sum) {
        List<Tree<E>> subtrees = new ArrayList<>();
        findSubtreesWithGivenSum(sum, this, subtrees);
        return subtrees;
    }

    private void findSubtreesWithGivenSum(int sum, Tree<E> tree, List<Tree<E>> subtrees) {
        int treeSum = calculateTreeSum(tree);
        if (sum == treeSum){
            subtrees.add(tree);
        }

        for (Tree<E> child : tree.children) {
            findSubtreesWithGivenSum(sum, child,subtrees);
        }
        
    }

    private int calculateTreeSum(Tree<E> tree) {
        int sum = 0;
        sum += (Integer) tree.getKey();
        for (Tree<E> child : tree.children) {
            sum += calculateTreeSum(child);
        }

        return sum;
    }

    class Node<E> {
        int deep;
        Tree<E> tree;

        public Node(int deep, Tree<E> tree) {
            this.deep = deep;
            this.tree = tree;
        }
    }
}



