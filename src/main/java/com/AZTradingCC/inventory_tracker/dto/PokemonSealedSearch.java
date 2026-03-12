package com.AZTradingCC.inventory_tracker.dto;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PokemonSealedSearch {

    private Long id;
    private String name;
    private String productType;
    private String specialty;
    private String set;
    private Integer year;
    private BigDecimal price;
    private LocalDateTime timeStmp;
    private Boolean verified;

    // Constructor
    public PokemonSealedSearch() {}

    // --- GETTERS ---
    public Long getId() {return id;}

    public String getName() {return name;}

    public String getProductType() {return productType;}

    public String getSpecialty() {return specialty;}

    public String getSet(){return set;}

    public Integer getYear() {return year;}

    public BigDecimal getPrice() {return price;}

    public LocalDateTime getTimeStmp() {return timeStmp;}

    public Boolean getVerified() {return verified;}

    // --- SETTERS (if needed) ---
    public void setId(Long id) {this.id = id;}

    public void setName(String name) {this.name = name;}

    public void setProductType(String productType) {this.productType = productType;}

    public void setSpecialty(String specialty) { this.specialty = specialty;}

    public void setSet(String set) {this.set = set;}

    public void setYear(Integer year) {this.year = year;}

    public void setPrice(BigDecimal price) {this.price = price;}

    public void setTimeStamp(LocalDateTime timeStmp) {this.timeStmp = timeStmp;}

    public void setVerified(Boolean verified) {this.verified = verified;}
}
