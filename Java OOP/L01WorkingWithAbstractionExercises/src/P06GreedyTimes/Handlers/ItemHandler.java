package P06GreedyTimes.Handlers;

import P06GreedyTimes.Bag;
import P06GreedyTimes.Item;

public interface ItemHandler {
    public boolean canHandle(Item item, Bag bag);
    public void Handle(Item item, Bag bag);
}
