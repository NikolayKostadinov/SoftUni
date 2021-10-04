package L06DefiningClassesExercise.P08FamilyTree;

import java.util.LinkedHashMap;
import java.util.Map;

public class Person {
    private String name;
    private String birthDay;
    private final Map<String, Person> parents;
    private final Map<String, Person> children;

    public Person(String name, String birthDay) {
        this.name = name;
        this.birthDay = birthDay;
        this.parents = new LinkedHashMap<>();
        this.children = new LinkedHashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addParent(Person parent){
        this.parents.putIfAbsent(parent.getName(), parent);
    }

    public void addChild(Person child){
        this.children.putIfAbsent(child.getName(), child);
    }

    public Map<String, Person> getParents() {
        return parents;
    }

    public Map<String, Person> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return name + " " + birthDay;
    }
}
