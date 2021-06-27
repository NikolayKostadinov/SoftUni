package L12ObjectsAndClassesExercise.P04Articles2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<P04Articles2.Article> articles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(", ");
            P04Articles2.Article article = new P04Articles2.Article(input[0], input[1], input[2]);
            articles.add(article);
        }

        String sortBy = scan.nextLine();
        switch (sortBy) {
            case "title":
                articles.sort(Comparator.comparing(P04Articles2.Article::getTitle));
                break;
            case "content":
                articles.sort(Comparator.comparing(P04Articles2.Article::getContent));
                break;
            case "author":
                articles.sort(Comparator.comparing(P04Articles2.Article::getAuthor));
                break;
        }

        for (P04Articles2.Article article : articles) {
            System.out.println(article);
        }
    }
}
