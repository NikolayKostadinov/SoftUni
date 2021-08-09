package LFE01ProgrammingFundamentalsFinalExamRetake;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02AdAstra {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<String> names = new ArrayList<>();
        List<String> bestBefore = new ArrayList<>();
        List<Integer> calories = new ArrayList<>();

        String ptr = "([\\|#])(?<name>[A-Za-z\\s]+)\\1(?<bestBefore>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>\\d{1,5})\\1";
        Pattern pattern = Pattern.compile(ptr);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            names.add(matcher.group("name"));
            bestBefore.add(matcher.group("bestBefore"));
            calories.add(Integer.parseInt(matcher.group("calories")));
        }

        int sumOfCalories = calories.stream().reduce(0,(a,b)-> a+b);
        int dailyCalories = 2000;

        System.out.printf("You have food to last you for: %d days!\n", sumOfCalories / dailyCalories);

        for (int i = 0; i < names.size(); i++) {
            System.out.printf("Item: %s, Best before: %s, Nutrition: %d\n"
                    , names.get(i), bestBefore.get(i), calories.get(i));
        }
    }
}
