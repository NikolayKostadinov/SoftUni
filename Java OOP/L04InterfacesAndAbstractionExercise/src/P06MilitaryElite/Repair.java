package P06MilitaryElite;

public class Repair {
    private String partName;
    private int hoursWorked;

    public Repair(String partName, int hoursWorked) {
        this.setPartName(partName);
        this.setHoursWorked(hoursWorked);
    }

    public String getPartName() {
        return partName;
    }

    private void setPartName(String partName) {
        if (partName.trim().isEmpty()) throw new IllegalArgumentException("Invalid partName");
        this.partName = partName;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    private void setHoursWorked(int hoursWorked) {
        if (hoursWorked < 0 ) throw new IllegalArgumentException("Invalid hoursWorked");
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Worked: %d", this.partName, this.hoursWorked);
    }
}
