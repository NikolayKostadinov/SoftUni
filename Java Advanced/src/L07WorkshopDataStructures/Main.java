package L07WorkshopDataStructures;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(42);
        stack.push(33);
        stack.push(28);
        stack.push(13);

        stack.forEach(System.out::println);
    }
}
