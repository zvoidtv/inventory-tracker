package com.AZTradingCC.inventory_tracker.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"PokemonSealed\"") // The quotes here are important!
public class PokemonSealed {

    @Id
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

    // --- ADD GETTERS AND SETTERS FOR THE NEW FIELDS ---


}
