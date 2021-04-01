package L16SapleExams.ProgrammingBasicsOnlineExam18and19July2020;

import java.util.Scanner;

public class P03AluminumJoinery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        String size = scan.nextLine();
        String deliveryType = scan.nextLine();

        if (count < 10) {
            System.out.println("Invalid order");
        } else {
            double price = 0;
            switch (size) {
                case "90X130":
                    price = 110.0;
                    if (30 < count && count <= 60) price *= 0.95;
                    else if (count > 60) price *= 0.92;
                    break;
                case "100X150":
                    price = 140.0;
                    if (40 < count && count <= 80) price *= 0.94;
                    else if (count > 80) price *= 0.90;
                    break;

                case "130X180":
                    price = 190.0;
                    if (20 < count && count <= 50) price *= 0.93;
                    else if (count > 50) price *= 0.88;
                    break;

                case "200X300":
                    price = 250.0;
                    if (25 < count && count <= 50) price *= 0.91;
                    else if (count > 50) price *= 0.86;
                    break;
            }

            double deliveryPrice = 0;
            if ("With delivery".equals(deliveryType)) deliveryPrice = 60.0;

            double sum = ((price * count) + deliveryPrice) * ((count > 99)?0.96:1.0);

            System.out.printf("%.2f BGN", sum);

        }
    }
}
