package L14NestedLoopsLabExcercises;

import java.util.Scanner;

public class P04TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int juryCount = Integer.parseInt(scan.nextLine());
        String presentationName = scan.nextLine();
        int presentationCounter = 0;
        double sumGrade = 0;
        while (!"Finish".equals(presentationName)){
            presentationCounter++;
            double averagePresentationGrade =0;
            for (int i = 0; i < juryCount; i++) {
                averagePresentationGrade += Double.parseDouble(scan.nextLine());
            }
            averagePresentationGrade /= juryCount;
            sumGrade += averagePresentationGrade;
            System.out.printf("%s - %.2f.\n", presentationName, averagePresentationGrade);
            presentationName = scan.nextLine();
        }
        System.out.printf("Student's final assessment is %.2f.", sumGrade / presentationCounter);
    }
}
