package com.satalia.beerTest.beerTest.mainTask;

import com.satalia.beerTest.beerTest.dto.GeoLocationDto;
import com.satalia.beerTest.beerTest.entities.GeoLocation;

import java.util.ArrayList;

public class Route {
    private GeoLocation home;
    private GeoLocation currentBrewery;
    private ArrayList<GeoLocation> breweries = new ArrayList<>();

    public Route(GeoLocation home, GeoLocation currentBrewery, ArrayList<GeoLocation> breweries) {
        this.home = home;
        this.currentBrewery = currentBrewery;
        this.breweries = breweries;
    }

    public Route() {
        home = null;
    }

    public Route(GeoLocation geoLocation) {
        this.home = geoLocation;
        this.currentBrewery = geoLocation;
        this.breweries.add(geoLocation);
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

    public ArrayList<GeoLocation> getBreweries() {
        return breweries;
    }

    public void setBreweries(ArrayList<GeoLocation> breweries) {
        this.breweries = breweries;
    }
}
