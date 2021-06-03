package L03DataTypesAndVariables;

import java.util.Scanner;

public class P08LowerOrUpper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char chr = scan.nextLine().charAt(0);
        if ('a' <= chr && chr <= 'z'){
            System.out.println("lower-case");
        } else {
            System.out.println("upper-case");
        }
    }
}
