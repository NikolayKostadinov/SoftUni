package cafe;

import java.util.*;
import java.util.stream.Collectors;

public class Cafe {
    private Map<String, cafe.Employee> employees;
    private String name;
    private int capacity;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new HashMap<>() {
        };
    }

    public void addEmployee(cafe.Employee employee){
        if (this.employees.size() < this.capacity)
        this.employees.put(employee.getName(),employee);
    }

    public boolean removeEmployee(String name){
        boolean result = employees.containsKey(name);
        employees.remove(name);
        return false;
    }

    public cafe.Employee getOldestEmployee(){
        return this.employees.values().stream().max(Comparator.comparingInt(cafe.Employee::getAge)).orElse(null);
    }

    public cafe.Employee getEmployee(String name){
        return this.employees.get(name);
    }

    public int getCount(){
        return this.employees.size();
    }

    public String report(){
        String employees = this.employees.isEmpty()?"":"\n"+
        this.employees.values()
                .stream()
                .map(cafe.Employee::toString)
                .collect(Collectors.joining("\n"));
        return String.format("Employees working at Cafe %s:%s",
                this.name, employees);
    }
}
