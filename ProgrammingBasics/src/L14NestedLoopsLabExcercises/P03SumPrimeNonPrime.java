package L14NestedLoopsLabExcercises;

import java.util.Scanner;

public class P03SumPrimeNonPrime {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int sumPrimes = 0;
        int sumNonPrime = 0;
        while (!"stop".equals(input)) {
            int num = Integer.parseInt(input);
            if (num < 0) {
                System.out.println("Number is negative.");
            } else {
                boolean isPrime = true;
                int max = (int)(Math.round(Math.sqrt(num)));

                for (int i = 2; i <= max; i++) {
                    if (num % i == 0){
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime){
                    sumPrimes += num;
                } else {
                    sumNonPrime += num;
                }
            }

            input = scan.nextLine();
        }

        System.out.printf("Sum of all prime numbers is: %d\n", sumPrimes);
        System.out.printf("Sum of all non prime numbers is: %d\n", sumNonPrime);
    }
}
