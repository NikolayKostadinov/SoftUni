import java.util.Scanner;

public class P05TimePlus15Minutes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hours = Integer.parseInt(scan.nextLine());
        int minutes = Integer.parseInt(scan.nextLine());

        minutes += 15;

        if (minutes > 59) {
            minutes -= 60;
            hours += 1;
        }

        if (hours > 23) {
            hours -= 24;
        }

        System.out.printf("%1$d:%2$02d", hours, minutes);
    }
}
