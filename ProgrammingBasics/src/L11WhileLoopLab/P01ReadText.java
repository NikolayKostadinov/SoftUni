package L11WhileLoopLab;

import java.util.Scanner;

public class P01ReadText {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        while(!text.equalsIgnoreCase("stop")){
            System.out.println(text);
            text = scan.nextLine();
        }
    }
}
