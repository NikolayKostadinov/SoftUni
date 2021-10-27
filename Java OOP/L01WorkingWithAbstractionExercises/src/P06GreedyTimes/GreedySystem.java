package P06GreedyTimes;

import P06GreedyTimes.Handlers.ItemHandler;
import input.Reader;
import output.ConsolePrinter;

import java.util.List;

public class GreedySystem {
    private final Bag bag;
    private final List<ItemHandler> handlers;

    public GreedySystem(List<ItemHandler> handlers) {
        long bagCapacity = Long.parseLong(Reader.readLine());
        this.bag = new Bag(bagCapacity);
        this.handlers = handlers;
    }

    public void start() {
        String[] safe = Reader.readStringArray("\\s+");

        for (int i = 0; i < safe.length; i += 2) {
            String typeName = safe[i];
            long quantity = Long.parseLong(safe[i + 1]);

            Item item = new Item(typeName, quantity);

            for (ItemHandler handler : handlers) {
                if (handler.canHandle(item, bag)){
                    handler.Handle(item, bag);
                    break;
                }
            }
        }

        ConsolePrinter.printLine(bag.toString());
    }
}
