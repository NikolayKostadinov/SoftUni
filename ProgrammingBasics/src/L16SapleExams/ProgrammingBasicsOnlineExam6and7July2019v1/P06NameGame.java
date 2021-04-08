package L16SapleExams.ProgrammingBasicsOnlineExam6and7July2019v1;

import java.util.Scanner;

public class P06NameGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int maxPoint = 0;
        String winnerName = "";
        String name = scan.nextLine();
        while (!"Stop".equals(name)){
            int points = 0;
            for (int i = 0; i < name.length(); i++) {
                int num = Integer.parseInt(scan.nextLine());
                if (name.charAt(i) == num ) points += 10;
                else points += 2;
            }

            if (points >= maxPoint){
                maxPoint = points;
                winnerName = name;
            }
            name = scan.nextLine();
        }

        System.out.printf("The winner is %s with %d points!", winnerName, maxPoint);
    }
}
