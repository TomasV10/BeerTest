package com.satalia.beerTest.beerTest.dto;

import java.util.List;

public class Result {
    private double routeCost;
    private List<BreweryDto>visitedBreweries;
    private List<BeerTypeDto>collectedBeer;
    private long duration;

    public Result() {
    }

    public Result(double routeCost, List<BreweryDto> visitedBreweries, List<BeerTypeDto> collectedBeer, long duration) {
        this.routeCost = routeCost;
        this.visitedBreweries = visitedBreweries;
        this.collectedBeer = collectedBeer;
        this.duration = duration;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public double getRouteCost() {
        return routeCost;
    }

    public void setRouteCost(double routeCost) {
        this.routeCost = routeCost;
    }

    public List<BreweryDto> getVisitedBreweries() {
        return visitedBreweries;
    }

    public void setVisitedBreweries(List<BreweryDto> visitedBreweries) {
        this.visitedBreweries = visitedBreweries;
    }

    public List<BeerTypeDto> getCollectedBeer() {
        return collectedBeer;
    }

    public void setCollectedBeer(List<BeerTypeDto> collectedBeer) {
        this.collectedBeer = collectedBeer;
    }

    @Override
    public String toString() {
        return "Result{" +
                "routeCost=" + routeCost +
                ", visitedBreweries=" + visitedBreweries +
                ", collectedBeer=" + collectedBeer +
                ", duration=" + duration +
                '}';
    }
}
