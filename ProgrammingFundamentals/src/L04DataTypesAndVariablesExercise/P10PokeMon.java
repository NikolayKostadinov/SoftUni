package L04DataTypesAndVariablesExercise;

import java.util.Scanner;

public class P10PokeMon {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());
        int M = Integer.parseInt(scan.nextLine());
        int Y = Integer.parseInt(scan.nextLine());
        double halfN = N / 2.0;

        int counter = 0;
        while (N >= M){
            N-=M;
            counter++;
            if (N == halfN && Y != 0){
                N /= Y;
            }
        }
        System.out.println(N);
        System.out.println(counter);
    }
}
