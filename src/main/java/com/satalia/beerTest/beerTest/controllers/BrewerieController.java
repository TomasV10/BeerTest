package com.satalia.beerTest.beerTest.controllers;

import com.satalia.beerTest.beerTest.entities.Brewery;
import com.satalia.beerTest.beerTest.repositories.BreweriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController()
public class BrewerieController {

    @Autowired
    private BreweriesRepository breweriesRepository;

    @GetMapping("/all")
    public List<Brewery>getAllBars(){
        return new ArrayList<>(breweriesRepository.findAll());
    }

    @GetMapping("/{id}")
        public Optional<Brewery> getBreweryById(@PathVariable Long id) {
            return breweriesRepository.findById(id);
        }
    }
