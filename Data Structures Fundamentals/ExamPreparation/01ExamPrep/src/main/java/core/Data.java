package core;

import interfaces.Entity;
import interfaces.Repository;

import java.util.*;
import java.util.stream.Collectors;

public class Data implements Repository {
    private List<Entity> elements;
    private Map<Integer, Entity> elementsById;

    public Data() {
        this.elements = new ArrayList<>();
        this.elementsById = new LinkedHashMap<>();
    }

    @Override
    public void add(Entity entity) {
        this.elements.add(entity);
        this.heapifyUp(this.elements.size() - 1);
        this.elementsById.putIfAbsent(entity.getId(), entity);
        Entity parentEntity = this.getById(entity.getParentId());
        if (parentEntity != null)
            parentEntity.addChild(entity);
    }

    @Override
    public Entity getById(int id) {
        Entity entity = null;
        if (this.elementsById.containsKey(id)) {
            entity = this.elementsById.get(id);
        }
        return entity;
    }

    @Override
    public List<Entity> getByParentId(int id) {
        Entity parent = this.getById(id);
        if (parent == null){
            return new ArrayList<>();
        }
        return parent.getChildren();
    }

    @Override
    public List<Entity> getAll() {
        return this.elementsById
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public Repository copy() {
        Repository repository = new Data();
        this.getAll()
                .forEach(repository::add);
        return repository;
    }

    @Override
    public List<Entity> getAllByType(String type) {
        List<Entity> result = this.elements
                .stream()
                .filter(x -> x.getClass().getSimpleName().equals(type))
                .collect(Collectors.toList());
        if (result.size() == 0) throw new IllegalArgumentException("Illegal type: " + type);

        return result;
    }

    @Override
    public Entity peekMostRecent() {
        ensureHasElements();
        return this.elements.get(0);
    }

    @Override
    public Entity pollMostRecent() {
        ensureHasElements();
        Collections.swap(this.elements, 0, this.elements.size() - 1);
        Entity peek = this.elements.remove(this.elements.size() - 1);
        this.elementsById.remove(peek.getId());
        this.heapifyDown(0);
        return peek;
    }

    private void heapifyDown(int index) {
        while (getLeftChildIndex(index) < this.size() && isLessThan(index, getLeftChildIndex(index))) {
            int childIndex = getLeftChildIndex(index);
            int rightChildIndex = getRightChildIndex(index);
            if (rightChildIndex < this.size() && isLessThan(childIndex, rightChildIndex)) {
                childIndex = rightChildIndex;
            }

            Collections.swap(this.elements, childIndex, index);
            index = childIndex;
        }
    }

    @Override
    public int size() {
        return this.elements.size();
    }

    private void heapifyUp(int index) {
        while (index > 0 && isLessThan(getParentIndex(index), index)) {
            Collections.swap(this.elements, index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private boolean isLessThan(int parentIndex, int childIndex) {
        return getElement(parentIndex).getId() < getElement(childIndex).getId();
    }

    private Entity getElement(int parentIndex) {
        return this.elements.get(parentIndex);
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChildIndex(int parentIndex) {
        return (parentIndex * 2) + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return (parentIndex * 2) + 2;
    }

    private void ensureHasElements() {
        if (this.elements.isEmpty()) throw new IllegalStateException("Operation on empty Data");
    }
}
