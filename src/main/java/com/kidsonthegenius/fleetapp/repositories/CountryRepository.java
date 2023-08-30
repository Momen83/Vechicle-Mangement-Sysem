package com.kidsonthegenius.fleetapp.repositories;

import com.kidsonthegenius.fleetapp.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
