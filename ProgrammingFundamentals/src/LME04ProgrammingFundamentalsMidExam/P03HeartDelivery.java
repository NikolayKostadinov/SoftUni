package LME04ProgrammingFundamentalsMidExam;

import java.util.Arrays;
import java.util.Scanner;

public class P03HeartDelivery {
    public static void main(String[] args) {
        int diminutive = 2;
        Scanner scan = new Scanner(System.in);
        int[] houses = Arrays.stream(scan.nextLine().split("@")).mapToInt(Integer::parseInt).toArray();

        String command = scan.nextLine();

        int position = 0;

        while (!"Love!".equals(command)) {
            int jump = Integer.parseInt(command.split(" ")[1]);
            int newPosition = position + jump;
            position = (newPosition < houses.length) ? newPosition : 0;
            if (houses[position] == 0) {
                System.out.printf("Place %d already had Valentine's day.\n", position);
            } else if (houses[position] - diminutive == 0) {
                houses[position] = 0;
                System.out.printf("Place %d has Valentine's day.\n", position);
            } else {
                houses[position] -= diminutive;
            }
            command = scan.nextLine();
        }

        System.out.printf("Cupid's last position was %d.\n", position);
        int notCelebratedCount = 0;
        for (int house : houses) {
            if (house > 0) notCelebratedCount++;
        }
        if (notCelebratedCount > 0){
            System.out.printf("Cupid has failed %d places.\n", notCelebratedCount);
        }else{
            System.out.println("Mission was successful.");
        }
    }
}
