package com.AZTradingCC.inventory_tracker.dto;

public class PokemonSealedSearch {

    private Long id;
    private String name;
    private String productType;
    private String specialty;
    private String set;
    private int year;

    // Constructor
    public PokemonSealedSearch() {}

    // --- GETTERS ---
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProductType() {
        return productType;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getSet(){
        return set;
    }

    public int getYear() {
        return year;
    }

    // --- SETTERS (if needed) ---
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
