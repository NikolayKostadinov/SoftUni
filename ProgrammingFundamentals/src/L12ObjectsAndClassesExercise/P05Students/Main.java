package L12ObjectsAndClassesExercise.P05Students;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(" ");
            Student student = new Student(input[0], input[1], Double.parseDouble(input[2]));
            students.add(student);
        }

        students.sort(Comparator.comparing(Student::getGrade));

        for (int i = students.size() - 1; i >= 0 ; i--) {
            System.out.println(students.get(i));
        }
    }
}
