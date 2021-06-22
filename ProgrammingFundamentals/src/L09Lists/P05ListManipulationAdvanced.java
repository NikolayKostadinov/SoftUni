package L09Lists;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays
                .stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = scan.nextLine();
        while (!"end".equals(command)) {
            String[] tokens = command.split(" ");
            switch (tokens[0]) {
                case "Contains":
                    System.out.println((numbers.contains(Integer.parseInt(tokens[1]))) ? "Yes" : "No such number");
                    break;
                case "Print":
                    printList(numbers.stream()
                            .filter(x-> ("even".equals(tokens[1]) && x % 2 == 0) || ("odd".equals(tokens[1]) && x % 2 != 0))
                            .map(x->x.intValue())
                            .collect(Collectors.toList()));

                    break;
                case "Get":
                    System.out.println(numbers.stream()
                            .mapToInt(x->x.intValue())
                            .sum());
                    break;
                case "Filter":
                    int number = Integer.parseInt(tokens[2]);
                    switch (tokens[1]){
                        case "<":
                            printList(numbers.stream()
                                    .filter(x -> x < number)
                                    .map(x->x.intValue())
                                    .collect(Collectors.toList()));
                            break;
                        case ">":
                            printList(numbers.stream()
                                    .filter(x -> x > number)
                                    .map(x->x.intValue())
                                    .collect(Collectors.toList()));
                            break;
                        case ">=":
                            printList(numbers.stream()
                                    .filter(x -> x >= number)
                                    .map(x->x.intValue())
                                    .collect(Collectors.toList()));
                            break;
                        case "<=":
                            printList(numbers.stream()
                                    .filter(x -> x <= number)
                                    .map(x->x.intValue())
                                    .collect(Collectors.toList()));
                            break;
                    }
                    break;
            }
            command = scan.nextLine();
        }
    }

    private static void printList(List<Integer> numbers){
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
