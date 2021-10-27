package P06GreedyTimes.Handlers;

import P06GreedyTimes.Bag;
import P06GreedyTimes.Item;
import P06GreedyTimes.ItemType;

public class GemHandler implements ItemHandler {
    @Override
    public boolean canHandle(Item item, Bag bag) {
        return item.getType() == ItemType.GEM
                && bag.getGem() + item.getQuantity() <= bag.getGold();
    }

    @Override
    public void Handle(Item item, Bag bag) {
        bag.addItem(item);
    }
}
