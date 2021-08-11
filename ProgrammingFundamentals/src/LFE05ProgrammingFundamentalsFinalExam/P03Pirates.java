package LFE05ProgrammingFundamentalsFinalExam;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P03Pirates {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, CityParams> cities = getData();
        modifyCities(cities);
        print(cities);
    }

    private static void print(Map<String, CityParams> cities) {
        System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:\n", cities.entrySet().size());
        cities
                .entrySet()
                .stream()
                .sorted((c1,c2)->c2.getValue().getGold() - c1.getValue().getGold())
                .forEach(c ->  System.out.printf("%s -> Population: %d citizens, Gold: %d kg\n",
                        c.getKey(), c.getValue().getPopulation(), c.getValue().getGold()));
    }

    private static void modifyCities(Map<String, CityParams> cities) {
        String command = scan.nextLine();
        while (!"End".equals(command)) {
            String[] tokens = command.split("=>");
            String city = tokens[1];
            switch (tokens[0]) {
                case "Plunder":
                    int people = Integer.parseInt(tokens[2]);
                    int gold = Integer.parseInt(tokens[3]);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.\n", city, gold, people);
                    CityParams cityParams = cities.get(city);
                    cityParams.removePeople(people).removeGold(gold);
                    if (!(cityParams.hasGold() && cityParams.hasPeople())){
                        cities.remove(city);
                        System.out.printf("%s has been wiped off the map!\n", city);
                    }
                    break;
                case "Prosper":
                    gold = Integer.parseInt(tokens[2]);
                    if (gold >=0 ){
                        cities.get(city).addGold(gold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.\n",
                                gold, city, cities.get(city).getGold());
                    } else {
                        System.out.println("Gold added cannot be a negative number!");
                    }
                    break;
            }
            command = scan.nextLine();
        }
    }

    private static Map<String, CityParams> getData() {
        Map<String, CityParams> cities = new TreeMap<>();
        String command = scan.nextLine();
        while (!"Sail".equals(command)) {
            String[] tokens = command.split("\\|\\|");
            String city = tokens[0];
            int people = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2]);
            if (cities.containsKey(city)) {
                cities.get(city).addPopulation(people).addGold(gold);
            } else {
                cities.put(city, new CityParams(people, gold));
            }
            command = scan.nextLine();
        }

        return cities;
    }

    private static class CityParams {
        private int population;
        private int gold;

        public int getPopulation() {
            return population;
        }

        public int getGold() {
            return gold;
        }

        public CityParams(int population, int gold) {
            this.population = population;
            this.gold = gold;
        }

        public CityParams addPopulation(int population) {
            this.population += population;
            return this;
        }

        public CityParams addGold(int gold) {
            this.gold += gold;
            return this;
        }

        public CityParams removePeople(int people) {
            this.population -= people;
            return this;
        }

        public CityParams removeGold(int gold) {
            this.gold -= gold;
            return this;
        }

        public boolean hasPeople(){
            return this.population > 0;
        }

        public boolean hasGold(){
            return this.gold > 0;
        }
    }
}