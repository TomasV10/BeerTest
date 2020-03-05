package com.satalia.beerTest.beerTest.dto;

import com.satalia.beerTest.beerTest.entities.BeerType;
import com.satalia.beerTest.beerTest.entities.GeoLocation;

import java.util.List;

public class BreweryDto {
    private long id;
    private String name;
    private List<GeoLocation>locations;
    private List<BeerType>beerTypes;

    public BreweryDto() {
    }

    public BreweryDto(long id, String name, List<GeoLocation> locations, List<BeerType> beerTypes) {
        this.id = id;
        this.name = name;
        this.locations = locations;
        this.beerTypes = beerTypes;
    }

    public BreweryDto(long id, String name) {
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

    public List<GeoLocation> getLocations() {
        return locations;
    }

    public void setLocations(List<GeoLocation> locations) {
        this.locations = locations;
    }

    public List<BeerType> getBeerTypes() {
        return beerTypes;
    }

    public void setBeerTypes(List<BeerType> beerTypes) {
        this.beerTypes = beerTypes;
    }
}
