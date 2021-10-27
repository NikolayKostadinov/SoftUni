package P06GreedyTimes.Handlers;

import P06GreedyTimes.Bag;
import P06GreedyTimes.Item;
import P06GreedyTimes.ItemType;

public class CashHandler implements ItemHandler {

    @Override
    public boolean canHandle(Item item, Bag bag) {
        return item.getType() == ItemType.CASH
                && bag.getCash() + item.getQuantity() <= bag.getGem();
    }

    @Override
    public void Handle(Item item, Bag bag) {
        bag.addItem(item);
    }
}
