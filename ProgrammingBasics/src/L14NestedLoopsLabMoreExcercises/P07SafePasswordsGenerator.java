package L14NestedLoopsLabMoreExcercises;

import java.util.Scanner;

public class P07SafePasswordsGenerator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int maxX = Integer.parseInt(scan.nextLine());
        int maxY = Integer.parseInt(scan.nextLine());
        int passCount = Integer.parseInt(scan.nextLine());

        int a = 35, b = 64;

        for (int x = 1; x <= maxX; x++) {
            for (int y = 1; y <= maxY; y++) {
                System.out.printf("%s%s%d%d%s%s|", (char) a, (char) b, x, y, (char) b, (char) a);
                passCount--;
                if (passCount == 0) return;
                a++;
                b++;
                if (a > 55) a = 35;
                if (b > 96) b = 64;
            }
        }
    }
}
