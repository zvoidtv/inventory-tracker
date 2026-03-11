package com.AZTradingCC.inventory_tracker.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "\"PokemonSealed\"") // The quotes here are important!
public class PokemonSealed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID\"")
    private Long id;

    @Column(name = "\"NAME\"")
    private String name;

    @Column(name = "\"QUANTITY\"")
    private int quantity;

    @Column(name = "\"PRODUCT TYPE\"")
    private String productType;

    @Column(name = "\"SPECIALTY\"")
    private String specialty;

    @Column(name = "\"SET\"")
    private String set;

    @Column(name = "\"YEAR\"")
    private Integer year;

    @Column(name="\"IMAGE_URL\"")
    private String imageUrl;


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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public int getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // --- ADD GETTERS AND SETTERS FOR THE NEW FIELDS ---


}
