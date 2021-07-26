package L15TextProcessing;

import java.util.Scanner;

public class P03Substring {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String pattern = scan.nextLine();
        String text = scan.nextLine();

        while(text.contains(pattern)){
            text = text.replaceAll(pattern,"");
        }

        System.out.println(text);
    }
}
