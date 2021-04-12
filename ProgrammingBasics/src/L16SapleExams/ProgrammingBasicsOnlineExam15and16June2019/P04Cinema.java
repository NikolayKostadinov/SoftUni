package L16SapleExams.ProgrammingBasicsOnlineExam15and16June2019;

import java.util.Scanner;

public class P04Cinema {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hallCapacity = Integer.parseInt(scan.nextLine());
        String command = scan.nextLine();
        int tickets= 0;
        int sum = 0;

        while (!"Movie time!".equals(command)){
            int newTickets = Integer.parseInt(command);
            tickets +=  newTickets;
            if (tickets > hallCapacity) break;
            if (newTickets % 3 == 0){
                sum += newTickets * 5 - 5;
            } else {
                sum += newTickets * 5;
            }
            command = scan.nextLine();
        }

        if ("Movie time!".equals(command))
            System.out.printf("There are %d seats left in the cinema.\n", hallCapacity - tickets);
        else
            System.out.println("The cinema is full.");

        System.out.printf("Cinema income - %d lv.", sum);
    }
}
