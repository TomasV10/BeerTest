package com.satalia.beerTest.beerTest;

import com.satalia.beerTest.beerTest.brewery.GeoLocation;
import com.satalia.beerTest.beerTest.services.DistanceService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class DistanceServiceTest {

    @Autowired
    DistanceService distanceService;

    @Test
    public void getDistanceBetweenBreweriesTest(){
        GeoLocation home = new GeoLocation(11.11, 22.22);
        List<GeoLocation> actualDistances = Arrays.asList(new GeoLocation(33.33, 44.44),
                new GeoLocation(55.55, 66.66));

        List<GeoLocation>distances = distanceService.getDistancesBetweenBreweries(home,actualDistances);

        Assert.assertEquals(11.11, distances.get(0).getLatitude(), 0d);

        Assert.assertEquals(33.33, distances.get(1).getLatitude(), 0d);

        Assert.assertEquals(55.55, distances.get(2).getLatitude(), 0d);
    }

    @Test
    public void calculateDistanceTest(){
        double actualDistance =  distanceService.calculateDistance(51.74250300, 19.43295600,
                51.74250300, 19.43295600);

        Assert.assertEquals(0, actualDistance, 0d);

        double actualDistance1 = distanceService.calculateDistance(51.74250300, 19.43295600,
                49.96220016, 20.60029984);

        Assert.assertEquals(214, actualDistance1, 0d);

        double actualDistance2 = distanceService.calculateDistance(49.96220016, 20.60029984,
                52.673900060,14.90040016);

        Assert.assertEquals(498, actualDistance2, 0d);
    }
}
