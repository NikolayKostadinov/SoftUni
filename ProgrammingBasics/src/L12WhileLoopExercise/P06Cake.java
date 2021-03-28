package L12WhileLoopExercise;

import java.util.Scanner;

public class P06Cake {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int width = Integer.parseInt(scan.nextLine());
        int length = Integer.parseInt(scan.nextLine());
        int peaces = width * length;
        int peacesTaken = 0;
        String input = scan.nextLine();

        while (!input.equals("STOP")){
            peacesTaken = Integer.parseInt(input);
            peaces -= peacesTaken;

            if (peaces <= 0){
                break;
            }

            input = scan.nextLine();
        }

        if (input.equals("STOP")){
            System.out.printf("%d pieces are left.", peaces);
        } else {
            System.out.printf("No more cake left! You need %d pieces more.", Math.abs(peaces));
        }

    }
}
