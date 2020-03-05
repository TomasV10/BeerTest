package com.satalia.beerTest.beerTest.mainTask;

import com.satalia.beerTest.beerTest.dto.BeerTypeDto;
import com.satalia.beerTest.beerTest.dto.BreweryDto;
import com.satalia.beerTest.beerTest.entities.BeerType;
import com.satalia.beerTest.beerTest.entities.Brewery;
import com.satalia.beerTest.beerTest.entities.GeoLocation;
import org.springframework.stereotype.Component;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class NearestBrewery {
    public Result nearestBrewery(List<GeoLocation> breweryLoc, double[][] distanceMatrix) {
        final long startTime = System.nanoTime();
        double routeCost = 0;

        Route nearestRoute = new Route(breweryLoc.get(0));

        while (nearestRoute.getLocations().size() != breweryLoc.size()) {
            GeoLocation neighbourBrewery = null;
            double neighbourDistance = Double.MAX_VALUE;

            for (int i = 0; i < distanceMatrix.length; i++) {
                for (int j = 0; j < distanceMatrix[i].length; j++) {

                    if (distanceMatrix[breweryLoc.indexOf(nearestRoute.getCurrentBrewery())][j] < neighbourDistance
                            && distanceMatrix[breweryLoc.indexOf(nearestRoute.getCurrentBrewery())][j] != 0
                            && !nearestRoute.getLocations().contains(breweryLoc.get(j))) {
                        neighbourBrewery = breweryLoc.get(j);
                        neighbourDistance = distanceMatrix[breweryLoc.indexOf(nearestRoute.getCurrentBrewery())][j];
                    }
                }
            }
            if (neighbourBrewery != null) {
                nearestRoute.getLocations().add(neighbourBrewery);
                nearestRoute.setCurrentBrewery(neighbourBrewery);

                if (neighbourDistance + routeCost + distanceToHome(routeCost + distanceMatrix[breweryLoc.indexOf(nearestRoute.getHome())][breweryLoc.indexOf(nearestRoute.getCurrentBrewery())]) >= 2000) {
                    break;
                }
                routeCost += neighbourDistance;
            }
        }
        nearestRoute.getLocations().add(breweryLoc.get(0));
        routeCost += distanceMatrix[breweryLoc.indexOf(nearestRoute.getHome())][breweryLoc.indexOf(nearestRoute.getCurrentBrewery())];

        List<Brewery> breweries = nearestRoute.getLocations().stream()
                .map(GeoLocation::getBrewery)
                .collect(Collectors.toList());

        System.out.println(breweries);

        List<BeerType> collectedBeer = breweries.stream()
                .map(Brewery::getBeerTypes)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println(collectedBeer);



        final long duration = System.nanoTime() - startTime;
        return new Result(routeCost, listOfbreweriesToDto(breweries), listOfBeerTypeToDto(collectedBeer), duration);
    }

    private double distanceToHome(double distanceToHome1) {
        return distanceToHome1;
    }

    private Result buildResult(double routeCost, List<Brewery>breweries, List<BeerType>collectedBeer, long duration){
        listOfbreweriesToDto(breweries);
        listOfBeerTypeToDto(collectedBeer);
        return new Result(routeCost, listOfbreweriesToDto(breweries), listOfBeerTypeToDto(collectedBeer), duration);
    }

    private List<BreweryDto> listOfbreweriesToDto(List<Brewery> breweries){
        return breweries.stream()
                .map(br -> BreweryToDto(br))
                .collect(Collectors.toList());
    }

    private BreweryDto BreweryToDto(Brewery brewery1) {
        BreweryDto breweryDto = new BreweryDto();
        breweryDto.setId(brewery1.getId());
        breweryDto.setName(brewery1.getName());
        breweryDto.setBeerTypes(brewery1.getBeerTypes());
        breweryDto.setLocations(brewery1.getLocation());
        return breweryDto;
    }

    private List<BeerTypeDto>listOfBeerTypeToDto(List<BeerType>beerTypes){
        return beerTypes.stream()
                .map(beer -> BeerTypeToDto(beer))
                .collect(Collectors.toList());
    }

    private BeerTypeDto BeerTypeToDto(BeerType beerType) {
        BeerTypeDto beerTypeDto = new BeerTypeDto();
        beerTypeDto.setId(beerType.getId());
        beerTypeDto.setName(beerType.getName());
        return beerTypeDto;
    }
}


