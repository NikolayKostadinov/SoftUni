package L16SapleExams.ProgrammingBasicsOnlineExam6and7July2019v2;

import java.util.Scanner;

public class P04Renovation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int height = Integer.parseInt(scan.nextLine());
        int width = Integer.parseInt(scan.nextLine());
        int percent = Integer.parseInt(scan.nextLine());

        int area =  (int)Math.ceil(height * width * 4 * (100 - percent) / 100.0);

        String command = scan.nextLine();
        int litersSpent =0 ;
        while (!"Tired!".equals(command)){
            litersSpent += Integer.parseInt(command);
            if (litersSpent >= area) break;
            command = scan.nextLine();
        }

        int difference = Math.abs(litersSpent - area);
        if ("Tired!".equals(command)){
            System.out.printf("%d quadratic m left.\n" , difference);
        } else {
            if (litersSpent > area){
                System.out.printf("All walls are painted and you have %d l paint left!", difference);
            } else if (difference == 0){
                System.out.println("All walls are painted! Great job, Pesho!");
            }
        }

    }
}
