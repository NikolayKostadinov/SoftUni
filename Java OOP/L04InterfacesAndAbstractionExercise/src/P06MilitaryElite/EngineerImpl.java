package P06MilitaryElite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private final Collection<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

   @Override
   public void addRepair(Repair repair){
        this.repairs.add(repair);
   }
   @Override
   public Collection<Repair> getRepairs(){
        return Collections.unmodifiableCollection(this.repairs);
   }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +
                "Repais:" + System.lineSeparator() +
                this.repairs.stream()
                        .map(Repair::toString)
                        .collect(Collectors.joining(System.lineSeparator()));
    }
}
