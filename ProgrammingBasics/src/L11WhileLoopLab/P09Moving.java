package L11WhileLoopLab;

import java.util.Scanner;

public class P09Moving {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int width = Integer.parseInt(scan.nextLine());
        int length = Integer.parseInt(scan.nextLine());
        int high =Integer.parseInt(scan.nextLine());
        int apartmentVolume = width * length * high;

        String text = scan.nextLine();
        int sumBoxVolume = 0;
        while (!text.equals("Done")){
            sumBoxVolume += Integer.parseInt(text);
            if(sumBoxVolume > apartmentVolume) {
                System.out.printf("No more free space! You need %d Cubic meters more.", sumBoxVolume - apartmentVolume);
                return;
            }
            text = scan.nextLine();
        }

        System.out.printf("%d Cubic meters left.", apartmentVolume - sumBoxVolume );
    }
}
