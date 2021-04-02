package L16SapleExams.ProgrammingBasicsOnlineExam28and29March2020v1;

import java.util.Scanner;

public class P05CareOfPuppy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int food = Integer.parseInt(scan.nextLine()) * 1000;
        String command = scan.nextLine();
        int eaten = 0;
        while (!"Adopted".equals(command)) {
            eaten += Integer.parseInt(command);
            command = scan.nextLine();
        }

        if (eaten <= food) {
            System.out.printf("Food is enough! Leftovers: %d grams.", food - eaten);
        } else {
            System.out.printf("Food is not enough. You need %d grams more.", eaten - food );
        }
    }
}
