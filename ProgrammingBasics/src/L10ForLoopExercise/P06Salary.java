package L10ForLoopExercise;

import java.util.Scanner;

public class P06Salary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int browserTabs = Integer.parseInt(scan.nextLine());
        int salary = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < browserTabs; i++) {
            String siteName = scan.nextLine();
            switch (siteName) {
                case "Facebook":
                    salary -= 150;
                    break;
                case "Instagram":
                    salary -= 100;
                    break;
                case "Reddit" :
                    salary -= 50;
                    break;
            }

            if (salary <= 0) {
                System.out.println("You have lost your salary.");
                return;
            }
        }

        System.out.printf("%d", salary);
    }
}
