package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02Problem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> biscuits = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());

        String command = scan.nextLine();

        while(!"No More Money".equals(command)){
            String[] tokens = command.split("\\s");
            switch (tokens[0]){
                case "OutOfStock":
                    for (int i = 0; i < biscuits.size(); i++) {
                        if (biscuits.get(i).equals(tokens[1])){
                            biscuits.set(i, "None");
                        }
                    }
                    break;
                case "Required":
                    int index = Integer.parseInt(tokens[2]);
                    if (indexIsValid(biscuits, index)){
                        biscuits.set(index, tokens[1]);
                    }
                    break;
                case "Last":
                    biscuits.add(tokens[1]);
                    break;
            }
            command = scan.nextLine();
        }

        biscuits = biscuits.stream().filter(x->!x.equals("None")).collect(Collectors.toList());

        System.out.println(biscuits.toString().replaceAll("[\\[\\],]",""));
    }

    private static boolean indexIsValid(List<String> biscuits, int index) {
        return 0 <= index && index < biscuits.size() && !biscuits.get(index).equals("None");
    }
}
