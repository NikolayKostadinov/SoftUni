package L10ListsExcercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P08AnonymousThreat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> partitions = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());

        String command = scan.nextLine();
        while (!"3:1".equals(command)){
            String[] cmdTokens = command.split(" ");
            switch (cmdTokens[0]){
                case "merge":
                    applyMerge(partitions, cmdTokens);
                    break;
                case "divide":
                    applyDivide(partitions, cmdTokens);
                    break;
            }
            command = scan.nextLine();
        }

        System.out.println(partitions.toString().replaceAll("[\\[\\],]", ""));
    }

    private static void applyDivide(List<String> partitions, String[] cmdTokens) {
        int index = Integer.parseInt(cmdTokens[1]);
        int partitionsCount = Integer.parseInt(cmdTokens[2]);

        String partition = partitions.get(index);
        int partitionLength = partition.length() / partitionsCount;

        List<String> parts = new ArrayList<>();

        for (int i = 0; i < partitionsCount-1; i++) {
            parts.add(partition.substring(i*partitionLength, i*partitionLength + partitionLength));
        }
        parts.add(partition.substring((partitionsCount-1) * partitionLength));

        partitions.remove(index);
        for (int i = partitionsCount-1; i >= 0 ; i--) {
            partitions.add(index, parts.get(i));
        }
    }

    private static void applyMerge(List<String> partitions, String[] cmdTokens) {
        int startIndex = Integer.parseInt(cmdTokens[1]);
        if (startIndex < 0) startIndex = 0;
        int endIndex =  Integer.parseInt(cmdTokens[2]);
        if (endIndex > partitions.size() - 1) endIndex = partitions.size() - 1;

        for (int i = startIndex; i < endIndex; i++) {
            partitions.set(startIndex, partitions.get(startIndex) + partitions.get(startIndex + 1));
            partitions.remove(startIndex + 1);
        }
    }
}
