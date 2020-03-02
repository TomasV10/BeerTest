package com.satalia.beerTest.beerTest.controllers;


import com.satalia.beerTest.beerTest.entities.Brewery;
import com.satalia.beerTest.beerTest.entities.GeoLocation;
import com.satalia.beerTest.beerTest.mainTask.DistanceMatrixCreator;
import com.satalia.beerTest.beerTest.mainTask.NearestBrewery;
import com.satalia.beerTest.beerTest.repositories.BreweriesRepository;
import com.satalia.beerTest.beerTest.repositories.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController()
public class BrewerieController {

    @Autowired
    private BreweriesRepository breweriesRepository;
    @Autowired
    private NearestBrewery nearestBrewery;
    @Autowired
    private DistanceMatrixCreator distanceMatrixCreator;
    @Autowired
    private LocationsRepository locationsRepository;


    @GetMapping("/loc")
    public List<GeoLocation>getLocations(){
      return locationsRepository.findAll();
    }

    @GetMapping("/all")
    public double getAllBreweries() {
        GeoLocation userInput = new GeoLocation(51.74250300, 19.43295600);
        List<GeoLocation> locations = locationsRepository.findAll().stream().limit(10).collect(Collectors.toList());
        locations.add(0, userInput);
        double kazkas = nearestBrewery.nearestBrewery(locations, distanceMatrixCreator.calculateDistanceUsingMatrix(locations));
        System.out.println(kazkas);
        return kazkas;
//        return new ArrayList<>(breweriesRepository.findAll());

    }

    @GetMapping("/{id}")
    public Optional<Brewery> getBreweryById(@PathVariable Long id) {
        return breweriesRepository.findById(id);
    }




}
