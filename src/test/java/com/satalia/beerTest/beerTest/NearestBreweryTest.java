package com.satalia.beerTest.beerTest;

import com.satalia.beerTest.beerTest.dto.BreweryDto;
import com.satalia.beerTest.beerTest.mainTask.DistanceMatrixCreator;
import com.satalia.beerTest.beerTest.mainTask.NearestBrewery;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class NearestBreweryTest {

	@Test
	public void nearestNeighbourTest(){

        List<BreweryDto>breweryDtos = new ArrayList<>();

        breweryDtos.add(new BreweryDto("Birmingham", 0, false));
        breweryDtos.add(new BreweryDto("Lancaster", 1, false));
        breweryDtos.add(new BreweryDto("Leeds", 2, false));
        breweryDtos.add(new BreweryDto("Leicester", 3, false));
        breweryDtos.add(new BreweryDto("Lincoln", 4, true)); //home
		
		NearestBrewery neighbour = new NearestBrewery();
		final double[][] distances = { 	{0, 2.56, 100.05, 1.18, 2.25},
										{2.25, 1.10, 0, 5.50, 3.33},
										{4.78, 3.55, 10, 0,5.12},
										{8.45, 4.1, 0.5, 7.88, 0},
										{5.8,8.2, 1.5,2.1, 0} };

		Assert.assertEquals(10.58, neighbour.nearestBrewery(breweryDtos, distances), 0d);
		System.out.println(neighbour.nearestBrewery(breweryDtos, distances));
	}

}
