package L14AssociativeArraysLambdaAndStreamAPIExcersize;

import java.util.*;

public class P06Courses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, List<String>> courses = new LinkedHashMap<>();

        String command = scan.nextLine();

        while (!"end".equals(command)) {
            String tokens[] = command.split(" : ");

            if (!courses.containsKey(tokens[0])) {
                courses.put(tokens[0], new ArrayList<>());
            }
            courses.get(tokens[0]).add(tokens[1]);

            command = scan.nextLine();
        }

        courses.
                entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue().size() - o1.getValue().size())
                .forEach((course) -> {
                    List<String> students = course.getValue();

                    System.out.printf("%s: %d\n", course.getKey(), students.size());
                    students
                            .stream()
                            .sorted()
                            .forEach(student -> System.out.printf("-- %s\n", student));
                });
    }
}
