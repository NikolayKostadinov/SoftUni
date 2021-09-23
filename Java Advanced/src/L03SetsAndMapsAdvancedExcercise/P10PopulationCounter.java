package L03SetsAndMapsAdvancedExcercise;

import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P10PopulationCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Map<String, Integer>> dataTable = new LinkedHashMap<>();
        Map<String, Integer> countries = new LinkedHashMap<>();

        String input = scan.nextLine();

        while (!"report".equals(input)) {
            String[] tokens = input.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            int population = Integer.parseInt(tokens[2]);

            dataTable.putIfAbsent(country, new LinkedHashMap<>());
            dataTable.get(country).putIfAbsent(city, population);
            countries.putIfAbsent(country, 0);
            countries.put(country, countries.get(country) + population);

            input = scan.nextLine();
        }

        printData(countries, dataTable);
    }

    private static void printData(Map<String, Integer> countries, Map<String, Map<String, Integer>> dataTable) {
        countries.entrySet()
                .stream()
                .sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
                .forEach(country -> {
                    System.out.printf("%s (total population: %d)%n", country.getKey(), country.getValue());
                    Map<String, Integer> cities = dataTable.get(country.getKey());
                    cities.entrySet()
                            .stream()
                            .sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
                            .forEach(ct-> System.out.printf("=>%s: %d%n", ct.getKey(), ct.getValue()));
                });
    }

}