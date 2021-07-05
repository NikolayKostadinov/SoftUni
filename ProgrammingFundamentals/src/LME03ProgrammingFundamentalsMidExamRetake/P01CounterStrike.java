package LME03ProgrammingFundamentalsMidExamRetake;

import java.util.Scanner;

public class P01CounterStrike {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int energy = Integer.parseInt(scan.nextLine());
        int wonBattlesCount = 0;
        String command = scan.nextLine();
        while(!"End of battle".equals(command)){
            int distance = Integer.parseInt(command);
            if (energy - distance >= 0){
                energy -= distance;
                wonBattlesCount++;
                if (wonBattlesCount % 3 == 0) energy += wonBattlesCount;
            } else {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", wonBattlesCount, energy);
                return;
            }
            command = scan.nextLine();
        }

        System.out.printf("Won battles: %d. Energy left: %d", wonBattlesCount, energy);
    }
}
