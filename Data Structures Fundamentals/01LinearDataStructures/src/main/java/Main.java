import java.util.List;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        List<Integer> da = new DynamicArray<>(new Integer[]{1, 2, 3, 4, 5});

        printList(da);
        da.add(6);
        printList(da);
        da.remove(4);
        printList(da);
        da.add(4, 5);
        printList(da);
    }

    private static void printList(List<Integer> da) {
        System.out.println(
                da.stream()
                        .map(x -> x.toString())
                        .collect(Collectors.joining(" ")));
    }
}
