import implementations.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        var test = new ArrayDeque<String>();
        test.add("1");
        System.out.println(test);
        test.add("2");
        System.out.println(test);
        test.add("3");
        System.out.println(test);
        test.add("5");
        System.out.println(test);
        test.add("6");
        System.out.println(test);
        test.add("7");
        System.out.println(test);
        test.insert(3, "4");
        System.out.println(test);
        test.insert(0, "0");
        System.out.println(test);
        test.add("9");
        System.out.println(test);
        test.insert(8,"8");
        System.out.println(test);
        test.remove(3);
        System.out.println(test);
        test.trimToSize();
        System.out.println(test);
        test.set(0,"10");
        System.out.println(test);
        test.set(5,"666");
        System.out.println(test);
        test.remove(5);
        System.out.println(test);
        test.insert(5,"6");
        System.out.println(test);
        test.insert(3,"3");
        System.out.println(test);
        test.set(0,"0");
        System.out.println(test);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            queue.offer(i);
        }
        print(queue);
        System.out.println("peek -> " + queue.peek());

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        print(stack);
        System.out.println("peek -> " + stack.peek());

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }

    private static void print(ArrayDeque<Integer> test) {
        StringBuilder sb = new StringBuilder();
        for (Integer element : test) {
            sb.append(element).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
