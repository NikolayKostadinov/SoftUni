package _04HospitalDatabase.entities;

import Common.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "_04_patients")
public class Patient extends BaseEntity<Integer> {
    private String firstName;
    private String lastName;
    private Address address;
    private String email;
    private LocalDateTime dateОfBirth;
    private byte[] picture;
    private Boolean hasInsurance;

    @Column(name = "first_name", nullable = false, length = 50)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false, length = 50)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @ManyToOne
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Column(name="email", unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="date_of_birth")
    public LocalDateTime getDateОfBirth() {
        return dateОfBirth;
    }

    public void setDateОfBirth(LocalDateTime dateОfBirth) {
        this.dateОfBirth = dateОfBirth;
    }

    @Lob
    @Column(name="picture")
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public Boolean getHasInsurance() {
        return hasInsurance;
    }

    public void setHasInsurance(Boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }
}
