package com.satalia.beerTest.beerTest.brewery;

import com.satalia.beerTest.beerTest.dto.BreweryDto;
import javax.persistence.*;
import java.util.List;


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

    public Brewery() {
    }

    public Brewery(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Brewery(Long id, String name, List<GeoLocation> location) {
        this.id = id;
        this.name = name;
        this.location = location;
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
    public BreweryDto toDto(){
        return new BreweryDto(id, name, location, beerTypes);
    }
}
