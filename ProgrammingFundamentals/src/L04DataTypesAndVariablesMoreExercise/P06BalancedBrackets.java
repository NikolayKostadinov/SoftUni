package L04DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class P06BalancedBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());

        int brackets = 0;
        for (int i = 0; i < count; i++) {
            String row = scan.nextLine();
            if ("(".equals(row)) {
                brackets++;
                if (brackets > 1) break;
            } else if (")".equals(row)) {
                brackets--;
                if (brackets < 0) break;
            }
        }

        System.out.println((brackets == 0) ? "BALANCED" : "UNBALANCED");
    }
}
