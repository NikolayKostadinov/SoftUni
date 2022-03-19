package core;

import interfaces.Buffer;
import interfaces.Entity;
import model.BaseEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Loader implements Buffer {
    List<Entity> entities;

    public Loader() {
        this.entities = new ArrayList<>();
    }

    @Override
    public void add(Entity entity) {
        entities.add(entity);
    }

    @Override
    public Entity extract(int id) {
        if (entities.size() == 0) return null;
        for (int i = 0; i < this.entities.size(); i++) {
            if (this.entities.get(i).getId() == id) {
                return entities.remove(i);
            }
        }
        return null;
    }

    @Override
    public Entity find(Entity entity) {
        if (entities.size() == 0) return null;
        return this.entities
                .stream()
                .filter(e -> e.equals(entity))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean contains(Entity entity) {
        return this.find(entity) != null;
    }

    @Override
    public int entitiesCount() {
        return this.entities.size();
    }

    @Override
    public void replace(Entity oldEntity, Entity newEntity) {
        int index = this.entities.indexOf(oldEntity);
        if (index < 0) throw new IllegalStateException("Entity not found");
        this.entities.set(index, newEntity);
    }

    @Override
    public void swap(Entity first, Entity second) {
        int index1 = this.entities.indexOf(first);
        int index2 = this.entities.indexOf(second);
        if (index1 < 0 || index2 < 0) throw new IllegalStateException("Entity not found");
        Entity buffer = this.entities.get(index1);
        this.entities.set(index1, this.entities.get(index2));
        this.entities.set(index2, buffer);
    }

    @Override
    public void clear() {
        this.entities.clear();
    }

    @Override
    public Entity[] toArray() {
        return this.entities.toArray(Entity[]::new);
    }

    @Override
    public List<Entity> retainAllFromTo(BaseEntity.Status lowerBound, BaseEntity.Status upperBound) {
        return this.entities
                .stream()
                .filter(e -> e.getStatus().compareTo(lowerBound) >= 0
                        && e.getStatus().compareTo(upperBound) <= 0)
                .collect(Collectors.toList());
    }

    @Override
    public List<Entity> getAll() {
        return this.entities;
    }

    @Override
    public void updateAll(BaseEntity.Status oldStatus, BaseEntity.Status newStatus) {
        this.entities
                .stream()
                .filter(e -> e.getStatus().equals(oldStatus))
                .forEach(e -> e.setStatus(newStatus));
    }

    @Override
    public void removeSold() {
        this.entities = this.entities
                .stream()
                .filter(e -> !e.getStatus().equals(BaseEntity.Status.SOLD))
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Entity> iterator() {

        return this.entities.iterator();
    }
}
