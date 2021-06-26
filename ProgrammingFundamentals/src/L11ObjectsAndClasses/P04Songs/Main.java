package L11ObjectsAndClasses.P04Songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        List<Song> songs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("_");
            songs.add(new Song(input[0], input[1], input[2]));
        }

        String type = scan.nextLine();

        for (Song song : songs) {
            if (song.typeList.equals(type) || "all".equals(type)) {
                System.out.println(song);
            }
        }

    }
}
