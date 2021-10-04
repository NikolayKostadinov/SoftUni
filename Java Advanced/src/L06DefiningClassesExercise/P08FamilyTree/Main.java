package L06DefiningClassesExercise.P08FamilyTree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    private static final String ADD_PATTERN = "^(?<name>(\\w+)\\s(\\w+))\\s(?<birthDay>\\d+\\/\\d+\\/\\d+)$";
    private static final Pattern patternAdd = Pattern.compile(ADD_PATTERN);

    private static Map<String, Person> relativesByDate = new LinkedHashMap<>();
    private static Map<String, Person> relativesByName = new LinkedHashMap<>();
    private static Map<String, String> relation = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String targetPerson = scan.nextLine();

        readInput(scan);
        applyRelations();
        Person person;
        if (targetPerson.contains("/")) {
            person = relativesByDate.get(targetPerson);
        } else {
            person = relativesByName.get(targetPerson);
        }

        printPerson(person);
    }

    private static void printPerson(Person person) {
        System.out.println(person.toString());

        System.out.println("Parents:");
        System.out.println(person.getParents()
                .values()
                .stream()
                .map(Person::toString)
                .collect(Collectors.joining("\n")));

        System.out.println("Children:");
        System.out.println(person.getChildren()
                .values()
                .stream()
                .map(Person::toString)
                .collect(Collectors.joining("\n")));
    }

    private static void applyRelations() {
        relation
                .entrySet()
                .stream()
                .forEach(entry -> {
                    Person parent;
                    Person child;

                    if (entry.getKey().contains("/")){
                        parent = relativesByDate.get(entry.getKey());
                    }else{
                        parent = relativesByName.get(entry.getKey());
                    }

                    if (entry.getValue().contains("/")){
                        child = relativesByDate.get(entry.getValue());
                    }else{
                        child = relativesByName.get(entry.getValue());
                    }

                    parent.addChild(child);
                    child.addParent(parent);
                });
    }

    private static void readInput(Scanner scan) {
        String input = scan.nextLine();
        while (!"End".equals(input)) {
            Matcher matcherAdd = patternAdd.matcher(input);

            if (matcherAdd.find()) {
                String name = matcherAdd.group("name");
                String date = matcherAdd.group("birthDay");

                Person person = new Person(name, date);
                relativesByDate.putIfAbsent(date, person);
                relativesByName.putIfAbsent(name, person);
            } else {
                String tokens[] = input.split(" - ");
                relation.putIfAbsent(tokens[0],tokens[1]);
            }

            input = scan.nextLine();
        }
    }
}
