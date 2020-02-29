package com.satalia.beerTest.beerTest.mainTask;

import com.satalia.beerTest.beerTest.dto.BreweryDto;

import java.util.ArrayList;
import java.util.List;

public class NearestBrewery {

    public List<BreweryDto>getList() {
        List<BreweryDto>breweryDtos = new ArrayList<>();

        breweryDtos.add(new BreweryDto("Birmingham", 0, false));
        breweryDtos.add(new BreweryDto("Lancaster", 1, false));
        breweryDtos.add(new BreweryDto("Leeds", 2, false));
        breweryDtos.add(new BreweryDto("Leicester", 3, false));
        breweryDtos.add(new BreweryDto("Lincoln", 4, true)); //home

        return breweryDtos;
    }


    public double nearestBrewery(double[][] distanceMatrix) {
        double routeCost = 0;

        Route nearestRoute = new Route(getList().get(4));

        while(nearestRoute.getBreweries().size() != getList().size()){
            BreweryDto neighbourBrewery = null;
            double neighbourDistance = Double.MAX_VALUE;

            for(int i = 0; i < distanceMatrix.length; i++) {
                for (int j = 0; j < distanceMatrix[i].length; j++) {

                    if (distanceMatrix[nearestRoute.getCurrentBrewery().getId()][j] < neighbourDistance
                            && distanceMatrix[nearestRoute.getCurrentBrewery().getId()][j] != 0
                            && getList().get(j).isVisited() == false) {

                        neighbourBrewery = getList().get(j);
                        neighbourDistance = distanceMatrix[nearestRoute.getCurrentBrewery().getId()][j];
                    }
                }
            }
            if (neighbourBrewery != null){
                nearestRoute.getBreweries().add(neighbourBrewery);
                nearestRoute.setCurrentBrewery(neighbourBrewery);
                neighbourBrewery.setVisited(true);

                routeCost += neighbourDistance;
            }
        }

        routeCost += distanceMatrix[nearestRoute.getHome().getId()][nearestRoute.getCurrentBrewery().getId()];
        nearestRoute.getBreweries().add(getList().get(4));

        return routeCost;
    }
}

