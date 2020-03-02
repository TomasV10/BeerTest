package com.satalia.beerTest.beerTest.repositories;

import com.satalia.beerTest.beerTest.entities.Brewery;
import com.satalia.beerTest.beerTest.entities.GeoLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

public interface BreweriesRepository extends JpaRepository<Brewery, Long> {
}
