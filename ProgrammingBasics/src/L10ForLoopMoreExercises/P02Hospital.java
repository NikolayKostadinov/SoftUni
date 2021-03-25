package L10ForLoopMoreExercises;

import java.util.Scanner;

public class P02Hospital {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int period = Integer.parseInt(scan.nextLine());
        int patientsCount = 0;
        int doctorsCount = 7;
        int treatedPatientsCount = 0;
        int untreatedPatientsCount = 0;
        for (int i = 1; i <= period; i++) {
            patientsCount = Integer.parseInt(scan.nextLine());

            if (i % 3 == 0 && untreatedPatientsCount > treatedPatientsCount){
                doctorsCount++;
            }

            if (patientsCount > doctorsCount) {
                treatedPatientsCount += doctorsCount;
                untreatedPatientsCount += (patientsCount - doctorsCount);
            } else {
                treatedPatientsCount += patientsCount;
            }
        }

        System.out.printf("Treated patients: %d.\n", treatedPatientsCount);
        System.out.printf("Untreated patients: %d.", untreatedPatientsCount);
    }
}
