package L10ListsExcercise;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P10SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> courses = Arrays.stream(scan.nextLine()
                .split(", "))
                .collect(Collectors.toList());

        String command = scan.nextLine();

        while (!"course start".equals(command)) {
            String[] tokens = command.split(":");
            switch (tokens[0]) {
                case "Add":
                    if (!courses.contains(tokens[1])) courses.add(tokens[1]);
                    break;
                case "Insert":
                    if (!courses.contains(tokens[1])) courses.add(Integer.parseInt(tokens[2]), tokens[1]);
                    break;
                case "Remove":
                    if (courses.contains(tokens[1])) {
                        courses.remove(tokens[1]);
                        if (courses.contains(tokens[1] + "-Exercise")) {
                            courses.remove(tokens[1] + "-Exercise");
                        }
                    }
                    break;
                case "Swap":
                    if (courses.contains(tokens[1]) && courses.contains(tokens[2])) {
                        swapCourses(courses, tokens[1], tokens[2]);
                    }
                    break;
                case "Exercise":
                    if (courses.contains(tokens[1])) {
                        if (!courses.contains(tokens[1] + "-Exercise")) {
                            int index1 = courses.indexOf(tokens[1]);
                            courses.set(index1, courses.get(index1) + "-Exercise");
                        }
                    } else {
                        courses.add(tokens[1]);
                        courses.add(tokens[1] + "-Exercise");
                    }
                    break;
            }
            command = scan.nextLine();
        }

        for (int i = 0; i < courses.size(); i++) {
            System.out.printf("%d.%s\n", i+1, courses.get(i));

        }
    }

    private static void swapCourses(List<String> courses, String course1, String course2) {
        int index1 = courses.indexOf(course1);
        int index2 = courses.indexOf(course2);
        String buff = courses.get(index1);
        courses.set(index1, courses.get(index2));
        courses.set(index2, buff);
        if (index1 + 1 < courses.size() && courses.get(index1+1).equals(course1 + "-Exercise")){
            buff = courses.get(index1+1);
            courses.remove(index1+1);
            courses.add(index2+1, buff);
        }

        if (index2 + 1 < courses.size() && courses.get(index2+1).equals(course2 + "-Exercise")){
            buff = courses.get(index2+1);
            courses.remove(index2+1);
            courses.add(index1+1, buff);
        }

    }
}
