package L16SapleExams.ProgrammingBasicsOnlineExam28and29March2020v1;

import java.util.Scanner;

public class P04FoodForPets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        double food = Double.parseDouble(scan.nextLine());
        double cat = 0;
        double dog = 0;
        double bisquites = 0;

        for (int i = 1; i <= days; i++) {
            int dogD = Integer.parseInt(scan.nextLine());
            int catD = Integer.parseInt(scan.nextLine());
            if (i % 3 == 0) {
                bisquites += (catD + dogD) * 0.1;
            }

            dog += dogD;
            cat += catD;
        }

        System.out.printf("Total eaten biscuits: %dgr.\n", (int)Math.round(bisquites));
        System.out.printf("%.2f%% of the food has been eaten.\n", ((dog + cat) / food) * 100.0);
        System.out.printf("%.2f%% eaten from the dog.\n", (dog / (dog + cat)) * 100.0);
        System.out.printf("%.2f%% eaten from the cat.\n", (cat / (dog + cat)) * 100.0);
    }
}
