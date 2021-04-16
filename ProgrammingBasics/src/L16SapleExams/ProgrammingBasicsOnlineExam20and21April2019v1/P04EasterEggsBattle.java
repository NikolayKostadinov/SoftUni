package L16SapleExams.ProgrammingBasicsOnlineExam20and21April2019v1;

import java.util.Scanner;

public class P04EasterEggsBattle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int eggs1 = Integer.parseInt(scan.nextLine());
        int eggs2 = Integer.parseInt(scan.nextLine());

        String command = scan.nextLine();

        while (!"End of battle".equals(command)) {
            switch (command) {
                case "one":
                    eggs2--;
                    break;
                case "two":
                    eggs1--;
                    break;
            }
            if (eggs1 == 0 || eggs2 == 0) break;
                command = scan.nextLine();
        }

        if (eggs1 == 0){
            System.out.printf("Player one is out of eggs. Player two has %d eggs left.", eggs2);
        }else if (eggs2 == 0){
            System.out.printf("Player two is out of eggs. Player one has %d eggs left.", eggs1);
        }else{
            System.out.printf("Player one has %d eggs left.\n",eggs1);
            System.out.printf("Player two has %d eggs left.\n",eggs2);
        }

    }
}
