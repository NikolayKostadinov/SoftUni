package _04HospitalDatabase.entities;

import Common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prescriptions_row")
public class PrescriptionRow extends BaseEntity<Integer> {

    private Medicament medicament;

    private int timesPerDay;

    private int quantityPerConsumption;

    private Prescription prescription;

    @Column(name="times_per_day", nullable = false)
    public int getTimesPerDay() {
        return timesPerDay;
    }

    public void setTimesPerDay(int timesPerDay) {
        this.timesPerDay = timesPerDay;
    }

    @Column(name="quantity_per_consumption", nullable = false)
    public int getQuantityPerConsumption() {
        return quantityPerConsumption;
    }

    public void setQuantityPerConsumption(int quantityPerConsumption) {
        this.quantityPerConsumption = quantityPerConsumption;
    }

    @ManyToOne
    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

    @ManyToOne
    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
}
