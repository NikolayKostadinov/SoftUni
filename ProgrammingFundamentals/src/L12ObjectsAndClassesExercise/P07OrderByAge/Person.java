package P07OrderByAge;

public class Person {
    private String name;
    private String id;
    private int age;

    public Person(String input) {

        String[] tokens = input.split(" ");

        this.name = tokens[0];
        this.id = tokens[1];
        this.age = Integer.parseInt(tokens[2]);
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString (){
        return String.format("%s with ID: %s is %d years old.",this.name, this.id, this.age);
    }
}
