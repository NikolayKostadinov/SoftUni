package L16SapleExams.ProgrammingBasicsOnlineExam28and29March2020v2;

import java.util.Scanner;

public class P05SuitcasesLoad {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double capacity = Double.parseDouble(scan.nextLine());
        String command = scan.nextLine();
        int count = 0;

        while (!"End".equals(command)){
            count++;
            double volume = Double.parseDouble(command);
            if (count % 3 == 0) volume *= 1.1;
            capacity -= volume;
            if (capacity < 0) {
                count --;
                break;
            }
            command = scan.nextLine();
        }

        if ("End".equals(command)) {
            System.out.println("Congratulations! All suitcases are loaded!");
        } else {
            System.out.println("No more space!");
        }

        System.out.printf("Statistic: %d suitcases loaded.", count);
    }
}
