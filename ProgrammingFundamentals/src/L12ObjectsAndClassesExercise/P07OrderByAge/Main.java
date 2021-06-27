package P07OrderByAge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();

        List<P07OrderByAge.Person> people = new ArrayList<>();

        while (!"End".equals(command)){
            people.add(new P07OrderByAge.Person(command));
            command = scan.nextLine();
        }

        people.sort(Comparator.comparing(P07OrderByAge.Person::getAge));
        people.stream().forEach(System.out::println);
    }
}
