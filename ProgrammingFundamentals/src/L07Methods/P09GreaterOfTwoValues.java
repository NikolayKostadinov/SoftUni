package L07Methods;

import java.util.Scanner;

public class P09GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String type = scan.nextLine();
        switch (type) {
            case "int":
                System.out.println(getMax(Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine())));
                break;
            case "char":
                System.out.println(getMax(scan.nextLine().charAt(0), scan.nextLine().charAt(0)));
                break;
            case "string":
                System.out.println(getMax(scan.nextLine(), scan.nextLine()));
                break;
        }
    }

    public static int getMax(int a, int b) {
        if (a >= b) return a;
        else return b;
    }

    public static char getMax(char a, char b) {
        if (a >= b) return a;
        else return b;
    }

    public static String getMax(String a, String b) {
        if (a.compareTo(b) >= 0) return a;
        else return b;
    }
}
