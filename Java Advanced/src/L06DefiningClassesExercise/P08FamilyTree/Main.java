package L06DefiningClassesExercise.P08FamilyTree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    private static final String ADD_PATTERN =
            "^(?<name>(\\w+)\\s(\\w+))\\s(?<birthDay>\\d+\\/\\d+\\/\\d+)$";
    private static final String PARENT_NAME_CHILD_NAME =
            "^(?<parentName>(\\w+)\\s(\\w+))\\s-\\s(?<childName>(\\w+)\\s(\\w+))$";
    private static final String PARENT_NAME_CHILD_BIRTHDAY =
            "^(?<parentName>(\\w+)\\s(\\w+))\\s-\\s(?<childBirthDay>\\d+\\/\\d+\\/\\d+)$";
    private static final String PARENT_BIRTHDAY_CHILD_NAME =
            "^(?<parentBirthDay>\\d+\\/\\d+\\/\\d+)\\s-\\s(?<childName>(\\w+)\\s(\\w+))$";
    private static final String PARENT_BIRTHDAY_CHILD_BIRTHDAY =
            "^(?<parentBirthDay>\\d+\\/\\d+\\/\\d+)\\s-\\s(?<childBirthDay>\\d+\\/\\d+\\/\\d+)$";

    private static final Pattern patternAdd = Pattern.compile(ADD_PATTERN);
    private static final Pattern parentNameToChildName = Pattern.compile(PARENT_NAME_CHILD_NAME);
    private static final Pattern patternParentNameToChildBirthDay = Pattern.compile(PARENT_NAME_CHILD_BIRTHDAY);
    private static final Pattern patternParentBirthDayToChildName = Pattern.compile(PARENT_BIRTHDAY_CHILD_NAME);
    private static final Pattern patternParentBirthDayToChildBirtDay = Pattern.compile(PARENT_BIRTHDAY_CHILD_BIRTHDAY);

    private static Map<String, Person> relativesByDate = new LinkedHashMap<>();
    private static Map<String, Person> relativesByName = new LinkedHashMap<>();
    private static Map<String, String> parentNameToChildNameCollection = new LinkedHashMap<>();
    private static Map<String, String> parentNameToChildBirthDayCollection = new LinkedHashMap<>();
    private static Map<String, String> parentBirthDayToChildNameCollection = new LinkedHashMap<>();
    private static Map<String, String> parentBirthDayToChildBirtDayCollection = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String targetPerson = scan.nextLine();

        readInput(scan);
        applyRelations();
        Person person;
        if (targetPerson.contains("/")){
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
        parentNameToChildNameCollection
                .entrySet()
                .stream()
                .forEach(entry->{
                    var parent = relativesByName.get(entry.getKey());
                    var child = relativesByName.get(entry.getValue());
                    parent.addChild(child);
                    child.addParent(parent);
                });

        parentNameToChildBirthDayCollection
                .entrySet()
                .stream()
                .forEach(entry->{
                    Person parent = relativesByName.get(entry.getKey());
                    Person child = relativesByDate.get(entry.getValue());
                    parent.addChild(child);
                    child.addParent(parent);
                });

        parentBirthDayToChildNameCollection
                .entrySet()
                .stream()
                .forEach(entry->{
                    Person parent = relativesByDate.get(entry.getKey());
                    Person child = relativesByName.get(entry.getValue());
                    parent.addChild(child);
                    child.addParent(parent);
                });

        parentBirthDayToChildBirtDayCollection
                .entrySet()
                .stream()
                .forEach(entry->{
                    Person parent = relativesByDate.get(entry.getKey());
                    Person child = relativesByDate.get(entry.getValue());
                    parent.addChild(child);
                    child.addParent(parent);
                });
    }

    private static void readInput(Scanner scan) {
        String input = scan.nextLine();
        while (!"End".equals(input)) {
            Matcher matcherAdd = patternAdd.matcher(input);
            Matcher matcherParentNameToChildName = parentNameToChildName.matcher(input);
            Matcher matcherParentNameToChildBirthDay = patternParentNameToChildBirthDay.matcher(input);
            Matcher matcherParentBirthDayToChildName = patternParentBirthDayToChildName.matcher(input);
            Matcher matcherParentBirthDayToChildBirtDay = patternParentBirthDayToChildBirtDay.matcher(input);

            if (matcherAdd.find()) {
                String name = matcherAdd.group("name");
                String date = matcherAdd.group("birthDay");

                Person person = new Person(name, date);
                relativesByDate.putIfAbsent(date, person);
                relativesByName.putIfAbsent(name, person);
            } else if (matcherParentNameToChildName.find()) {
                String parentName = matcherParentNameToChildName.group("parentName");
                String childName = matcherParentNameToChildName.group("childName");

                parentNameToChildNameCollection.putIfAbsent(parentName, childName);
            } else if (matcherParentNameToChildBirthDay.find()) {
                String parentName = matcherParentNameToChildBirthDay.group("parentName");
                String childBirthDay = matcherParentNameToChildBirthDay.group("childBirthDay");

                parentNameToChildBirthDayCollection.putIfAbsent(parentName, childBirthDay);
            } else if (matcherParentBirthDayToChildName.find()) {
                String parentBirthDay = matcherParentBirthDayToChildName.group("parentBirthDay");
                String childName = matcherParentBirthDayToChildName.group("childName");

                parentBirthDayToChildNameCollection.putIfAbsent(parentBirthDay, childName);
            } else if (matcherParentBirthDayToChildBirtDay.matches()) {
                String parentBirthDay = matcherParentBirthDayToChildBirtDay.group("parentBirthDay");
                String childBirthDay = matcherParentBirthDayToChildBirtDay.group("childBirthDay");

                parentBirthDayToChildBirtDayCollection.putIfAbsent(parentBirthDay, childBirthDay);
            }
            input = scan.nextLine();
        }
    }
}
