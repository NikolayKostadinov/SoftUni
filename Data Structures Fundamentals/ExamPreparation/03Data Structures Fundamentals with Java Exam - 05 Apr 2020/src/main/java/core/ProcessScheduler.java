package core;

import model.Task;
import shared.Scheduler;

import java.util.ArrayList;
import java.util.List;

public class ProcessScheduler implements Scheduler {
    private Node first;
    private Node last;
    private int size;

    @Override
    public void add(Task task) {
        if (this.first == null) {
            this.first = new Node(task);
            this.last = first;
        } else {
            attachAfter(last, task);
        }
        this.size++;
    }

    private void attachAfter(Node destination, Task task) {
        Node node = new Node(task);
        if (destination == last) {
            last = node;
        } else {
            node.next = destination.next;
        }

        destination.next = node;
    }

    @Override
    public Task process() {
        if (size == 0) return null;
        Task task = peek();
        remove(task.getId());
        return task;
    }

    @Override
    public Task peek() {
        Task task = null;
        if (size > 0) {
            task = this.first.task;
        }

        return task;
    }

    @Override
    public Boolean contains(Task task) {
        for (Node node = first; node != null; node = node.next) {
            if (node.task.getId() == task.getId()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Boolean remove(Task task) {
        return remove(task.getId());
    }

    @Override
    public Boolean remove(int id) {
        NodeAndPrev result = getNodeAndPrevByTaskId(id);

        if (result.node == first) {
            first = result.node.next;
        } else {
            result.prev.next = result.node.next;
            if (result.node == last) {
                last = result.prev;
            }
        }
        size--;
        return true;
    }


    @Override
    public void insertBefore(int id, Task task) {
        NodeAndPrev result = getNodeAndPrevByTaskId(id);
        if (result.node == first) {
            Node node = new Node(task);
            node.next = first;
            first = node;
        } else {
            attachAfter(result.prev, task);
        }
        size++;
    }

    @Override
    public void insertAfter(int id, Task task) {
        Node node = getNodeByTaskId(id);
        attachAfter(node, task);
        size++;
    }

    @Override
    public void clear() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    @Override
    public Task[] toArray() {
        return toList().toArray(new Task[size]);
    }

    @Override
    public void reschedule(Task first, Task second) {
        Node firstNode = getNodeByTaskId(first.getId());
        Node secondNode = getNodeByTaskId(second.getId());

        firstNode.task = second;
        secondNode.task = first;
    }

    @Override
    public List<Task> toList() {
        List<Task> tasks = new ArrayList<>(size);
        for (Node node = first; node != null; node = node.next) {
            tasks.add(node.task);
        }
        return tasks;
    }

    @Override
    public void reverse() {
        List<Task> tasks = toList();
        clear();
        for (int i = tasks.size() - 1; i >= 0; i--) {
            add(tasks.get(i));
        }
    }

    @Override
    public Task find(int id) {
        return getNodeByTaskId(id).task;
    }

    @Override
    public Task find(Task task) {
        return getNodeByTaskId(task.getId()).task;
    }

    private Node getNodeByTaskId(int id) {
        return getNodeAndPrevByTaskId(id).node;
    }

    private NodeAndPrev getNodeAndPrevByTaskId(int id) {
        Node prev = null;
        for (Node node = first; node != null; node = node.next) {
            if (node.task.getId() == id) {
                return new NodeAndPrev(prev, node);
            }
            prev = node;
        }
        throw new IllegalArgumentException();
    }

    private static class Node {
        private Task task;
        private Node next;

        public Node(Task value) {
            this.task = value;
        }
    }

    private static class NodeAndPrev {
        private Node prev;
        private Node node;

        public NodeAndPrev(Node prev, Node node) {
            this.prev = prev;
            this.node = node;
        }
    }
}
