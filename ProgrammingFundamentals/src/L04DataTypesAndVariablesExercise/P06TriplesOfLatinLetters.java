package L04DataTypesAndVariablesExercise;

        import java.util.Scanner;

public class P06TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int p1 = 0; p1 < n; p1++) {
            for (int p2 = 0; p2 < n; p2++) {
                for (int p3 = 0; p3 < n; p3++) {
                    System.out.printf("%c%c%c\n", (char)('a' + p1), (char)('a' + p2),(char)('a' + p3));
                }
            }
        }
    }
}
