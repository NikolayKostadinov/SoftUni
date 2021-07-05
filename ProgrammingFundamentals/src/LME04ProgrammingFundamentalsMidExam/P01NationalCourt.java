package LME04ProgrammingFundamentalsMidExam;

import java.util.Scanner;

public class P01NationalCourt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int employee1 = Integer.parseInt(scan.nextLine());
        int employee2 = Integer.parseInt(scan.nextLine());
        int employee3 = Integer.parseInt(scan.nextLine());

        int totalPeopleCount  = Integer.parseInt(scan.nextLine());

        int capacityPerHour = employee1+employee2+employee3;

        int hours = 0;
        while (totalPeopleCount > 0){
            totalPeopleCount -= capacityPerHour;
            hours++;
            if (hours % 4 == 0) hours++;
        }

        System.out.printf("Time needed: %dh.", hours);
    }
}
