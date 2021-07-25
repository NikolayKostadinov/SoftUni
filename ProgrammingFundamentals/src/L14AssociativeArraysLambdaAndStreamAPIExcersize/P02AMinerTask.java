package L14AssociativeArraysLambdaAndStreamAPIExcersize;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02AMinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        Map<String, Integer> resources = new LinkedHashMap<>();
        while(!"stop".equals(command)){
            if (!resources.containsKey(command)){
                resources.put(command,0);
            }
            resources.put(command,resources.get(command) + Integer.parseInt(scan.nextLine()));
            command = scan.nextLine();
        }

        resources.forEach((k,v) -> System.out.printf("%s -> %d\n", k, v));
    }
}
