package L02BasicSyntaxConditionalStatementsAndLoopsMoreExcercise;

import java.util.Scanner;

public class P05Messages {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String str = "";
        for (int i = 0; i < n; i++) {
            String number = scan.next();
            switch (number.charAt(0)) {
                case '2':
                    switch (number.length()) {
                        case 1:
                            str += "a";
                            break;
                        case 2:
                            str += "b";
                            break;
                        case 3:
                            str += "c";
                            break;
                    }
                    break;
                case '3':
                    switch (number.length()) {
                        case 1:
                            str += "d";
                            break;
                        case 2:
                            str += "e";
                            break;
                        case 3:
                            str += "f";
                            break;
                    }
                    break;

                case '4':
                    switch (number.length()) {
                        case 1:
                            str += "g";
                            break;
                        case 2:
                            str += "h";
                            break;
                        case 3:
                            str += "i";
                            break;
                    }
                    break;

                case '5':
                    switch (number.length()) {
                        case 1:
                            str += "j";
                            break;
                        case 2:
                            str += "k";
                            break;
                        case 3:
                            str += "l";
                            break;
                    }
                    break;

                case '6':
                    switch (number.length()) {
                        case 1:
                            str += "m";
                            break;
                        case 2:
                            str += "n";
                            break;
                        case 3:
                            str += "o";
                            break;
                    }
                    break;

                case '7':
                    switch (number.length()) {
                        case 1:
                            str += "p";
                            break;
                        case 2:
                            str += "q";
                            break;
                        case 3:
                            str += "r";
                            break;
                        case 4:
                            str += "s";
                            break;
                    }
                    break;

                case '8':
                    switch (number.length()) {
                        case 1:
                            str += "t";
                            break;
                        case 2:
                            str += "u";
                            break;
                        case 3:
                            str += "v";
                            break;
                    }
                    break;

                case '9':
                    switch (number.length()) {
                        case 1:
                            str += "w";
                            break;
                        case 2:
                            str += "x";
                            break;
                        case 3:
                            str += "y";
                            break;
                        case 4:
                            str += "z";
                            break;
                    }
                    break;

                case '0':
                    str += " ";
                    break;
            }
        }

        System.out.println(str);
    }
}
