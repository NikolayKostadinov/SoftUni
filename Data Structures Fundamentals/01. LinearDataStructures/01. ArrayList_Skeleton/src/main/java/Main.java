import implementations.ArrayList;
import interfaces.List;

import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> da = new ArrayList<Integer>(new Integer[]{1, 2, 3, 4, 5});

        printList(da);
        da.add(6);
        printList(da);
        da.remove(4);
        printList(da);
        da.add(4, 5);
        printList(da);
    }

    private static void printList(List<Integer> da) {
        StringBuilder sb = new StringBuilder();
        for (Integer n : da) {
            sb.append(n).append(" ");
        }

        System.out.println(sb);
    }
}
