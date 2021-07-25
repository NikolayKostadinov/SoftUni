package L14AssociativeArraysLambdaAndStreamAPIExcersize;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P08CompanyUsers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        Map<String, Map<String, Integer>> companies = new TreeMap<>();

        while (!"End".contains(command)) {
            String[] tokens = command.split(" -> ");
            companies.putIfAbsent(tokens[0], new LinkedHashMap<>());
            companies.get(tokens[0]).putIfAbsent(tokens[1], 0);
            command = scan.nextLine();
        }

        companies.forEach((companyName, employees) -> {
                    System.out.println(companyName);
                    employees.forEach((employeeName, payload) ->
                            System.out.printf("-- %s\n", employeeName)
                    );
                }
        );
    }
}
