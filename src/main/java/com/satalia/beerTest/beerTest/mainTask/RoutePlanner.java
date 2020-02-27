package com.satalia.beerTest.beerTest.mainTask;

import com.satalia.beerTest.beerTest.entities.GeoLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoutePlanner {


    private DistanceMatrixCreator distanceMatrixCreator;

    double[][] createRoute(GeoLocation home, List<GeoLocation>breweries){
        List<GeoLocation>distances = getDistancesBetweenBreweries(home, breweries);

        double[][] distanceMatrix = distanceMatrixCreator.calculateDistanceUsingMatrix(distances);
        return distanceMatrix;

        //TODO
    }

    public double calculateTotalDistance(double[][] distanceMatrix) {
        List<GeoLocation> distance = new ArrayList<>();
        double sum = 0;
        for (int i = 0; i < distanceMatrix.length; i++) {
            for (int j = 0; j < distanceMatrix[i].length; j++) {
                //TODO
            }
        }
    }

   public List<GeoLocation> getDistancesBetweenBreweries(GeoLocation home, List<GeoLocation>breweries){
        List<GeoLocation>visitedBreweries = new ArrayList<>();
        visitedBreweries.add(new GeoLocation(home.getLatitude(), home.getLongitude()));

        visitedBreweries.addAll(breweries.stream()
        .map(b -> new GeoLocation(b.getLatitude(), b.getLongitude()))
                .collect(Collectors.toList()));
        return visitedBreweries;
    }
}

