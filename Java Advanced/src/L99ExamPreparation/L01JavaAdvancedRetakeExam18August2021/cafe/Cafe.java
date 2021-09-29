package cafe;

import java.util.*;
import java.util.stream.Collectors;

public class Cafe {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(cafe.Employee employee) {
        if (this.employees.size() < this.capacity)
            this.employees.add(employee);
    }

    public boolean removeEmployee(String name) {
        if (employees.stream().anyMatch(x -> x.getName().equals(name))) {
            employees.remove(getEmployee(name));
            return true;
        }
        return false;
    }

    public cafe.Employee getOldestEmployee() {
        return Collections.max(this.employees);
    }

    public cafe.Employee getEmployee(String name) {
        return this.employees.stream()
                .filter(x -> x.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        String employees = this.employees.isEmpty() ? "" : "\n" +
                this.employees
                        .stream()
                        .map(cafe.Employee::toString)
                        .collect(Collectors.joining("\n"));
        return String.format("Employees working at Cafe %s:%s",
                this.name, employees);
    }
}
