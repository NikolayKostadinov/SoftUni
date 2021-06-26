package L11ObjectsAndClasses.P05Students2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        List<Student> students = new ArrayList<>();

        while (!"end".equals(command)){
            String[] input = command.split(" ");
            Student student = new Student(input[0],input[1],Integer.parseInt(input[2]),input[3]);
            int position = studentPosition(students, student);
            if (position > -1) {
                students.set(position, student);
            } else {
                students.add(student);
            }

            command = scan.nextLine();
        }

        String targetTown = scan.nextLine();

        for (Student student : students) {
            if (student.getHometown().equals(targetTown)){
                System.out.println(student);
            }
        }

    }

    private static int studentPosition(List<Student> students, Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).equals(student)) return i;
        }

        return -1;
    }
}
