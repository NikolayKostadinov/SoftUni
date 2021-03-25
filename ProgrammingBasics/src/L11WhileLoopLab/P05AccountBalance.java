package L11WhileLoopLab;

import java.util.Scanner;

public class P05AccountBalance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        double sum = 0;
        double increment = 0;
        while (!input.equals("NoMoreMoney")) {
            increment = Double.parseDouble(input);
            if (increment < 0){
                System.out.println("Invalid operation!");
                break;
            }
            sum += increment;
            System.out.printf("Increase: %.2f\n", increment);
            input = scan.nextLine();
        }

        System.out.printf("Total: %.2f\n", sum);
    }
}
