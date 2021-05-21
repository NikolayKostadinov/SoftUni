package L01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class P05MonthPrinter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = Integer.parseInt(scan.nextLine());
        String answer = "";
        switch (m) {
            case 1:
                answer = "January";
                break;
            case 2:
                answer = "February";
                break;
            case 3:
                answer = "March";
                break;
            case 4:
                answer = "April";
                break;
            case 5:
                answer = "May";
                break;
            case 6:
                answer = "June";
                break;
            case 7:
                answer = "July";
                break;
            case 8:
                answer = "August";
                break;
            case 9:
                answer = "September";
                break;
            case 10:
                answer = "October";
                break;
            case 11:
                answer = "November";
                break;
            case 12:
                answer = "December";
                break;
            default:
                answer = "Error!";
                break;
        }

        System.out.println(answer);
    }
}
