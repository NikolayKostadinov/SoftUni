package L01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class P04BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hours = Integer.parseInt(scan.nextLine());
        int minutes = Integer.parseInt(scan.nextLine());

        minutes += 30;
        if (minutes >= 60){
            minutes -= 60;
            hours ++;
        }

        if (hours > 23){
            hours = 0;
        }

        System.out.printf("%d:%02d", hours, minutes);
    }
}
