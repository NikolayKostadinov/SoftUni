package core;

import model.Task;
import shared.Scheduler;

import java.util.*;

public class ProcessScheduler implements Scheduler {
    Map<Integer, Node> nodeMap;
    private Node head;
    private Node tail;
    private int size;

    private static class Node {
        private Task element;
        private Node prev;
        private Node next;

        public Node(Task value) {
            this.element = value;
        }
    }

    public ProcessScheduler() {
        this.nodeMap = new TreeMap<>();
    }

    @Override
    public void add(Task task) {
        Node newNode = new Node(task);
        if (this.head == null) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
        }
        this.tail = newNode;
        this.size++;
        this.nodeMap.put(task.getId(), newNode);
    }

    @Override
    public Task process() {
        Task element = this.head.element;
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            Node next = this.head.next;
            this.head.next = null;
            this.head = next;
        }
        this.size--;
        this.nodeMap.remove(element.getId());

        return element;
    }

    @Override
    public Task peek() {
        if (this.head != null) {
            return this.head.element;
        } else {
            return null;
        }
    }

    @Override
    public Boolean contains(Task task) {
        return this.nodeMap.containsKey(task.getId());
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
        ensureExists(id);
        Node node = this.nodeMap.remove(id);
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        size--;
        return true;
    }

    private void ensureExists(int id) {
        if (!this.nodeMap.containsKey(id))
            throw new IllegalArgumentException();
    }

    @Override
    public void insertBefore(int id, Task task) {

    }

    @Override
    public void insertAfter(int id, Task task) {

    }

    @Override
    public void clear() {
        this.nodeMap.clear();
        this.head = null;
        this.tail = null;
        this.size = 0;

    }

    @Override
    public Task[] toArray() {
        Task[] tasks = new Task[size()];
        int ix = 0;
        while (iterator().hasNext()){
            tasks[ix++]= iterator().next();
        }
        return tasks;
    }

    @Override
    public void reschedule(Task first, Task second) {

    }

    @Override
    public List<Task> toList() {
        List<Task> tasks = new ArrayList<>(size);
        while (iterator().hasNext()){
            tasks.add(iterator().next());
        }
        return tasks;
    }

    @Override
    public void reverse() {

    }

    @Override
    public Task find(int id) {
        ensureExists(id);
        return nodeMap.get(id).element;
    }

    @Override
    public Task find(Task task) {
        return find(task.getId());
    }

    public Iterator<Task> iterator() {
        return new Iterator<Task>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return this.current != null;
            }

            @Override
            public Task next() {
                Task element = this.current.element;
                this.current = this.current.next;
                return element;
            }
        };
    }
}
