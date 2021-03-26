package L12WhileLoopExercise;

import java.util.Scanner;

public class P01OldBooks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String bookName = scan.nextLine();

        String libraryBookName = scan.nextLine();
        int booksCount = 0;
        while (!libraryBookName.equals("No More Books")){
            if (libraryBookName.equals(bookName)){
                System.out.printf("You checked %d books and found it.", booksCount);
                return;
            } else {
                booksCount++;
                libraryBookName = scan.nextLine();
            }
        }

        System.out.printf("The book you search is not here!\n" +
                "You checked %d books.", booksCount);
    }
}
