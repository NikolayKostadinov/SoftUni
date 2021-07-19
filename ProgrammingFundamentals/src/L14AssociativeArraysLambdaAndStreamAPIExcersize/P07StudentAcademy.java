package L14AssociativeArraysLambdaAndStreamAPIExcersize;

import java.util.*;

public class P07StudentAcademy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Map<String, List<Double>> students = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String studentName = scan.nextLine();
            double grade = Double.parseDouble(scan.nextLine());

            if (!students.containsKey(studentName)) {
                students.put(studentName, new ArrayList<>());
            }

            students.get(studentName).add(grade);
        }

        students
                .entrySet()
                .stream()
                .map(x -> {
                    List<Double> grades = x.getValue();
                    double averageGrade = grades
                            .stream()
                            .mapToDouble(Double::doubleValue).sum() / (double) grades.size();
                    return new AbstractMap.SimpleEntry<String, Double>(x.getKey(), averageGrade);
                })
                .filter(e -> e.getValue() >= 4.5)
                .sorted(
                        Map.Entry.<String, Double>comparingByValue().reversed()
                                .thenComparing(Map.Entry.<String, Double>comparingByKey().reversed()))
                .forEach(x-> System.out.printf("%s -> %.2f\n",x.getKey(), x.getValue()));
        ;
    }
}
