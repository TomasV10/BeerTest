package com.satalia.beerTest.beerTest.mainTask;

import com.satalia.beerTest.beerTest.dto.BreweryDto;

import java.util.ArrayList;

public class Route {
    private BreweryDto home;
    private BreweryDto currentBrewery;
    private ArrayList<BreweryDto> breweries = new ArrayList<>();

    public Route(BreweryDto home, BreweryDto currentBrewery, ArrayList<BreweryDto> breweries) {
        this.home = home;
        this.currentBrewery = currentBrewery;
        this.breweries = breweries;
    }

    public Route() {
        home = null;
    }

    public Route(BreweryDto breweryDto) {
        this.home = breweryDto;
        this.currentBrewery = breweryDto;
        this.breweries.add(breweryDto);
    }

    public BreweryDto getHome() {
        return home;
    }

    public void setHome(BreweryDto home) {
        this.home = home;
    }

    public BreweryDto getCurrentBrewery() {
        return currentBrewery;
    }

    public void setCurrentBrewery(BreweryDto currentBrewery) {
        this.currentBrewery = currentBrewery;
    }

    public ArrayList<BreweryDto> getBreweries() {
        return breweries;
    }

    public void setBreweries(ArrayList<BreweryDto> breweries) {
        this.breweries = breweries;
    }
}
