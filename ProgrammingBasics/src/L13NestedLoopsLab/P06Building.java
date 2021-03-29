package L13NestedLoopsLab;

import java.util.Scanner;

public class P06Building {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int floorsCount = Integer.parseInt(scan.nextLine());
        int roomCount = Integer.parseInt(scan.nextLine());

        for (int i = floorsCount; i > 0; i--) {
            for (int j = 0; j < roomCount; j++) {
                if (i == floorsCount){
                    System.out.printf("L%d%d ",i,j);
                }else if (i % 2 == 0){
                    System.out.printf("O%d%d ",i,j);
                } else {
                    System.out.printf("A%d%d ",i,j);
                }
            }
            System.out.println();
        }
    }
}
