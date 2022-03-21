package core;

import interfaces.Entity;
import interfaces.Repository;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Data implements Repository {

    public static final int HEAP_TOP_INDEX = 0;
    private final List<Entity> elements;
    private final BiFunction<Entity, Entity, Boolean> heapProperty;

    public Data() {
        this(new ArrayList<>(),
                //for MinHeap must be "<"
                (first, second) -> first.compareTo(second) < 0);
    }

    public Data(List<Entity> nodes, BiFunction<Entity, Entity, Boolean> heapProperty) {
        this.elements = nodes;
        this.heapProperty = heapProperty;
    }

    @Override
    public void add(Entity entity) {
        this.elements.add(entity);
        heapifyUp(size() - 1);
    }

    private void heapifyUp(int index) {
        while (index > 0 && isHeapifyUpFulfilled(index)) {
            Collections.swap(elements, index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    @Override
    public Entity getById(int id) {
        if (this.elements.size() == 0) return null;
        for (int i = 0; i < this.elements.size(); i++) {
            Entity entity = this.elements.get(i);
            if (entity.getId() == id) {
                return entity;
            }
        }
        return null;
    }

    @Override
    public List<Entity> getByParentId(int id) {
        return this.elements
                .stream()
                .filter(e->e.getParentId() == id)
                .collect(Collectors.toList());
    }

    @Override
    public List<Entity> getAll() {
        return this.elements;
    }

    @Override
    public Repository copy() {
        Data data = new Data();
        this.elements.forEach(e -> data.elements.add(e));
        return data;
    }

    @Override
    public List<Entity> getAllByType(String type) {
        if (!type.equals("Invoice") && !type.equals("StoreClient") && !type.equals("User")) {
            throw new IllegalArgumentException("Illegal type: " + type);
        }

        return this.elements
                .stream()
                .filter(e -> e.getClass().getSimpleName().equals(type))
                .collect(Collectors.toList());
    }

    @Override
    public Entity peekMostRecent() {
        ensureNotEmpty();
        return this.elements.get(HEAP_TOP_INDEX);
    }

    private void ensureNotEmpty() {
        if (size() == 0) throw new IllegalStateException("Operation on empty Data");
    }

    @Override
    public Entity pollMostRecent() {
        ensureNotEmpty();
        Entity result = get(HEAP_TOP_INDEX);
        Collections.swap(this.elements, HEAP_TOP_INDEX, size() - 1);
        this.elements.remove(size() - 1);
        heapifyDown(HEAP_TOP_INDEX);
        return result;
    }

    private void heapifyDown(int index) {
        while ((index < size() / 2) && this.heapProperty.apply(get(left(index)), get(index))) {
            int left = left(index);
            int right = right(index);
            int child = left;

            if (right < size() && this.heapProperty.apply(get(right), get(left))) {
                child = right;
            }

            Collections.swap(this.elements, index, child);
            index = child;
        }
    }

    @Override
    public int size() {
        return this.elements.size();
    }

    private Boolean isHeapifyUpFulfilled(int index) {
        return heapProperty.apply(get(index), get(getParentIndex(index)));
    }

    private Entity get(int index) {
        return this.elements.get(index);
    }

    public int left(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    public int right(int parentIndex) {
        return parentIndex * 2 + 2;
    }

    public int getParentIndex(int index) {
        return (index - 1) / 2;
    }

}
