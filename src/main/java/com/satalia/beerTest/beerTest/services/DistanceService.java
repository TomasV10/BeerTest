package com.satalia.beerTest.beerTest.services;

import com.satalia.beerTest.beerTest.entities.GeoLocation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class DistanceService {



    public double calculateDistance(double homeLat, double homeLon, double endLat, double endLon) {
        final int R = 6371;

        double latDistance = deg2rad(endLat - homeLat);
        double lonDistance = deg2rad(endLon - homeLon);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(deg2rad(homeLat)) * Math.cos(deg2rad(endLat))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c;

        distance = Math.pow(distance, 2);
        return Math.sqrt(distance);
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }


}
