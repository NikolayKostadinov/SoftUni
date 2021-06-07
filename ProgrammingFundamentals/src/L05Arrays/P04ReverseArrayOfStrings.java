package L05Arrays;

import java.util.Scanner;

public class P04ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] stringArr = scan.nextLine().split(" ");

        for (int i = 0; i < stringArr.length / 2; i++) {
            String buf = stringArr[i];
            stringArr[i] = stringArr [stringArr.length - 1 - i];
            stringArr [stringArr.length - 1 - i] = buf;
        }

        System.out.println(String.join(" ", stringArr));

    }
}
