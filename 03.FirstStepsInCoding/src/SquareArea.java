    import java.util.Scanner;

    public class SquareArea {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int squireSide = Integer.parseInt(scanner.nextLine());
            int area = squireSide * squireSide;
            System.out.println(area);
        }
    }