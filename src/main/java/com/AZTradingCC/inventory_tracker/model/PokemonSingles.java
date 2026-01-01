package com.AZTradingCC.inventory_tracker.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"PokemonSingles\"") // The quotes here are important!
public class PokemonSingles {

    @Id
    @Column(name = "\"ID\"")
    private Long id;

    @Column(name = "\"NAME\"")
    private String name;

    @Column(name = "\"CONDITION\"")
    private String condition;

    @Column(name = "\"COLLECTOR NUMBER\"")
    private String collectorNumber;

    @Column(name = "\"QUANTITY\"")
    private int quantity;

    // --- ADD THESE NEW FIELDS ---
    @Column(name = "\"GRADEDCOMPANY\"")
    private String gradedCompany;

    @Column(name = "\"GRADED\"")
    private String graded;

    @Column(name = "\"SPECIALTY\"")
    private String specialty;

    // --- Getters and Setters (including new ones) ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCollectorNumber() {
        return collectorNumber;
    }

    public void setCollectorNumber(String collectorNumber) {
        this.collectorNumber = collectorNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // --- ADD GETTERS AND SETTERS FOR THE NEW FIELDS ---

    public String getGradedCompany() {
        return gradedCompany;
    }

    public void setGradedCompany(String gradedCompany) {
        this.gradedCompany = gradedCompany;
    }

    public String getGraded() {
        return graded;
    }

    public void setGraded(String graded) {
        this.graded = graded;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}