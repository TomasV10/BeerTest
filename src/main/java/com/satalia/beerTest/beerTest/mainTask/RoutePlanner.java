package com.satalia.beerTest.beerTest.mainTask;

import com.satalia.beerTest.beerTest.entities.GeoLocation;
import com.satalia.beerTest.beerTest.services.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class RoutePlanner {

    @Autowired
    DistanceService distanceService;


    private DistanceMatrixCreator distanceMatrixCreator;

    public double[][] createRoute(GeoLocation home, List<GeoLocation>breweries){
        List<GeoLocation>distances = distanceService.getDistancesBetweenBreweries(home, breweries);

        double[][] distanceMatrix = distanceMatrixCreator.calculateDistanceUsingMatrix(distances);
        //TODO

    return distanceMatrix;
    }

}

