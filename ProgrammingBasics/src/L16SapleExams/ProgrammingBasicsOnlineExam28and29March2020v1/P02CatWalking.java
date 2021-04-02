package L16SapleExams.ProgrammingBasicsOnlineExam28and29March2020v1;

import java.util.Scanner;

public class P02CatWalking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int minutes = Integer.parseInt(scan.nextLine());
        int count = Integer.parseInt(scan.nextLine());
        int calories = Integer.parseInt(scan.nextLine());

        int burnedCalories = minutes * count * 5;

        if (burnedCalories >= (calories / 2.0)){
            System.out.printf("Yes, the walk for your cat is enough. Burned calories per day: %d.", burnedCalories);
        } else {
            System.out.printf("No, the walk for your cat is not enough. Burned calories per day: %d.", burnedCalories);
        }
    }
}
