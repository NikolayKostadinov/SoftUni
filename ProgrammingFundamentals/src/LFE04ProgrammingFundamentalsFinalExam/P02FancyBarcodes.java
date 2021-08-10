package LFE04ProgrammingFundamentalsFinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02FancyBarcodes {
    public static final String PRODUCT_PATTERN = "@#+(?<barcode>[A-Z][A-Za-z0-9]{4,}[A-Z])@#+";
    public static final String NUMBERS_PATTERN = "\\d+";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Pattern productPattern = Pattern.compile(PRODUCT_PATTERN);
        Pattern numbers = Pattern.compile(NUMBERS_PATTERN);
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            Matcher matcher = productPattern.matcher(input);

            if (matcher.find()) {
                String barcode = matcher.group("barcode");
                Matcher numbersMatcher = numbers.matcher(barcode);
                StringBuilder productGroup = new StringBuilder();

                while (numbersMatcher.find()) {
                    productGroup.append(numbersMatcher.group());
                }

                if (productGroup.length() == 0) {
                    productGroup.append("00");
                }

                System.out.printf("Product group: %s\n", productGroup);
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
