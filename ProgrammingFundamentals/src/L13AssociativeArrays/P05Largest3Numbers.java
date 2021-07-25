package L13AssociativeArrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class P05Largest3Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        AtomicInteger ix = new AtomicInteger();
        Arrays.stream(scan.nextLine().split("\\s"))
                .map(Integer::parseInt).sorted((x,y)->y.compareTo(x)).forEach(x->{if (ix.get() < 3) {
            System.out.print(x + " ");
            ix.getAndIncrement();
        }});

    }
}
