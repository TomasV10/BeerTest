package com.satalia.beerTest.beerTest.repositories;

import com.satalia.beerTest.beerTest.entities.Brewery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreweriesRepository extends JpaRepository<Brewery, Long> {

}
