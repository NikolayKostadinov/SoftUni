package L16SapleExams.ProgrammingBasicsOnlineExam9and10March2019v1;

import java.util.Scanner;

public class P02FootballResults {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int won = 0;
        int lost = 0;
        int drawn = 0;

        for (int i = 0; i < 3; i++) {
            String result = scan.nextLine();
            String[] res = result.split(":");
            int myG = Integer.parseInt(res[0]);
            int enemyG = Integer.parseInt(res[1]);

            if (myG > enemyG) won++;
            else if(myG < enemyG) lost ++;
            else drawn ++;
        }

        System.out.printf("Team won %d games.\n", won);
        System.out.printf("Team lost %d games.\n", lost);
        System.out.printf("Drawn games: %d", drawn);
    }
}
