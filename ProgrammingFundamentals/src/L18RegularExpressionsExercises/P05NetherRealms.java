package L18RegularExpressionsExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P05NetherRealms {
    public static final String SEPARATOR_PATTERN = "\\s*,\\s*";
    public static final String HEALTH_PATTERN = "[^0-9+\\-*/.]";
    public static final String DAMAGE_NUMBERS_PATTERN = "-?\\d+(\\.\\d+)?";
    public static final String DAMAGE_OPERATIONS_PATTERN = "[*/]";


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Score> daemons = new TreeMap<>();
        Arrays.stream(scan.nextLine().split(SEPARATOR_PATTERN))
                .forEach(daemon ->
                        daemons.putIfAbsent(daemon, new Score(calculateHeat(daemon), calculateDamage(daemon)))
                );

        if (daemons.entrySet().size() > 0) {
            daemons.forEach((name, score) -> System.out.printf("%s - %d health, %.2f damage\n",
                    name, score.getHealth(), score.getDamage()));
        }
    }

    private static double calculateDamage(String daemon) {
        Pattern pattern = Pattern.compile(DAMAGE_NUMBERS_PATTERN);
        Matcher matcher = pattern.matcher(daemon);
        double damage = 0;
        while (matcher.find()) {
            damage += Double.parseDouble(matcher.group());
        }

        pattern = Pattern.compile(DAMAGE_OPERATIONS_PATTERN);
        matcher = pattern.matcher(daemon);

        while (matcher.find()) {
            switch (matcher.group()) {
                case "*":
                    damage *= 2.0;
                    break;
                case "/":
                    damage /= 2.0;
                    break;
            }
        }

        return damage;
    }

    private static int calculateHeat(String daemon) {
        Pattern pattern = Pattern.compile(HEALTH_PATTERN);
        Matcher matcher = pattern.matcher(daemon);
        int health = 0;
        while (matcher.find()) {
            health += matcher.group().charAt(0);
        }

        return health;
    }

    private static class Score {
        private final int health;
        private final double damage;

        public Score(int health, double damage) {
            this.health = health;
            this.damage = damage;
        }

        public int getHealth() {
            return health;
        }

        public double getDamage() {
            return damage;
        }

    }
}
