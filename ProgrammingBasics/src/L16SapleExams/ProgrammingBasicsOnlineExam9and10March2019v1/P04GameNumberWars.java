package L16SapleExams.ProgrammingBasicsOnlineExam9and10March2019v1;

import java.util.Scanner;

public class P04GameNumberWars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String player1Name = scan.nextLine();
        String player2Name = scan.nextLine();
        int points1 = 0;
        int points2 = 0;
        boolean isNumberWars = false;

        while (true) {
            String command1 = scan.nextLine();
            if ("End of game".equals(command1)) break;
            String command2 = scan.nextLine();
            if ("End of game".equals(command2)) break;

            int card1 = Integer.parseInt(command1);
            int card2 = Integer.parseInt(command2);
            if (isNumberWars) {
                if (card1 > card2) {
                    System.out.printf("%s is winner with %d points", player1Name, points1);
                } else {
                    System.out.printf("%s is winner with %d points", player2Name, points2);
                }
                break;
            }
            if (card1 > card2) {
                points1 += card1 - card2;
            } else if (card2 > card1) {
                points2 += card2 - card1;
            } else {
                isNumberWars = true;
                System.out.println("Number wars!");
            }
        }

        if (!isNumberWars){
            System.out.printf("%s has %d points\n", player1Name, points1);
            System.out.printf("%s has %d points", player2Name, points2);
        }
    }
}
