package L16SapleExams.ProgrammingBasicsOnlineExam6and7April2019;

import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;

public class P05MovieRatings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int moviesCount = Integer.parseInt(scan.nextLine());
        double minRating = 10.0;
        String minRatingName = "";
        double maxRating = 0;
        String maxRatingName = "";

        double sumRating = 0;
        for (int i = 0; i < moviesCount; i++) {
            String name = scan.nextLine();
            double rating = Double.parseDouble(scan.nextLine());
            sumRating += rating;

            if (rating < minRating){
                minRating = rating;
                minRatingName = name;
            }

            if (rating > maxRating){
                maxRating = rating;
                maxRatingName = name;
            }
        }

        System.out.printf("%s is with highest rating: %.1f\n", maxRatingName, maxRating);
        System.out.printf("%s is with lowest rating: %.1f\n", minRatingName, minRating);
        System.out.printf("Average rating: %.1f\n", sumRating / moviesCount);

    }
}
