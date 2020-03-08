package com.satalia.beerTest.beerTest.web;


import com.satalia.beerTest.beerTest.dto.GeoLocationDto;
import com.satalia.beerTest.beerTest.brewery.GeoLocation;
import com.satalia.beerTest.beerTest.distanceMatrix.DistanceMatrixCreator;
import com.satalia.beerTest.beerTest.brewery.NearestBreweryFinder;
import com.satalia.beerTest.beerTest.dto.Result;
import com.satalia.beerTest.beerTest.repositories.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("/mvc/breweries")
public class BreweriesController {

    @Autowired
    private NearestBreweryFinder nearestBreweryFinder;
    @Autowired
    private DistanceMatrixCreator distanceMatrixCreator;
    @Autowired
    private LocationsRepository locationsRepository;


    @GetMapping("/home")
    public String getFrom(Model model) {
        GeoLocationDto geoLocationDto = new GeoLocationDto();
        model.addAttribute("geoLocationDto", geoLocationDto);
        return "homeLocationForm";
    }

    @PostMapping(value = "/save")
    public ModelAndView getCalculated(GeoLocationDto geoLocationDto, Model model){
        GeoLocation location = dtoToGeoLocation(geoLocationDto);
        List<GeoLocation>locations = locationsRepository.findAll();
        locations.add(0, location);
        Result result = nearestBreweryFinder.nearestBrewery(locations, distanceMatrixCreator.calculateDistanceUsingMatrix(locations));
        model.addAttribute("calculationResult", result);
        return new ModelAndView("result");
    }

    private GeoLocation dtoToGeoLocation(GeoLocationDto geoLocationDto) {
        GeoLocation location = new GeoLocation();
        location.setId(geoLocationDto.getId());
        location.setBrewery(geoLocationDto.getBrewery());
        location.setLatitude(geoLocationDto.getLatitude());
        location.setLongitude(geoLocationDto.getLongitude());
        locationsRepository.save(location);
        return location;
    }
}
