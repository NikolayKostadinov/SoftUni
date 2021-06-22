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

        String input = scan.nextLine();

        while (!"course start".equals(input)) {
            String[] tokens = input.split(":");
            String command = tokens[0];
            String course1 = tokens[1];
            switch (command) {
                case "Add":
                    if (!courses.contains(course1)) courses.add(course1);
                    break;
                case "Insert":
                    if (!courses.contains(course1)) {
                        int index = Integer.parseInt(tokens[2]);
                        courses.add(index, course1);
                    }
                    ;
                    break;
                case "Remove":
                    String courseExercise1 = course1 + "-Exercise";
                    if (courses.contains(course1)) {
                        courses.remove(course1);
                        if (courses.contains(courseExercise1)) {
                            courses.remove(courseExercise1);
                        }
                    }
                    break;
                case "Swap":
                    String course2 = tokens[2];
                    courseExercise1 = course1 + "-Exercise";
                    String courseExercise2 = course2 + "-Exercise";

                    int index1 = courses.indexOf(course1);
                    int index2 = courses.indexOf(course2);

                    if (index1 >= 0 && index2 >= 0) {
                        courses.set(index1, course2);
                        courses.set(index2, course1);
                    }

                    if (courses.contains(courseExercise1)){
                        courses.remove(courses.indexOf(courseExercise1));
                        courses.add(index2+1, courseExercise1);
                    }

                    if (courses.contains(courseExercise2)){
                        courses.remove(courses.indexOf(courseExercise2));
                        courses.add(index1+1, courseExercise2);
                    }

                    break;
                case "Exercise":
                    courseExercise1 = course1 + "-Exercise";
                    index1 = courses.indexOf(course1);
                    if (index1 >= 0) {
                        if (!courses.contains(courseExercise1)) {
                            if (index1 == courses.size() - 1)
                            {
                                courses.add(courseExercise1);
                            } else {
                                courses.add(index1+1, courseExercise1);
                            }
                        }
                    } else {
                        courses.add(course1);
                        courses.add(courseExercise1);
                    }
                    break;
            }
            input = scan.nextLine();
        }

        for (int i = 0; i < courses.size(); i++) {
            System.out.printf("%d.%s\n", i + 1, courses.get(i));
        }
    }
}
