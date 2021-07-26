package L16TextProcessingMoreExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P05HTML {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder html = new StringBuilder();
        html.append("<h1>\n");
        html.append("\t");
        html.append(scan.nextLine());
        html.append("\n</h1>\n");
        html.append("<article>\n");
        html.append("\t");
        html.append(scan.nextLine());
        html.append("\n</article>\n");

        String comment = scan.nextLine();
        while (!"end of comments".equals(comment)){
            html.append("<div>\n");
            html.append("\t");
            html.append(comment);
            html.append("\n</div>\n");
            comment = scan.nextLine();
        }

        System.out.println(html);
    }
}
