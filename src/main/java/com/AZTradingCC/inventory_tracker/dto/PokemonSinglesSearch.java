package com.AZTradingCC.inventory_tracker.dto;

public class PokemonSinglesSearch {

    private Long id;
    private String name;
    private String collectorNumber;
    private String condition;
    private String gradedCompany;
    private String graded;
    private String specialty;

    // Constructor
    public PokemonSinglesSearch() {}

    // --- GETTERS ---
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getCollectorNumber() { return collectorNumber; }
    public String getCondition() { return condition; }
    public String getGradedCompany() { return gradedCompany; }
    public String getGraded() { return graded; }
    public String getSpecialty() { return specialty; }

    // --- SETTERS ---
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCollectorNumber(String collectorNumber) { this.collectorNumber = collectorNumber; }
    public void setCondition(String condition) { this.condition = condition; }
    public void setGradedCompany(String gradedCompany) { this.gradedCompany = gradedCompany; }
    public void setGraded(String graded) { this.graded = graded; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }

    // --- Extra helper ---
    public boolean useGraded() {
        return (graded != null && !graded.isEmpty()) || (gradedCompany != null && !gradedCompany.isEmpty());
    }
}
