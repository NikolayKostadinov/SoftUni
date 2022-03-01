package _04HospitalDatabase.entities;

import Common.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name="diagnoses")
public class Diagnose extends BaseEntity<Integer> {

    private String name;

    private String comments;

    private Visitation visitation;

    private Prescription prescription;

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="comments", columnDefinition = "TEXT")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @OneToOne(mappedBy = "diagnose")
    public Visitation getVisitation() {
        return visitation;
    }

    public void setVisitation(Visitation visitation) {
        this.visitation = visitation;
    }

    @OneToOne(mappedBy = "diagnose")
    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
}
