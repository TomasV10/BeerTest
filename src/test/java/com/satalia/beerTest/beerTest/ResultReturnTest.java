package com.satalia.beerTest.beerTest;

import com.satalia.beerTest.beerTest.dto.BeerTypeDto;
import com.satalia.beerTest.beerTest.dto.BreweryDto;
import com.satalia.beerTest.beerTest.dto.Result;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ResultReturnTest {

	@Test
	public void resultReturnTest(){
		 double routeCost = 103.71;
		 List<BreweryDto>visitedBreweries = new ArrayList<>();
		 List<BeerTypeDto>collectedBeer = new ArrayList<>();
		 long duration = 1;


		visitedBreweries.add(new BreweryDto(1, "Kauno"));
		visitedBreweries.add(new BreweryDto(2, "Utenos"));
		visitedBreweries.add(new BreweryDto(3, "Vilniaus"));

		collectedBeer.add(new BeerTypeDto(1, "Kalnapilis" ));
		collectedBeer.add(new BeerTypeDto(2, "Tamsusis" ));
		collectedBeer.add(new BeerTypeDto(3, "Stiprusis" ));

		Result result = new Result(routeCost, visitedBreweries, collectedBeer, duration);
		Assert.assertEquals(routeCost, result.getRouteCost(), 0d);
		Assert.assertEquals(duration, result.getDuration());
		Assert.assertEquals(visitedBreweries, result.getVisitedBreweries());
		Assert.assertEquals(collectedBeer, result.getCollectedBeer());
	}
}
