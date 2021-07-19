package L14AssociativeArraysLambdaAndStreamAPIExcersize;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05SoftUniParking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Map<String, String> parkingList = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
                switch (tokens[0]){
                    case "register":
                        if (parkingList.containsKey(tokens[1])){
                            System.out.printf("ERROR: already registered with plate number %s\n", tokens[2]);
                        } else {
                            parkingList.put(tokens[1], tokens[2]);
                            System.out.printf("%s registered %s successfully\n",tokens[1],tokens[2]);
                        }
                        break;
                    case "unregister":
                        if (parkingList.containsKey(tokens[1])){
                            parkingList.remove(tokens[1]);
                            System.out.printf("%s unregistered successfully\n", tokens[1]);
                        } else {
                            System.out.printf("ERROR: user %s not found\n",tokens[1]);
                        }
                        break;
                }
        }
        parkingList.forEach((k,v) -> System.out.printf("%s => %s\n", k, v));
    }
}
