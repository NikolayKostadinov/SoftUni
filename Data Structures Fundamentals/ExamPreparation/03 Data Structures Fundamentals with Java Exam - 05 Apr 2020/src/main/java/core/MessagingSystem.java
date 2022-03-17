package core;

import model.Message;
import shared.DataTransferSystem;

import java.util.ArrayList;
import java.util.List;

public class MessagingSystem implements DataTransferSystem {

    int size;
    private Node root;

    @Override
    public void add(Message message) {
        if (this.root == null) {
            this.root = new Node(message);
        } else {
            Node current = this.root;
            Node prev = current;
            while (current != null) {
                prev = current;
                if (less(message, current.message)) {
                    current = current.left;
                } else if (greater(message, current.message)) {
                    current = current.right;
                } else {
                    throw new IllegalArgumentException();
                }
            }

            if (less(message, prev.message)) {
                prev.left = new Node(message);
            } else if (greater(message, prev.message)) {
                prev.right = new Node(message);
            }
        }
        size++;
    }

    private void add(Node node, Message message) {
        if (node == null) {
            node = new Node(message);
        } else {
            if (less(message, node.message)) {
                add(node.left, message);
            } else if (greater(message, node.message)) {
                add(node.right, message);
            } else {
                throw new IllegalArgumentException();
            }
        }

        size++;
    }

    @Override
    public Message getByWeight(int weight) {
        Node node = findNodeByWeight(weight);
        ensureFound(node);
        return node.message;
    }

    private void ensureFound(Node node) {
        if (node == null) throw new IllegalArgumentException();
    }

    private Node findNodeByWeight(int weight) {
        Node current = this.root;
        while (current != null) {
            if (weight < current.message.getWeight()) {
                current = current.left;
            } else if (weight > current.message.getWeight()) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }


    @Override
    public Message getLightest() {
        ensureNotEmpty();
        Node node = root;
        while (node.left != null) {
            node = node.left;
        }
        return node.message;
    }

    @Override
    public Message getHeaviest() {
        ensureNotEmpty();
        Node node = root;
        while (node.right != null) {
            node = node.right;
        }
        return node.message;
    }

    @Override
    public Message deleteLightest() {
        ensureNotEmpty();
        Node current = this.root;
        Node prev = current;

        while (current.left != null) {
            prev = current;
            current = current.left;
        }
        Message message;
        if (prev.equals(root)) {
            message = prev.message;
            this.root = null;
        } else {
            message = prev.left.message;
            prev.left = null;
        }

        this.size--;
        return message;
    }

    @Override
    public Message deleteHeaviest() {
        ensureNotEmpty();
        Node current = this.root;
        Node prev = current;

        while (current.right != null) {
            prev = current;
            current = current.right;
        }
        Message message;
        if (prev.equals(root)) {
            message = prev.message;
            this.root = null;
        } else {
            message = prev.right.message;
            prev.right = null;
        }

        this.size--;
        return message;
    }

    private void ensureNotEmpty() {
        if (root == null) throw new IllegalStateException();
    }

    @Override
    public Boolean contains(Message message) {
        return findNodeByWeight(message.getWeight()) != null;
    }

    @Override
    public List<Message> getOrderedByWeight() {
        return getInOrder();
    }

    @Override
    public List<Message> getPostOrder() {
        return postOrder(root);
    }

    private List<Message> postOrder(Node node) {
        List<Message> result = new ArrayList<>();
        if (node != null) {
            result.addAll(postOrder(node.left));
            result.addAll(postOrder(node.right));
            result.add(node.message);
        }

        return result;
    }

    @Override
    public List<Message> getPreOrder() {
        return preOrder(root);
    }

    private List<Message> preOrder(Node node) {
        List<Message> result = new ArrayList<>();
        if (node != null) {
            result.add(node.message);
            result.addAll(preOrder(node.left));
            result.addAll(preOrder(node.right));
        }

        return result;
    }


    @Override
    public List<Message> getInOrder() {
        return inOrder(root);
    }

    private List<Message> inOrder(Node node) {
        List<Message> result = new ArrayList<>();
        if (node != null) {
            result.addAll(inOrder(node.left));
            result.add(node.message);
            result.addAll(inOrder(node.right));
        }

        return result;
    }

    @Override
    public int size() {
        return this.size;
    }

    private boolean greater(Message first, Message second) {
        return first.getWeight() > second.getWeight();
    }

    private boolean less(Message first, Message second) {
        return first.getWeight() < second.getWeight();
    }

    class Node {

        public Message message;
        public Node left;
        public Node right;

        public Node(Message value) {
            this.message = value;
        }

        public Node(Message value, Node leftChild, Node rightChild) {
            this.message = value;
            this.left = leftChild;
            this.right = rightChild;
        }

    }
}
