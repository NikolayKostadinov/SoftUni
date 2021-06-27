package P03OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        List<P03OpinionPoll.Person> personList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(" ");
            P03OpinionPoll.Person person = new P03OpinionPoll.Person(input[0], Integer.parseInt(input[1]));
            personList.add(person);
        }

        personList.sort(Comparator.comparing(P03OpinionPoll.Person::getName));
        List<P03OpinionPoll.Person> result = personList.stream().filter(x->x.getAge() > 30).collect(Collectors.toList());

        for (P03OpinionPoll.Person person : result) {
            System.out.println(person);
        }
    }
}
