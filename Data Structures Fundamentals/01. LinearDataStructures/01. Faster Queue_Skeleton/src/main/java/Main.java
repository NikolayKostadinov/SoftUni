import implementations.ArrayDeque;
import implementations.ReversedList;

public class Main {
    public static void main(String[] args) {
        ReversedList<Integer> test = new ReversedList<>();
        for (int i = 0; i < 10; i++) {
            test.add(i);
            System.out.println(test);
        }

        for (Integer o : test) {
            System.out.println(o);
        }
    }
}
