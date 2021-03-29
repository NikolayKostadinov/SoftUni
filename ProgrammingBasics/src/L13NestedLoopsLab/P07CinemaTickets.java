package L13NestedLoopsLab;

import java.util.Scanner;

public class P07CinemaTickets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String filmName = scan.nextLine();
        int freeSeeds = 0;
        int takenSeeds = 0;
        int student = 0;
        int standard = 0;
        int kid = 0;
        String command = "";
        while (!"Finish".equals(filmName)) {
            freeSeeds = Integer.parseInt(scan.nextLine());
            command = scan.nextLine();
            while (!"End".equals(command)) {
                takenSeeds++;
                switch (command) {
                    case "student":
                        student++;
                        break;
                    case "standard":
                        standard++;
                        break;
                    case "kid":
                        kid++;
                        break;
                }

                if (freeSeeds == takenSeeds) break;

                command = scan.nextLine();
            }
            System.out.printf("%s - %.2f%% full.\n", filmName, (takenSeeds / (double)freeSeeds) * 100.0);
            takenSeeds = 0;
            filmName = scan.nextLine();
        }
        double totalTickets = standard + student + kid;
        System.out.printf("Total tickets: %.0f\n", totalTickets);
        System.out.printf("%.2f%% student tickets.\n", (student / totalTickets) * 100.0);
        System.out.printf("%.2f%% standard tickets.\n", (standard / totalTickets) * 100.0);
        System.out.printf("%.2f%% kids tickets.", (kid / totalTickets) * 100.0);
    }
}
