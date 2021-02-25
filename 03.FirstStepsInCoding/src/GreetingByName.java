import java.util.Scanner;

public class GreetingByName {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        String greeting = "Hello, " + name + "!";
        System.out.println(greeting);
    }
}
