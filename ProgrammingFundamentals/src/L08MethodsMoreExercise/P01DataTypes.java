package L08MethodsMoreExercise;

import java.util.Scanner;

public class P01DataTypes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String type = scan.nextLine();
        switch (type){
            case "int":
                int intNum = Integer.parseInt(scan.nextLine());
                System.out.printf("%d", multyply(intNum));
                break;
            case "real":
                double doubleNum = Double.parseDouble(scan.nextLine());
                System.out.printf("%.2f", multyply(doubleNum));
                break;
            case "string":
                String str = scan.nextLine();
                System.out.printf("$%s$", str);
                break;
        }
    }

    private static int multyply(int num) {
        return num * 2;
    }

    private static double multyply(double num) {
        return num * 1.5;
    }

}
