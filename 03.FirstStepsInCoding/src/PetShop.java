import java.util.Scanner;

public class PetShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dogsCount = Integer.parseInt(sc.nextLine());
        int otherAnimalsCount = Integer.parseInt(sc.nextLine());

        double sum = (dogsCount * 2.5) + (otherAnimalsCount * 4);
        System.out.println(sum+"lv.");
    }
}
