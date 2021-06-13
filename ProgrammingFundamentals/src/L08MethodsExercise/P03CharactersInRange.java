package L08MethodsExercise;

import java.util.Scanner;

public class P03CharactersInRange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char chr1 = scan.nextLine().charAt(0);
        char chr2 = scan.nextLine().charAt(0);

        System.out.println(charsBetween(chr1, chr2));
    }

    private static String charsBetween(char begin, char end) {
        if (begin > end){
            char temp = begin;
            begin = end;
            end = temp;
        }
        StringBuilder sb = new StringBuilder(end-begin);
        for (int i = begin+1; i < end ; i++) {
            sb.append((char) i);
            sb.append(' ');
        }

        return sb.toString();
    }
}
