package L16SapleExams.ProgrammingBasicsOnlineExam20and21April2019v2;

import java.util.Scanner;

public class P04EasterShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int availableEggs = Integer.parseInt(scan.nextLine());
        String command = scan.nextLine();
        int soldEggs = 0;

        while (!"Close".equals(command)) {
            int eggs = Integer.parseInt(scan.nextLine());
            switch (command) {
                case "Buy":
                    if (eggs > availableEggs) {
                        System.out.println("Not enough eggs in store!");
                        System.out.printf("You can buy only %d.", availableEggs);
                        return;
                    }
                    availableEggs -= eggs;
                    soldEggs += eggs;
                    break;
                case "Fill":
                    availableEggs += eggs;
                    break;
            }
            command = scan.nextLine();
        }

        System.out.println("Store is closed!");
        System.out.printf("%d eggs sold.", soldEggs);
    }
}
