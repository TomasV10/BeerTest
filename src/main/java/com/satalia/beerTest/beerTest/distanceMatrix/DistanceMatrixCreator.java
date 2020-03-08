package com.satalia.beerTest.beerTest.distanceMatrix;

import com.satalia.beerTest.beerTest.brewery.GeoLocation;
import com.satalia.beerTest.beerTest.services.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DistanceMatrixCreator {

    @Autowired
    DistanceService distanceService;

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

