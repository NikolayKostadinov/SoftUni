package L03FirstStepsInCoding;

import java.util.Scanner;

public class P06ConcatenateData {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstName = sc.nextLine();
        String lastName = sc.nextLine();
        int age = Integer.parseInt(sc.nextLine());
        String town = sc.nextLine();

        String message = "You are " + firstName + " " + lastName + ", a " + age + "-years old person from " + town+".";

        System.out.println(message);
    }
}
