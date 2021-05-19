package TheExam;

import java.util.Scanner;

public class P03FinalCompetition {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int dancersCount = Integer.parseInt(scan.nextLine());
        double points = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();
        String country = scan.nextLine();

        double sum = points * dancersCount * ((("Abroad".equals(country))) ? 1.5 : 1.0);

        double expences = 0;
        switch (country){
            case "Bulgaria" :
                expences = ("summer".equals(season)) ? sum * 0.05 : sum * 0.08;
                break;
            case "Abroad" :
                expences = ("summer".equals(season)) ? sum * 0.1 : sum * 0.15;
                break;
        }

        sum -= expences;
        double charity = sum * 0.75;

        System.out.printf("Charity - %.2f\n", charity);
        System.out.printf("Money per dancer - %.2f", (sum - charity) / dancersCount);
    }
}
