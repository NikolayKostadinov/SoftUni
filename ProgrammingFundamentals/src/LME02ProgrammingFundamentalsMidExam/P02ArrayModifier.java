package LME02ProgrammingFundamentalsMidExam;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ArrayModifier {
    private static List<BigInteger> arr;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        arr = Arrays.stream(scan.nextLine().split("\\s"))
                .map(BigInteger::new).collect(Collectors.toList());

        String command = scan.nextLine();

        while (!"end".equals(command)){
            String[] tokens = command.split("\\s");

            switch (tokens[0]){
                case "swap":
                    swapElements(Integer.parseInt(tokens[1]),
                            Integer.parseInt(tokens[2]));
                    break;
                case "multiply":
                    multiplyElements(Integer.parseInt(tokens[1]),
                            Integer.parseInt(tokens[2]));
                    break;
                case "decrease":
                    decreaseElements();
                    break;
            }

            command = scan.nextLine();
        }

        System.out.println(arr.toString().replaceAll("[\\[\\]]", ""));
    }

    private static void decreaseElements() {
        for (int i = 0; i < arr.size(); i++) {
            arr.set(i, arr.get(i).subtract(new BigInteger("1")));
        }
    }

    private static void multiplyElements(int index1, int index2) {
        arr.set(index1, arr.get(index1).multiply(arr.get(index2)));
    }

    private static void swapElements(int index1, int index2) {
        BigInteger buff = arr.get(index1);
        arr.set(index1, arr.get(index2));
        arr.set(index2, buff);
    }
}
