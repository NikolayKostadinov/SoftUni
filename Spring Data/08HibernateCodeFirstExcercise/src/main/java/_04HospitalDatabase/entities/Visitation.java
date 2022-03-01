package _04HospitalDatabase.entities;

import Common.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="visitations")
public class Visitation extends BaseEntity<Integer> {

    private LocalDateTime date;

    private String comments;

    private Patient patient;

    private Diagnose diagnose;

    @Column(name="date", nullable = false)
    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Column(name="comments", columnDefinition = "TEXT")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @ManyToOne
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @OneToOne
    @JoinColumn(name = "diagnose_id", referencedColumnName = "id", unique = true)
    public Diagnose getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(Diagnose diagnose) {
        this.diagnose = diagnose;
    }
}
