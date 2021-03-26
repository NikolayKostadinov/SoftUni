package L12WhileLoopExercise;

import java.util.Scanner;

public class P03Vacation {
    //      •	Пари нужни за екскурзията - реално число в интервала [1.00…25000.00]
    //      •	Налични пари - реално число в интервала [0.00...25000.00]
    //    След това многократно се четат по два реда:
    //            •	Вид действие - текст с възможности "spend" и "save".
    //            •	Сумата, която ще спести/похарчи - реално число в интервала [0.01…25000.00]
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double neededMoney = Double.parseDouble(scan.nextLine());
        double ownedMoney = Double.parseDouble(scan.nextLine());
        int sequencedSpends = 0;
        String action;
        String lastAction = "";
        double money = 0;

        int days = 0;
        while (true) {
            days++;
            action = scan.nextLine();
            money = Double.parseDouble(scan.nextLine());

            if (action.equals("spend") && (lastAction.equals(action) || sequencedSpends == 0)) {
                sequencedSpends++;
            } else {
                sequencedSpends = 0;
            }

            if (sequencedSpends >= 5) {
                System.out.printf("You can't save the money.\n" +
                        "%d\n", days);
                break;
            }

            ownedMoney += action.equals("spend") ? -money : money;
            if (ownedMoney < 0) ownedMoney = 0;
            lastAction = action;

            if (ownedMoney >= neededMoney) {
                System.out.printf("You saved the money for %d days.", days);
                break;
            }
        }
    }

}
