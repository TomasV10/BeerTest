package com.satalia.beerTest.beerTest.repositories;

import com.satalia.beerTest.beerTest.entities.Brewery;
import com.satalia.beerTest.beerTest.entities.GeoLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationsRepository extends JpaRepository<GeoLocation, Long> {
}
