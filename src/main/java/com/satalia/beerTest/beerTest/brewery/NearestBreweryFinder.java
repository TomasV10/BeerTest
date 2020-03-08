package com.satalia.beerTest.beerTest.brewery;

import com.satalia.beerTest.beerTest.dto.BeerTypeDto;
import com.satalia.beerTest.beerTest.dto.BreweryDto;
import com.satalia.beerTest.beerTest.dto.Result;
import com.satalia.beerTest.beerTest.route.Route;
import org.springframework.stereotype.Component;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class NearestBreweryFinder {

    public Result nearestBrewery(List<GeoLocation> breweryLoc, double[][] distanceMatrix) {
        final long startTime = System.nanoTime();
        double routeCost = 0;
        Route nearestRoute = new Route(breweryLoc.get(0));

        routeCost = visitAsManyBreweriesAsPossibleInLimitedDistance(breweryLoc, distanceMatrix, routeCost, nearestRoute);

        nearestRoute.getLocations().add(breweryLoc.get(0));
        routeCost += distanceMatrix[breweryLoc.indexOf(nearestRoute.getHome())][breweryLoc.indexOf(nearestRoute.getCurrentBrewery())];

        List<Brewery> breweries = getListOfBreweries(nearestRoute);

        List<BeerType> collectedBeer = getListOfBeerTypes(breweries);

        final long duration = (System.nanoTime() - startTime) / 1000000;
        printResultToConsole(routeCost, breweries, collectedBeer, duration);
        return new Result(routeCost, listOfbreweriesToDto(breweries), listOfBeerTypeToDto(collectedBeer), duration);
    }

    private double visitAsManyBreweriesAsPossibleInLimitedDistance(List<GeoLocation> breweryLoc, double[][] distanceMatrix,
                                                                   double routeCost, Route nearestRoute) {
        while (nearestRoute.getLocations().size() != breweryLoc.size()) {
            GeoLocation neighbourBrewery = null;
            double neighbourDistance = Double.MAX_VALUE;

            for (double[] matrix : distanceMatrix) {
                for (int j = 0; j < matrix.length; j++) {
                    if (distanceMatrix[breweryLoc.indexOf(nearestRoute.getCurrentBrewery())][j] < neighbourDistance
                            && distanceMatrix[breweryLoc.indexOf(nearestRoute.getCurrentBrewery())][j] != 0
                            && !nearestRoute.getLocations().contains(breweryLoc.get(j))) {

                        neighbourBrewery = breweryLoc.get(j);
                        neighbourDistance = distanceMatrix[breweryLoc.indexOf(nearestRoute.getCurrentBrewery())][j];
                    }
                }
            }
            if (checkDistanceAccordingToGivenLimit(breweryLoc, distanceMatrix, routeCost, nearestRoute, neighbourDistance))
                break;

            routeCost = getRouteCost(routeCost, nearestRoute, neighbourBrewery, neighbourDistance);
        }
        return routeCost;
    }


    private double getRouteCost(double routeCost, Route nearestRoute, GeoLocation neighbourBrewery, double neighbourDistance) {
        if (neighbourBrewery != null) {
            nearestRoute.getLocations().add(neighbourBrewery);
            nearestRoute.setCurrentBrewery(neighbourBrewery);
            routeCost += neighbourDistance;
        }
        return routeCost;
    }

    private boolean checkDistanceAccordingToGivenLimit(List<GeoLocation> breweryLoc, double[][] distanceMatrix,
                                                       double routeCost, Route nearestRoute, double neighbourDistance) {

        return neighbourDistance + routeCost + distanceToHome(routeCost + distanceMatrix[breweryLoc.indexOf
                (nearestRoute.getHome())][breweryLoc.indexOf(nearestRoute.getCurrentBrewery())]) >= 2000;
    }

    private void printResultToConsole(double routeCost, List<Brewery> breweries, List<BeerType> collectedBeer,
                                      long duration) {

        System.out.println("Found " + breweries.size() + " beer factories");
        breweries.forEach(brewery -> {
                    System.out.println(brewery.getId() + " " + brewery.getName());
                    brewery.getLocation().forEach(br ->
                            System.out.println(br.getLatitude() + " " + br.getLongitude()));
                });

        System.out.println("Collected " + collectedBeer.size() + " beer types");
        collectedBeer.forEach(beer ->
                System.out.println(beer.getName()));

        System.out.println("Travelled distance " + routeCost);

        System.out.println("Program took " + duration + " ms");
    }

    private List<Brewery> getListOfBreweries(Route nearestRoute) {
        return nearestRoute.getLocations().stream()
                .map(GeoLocation::getBrewery)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
    private double distanceToHome(double distanceToHome1) {
        return distanceToHome1;
    }

    private List<BreweryDto> listOfbreweriesToDto(List<Brewery> breweries){
        return breweries.stream()
                .map(br -> br.toDto())
                .collect(Collectors.toList());
    }

    private List<BeerTypeDto>listOfBeerTypeToDto(List<BeerType>beerTypes){
        return beerTypes.stream()
                .map(beer -> beer.toDto())
                .collect(Collectors.toList());
    }

    private List<BeerType> getListOfBeerTypes(List<Brewery> breweries) {
        return breweries.stream()
                .map(Brewery::getBeerTypes)
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());
    }
}


