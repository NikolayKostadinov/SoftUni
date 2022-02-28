package _04HospitalDatabase.entities;

import Common.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prescriptions")
public class PrescriptionRow extends BaseEntity<Integer> {

    private Medicament medicament;

    private int timesPerDay;

    private int quantityPerConsumption;

    @ManyToOne
    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

    public int getTimesPerDay() {
        return timesPerDay;
    }

    public void setTimesPerDay(int timesPerDay) {
        this.timesPerDay = timesPerDay;
    }

    public int getQuantityPerConsumption() {
        return quantityPerConsumption;
    }

    public void setQuantityPerConsumption(int quantityPerConsumption) {
        this.quantityPerConsumption = quantityPerConsumption;
    }
}
