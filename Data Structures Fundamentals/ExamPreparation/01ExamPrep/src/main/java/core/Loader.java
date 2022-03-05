package core;

import interfaces.Buffer;
import interfaces.Entity;
import model.BaseEntity;

import java.util.*;

public class Loader implements Buffer {
    Map<Integer, Node> nodeMap;
    private Node head;
    private Node tail;
    private int size;

    private static class Node {
        private Entity element;
        private Node prev;
        private Node next;

        public Node(Entity value) {
            this.element = value;
        }
    }

    public Loader() {
        this.nodeMap = new HashMap<>();
    }

    @Override
    public void add(Entity entity) {
        Node newNode = new Node(entity);
        if (this.head == null) {
            this.head = newNode;
        } else {
            newNode.prev = this.tail;
            this.tail.next = newNode;
        }
        this.tail = newNode;
        this.nodeMap.putIfAbsent(entity.getId(), newNode);
        size++;
    }

    @Override
    public Entity extract(int id) {
        Entity entity = null;
        if (this.nodeMap.containsKey(id)) {
            Node node = this.nodeMap.get(id);
            entity = node.element;
            if (size == 1) {
                node = null;
            } else if (node.prev == null) {
                node = node.next;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
        }
        size--;
        return entity;
    }

    @Override
    public Entity find(Entity entity) {
        Entity foundEntity = null;
        if (this.nodeMap.containsKey(entity.getId())) {
            foundEntity = this.nodeMap.get(entity.getId()).element;
        }
        return foundEntity;
    }

    @Override
    public boolean contains(Entity entity) {
        return this.nodeMap.containsKey(entity.getId());
    }

    @Override
    public int entitiesCount() {
        return this.size;
    }

    @Override
    public void replace(Entity oldEntity, Entity newEntity) {
        if (!this.nodeMap.containsKey(oldEntity.getId())) {
            throw new IllegalStateException("Entity not found");
        }

        Node node = this.nodeMap.remove(oldEntity.getId());
        node.element = newEntity;
        this.nodeMap.putIfAbsent(node.element.getId(), node);
    }

    @Override
    public void swap(Entity first, Entity second) {
        if (!(this.nodeMap.containsKey(first.getId())
                && this.nodeMap.containsKey(second.getId()))) {
            throw new IllegalStateException("Entity not found");
        }

        Node firstNode = this.nodeMap.remove(first.getId());
        Node secondNode = this.nodeMap.remove(second.getId());
        firstNode.element = second;
        secondNode.element = first;
        this.nodeMap.putIfAbsent(firstNode.element.getId(), firstNode);
        this.nodeMap.putIfAbsent(secondNode.element.getId(), secondNode);
    }

    @Override
    public void clear() {
        this.nodeMap.clear();
        this.head = null;
        size = 0;
    }

    @Override
    public Entity[] toArray() {
        Entity[] elements = new Entity[size];
        int ix = 0;
        for (Entity entity : this) {
            elements[ix++] = entity;
        }
        return elements;
    }

    @Override
    public List<Entity> retainAllFromTo(BaseEntity.Status lowerBound, BaseEntity.Status upperBound) {
        List<Entity> elements = new ArrayList<>();
        for (Entity entity : this) {
            if (lowerBound.ordinal() <= entity.getStatus().ordinal() && entity.getStatus().ordinal() <= upperBound.ordinal()) {
                elements.add(entity);
            }
        }
        return elements;
    }

    @Override
    public List<Entity> getAll() {
        List<Entity> elements = new ArrayList<>();
        for (Entity entity : this) {
            elements.add(entity);
        }
        return elements;
    }

    @Override
    public void updateAll(BaseEntity.Status oldStatus, BaseEntity.Status newStatus) {
        for (Entity entity : this) {
            if (entity.getStatus().equals(oldStatus)) {
                entity.setStatus(newStatus);
            }
        }
    }

    @Override
    public void removeSold() {
        for (Entity entity : this) {
            if (entity.getStatus().equals(BaseEntity.Status.SOLD)) {
                this.extract(entity.getId());
            }
        }
    }

    @Override
    public Iterator<Entity> iterator() {
        return new Iterator<Entity>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Entity next() {
                Entity element = current.element;
                current = current.next;
                return element;
            }
        };
    }
}
