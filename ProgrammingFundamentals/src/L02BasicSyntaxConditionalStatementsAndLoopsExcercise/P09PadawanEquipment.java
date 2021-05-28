package L02BasicSyntaxConditionalStatementsAndLoopsExcercise;

import java.util.Scanner;

public class P09PadawanEquipment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double money = Double.parseDouble(scan.nextLine());
        int students = Integer.parseInt(scan.nextLine());
        double lightsabersPrice = Double.parseDouble(scan.nextLine());
        double robesPrice = Double.parseDouble(scan.nextLine());
        double beltPrice = Double.parseDouble(scan.nextLine());

        double lighrsaberSum = lightsabersPrice * (students + Math.ceil(students * 0.1));
        double robesSum = robesPrice * students;
        double beltsSum = beltPrice * (students - (students/6));

        double sum = lighrsaberSum + robesSum + beltsSum;

        if (money >= sum){
            System.out.printf("The money is enough - it would cost %.2flv.", sum);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", sum - money);
        }
    }
}
