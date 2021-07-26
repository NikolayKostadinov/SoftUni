package L16TextProcessingMoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P03TreasureFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] key = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        String command = scan.nextLine();

        while (!"find".equals(command)){
            String decrypted = decryptCommand(command, key);
            findTreasure(decrypted);
            command = scan.nextLine();
        }


    }

    private static void findTreasure(String decrypted) {
        int treasureStartIndex = decrypted.indexOf("&");
        int treasureEndIndex = decrypted.lastIndexOf("&");
        int coordinatesStartIndex = decrypted.indexOf("<");
        int coordinatesEndIndex = decrypted.indexOf(">");

        System.out.printf("Found %s at %s\n",
                decrypted.substring(treasureStartIndex+1, treasureEndIndex),
                decrypted.substring(coordinatesStartIndex+1, coordinatesEndIndex));
    }

    private static String decryptCommand(String command, int[] key) {
        StringBuilder decrypted = new StringBuilder(command.length());

        for (int i = 0; i < command.length(); i++) {
            decrypted.append((char)(command.charAt(i) - key[i % key.length]));
        }

        return decrypted.toString();
    }
}
