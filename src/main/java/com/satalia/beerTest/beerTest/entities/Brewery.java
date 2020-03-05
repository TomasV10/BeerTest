package com.satalia.beerTest.beerTest.entities;

import com.satalia.beerTest.beerTest.dto.BreweryDto;
import com.satalia.beerTest.beerTest.dto.GeoLocationDto;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "breweries")
public class Brewery {
    @Id
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address1")
    private String address;
    @Column(name = "city")
    private String city;


    @OneToMany(mappedBy = "brewery", cascade = CascadeType.ALL)
    private List<GeoLocation> location;

    @OneToMany(mappedBy = "brewery", cascade = CascadeType.ALL)
    private List<BeerType>beerTypes;

    public Brewery(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Brewery(Long id, String name, List<GeoLocation> location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Brewery() {
    }

    public List<BeerType> getBeerTypes() {
        return beerTypes;
    }

    public void setBeerTypes(List<BeerType> beerTypes) {
        this.beerTypes = beerTypes;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<GeoLocation> getLocation() {
        return location;
    }

    public void setLocation(List<GeoLocation> location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Brewery{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", location=" + location +
                ", beerTypes=" + beerTypes +
                '}';
    }

}
