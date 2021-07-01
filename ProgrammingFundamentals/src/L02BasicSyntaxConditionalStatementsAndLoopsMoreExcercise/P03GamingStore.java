package L02BasicSyntaxConditionalStatementsAndLoopsMoreExcercise;

import java.util.Scanner;

public class P03GamingStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double balance = Double.parseDouble(scan.nextLine());
        double balanceCp = balance;
        String command = scan.nextLine();

        while (!"Game Time".equals(command)) {
            double gamePrice = estimateGame(command);
            if (gamePrice > 0){
                if (balance - gamePrice < 0){
                    System.out.println("Too Expensive");
                } else {
                    System.out.printf("Bought %s\n", command);
                   balance -= gamePrice;
                }

                if (balance == 0){
                    System.out.println("Out of money!");
                    return;
                }
            }
            command = scan.nextLine();
        }

        System.out.printf("Total spent: $%.2f. Remaining: $%.2f\n",balanceCp - balance, balance);
    }

    private static double estimateGame(String gameName) {
        double gamePrice = 0.0;
        switch (gameName){
            case "OutFall 4":
            case "RoverWatch Origins Edition":
                gamePrice = 39.99;
                break;
            case "CS: OG":
                gamePrice = 15.99;
                break;
            case "Zplinter Zell":
                gamePrice = 19.99;
                break;
            case "Honored 2":
                gamePrice = 59.99;
                break;
            case "RoverWatch":
                gamePrice = 29.99;
                break;
            default:
                System.out.println("Not Found");
                break;
        }
        return gamePrice;
    }
}
