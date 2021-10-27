
package P06GreedyTimes;

import P06GreedyTimes.Handlers.CashHandler;
import P06GreedyTimes.Handlers.GemHandler;
import P06GreedyTimes.Handlers.GoldHandler;
import P06GreedyTimes.Handlers.ItemHandler;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ItemHandler> handlers = List.of(new GemHandler(), new CashHandler(), new GoldHandler());
        GreedySystem system = new GreedySystem(handlers);
        system.start();
    }
}