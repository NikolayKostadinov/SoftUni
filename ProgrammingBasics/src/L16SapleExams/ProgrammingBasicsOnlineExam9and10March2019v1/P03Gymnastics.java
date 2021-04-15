package L16SapleExams.ProgrammingBasicsOnlineExam9and10March2019v1;

import java.util.Scanner;

public class P03Gymnastics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String country = scan.nextLine();
        String tool = scan.nextLine();

        double points = 0;

        switch (country) {
            case "Russia":
                switch (tool) {
                    case "ribbon":
                        points = 9.1 + 9.4;
                        break;
                    case "hoop":
                        points = 9.3 + 9.8;
                        break;
                    case "rope":
                        points = 9.6 + 9.0;
                        break;
                }
                break;
            case "Bulgaria":
                switch (tool) {
                    case "ribbon":
                        points = 9.6 + 9.4;
                        break;
                    case "hoop":
                        points = 9.55 + 9.75;
                        break;
                    case "rope":
                        points = 9.5+ 9.4;
                        break;
                }
                break;
            case "Italy":
                switch (tool) {
                    case "ribbon":
                        points = 9.2 + 9.5;
                        break;
                    case "hoop":
                        points = 9.45 + 9.35;
                        break;
                    case "rope":
                        points = 9.7 + 9.15;
                        break;
                }
                break;
        }


        System.out.printf("The team of %s get %.3f on %s.\n", country, points, tool);
        System.out.printf("%.2f%%", (20 - points) * 100.0 / 20.0);
    }
}
