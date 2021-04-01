package L14NestedLoopsLabMoreExcercises;

import java.util.Scanner;

public class P06WeddingSeats {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char lastSector = scan.nextLine().charAt(0);
        int sectorRows = Integer.parseInt(scan.nextLine());
        int oddRowSeats = Integer.parseInt(scan.nextLine());
        int rowSeats = 0;
        int seats = 0;
        for (char sector = 'A'; sector <= lastSector; sector++) {
            for (int row = 1; row <= sectorRows; row++) {
                rowSeats = oddRowSeats;
                if (row % 2 == 0) rowSeats += 2;
                for (char seat = 'a'; seat < rowSeats + 'a'; seat++) {
                    System.out.printf("%s%d%s\n", sector, row, seat);
                    seats++;
                }
            }
            sectorRows++;
        }

        System.out.println(seats);
    }
}
