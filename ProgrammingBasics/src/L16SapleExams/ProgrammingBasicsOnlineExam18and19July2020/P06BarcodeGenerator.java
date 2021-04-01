package L16SapleExams.ProgrammingBasicsOnlineExam18and19July2020;

import java.util.Scanner;

public class P06BarcodeGenerator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String minCode = scan.nextLine();
        String maxCode = scan.nextLine();
        int minP1 = Integer.parseInt(String.valueOf(minCode.charAt(0)));
        int minP2 = Integer.parseInt(String.valueOf(minCode.charAt(1)));
        int minP3 = Integer.parseInt(String.valueOf(minCode.charAt(2)));
        int minP4 = Integer.parseInt(String.valueOf(minCode.charAt(3)));

        int maxP1 = Integer.parseInt(String.valueOf(maxCode.charAt(0)));
        int maxP2 = Integer.parseInt(String.valueOf(maxCode.charAt(1)));
        int maxP3 = Integer.parseInt(String.valueOf(maxCode.charAt(2)));
        int maxP4 = Integer.parseInt(String.valueOf(maxCode.charAt(3)));

        for (int p1 = minP1; p1 <= maxP1; p1++) {
            for (int p2 = minP2; p2 <= maxP2; p2++) {
                for (int p3 = minP3; p3 <= maxP3; p3++) {
                    for (int p4 = minP4; p4 <= maxP4 ; p4++) {
                        if (p1 % 2 != 0 && p2 % 2 != 0 && p3 % 2 != 0 && p4 % 2 != 0 )
                            System.out.printf("%d%d%d%d ", p1,p2, p3, p4);
                    }

                }

            }
        }
    }
}
