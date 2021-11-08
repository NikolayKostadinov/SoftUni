package P06MilitaryElite;

public class PrivateImpl extends SoldierImpl implements Private {
    private double salary;

    public PrivateImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.setSalary(salary);
    }

    @Override
    public double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        if (salary < 0) throw new IllegalArgumentException("Salary must be greater than 0");
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString()
                + " " + String.format("Salary: %.2f", this.salary);
    }
}
