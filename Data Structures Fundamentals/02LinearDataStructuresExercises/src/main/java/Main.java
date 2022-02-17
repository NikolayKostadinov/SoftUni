import implementations.ArrayDeque;
import implementations.ReversedList;

public class Main {
    public static void main(String[] args) {
        ReversedList<Integer> test = new ReversedList<>();
//        for (int i = 0; i < 10; i++) {
//            test.add(i);
//            System.out.println(test);
//        }
//
//        for (Integer o : test) {
//            System.out.println(o);
//        }
//
//        test.removeAt(4);
//        System.out.println(test);
        for (int i = 0; i < 3; i++) {
            test.add(i);
            System.out.println(test);
        }

        test.removeAt(0);
        System.out.println(test);
        System.out.println(test.get(0));
    }


}
