package L11ObjectsAndClasses.P05Students2;

public class Student {
    String firstName;
    String lastName;
    int age;
    String hometown;

    public Student(String firstName, String lastName, int age, String hometown) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.hometown = hometown;
    }

    public String getHometown() {
        return this.hometown;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    @Override
    public String toString(){
        return String.format("%s %s is %d years old", this.firstName, this.lastName, this.age);
    }

    public boolean equals(Student student){
        return this.firstName.equals(student.getFirstName()) && this.lastName.equals(student.getLastName());
    }
}
