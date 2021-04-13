package L16SapleExams.ProgrammingBasicsOnlineExam15and16June2019;

import java.util.Scanner;

public class P06FavoriteMovie {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int counter = 0;
        String movieName = scan.nextLine();
        String maxMovieName = "";
        int maxMovieScore = 0;

        while (!"STOP".equals(movieName)) {
            counter++;

            int score = 0;
            for (int i = 0; i < movieName.length(); i++) {
                score += movieName.charAt(i);
                if ('a' <= movieName.charAt(i) && movieName.charAt(i) <= 'z') {
                    score -= movieName.length() * 2;
                } else if ('A' <= movieName.charAt(i) && movieName.charAt(i) <= 'Z') {
                    score -= movieName.length();
                }
            }

            if (score > maxMovieScore) {
                maxMovieScore = score;
                maxMovieName = movieName;
            }

            if (counter == 7) break;
            movieName = scan.nextLine();
        }

        if (counter == 7) System.out.println("The limit is reached.");

        System.out.printf("The best movie for you is %s with %d ASCII sum.", maxMovieName, maxMovieScore);
    }
}
