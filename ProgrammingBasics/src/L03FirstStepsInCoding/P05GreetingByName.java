package L03FirstStepsInCoding;

import java.util.Scanner;

public class P05GreetingByName {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        String greeting = "Hello, " + name + "!";
        System.out.println(greeting);
    }
}
