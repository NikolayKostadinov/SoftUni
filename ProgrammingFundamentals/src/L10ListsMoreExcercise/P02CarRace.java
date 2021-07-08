package L10ListsMoreExcercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02CarRace {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> racerTimes = Arrays.stream(scan.nextLine().split("\\s"))
                .map(Integer::parseInt).collect(Collectors.toList());

        double playerTime1 = 0.0;
        double playerTime2 = 0.0;

        for (int i = 0; i < racerTimes.size() / 2; i++) {
            playerTime1 = getPlayerTime(racerTimes, playerTime1, i);
            playerTime2 = getPlayerTime(racerTimes, playerTime2, racerTimes.size() - i - 1);
        }

        if (playerTime1 < playerTime2){
            System.out.printf("The winner is left with total time: %.1f", playerTime1);
        } else {
            System.out.printf("The winner is right with total time: %.1f", playerTime2);
        }
    }

    private static double getPlayerTime(List<Integer> racerTimes, double playerTime1, int i) {
        if (racerTimes.get(i)>0){
            playerTime1 += racerTimes.get(i);
        }else{
            playerTime1 *= 0.8;
        }
        return playerTime1;
    }
}
