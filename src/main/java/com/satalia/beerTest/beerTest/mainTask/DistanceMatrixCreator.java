package com.satalia.beerTest.beerTest.mainTask;

import com.satalia.beerTest.beerTest.entities.GeoLocation;
import com.satalia.beerTest.beerTest.services.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DistanceMatrixCreator {

    @Autowired
    private DistanceService distanceService;

    public double[][] calculateDistanceUsingMatrix(List<GeoLocation>distances){
        double[][] distanceMatrix = new double[distances.size()][distances.size()];

        for (int i = 0; i < distances.size(); i++){
            for (int j = 0; j < distances.size(); j++){
                if(i != j){
                    GeoLocation home = distances.get(i);
                    GeoLocation end = distances.get(j);
                    distanceMatrix[i][j] = distanceService.calculateDistance(home.getLatitude(), home.getLongitude(),
                            end.getLatitude(), end.getLongitude());
                }
            }
        }
        return distanceMatrix;
    }
}

