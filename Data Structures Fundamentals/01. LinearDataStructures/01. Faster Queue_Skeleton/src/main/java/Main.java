import implementations.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        var test = new ArrayDeque<Integer>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(5);
        test.add(6);
        test.add(7);
        test.insert(3, 4);
        test.insert(0, 0);
        test.add(9);
        test.insert(8,8);
        test.remove(3);
    }
}
