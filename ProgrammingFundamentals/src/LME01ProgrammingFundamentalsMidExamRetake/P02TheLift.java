package LME01ProgrammingFundamentalsMidExamRetake;

import java.util.Arrays;
import java.util.Scanner;

public class P02TheLift {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int capacity = 4;
        int peopleCount = Integer.parseInt(scan.nextLine());
        int[] wagons = Arrays.stream(scan.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < wagons.length; i++) {
            int freeSeats = capacity - wagons[i];
            if (freeSeats > 0) {
                int takenSeats = (freeSeats < peopleCount) ? freeSeats : peopleCount;
                wagons[i] += takenSeats;
                peopleCount -= takenSeats;
                if (peopleCount == 0) break;
            }
        }

        if (peopleCount == 0 && Arrays.stream(wagons).anyMatch(x->x!=capacity)) {
            System.out.printf("The lift has empty spots!\n%s", stringify(wagons));

        } else if (peopleCount > 0){
            System.out.printf("There isn't enough space! %d people in a queue!\n",peopleCount);
            System.out.printf("%s", stringify(wagons));
        } else {
            System.out.println(stringify(wagons));
        }

    }

    private static String stringify(int[] wagons) {
        StringBuilder sb = new StringBuilder();
        for (int wagon : wagons) {
            sb.append(wagon);
            sb.append(" ");
        }

        return sb.toString();
    }
}
