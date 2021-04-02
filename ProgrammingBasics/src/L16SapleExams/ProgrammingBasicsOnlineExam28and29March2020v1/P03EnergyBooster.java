package L16SapleExams.ProgrammingBasicsOnlineExam28and29March2020v1;

import java.util.Scanner;

public class P03EnergyBooster {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String fruit = scan.nextLine();
        String size = scan.nextLine();
        int count = Integer.parseInt(scan.nextLine());

        double price = 0;

        switch (fruit){
            case "Watermelon":
                price = ("small".equals(size))? 56.0 *2.0 : 28.70*5.0;
                break;
            case "Mango":
                price = ("small".equals(size))? 36.66*2.0 : 19.60*5.0;
                break;
            case "Pineapple":
                price = ("small".equals(size))? 42.10*2.0 : 24.80*5.0;
                break;
            case "Raspberry":
                price = ("small".equals(size))? 20.00 * 2.0 : 15.20 * 5.0;
                break;
        }

        double sum = count * price;

        if (400 <= sum && sum <= 1000){
            sum *= 0.85;
        } else if (sum > 1000){
            sum *= 0.5;
        }

        System.out.printf("%.2f lv.", sum);
    }
}
