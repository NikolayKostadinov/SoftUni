package L13NestedLoopsLab;

import java.util.Scanner;

public class P05Travelling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String destination = scan.nextLine();
        double neededSum = 0;
        double sum = 0;
        while (!destination.equals("End")){
            neededSum = Double.parseDouble(scan.nextLine());
            while (neededSum > sum){
                sum += Double.parseDouble(scan.nextLine());
            }

            System.out.printf("Going to %s!\n", destination);
            sum=0;
            destination = scan.nextLine();
        }
    }
}
