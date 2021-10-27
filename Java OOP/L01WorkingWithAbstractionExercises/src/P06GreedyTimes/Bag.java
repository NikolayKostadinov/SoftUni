package P06GreedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Bag {
    private long capacity;
    private final Map<ItemType, Map<String, Long>> bag;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.bag = new LinkedHashMap<>();
    }

    private boolean canTake(long quantity) {
        return this.capacity >= getTotalQuantity() + quantity;
    }

    public long getTotalQuantity() {
        return this.bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum();
    }

    public long getGold() {
        return this.getQuantityByType(ItemType.GOLD);
    }

    public long getGem() {
        return this.getQuantityByType(ItemType.GEM);
    }

    public long getCash() {
        return this.getQuantityByType(ItemType.CASH);
    }

    private long getQuantityByType(ItemType itemType) {
        if (bag.containsKey(itemType)) {
            return bag.get(itemType).values().stream().mapToLong(e -> e).sum();
        } else {
            return 0;
        }
    }

    public boolean hasItem(ItemType type) {
        return this.bag.containsKey(type);
    }

    public void addItem(Item item) {
        if (this.canTake(item.getQuantity())) {
            bag.putIfAbsent(item.getType(), new LinkedHashMap<>());
            bag.get(item.getType()).putIfAbsent(item.getName(), 0L);
            bag.get(item.getType()).put(item.getName(), bag.get(item.getType()).get(item.getName()) + item.getQuantity());
        }
    }

    public Set<Map.Entry<ItemType, Map<String, Long>>> entrySet() {
        return this.bag.entrySet();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        bag.entrySet().stream()
                .forEach(x -> {
                    Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();
                    sb.append(String.format("<%s> $%s", x.getKey().getDisplayText(), sumValues));
                    if (!x.getValue().entrySet().isEmpty()) {
                        sb.append(System.lineSeparator());
                        x.getValue().entrySet()
                                .stream()
                                .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                                .forEach(i ->
                                        sb.append("##" + i.getKey() + " - " + i.getValue())
                                                .append(System.lineSeparator()));
                    }
                });
        return sb.toString().trim();
    }
}
