package LFE02ProgrammingFundamentalsFinalExam;


import java.util.*;

public class P03PlantDiscovery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, PlantData> plants = new HashMap<>();

        gatherData(scan, n, plants);

        String command = scan.nextLine();
        while (!"Exhibition".equals(command)) {
            modifyData(plants, command);
            command = scan.nextLine();
        }

        if (!plants.isEmpty()) {
            System.out.println("Plants for the exhibition:");
            plants
                    .entrySet()
                    .stream()
                    .sorted((p1, p2) -> {
                        PlantData val1 = p1.getValue();
                        PlantData val2 = p2.getValue();
                        int result = val2.rarity - val1.rarity;

                        if (result == 0) {
                            result = (int) (val2.getAverageRate() - val1.getAverageRate());
                        }
                        return result;
                    })
                    .forEach(p -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n",
                            p.getKey(), p.getValue().rarity, p.getValue().getAverageRate()));
        }
    }

    private static void modifyData(Map<String, PlantData> plants, String command) {
        String[] tokens = command.replaceAll(": ", " - ").split(" - ");
        String plant = tokens[1];
        if (!plants.containsKey(plant)) {
            System.out.println("error");
        } else {
            switch (tokens[0]) {
                case "Rate":
                    int rating = Integer.parseInt(tokens[2]);
                    plants.get(plant).addRate(rating);
                    break;
                case "Update":
                    int rarity = Integer.parseInt(tokens[2]);
                    plants.get(plant).setRarity(rarity);
                    break;
                case "Reset":
                    plants.get(plant).resetRatings();
                    break;
            }
        }
    }

    private static void gatherData(Scanner scan, int n, Map<String, PlantData> plants) {
        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("<->");
            String plant = tokens[0];
            int rarity = Integer.parseInt(tokens[1]);
            plants.putIfAbsent(plant, new PlantData());
            plants.get(plant).setRarity(rarity);
        }
    }

    private static class PlantData {
        private int rarity;
        private List<Integer> rates;

        public PlantData() {
            this.rarity = 0;
            this.rates = new ArrayList<>();
        }

        public int getRarity() {
            return rarity;
        }

        public void resetRatings() {
            this.rates = new ArrayList<>();
        }

        public void setRarity(int rarity) {
            this.rarity = rarity;
        }

        public void addRate(int rate) {
            this.rates.add(rate);
        }

        public double getAverageRate() {
                return this.rates
                        .stream().mapToInt(Integer::intValue)
                        .average().orElse(0);
        }
    }
}
