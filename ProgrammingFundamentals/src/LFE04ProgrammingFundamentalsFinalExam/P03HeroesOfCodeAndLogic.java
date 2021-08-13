package LFE04ProgrammingFundamentalsFinalExam;

import java.util.*;

public class P03HeroesOfCodeAndLogic {
    private static final Scanner scan = new Scanner(System.in);
    private static final int MAX_MANA_POINTS = 200;
    private static final int MAX_HIT_POINTS = 100;


    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine());
        Map<String, HeroParams> heroes = getData(n);
        manipulateHeroes(heroes);
        printHeroes(heroes);
    }

    private static void printHeroes(Map<String, HeroParams> heroes) {
        heroes
                .entrySet()
                .stream()
                .sorted((h1, h2) -> {
                    HeroParams val1 = h1.getValue();
                    HeroParams val2 = h2.getValue();
                    int result = val2.getHitPoints() - val1.getHitPoints();

                    if (result == 0) {
                       result = h1.getKey().compareTo(h2.getKey());
                    }

                    return result;
                })
                .forEach(hero -> System.out.printf("%s\n  HP: %d\n  MP: %d\n",
                        hero.getKey(), hero.getValue().getHitPoints(), hero.getValue().getManaPoints()));
    }

    private static void manipulateHeroes(Map<String, HeroParams> heroes) {
        String command = scan.nextLine();

        while (!"End".equals(command)) {
            String[] tokens = command.split(" - ");
            String name = tokens[1];
            switch (tokens[0]) {
                case "CastSpell":
                    castSpell(heroes, name, Integer.parseInt(tokens[2]), tokens[3]);
                    break;
                case "TakeDamage":
                    takeDamage(heroes, name, Integer.parseInt(tokens[2]), tokens[3]);
                    break;
                case "Recharge":
                    recharge(heroes, name, Integer.parseInt(tokens[2]));
                    break;
                case "Heal":
                    heal(heroes, name, Integer.parseInt(tokens[2]));
                    break;
            }
            command = scan.nextLine();
        }
    }

    private static void heal(Map<String, HeroParams> heroes, String name, int amount) {
        HeroParams heroParams = heroes.get(name);

        if (heroParams.getHitPoints() + amount > MAX_HIT_POINTS) {
            amount = MAX_HIT_POINTS - heroParams.getHitPoints();
            heroParams.setHitPoints(MAX_HIT_POINTS);
        } else {
            heroParams.setHitPoints(heroParams.getHitPoints() + amount);
        }

        System.out.printf("%s healed for %d HP!\n", name, amount);
    }

    private static void recharge(Map<String, HeroParams> heroes, String name, int amount) {
        HeroParams heroParams = heroes.get(name);

        if (heroParams.getManaPoints() + amount > MAX_MANA_POINTS) {
            amount = MAX_MANA_POINTS - heroParams.getManaPoints();
            heroParams.setManaPoints(MAX_MANA_POINTS);
        } else {
            heroParams.setManaPoints(heroParams.getManaPoints() + amount);
        }

        System.out.printf("%s recharged for %d MP!\n", name, amount);
    }

    private static void takeDamage(Map<String, HeroParams> heroes, String name, int damage, String attacker) {
        HeroParams heroParams = heroes.get(name);
        heroParams.setHitPoints(heroParams.getHitPoints() - damage);
        if (heroParams.getHitPoints() > 0) {
            heroes.put(name, heroParams);
            System.out.printf("%s was hit for %d HP by %s and now has %d HP left!\n",
                    name, damage, attacker, heroParams.getHitPoints());
        } else {
            heroes.remove(name);
            System.out.printf("%s has been killed by %s!\n", name, attacker);
        }
    }

    private static void castSpell(Map<String, HeroParams> heroes, String name, int neededMana, String spellName) {
        HeroParams heroParams = heroes.get(name);
        if (heroParams.getManaPoints() >= neededMana) {
            heroParams.setManaPoints(heroParams.getManaPoints() - neededMana);
            heroes.put(name, heroParams);
            System.out.printf("%s has successfully cast %s and now has %d MP!\n",
                    name, spellName, heroParams.getManaPoints());
        } else {
            System.out.printf("%s does not have enough MP to cast %s!\n", name, spellName);
        }
    }

    private static Map<String, HeroParams> getData(int n) {
        Map<String, HeroParams> heroes = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            int hitPoints = Integer.parseInt(tokens[1]);
            int manaPoints = Integer.parseInt(tokens[2]);
            heroes.putIfAbsent(tokens[0], new HeroParams(hitPoints, manaPoints));
        }

        return heroes;
    }

    private static class HeroParams {
        private int hitPoints;
        private int manaPoints;

        public HeroParams() {
        }

        public HeroParams(int hitPoints, int manaPoints) {
            this.hitPoints = hitPoints;
            this.manaPoints = manaPoints;
        }

        public int getHitPoints() {
            return hitPoints;
        }

        public void setHitPoints(int hitPoints) {
            this.hitPoints = hitPoints;
        }

        public int getManaPoints() {
            return manaPoints;
        }

        public void setManaPoints(int manaPoints) {
            this.manaPoints = manaPoints;
        }
    }
}
