package com.satalia.beerTest.beerTest;

import com.satalia.beerTest.beerTest.dto.GeoLocationDto;
import com.satalia.beerTest.beerTest.entities.GeoLocation;
import com.satalia.beerTest.beerTest.mainTask.NearestBrewery;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class NearestBreweryTest {

	@Test
	public void nearestBreweryTest(){



        List<GeoLocation> geoLocation = new ArrayList<>();

		geoLocation.add(new GeoLocation(11.11, 22.22));//home
		geoLocation.add(new GeoLocation(33.33, 44.44));
		geoLocation.add(new GeoLocation(55.55, 66.66));
		geoLocation.add(new GeoLocation(77.77, 88.88));
		geoLocation.add(new GeoLocation(99.99, 100.00));

		NearestBrewery neighbour = new NearestBrewery();
		final double[][] distances = { 	{0, 2.56, 100.05, 1.18, 2.25},
										{2.25, 0, 1.10, 5.50, 3.33},
										{4.78, 3.55, 0, 10, 5.12},
										{8.45, 4.1, 0.5, 0, 7.88},
										{5.8,8.2, 1.5,2.1, 0} };

		Assert.assertEquals(10.57, neighbour.nearestBrewery(geoLocation, distances), 0d);
	}

}
