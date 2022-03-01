package _04HospitalDatabase.models;

import _04HospitalDatabase.entities.Diagnose;
import _04HospitalDatabase.entities.Patient;

import java.time.LocalDateTime;

public class VisitationModel {
    int id;

    private LocalDateTime date;

    private String comments;

    private Patient patient;

    private Diagnose diagnose;

    public VisitationModel(int id, LocalDateTime date, String comments, Patient patient, Diagnose diagnose) {
        this.id = id;
        this.date = date;
        this.comments = comments;
        this.patient = patient;
        this.diagnose = diagnose;
    }

    public VisitationModel(LocalDateTime date, String comments, Patient patient, Diagnose diagnose) {
        this(0, date, comments,patient, diagnose);
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getComments() {
        return comments;
    }

    public Patient getPatient() {
        return patient;
    }

    public Diagnose getDiagnose() {
        return diagnose;
    }
}
