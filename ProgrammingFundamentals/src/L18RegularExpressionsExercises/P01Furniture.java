package L18RegularExpressionsExercises;

import com.sun.source.tree.WhileLoopTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01Furniture {
    private static final String PATTERN = "^>>(?<name>\\w+)<<(?<price>\\d+(\\.\\d+)?)!(?<quantity>\\d+)\\b";
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        Pattern pattern = Pattern.compile(PATTERN);

        Double sum = 0.0;
        List<String> furniture = new ArrayList<>();
        while (!"Purchase".equals(command)){
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()){
                furniture.add(matcher.group("name"));
                double price = Double.parseDouble(matcher.group("price"));
                double quantity = Double.parseDouble(matcher.group("quantity"));

                sum += (price * quantity);
            }
            command = scan.nextLine();
        }

        System.out.println("Bought furniture:");
        if (furniture.size() > 0)
        System.out.println(String.join("\n", furniture));

        System.out.printf("Total money spend: %.2f\n", sum);
    }
}
