package com.zetcode.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Country {

    @Id
    private String id;
    private String name;
    private int population;

    public Country(String name, int population) {
        this.name = name;
        this.population = population;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "Country{" + "id=" + id + ", name=" 
                + name + ", population=" + population + '}';
    }
}