package L16SapleExams.ProgrammingBasicsOnlineExam18and19July2020;

import java.util.Scanner;

public class P02AddBags {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double over20kgPrice = Double.parseDouble(scan.nextLine());
        double weight = Double.parseDouble(scan.nextLine());
        int days = Integer.parseInt(scan.nextLine());
        int count = Integer.parseInt(scan.nextLine());

        // calculate the price per baggage
        double baggageWeight = weight;
        double pricePerBaggage = over20kgPrice;

        if (baggageWeight < 10){
            pricePerBaggage = over20kgPrice * 0.2;
        } else if(10 <= baggageWeight && baggageWeight <= 20){
            pricePerBaggage = over20kgPrice * 0.5;
        } else if (baggageWeight > 20){
            pricePerBaggage = over20kgPrice;
        }

        if (days < 7) {
            pricePerBaggage *= 1.4;
        }else if (7<= days && days <= 30){
            pricePerBaggage *= 1.15;
        }else if (days > 30) {
            pricePerBaggage *= 1.1;
        }

        System.out.printf("The total price of bags is: %.2f lv.", pricePerBaggage * count);

    }
}
