package com.satalia.beerTest.beerTest.mainTask;

import com.satalia.beerTest.beerTest.entities.GeoLocation;

import java.util.ArrayList;

public class Route {
    private GeoLocation home;
    private GeoLocation currentBrewery;
    private ArrayList<GeoLocation> locations = new ArrayList<>();

    public Route(GeoLocation home, GeoLocation currentBrewery, ArrayList<GeoLocation> locations) {
        this.home = home;
        this.currentBrewery = currentBrewery;
        this.locations = locations;
    }

    public Route() {
        home = null;
    }

    public Route(GeoLocation geoLocation) {
        this.home = geoLocation;
        this.currentBrewery = geoLocation;
        this.locations.add(geoLocation);
    }

    public GeoLocation getHome() {
        return home;
    }

    public void setHome(GeoLocation home) {
        this.home = home;
    }

    public GeoLocation getCurrentBrewery() {
        return currentBrewery;
    }

    public void setCurrentBrewery(GeoLocation currentBrewery) {
        this.currentBrewery = currentBrewery;
    }

    public ArrayList<GeoLocation> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<GeoLocation> locations) {
        this.locations = locations;
    }
}
