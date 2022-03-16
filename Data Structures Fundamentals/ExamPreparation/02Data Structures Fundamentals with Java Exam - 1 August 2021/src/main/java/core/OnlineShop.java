package core;

import model.Order;
import shared.Shop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OnlineShop implements Shop {
    List<Order> orders;

    public OnlineShop() {
        this.orders = new ArrayList<>();
    }

    @Override
    public void add(Order order) {
        this.orders.add(order);
    }

    @Override
    public Order get(int index) {
        return this.orders.get(index);
    }

    @Override
    public int indexOf(Order order) {
        return this.orders.indexOf(order);
    }

    @Override
    public Boolean contains(Order order) {
        return this.orders.contains(order);
    }

    @Override
    public Boolean remove(Order order) {
        return this.orders.remove(order);
    }

    @Override
    public Boolean remove(int id) {
        Order order = this.orders.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        if (order == null) {
            return false;
        }
        return this.orders.remove(order);
    }

    @Override
    public void set(int index, Order order) {
        this.orders.set(index, order);
    }

    @Override
    public void set(Order oldOrder, Order newOrder) {
        int index = indexOf(oldOrder);
        if (index < 0) throw new IndexOutOfBoundsException();
        this.set(index, newOrder);
    }

    @Override
    public void clear() {
        this.orders.clear();
    }

    @Override
    public Order[] toArray() {
        return this.orders.toArray(Order[]::new);
    }

    @Override
    public void swap(Order first, Order second) {
        int index1 = indexOf(first);
        int index2 = indexOf(second);
        if (index1 < 0 || index2 < 0) throw new IllegalArgumentException();
        this.orders.set(index1, second);
        this.orders.set(index2, first);
    }

    @Override
    public List<Order> toList() {
        return Collections.unmodifiableList(this.orders);
    }

    @Override
    public void reverse() {
        List<Order> buffer = new ArrayList<>(size());
        for (int i = size() - 1; i >= 0; i--) {
            buffer.add(this.orders.get(i));
        }
        this.orders = buffer;
    }

    @Override
    public void insert(int index, Order order) {
        this.orders.add(index, order);
    }

    @Override
    public Boolean isEmpty() {
        return this.orders.isEmpty();
    }

    @Override
    public int size() {
        return this.orders.size();
    }
}
