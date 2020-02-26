package com.satalia.beerTest.beerTest.entities;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.sql.Types;
import java.util.List;

@Entity
@Table(name = "breweries")
public class Brewery {
    @Id
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address1")
    private String address;
    @Column(name = "city")
    private String city;


    @OneToMany(mappedBy = "brewery", cascade = CascadeType.ALL)
    private List<GeoLocation> location;

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
}
