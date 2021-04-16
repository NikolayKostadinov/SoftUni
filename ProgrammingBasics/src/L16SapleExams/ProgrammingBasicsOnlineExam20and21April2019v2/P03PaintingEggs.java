package L16SapleExams.ProgrammingBasicsOnlineExam20and21April2019v2;

import java.util.Scanner;

public class P03PaintingEggs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String size = scan.nextLine();
        String color = scan.nextLine();
        int batches = Integer.parseInt(scan.nextLine());

        double price = 0;
        switch (size){
            case "Large":
                switch (color){
                    case "Red":
                        price = 16;
                        break;
                    case "Green":
                        price = 12;
                        break;
                    case "Yellow":
                        price = 9;
                        break;
                }
                break;
            case "Medium":
                switch (color){
                    case "Red":
                        price = 13;
                        break;
                    case "Green":
                        price = 9;
                        break;
                    case "Yellow":
                        price = 7;
                        break;
                }
                break;
            case "Small":
                switch (color){
                    case "Red":
                        price = 9;
                        break;
                    case "Green":
                        price = 8;
                        break;
                    case "Yellow":
                        price = 5;
                        break;
                }
                break;
        }

        double profit = price * batches * 0.65;

        System.out.printf("%.2f leva.", profit);
    }
}
