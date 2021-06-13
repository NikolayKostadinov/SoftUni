package L07Methods;

import java.util.Scanner;

public class P06CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int height = Integer.parseInt(scan.nextLine());
        int width = Integer.parseInt(scan.nextLine());

        int area = calculateArea(height, width);

        System.out.println(area);
    }

    private static int calculateArea(int height, int width) {
        return height * width;
    }
}
