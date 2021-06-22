package L10ListsExcercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03HouseParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfCommands = Integer.parseInt(scan.nextLine());
        List<String> partiList = new ArrayList<>();

        for (int i = 0; i < numberOfCommands; i++) {
            String command = scan.nextLine();
            String[] tokens = command.split(" ");
            if (command.contains("is going!")){
                if (partiList.contains(tokens[0])){
                    System.out.printf("%s is already in the list!\n", tokens[0]);
                } else {
                    partiList.add(tokens[0]);
                }
            }

            if (command.contains("is not going!")){
                if (partiList.contains(tokens[0])){
                    partiList.remove(tokens[0]);
                } else {
                    System.out.printf("%s is not in the list!\n", tokens[0]);
                }
            }
        }

        System.out.println(partiList.toString().replaceAll("[\\[\\]\\s+]", "").replaceAll("[,]","\n"));
    }
}
