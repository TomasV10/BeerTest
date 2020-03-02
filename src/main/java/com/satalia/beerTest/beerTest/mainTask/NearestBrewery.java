package com.satalia.beerTest.beerTest.mainTask;

import com.satalia.beerTest.beerTest.entities.GeoLocation;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class NearestBrewery {

    public double nearestBrewery(List<GeoLocation> breweryLoc, double[][] distanceMatrix) {
        double routeCost = 0;

        Route nearestRoute = new Route(breweryLoc.get(0));

        while(nearestRoute.getBreweries().size() != breweryLoc.size()){
            GeoLocation neighbourBrewery = null;
            double neighbourDistance = Double.MAX_VALUE;

            for(int i = 0; i < distanceMatrix.length; i++) {
                for (int j = 0; j < distanceMatrix[i].length; j++) {

                    if (distanceMatrix[breweryLoc.indexOf(nearestRoute.getCurrentBrewery())][j] < neighbourDistance
                            && distanceMatrix[breweryLoc.indexOf(nearestRoute.getCurrentBrewery())][j] != 0
                            && !nearestRoute.getBreweries().contains(breweryLoc)) {

                        neighbourBrewery = breweryLoc.get(j);
                        neighbourDistance = distanceMatrix[breweryLoc.indexOf(nearestRoute.getCurrentBrewery())][j];
                    }
                }
            }
            if (neighbourBrewery != null){
                nearestRoute.getBreweries().add(neighbourBrewery);
                nearestRoute.setCurrentBrewery(neighbourBrewery);
                if(neighbourDistance + routeCost >= 2000){
                    break;
                }
               routeCost += neighbourDistance;

            }
        }

        routeCost += distanceMatrix[breweryLoc.indexOf(nearestRoute.getHome())][breweryLoc.indexOf(nearestRoute.getCurrentBrewery())];
        nearestRoute.getBreweries().add(breweryLoc.get(0));

        return routeCost;
    }
}

