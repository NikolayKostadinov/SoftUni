package core;

import model.Task;
import shared.Scheduler;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class ProcessScheduler implements Scheduler {
    private Node head;
    private Node tail;
    private int size;

    public Task getTailValue() {
        return tail.task;
    }

    @Override
    public void add(Task task) {
        Node newNode = new Node(task);
        if (this.head == null) {
            this.head = newNode;
        } else {
            newNode.prev = this.tail;
            this.tail.next = newNode;
        }
        this.tail = newNode;
        this.size++;
    }

    @Override
    public Task process() {
        if (this.head == null) return null;
        Task task = this.head.task;
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            Node newHead = this.head.next;
            this.head = newHead;
        }
        this.size--;
        return task;
    }

    @Override
    public Task peek() {
        if (this.head == null) return null;
        return this.head.task;
    }

    @Override
    public Boolean contains(Task task) {
        return findNode(task.getId()) != null;
    }

    private Node findNode(int id) {
        Node node = this.head;
        while (node != null) {
            if (node.task.getId() == id) {
                return node;
            }
            node = node.next;
        }
        return null;
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
        Node node = findNode(id);
        ensureFound(node);
        if (node.equals(head)){
            this.head = node.next;
            head.prev = null;
        } else if (node.equals(tail)){
            tail.prev.next = node;
            tail = node.prev;
            tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        size--;
        return true;
    }

    @Override
    public void insertBefore(int id, Task task) {
        Node node = findNode(id);
        ensureFound(node);
        Node newNode = new Node(task);
        if (node.equals(head)){
            newNode.next = node;
            node.prev = newNode;
            head = newNode;
        } else {
            node.prev.next = newNode;
            newNode.prev =  node.prev;
            node.prev = newNode;
            newNode.next = node;
        }
        size++;
    }

    @Override
    public void insertAfter(int id, Task task) {
        Node node = findNode(id);
        ensureFound(node);
        Node newNode = new Node(task);
        if (node.equals(tail)){
            newNode.prev = node;
            node.next = newNode;
            tail = newNode;
        } else {
            newNode.prev = node;
            newNode.next = node.next;
            node.next.prev = newNode;
            node.next = newNode;
        }
        size++;
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    @Override
    public Task[] toArray() {
        Task[] tasks = new Task[size];
        int index = 0;
        Node node = this.head;
        while (node != null){
            tasks[index++] = node.task;
            node = node.next;
        }
        return tasks;
    }

    @Override
    public void reschedule(Task first, Task second) {
        Node firstNode = findNode(first.getId());
        Node secondNode = findNode(second.getId());
        ensureFound(firstNode);
        ensureFound(secondNode);
        Task buff = firstNode.task;
        firstNode.task = secondNode.task;
        secondNode.task = buff;
    }

    @Override
    public List<Task> toList() {
        List<Task> tasks = new ArrayList<>();
        Node node = this.head;
        while (node != null){
            tasks.add(node.task);
            node = node.next;
        }
        return tasks;
    }

    @Override
    public void reverse() {
        ProcessScheduler processScheduler = new ProcessScheduler();
        Node node = this.tail;
        while (node != null){
            processScheduler.add(node.task);
            node = node.prev;
        }

        this.head = processScheduler.head;
        this.tail = processScheduler.tail;
    }

    @Override
    public Task find(int id) {
        Node node = findNode(id);
        ensureFound(node);
        return node.task;
    }

    @Override
    public Task find(Task task) {
        return find(task.getId());
    }

    private void ensureFound(Node node) {
        if (node == null) throw new IllegalArgumentException();
    }

    private static class Node {
        private Task task;
        private Node prev;
        private Node next;

        public Node(Task value) {
            this.task = value;
        }
    }
}
