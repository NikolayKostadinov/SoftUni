package L16SapleExams.ProgrammingBasicsOnlineExam20and21April2019v1;

import java.util.Scanner;

public class P05EasterEggs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int eggsCount = Integer.parseInt(scan.nextLine());
        int redCount = 0;
        int orangeCount = 0;
        int blueCount = 0;
        int greenCount = 0;

        for (int i = 0; i < eggsCount; i++) {
            String color = scan.nextLine();
            switch (color) {
                case "red":
                    redCount++;
                    break;
                case "orange":
                    orangeCount++;
                    break;
                case "blue":
                    blueCount++;
                    break;
                case "green":
                    greenCount++;
                    break;
            }
        }

        int maxCount = redCount;
        String maxColor = "red";

        if (orangeCount > maxCount) {
            maxCount = orangeCount;
            maxColor = "orange";
        }

        if (blueCount > maxCount) {
            maxCount = blueCount;
            maxColor = "blue";
        }

        if (greenCount > maxCount) {
            maxCount = greenCount;
            maxColor = "green";
        }

        System.out.printf("Red eggs: %d\n", redCount);
        System.out.printf("Orange eggs: %d\n", orangeCount);
        System.out.printf("Blue eggs: %d\n", blueCount);
        System.out.printf("Green eggs: %d\n", greenCount);
        System.out.printf("Max eggs: %d -> %s\n", maxCount, maxColor);

    }
}
