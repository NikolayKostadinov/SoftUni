package L04DataTypesAndVariablesExercise;

import java.util.Scanner;

public class P07WaterOverflow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        int capacity = 255;
        int freeCapacity = capacity;
        for (int i = 0; i < n; i++) {
            int dose = Integer.parseInt(scan.nextLine());
            if (freeCapacity - dose < 0){
                System.out.println("Insufficient capacity!");
            } else {
                freeCapacity -= dose;
            }
        }

        System.out.println(capacity - freeCapacity);
    }
}
