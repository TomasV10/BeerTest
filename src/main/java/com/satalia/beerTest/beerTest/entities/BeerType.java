package com.satalia.beerTest.beerTest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.satalia.beerTest.beerTest.dto.BeerTypeDto;

import javax.persistence.*;

@Entity
@Table(name = "beers")
public class BeerType {
    @Id
    private long id;
    @Column(name = "name")
    private String name;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brewery_id")
    private Brewery brewery;

    public BeerType() {
    }

    public BeerType(long id, String name) {
        this.id = id;
        this.name = name;
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

    public Brewery getBrewery() {
        return brewery;
    }

    public void setBrewery(Brewery brewery) {
        this.brewery = brewery;
    }

    @Override
    public String toString() {
        return "BeerType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    public BeerTypeDto toDto(){
        return new BeerTypeDto(id, name);
    }
}
