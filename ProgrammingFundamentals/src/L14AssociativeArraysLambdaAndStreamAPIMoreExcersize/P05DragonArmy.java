package L14AssociativeArraysLambdaAndStreamAPIMoreExcersize;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P05DragonArmy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Map<String, Map<String, Stat>> dragonStat = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            dragonStat.putIfAbsent(tokens[0], new TreeMap<>());
            Map<String, Stat> dragons = dragonStat.get(tokens[0]);
            dragons.putIfAbsent(tokens[1], null);
            dragons.put(tokens[1], new Stat(tokens[2], tokens[3], tokens[4]));
        }

        dragonStat
                .entrySet()
                .stream()
                .forEach(type -> {
                    double avgDamage = type.getValue()
                            .entrySet()
                            .stream()
                            .mapToInt(x -> x.getValue().getDamage()).sum() / (double) type.getValue().entrySet().size();

                    double avgHealth = type.getValue()
                            .entrySet()
                            .stream()
                            .mapToInt(x -> x.getValue().getHealth()).sum() / (double) type.getValue().entrySet().size();

                    double avgArmor = type.getValue()
                            .entrySet()
                            .stream()
                            .mapToInt(x -> x.getValue().getArmor()).sum() / (double) type.getValue().entrySet().size();

                    System.out.printf("%s::(%.2f/%.2f/%.2f)\n", type.getKey(), avgDamage, avgHealth, avgArmor);

                    type.getValue()
                            .entrySet()
                            .stream()
                            .forEach(entry -> {
                                Stat entryValue = entry.getValue();
                                System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n",
                                        entry.getKey(),
                                        entryValue.getDamage(),
                                        entryValue.getHealth(),
                                        entryValue.getArmor());});
                });
    }

    private static class Stat {
        private int damage;
        private int health;
        private int armor;

        public Stat(String damage, String health, String armor) {
            this.damage = (!damage.equals("null")) ? Integer.parseInt(damage) : 45;
            this.health = (!health.equals("null")) ? Integer.parseInt(health) : 250;
            this.armor = (!armor.equals("null")) ? Integer.parseInt(armor) : 10;
        }

        public int getDamage() {
            return damage;
        }

        public int getHealth() {
            return health;
        }

        public int getArmor() {
            return armor;
        }
    }
}
