package com.satalia.beerTest.beerTest.api;

import com.satalia.beerTest.beerTest.dto.GeoLocationDto;
import com.satalia.beerTest.beerTest.entities.GeoLocation;
import com.satalia.beerTest.beerTest.mainTask.DistanceMatrixCreator;
import com.satalia.beerTest.beerTest.mainTask.NearestBrewery;
import com.satalia.beerTest.beerTest.mainTask.Result;
import com.satalia.beerTest.beerTest.repositories.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BreweryApiController {

    @Autowired
    private NearestBrewery nearestBrewery;
    @Autowired
    private DistanceMatrixCreator distanceMatrixCreator;
    @Autowired
    private LocationsRepository locationsRepository;


    @PostMapping("/api/breweries")
    public Result getCalculated(@RequestBody GeoLocationDto geoLocationDto) {
        GeoLocation location = geoLocationToDto(geoLocationDto);
        List<GeoLocation> locations = locationsRepository.findAll();
        locations.add(0, location);
        return nearestBrewery.nearestBrewery(locations, distanceMatrixCreator.calculateDistanceUsingMatrix(locations));
    }

    private GeoLocation geoLocationToDto(GeoLocationDto geoLocationDto) {
        GeoLocation location = new GeoLocation();
        location.setId(geoLocationDto.getId());
        location.setBrewery(geoLocationDto.getBrewery());
        location.setLatitude(geoLocationDto.getLatitude());
        location.setLongitude(geoLocationDto.getLongitude());
        locationsRepository.save(location);
        return location;
    }
}
