package hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hotel {
    private String name;
    private int capacity;
    private final List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(person);
        }
    }

    public boolean remove(String name) {
        Person person = this.roster
                .stream()
                .filter(p -> p.getName().equals(name))
                .findFirst().orElse(null);
        if (person == null) {
            return false;
        }

        return this.roster.remove(person);
    }

    public Person getPerson(String name, String hometown) {
        return this.roster
                .stream()
                .filter(p -> p.getName().equals(name) && p.getHometown().equals(hometown))
                .findFirst().orElse(null);
    }

    public int getCount() {
        return this.roster.size();
    }

    public String getStatistics() {
        return String.format("The people in the hotel %s are:", this.name) +
                (this.roster.isEmpty() ? "" :
                        System.lineSeparator() +
                                this.roster
                                        .stream()
                                        .map(Person::toString)
                                        .collect(Collectors.joining(System.lineSeparator())));
    }
}
