package core;

import model.Message;
import shared.DataTransferSystem;

import java.util.ArrayList;
import java.util.List;

public class MessagingSystem implements DataTransferSystem {
    private Node root;
    private int size;


    @Override
    public void add(Message message) {
        Node newNode = new Node(message);

        if (root == null) {
            this.root = newNode;
        } else {
            add(root, message);
        }

        size++;
    }

    private void add(Node node, Message message) {

        if (node.getWeight() == message.getWeight()) {
            throw new IllegalArgumentException();
        }

        Node newNode = new Node(message);
        if (node.getWeight() > message.getWeight()) {
            if (node.left == null) {
                node.left = newNode;
            } else {
                add(node.left, message);
            }
        }

        if (node.getWeight() < message.getWeight()) {
            if (node.right == null) {
                node.right = newNode;
            } else {
                add(node.right, message);
            }
        }
    }

    @Override
    public Message getByWeight(int weight) {
        Node node = getByWeight(root, weight);
        if (node == null) {
            throw new IllegalArgumentException();
        }

        return node.message;
    }

    private Node getByWeight(Node node, int weight) {
        if(node == null) return null;
        Node result;
        if (node.getWeight() == weight) {
            result = node;
        } else if (node.getWeight() > weight) {
            result = getByWeight(node.left, weight);
        } else {
            result = getByWeight(node.right, weight);
        }

        return result;
    }

    @Override
    public Message getLightest() {
        ensureNotEmpty();
        return getLightest(root);
    }

    private Message getLightest(Node node) {
        if (node.left == null) {
            return node.message;
        }
        return getLightest(node.left);
    }

    @Override
    public Message getHeaviest() {
        ensureNotEmpty();
        return getHeaviest(root);
    }

    private Message getHeaviest(Node node) {
        if (node.right == null) {
            return node.message;
        }

        return getHeaviest(node.right);
    }

    @Override
    public Message deleteLightest() {
        ensureNotEmpty();
        Node node = null;
        if (root.left == null) {
            node = root;
            root = root.right;
        } else {
            Node parent = root;
            while (parent.left.left != null) {
                parent = parent.left;
            }
            node = parent.left;
            parent.left = parent.left.right;
        }
        size--;
        return node.message;
    }

    @Override
    public Message deleteHeaviest() {
        ensureNotEmpty();
        Node node = null;
        if (root.right == null) {
            node = root;
            root = root.left;
        } else {
            Node parent = root;
            while (parent.right.right != null) {
                parent = parent.right;
            }
            node = parent.right;
            parent.right = parent.right.left;
        }
        size--;
        return node.message;
    }

    @Override
    public Boolean contains(Message message) {
        return getByWeight(root, message.getWeight()) != null;
    }

    @Override
    public List<Message> getOrderedByWeight() {
        return getInOrder();
    }

    @Override
    public List<Message> getPostOrder() {
        List<Message> result = new ArrayList<>();
        getPostOrder(root, result);
        return result;
    }

    private void ensureNotEmpty() {
        if (size == 0) throw new IllegalStateException();
    }

    private void getPostOrder(Node node, List<Message> result) {
        if (node == null) {
            return;
        }
        getPostOrder(node.left, result);
        getPostOrder(node.right, result);
        result.add(node.message);
    }

    // tree copy
    @Override
    public List<Message> getPreOrder() {
        List<Message> result = new ArrayList<>();
        getPreOrder(root, result);
        return result;
    }

    private void getPreOrder(Node node, List<Message> result) {
        if (node == null) {
            return;
        }
        result.add(node.message);
        getPreOrder(node.left, result);
        getPreOrder(node.right, result);
    }

    //sorted Tree
    @Override
    public List<Message> getInOrder() {
        List<Message> result = new ArrayList<>();
        getInOrder(root, result);
        return result;
    }

    private void getInOrder(Node node, List<Message> result) {
        if (node == null) {
            return;
        }
        getInOrder(node.left, result);
        result.add(node.message);
        getInOrder(node.right, result);
    }

    @Override
    public int size() {
        return this.size;
    }

    private static class Node {
        private Message message;
        private Node left;
        private Node right;

        public Node(Message message) {
            this.message = message;
        }

        int getWeight() {
            return this.message.getWeight();
        }
    }
}
