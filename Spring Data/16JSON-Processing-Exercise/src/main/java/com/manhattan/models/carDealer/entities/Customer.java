package com.manhattan.models.carDealer.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name="is_younger_driver", nullable = false)
    private boolean isYoungerDriver;

    @OneToMany(mappedBy = "customer", targetEntity = Sale.class)
    private Set<Sale> buys;

    public Customer() {
        this.buys = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungerDriver() {
        return isYoungerDriver;
    }

    public void setYoungerDriver(boolean youngerDriver) {
        isYoungerDriver = youngerDriver;
    }

    public Set<Sale> getBuys() {
        return buys;
    }

    public void setBuys(Set<Sale> buys) {
        this.buys = buys;
    }
}
