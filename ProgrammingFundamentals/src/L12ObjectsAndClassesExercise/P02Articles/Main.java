package P02Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(", ");
        P02Articles.Article article = new P02Articles.Article(input[0], input[1], input[2]);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            input = scan.nextLine().split(": ");
            switch (input[0]) {
                case "Edit":
                    article.edit(input[1]);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(input[1]);
                    break;
                case "Rename":
                    article.rename(input[1]);
                    break;
            }
        }

        System.out.println(article);
    }
}
