package com.satalia.beerTest.beerTest;

import com.satalia.beerTest.beerTest.entities.GeoLocation;
import com.satalia.beerTest.beerTest.mainTask.RoutePlanner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class DistanceBetweenBreweriesTest {

    @Test
    public void getDistanceBetweenBreweriesTest(){
        RoutePlanner planner = new RoutePlanner();

        GeoLocation home = new GeoLocation(11.11, 22.22);
        List<GeoLocation>actualDistances = Arrays.asList(new GeoLocation(33.33, 44.44),
                new GeoLocation(55.55, 66.66));

        List<GeoLocation>distances = planner.getDistancesBetweenBreweries(home,actualDistances);

        Assert.assertEquals(11.11, distances.get(0).getLatitude(), 0d);

        Assert.assertEquals(33.33, distances.get(1).getLatitude(), 0d);

        Assert.assertEquals(55.55, distances.get(2).getLatitude(), 0d);
    }
}
