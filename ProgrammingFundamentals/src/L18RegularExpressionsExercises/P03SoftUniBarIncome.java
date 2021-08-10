package L18RegularExpressionsExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03SoftUniBarIncome {
    private static final String PATTERN =
            "%(?<clientName>[A-Z][a-z]+)%.*<(?<product>\\w+)>.*\\|(?<count>\\d+)\\|\\D*(?<price>\\d+(.\\d+)*)\\$";

    private static final String PATTERN1 =
            "%(?<customerName>[A-Z][a-z]*)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<count>[0-9]+)\\|[^|$%.]*?(?<price>[0-9]+\\.*[0-9]*)\\$";


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String row = scan.nextLine();
        Pattern pattern = Pattern.compile(PATTERN);

        double sum = 0.0;
        while (!"end of shift".equals(row)) {
            Matcher matcher = pattern.matcher(row);
            if (matcher.find()) {
                double price = Double.parseDouble(matcher.group("price"));
                double count = Double.parseDouble(matcher.group("count"));
                sum += price * count;
                System.out.printf("%s: %s - %.2f\n", matcher.group("clientName"), matcher.group("product"), price * count);
            }

            row = scan.nextLine();
        }

        System.out.printf("Total income: %.2f", sum);
    }
}
