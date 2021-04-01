package L14NestedLoopsLabMoreExcercises;

import java.util.Scanner;

public class P12TheSongOfTheWheels {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int ctrlNum = Integer.parseInt(scan.nextLine());
        int counter = 0;
        String pass = "";
        for (int a = 1; a <= 9; a++) {
            for (int b = 1; b <= 9; b++) {
                for (int c = 1; c <= 9; c++) {
                    for (int d = 1; d <=9; d++) {
                        if (a < b && c > d && a * b + c * d == ctrlNum) {
                            if (++counter == 4) pass = String.format("%d%d%d%d", a, b, c, d);
                            System.out.printf("%d%d%d%d ", a, b, c, d);
                        }
                    }
                }
            }
        }
        if (!"".equals(pass)){
            System.out.printf("\nPassword: %s", pass);
        } else {
            System.out.println("\nNo!");
        }
    }
}
