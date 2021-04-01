package L16SapleExams.ProgrammingBasicsOnlineExam18and19July2020;

import java.util.Scanner;

public class P04Balls {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());

        String color = "";
        int sum = 0;
        int countRed = 0;
        int countOrange = 0;
        int countYellow = 0;
        int countWhite = 0;
        int countBlack = 0;
        int countOther = 0;

        for (int i = 0; i < count; i++) {
            color = scan.nextLine();
            switch (color) {
                case "red":
                    sum += 5;
                    countRed++;
                    break;
                case "orange":
                    sum += 10;
                    countOrange++;
                    break;
                case "yellow":
                    sum += 15;
                    countYellow++;
                    break;
                case "white":
                    sum += 20;
                    countWhite++;
                    break;
                case "black":
                    sum = (int) Math.floor(sum / 2.0);
                    countBlack++;
                    break;
                default:
                    countOther ++;
                    break;
            }
        }

        System.out.printf("Total points: %d\n", sum);
        System.out.printf("Points from red balls: %d\n",countRed);
        System.out.printf("Points from orange balls: %d\n", countOrange);
        System.out.printf("Points from yellow balls: %d\n", countYellow);
        System.out.printf("Points from white balls: %d\n", countWhite);
        System.out.printf("Other colors picked: %d\n", countOther);
        System.out.printf("Divides from black balls: %d\n", countBlack);

    }
}
