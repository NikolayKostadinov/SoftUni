package L06ArraysExcercise;

import java.util.Scanner;

public class P02CommonElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] firstArr = scan.nextLine().split(" ");
        String[] secondArr = scan.nextLine().split(" ");

        for (String template:secondArr) {
            for (String element:firstArr) {
                if (element.equals(template)){
                    System.out.printf("%s ", element);
                    break;
                }
            }
        }
    }
}
