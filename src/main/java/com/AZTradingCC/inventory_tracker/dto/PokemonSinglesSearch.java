package com.AZTradingCC.inventory_tracker.dto;

public class PokemonSinglesSearch {

    private Long id;
    private String name;
    private String collectorNumber;
    private String condition;
    private String gradedCompany;
    private String graded;
    private String specialty;
    private String set;
    private int year;

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
    public String getSet() { return set; }
    public int getYear() { return year; }

    // --- SETTERS ---
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCollectorNumber(String collectorNumber) { this.collectorNumber = collectorNumber; }
    public void setCondition(String condition) { this.condition = condition; }
    public void setGradedCompany(String gradedCompany) { this.gradedCompany = gradedCompany; }
    public void setGraded(String graded) { this.graded = graded; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }
    public void setSet(String set) { this.set = set; }
    public void setYear(int year) { this.year = year; }


    // --- Extra helper ---
    public boolean useGraded() {
        return (graded != null && !graded.isEmpty()) || (gradedCompany != null && !gradedCompany.isEmpty());
    }
}
