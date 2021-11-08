package P06MilitaryElite;

public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private Corps corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    private void setCorps(String corps) {
        this.corps = Corps.valueOf(corps.toUpperCase());
    }

    @Override
    public Corps getCorps() {
        return corps;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +
                String.format("Corps: %s", this.getCorps().getDisplayText());
    }
}
