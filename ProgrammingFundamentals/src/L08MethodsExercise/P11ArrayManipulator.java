package L08MethodsExercise;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class P11ArrayManipulator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String command = scan.nextLine();

        while (!"end".equals(command)) {
            String[] tokens = command.split(" ");
            switch (tokens[0]) {
                case "exchange":
                    int index = Integer.parseInt(tokens[1]);
                    if (0 <= index && index < array.length) {
                        array = exchangeArray(array, index);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "max":
                    maxElement(array, tokens[1]);
                    break;
                case "min":
                    minElement(array, tokens[1]);
                    break;
                case "first":
                    firstElements(array, Integer.parseInt(tokens[1]), tokens[2]);
                    break;
                case "last":
                    lastElements(array, Integer.parseInt(tokens[1]), tokens[2]);
                    break;
            }

            command = scan.nextLine();
        }

        System.out.println(Arrays.toString(array));
    }

    private static void firstElements(int[] array, int count, String token) {
        if (count > array.length) {
            System.out.println("Invalid count");
            return;
        }

        int [] arrResult = new int[count]; // result buffer
        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if (("even".equals(token) && array[i] % 2 == 0)
                    || ("odd".equals(token) && array[i] % 2 != 0)) {
                index++;
                if (index >= count - 1) break;
                arrResult[index] = array[i];
            }
        }

        arrResult = Arrays.copyOf(array, index+1);

        System.out.println( Arrays.toString(arrResult));
    }

    private static void lastElements(int[] array, int count, String token) {
        StringBuilder sb = new StringBuilder(count * 2 + 2);

        if (count > array.length) {
            System.out.println("Invalid count");
            return;
        }

        int [] arrResult = new int[count]; // result buffer
        int index = -1;

        for (int i = array.length - 1; i >= 0; i--) {
            if (("even".equals(token) && array[i] % 2 == 0)
                    || ("odd".equals(token) && array[i] % 2 != 0)) {
                index++;
                if (index >= count - 1) break;
                arrResult[index] = array[i];
            }
        }

        arrResult = Arrays.copyOf(array, index+1);

        System.out.println( Arrays.toString(arrResult));

    }

    private static void minElement(int[] array, String token) {
        int minElementIndex = -1;
        int minElementValue = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {

            if ((("even".equals(token) && array[i] % 2 == 0) || ("odd".equals(token) && array[i] % 2 != 0))
                    && array[i] <= minElementValue) {
                minElementIndex = i;
                minElementValue = array[i];
            }
        }

        if (minElementIndex == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(minElementIndex);
        }
    }

    private static void maxElement(int[] array, String token) {
        int maxElementIndex = -1;
        int maxElementValue = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {

            if ((("even".equals(token) && array[i] % 2 == 0) || ("odd".equals(token) && array[i] % 2 != 0))
                    && array[i] >= maxElementValue) {
                maxElementIndex = i;
                maxElementValue = array[i];
            }
        }

        if (maxElementIndex == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(maxElementIndex);
        }
    }

    private static int[] exchangeArray(int[] array, int index) {
        int[] result = new int[array.length];
        int ix = 0;
        for (int i = index + 1; i < array.length; i++) {
            result[ix] = array[i];
            ix++;
        }
        for (int i = 0; i <= index; i++) {
            result[ix] = array[i];
            ix++;
        }
        return result;
    }
}
