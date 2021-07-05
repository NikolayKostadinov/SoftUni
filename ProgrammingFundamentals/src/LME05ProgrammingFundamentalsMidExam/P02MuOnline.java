package LME05ProgrammingFundamentalsMidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02MuOnline {
    public static void main(String[] args) {
        int health = 100;
        int bitcoins = 0;

        Scanner scan = new Scanner(System.in);

        List<Command> commands = Arrays.stream(scan.nextLine().split("\\|")).map(Command::new).collect(Collectors.toList());
        int room = 1;
        for (Command command : commands) {
            switch (command.command){
                case "potion":
                    int healed = health + command.getAmount();
                    healed = (healed <= 100) ? healed : 100;
                    System.out.printf("You healed for %d hp.\n", Math.abs(healed - health));
                    health = healed;
                    System.out.printf("Current health: %d hp.\n", health);
                    break;
                case "chest":
                    bitcoins += command.getAmount();
                    System.out.printf("You found %d bitcoins.\n", command.getAmount());
                    break;
                default:
                    int leftHealth = health - command.getAmount();
                    if (leftHealth > 0){
                        health = leftHealth;
                        System.out.printf("You slayed %s.\n", command.getCommand());
                    } else {
                        System.out.printf("You died! Killed by %s.\n", command.getCommand());
                        System.out.printf("Best room: %d\n", room);
                        return;
                    }
                    break;
            }
            room++;
        }

        System.out.printf("You've made it!\nBitcoins: %d\nHealth: %d\n", bitcoins, health );
    }

    private static class Command{
        private String command;
        private int amount;

        public Command(String command) {
            String[] tokens = command.split("\\s");
            this.command = tokens[0];
            this.amount = Integer.parseInt(tokens[1]);
        }

        public String getCommand() {
            return command;
        }

        public int getAmount() {
            return amount;
        }
    }
}
