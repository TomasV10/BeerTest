package com.satalia.beerTest.beerTest.repositories;

import com.satalia.beerTest.beerTest.brewery.GeoLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationsRepository extends JpaRepository<GeoLocation, Long> {
}
