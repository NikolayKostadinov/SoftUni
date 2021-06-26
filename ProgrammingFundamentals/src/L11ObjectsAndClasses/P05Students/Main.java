package P05Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        List<P05Students.Student> students = new ArrayList<>();

        while (!"end".equals(command)){
            String[] input = command.split(" ");
            students.add(new P05Students.Student(input[0],input[1],Integer.parseInt(input[2]),input[3]));
            command = scan.nextLine();
        }

        String targetTown = scan.nextLine();

        for (P05Students.Student student : students) {
            if (student.getHometown().equals(targetTown)){
                System.out.println(student);
            }
        }

    }
}
