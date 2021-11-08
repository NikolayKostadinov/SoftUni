package P06MilitaryElite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private final Collection<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }

   @Override
   public void addMission(Mission mission){
        this.missions.add(mission);
   }
   @Override
   public Collection<Mission> getMissions(){
        return Collections.unmodifiableCollection(this.missions);
   }
}
