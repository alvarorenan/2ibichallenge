package com.challenge2ibi.alvaro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class country {
    //insert example sql
    //INSERT INTO country (name, capital, region, subregion, area) VALUES ('Spain', 'Madrid', 'Europe', 'Southern Europe', 505992.0);
    private String name;

    private String capital;


    private String region;

    private String subregion;

    private double area;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public country() {
    }

    public country(String name, String capital, String region, String subregion, double area) {
        this.name = name;
        this.capital = capital;
        this.region = region;
        this.subregion = subregion;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
