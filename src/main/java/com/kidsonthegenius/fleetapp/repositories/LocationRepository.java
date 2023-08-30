package com.kidsonthegenius.fleetapp.repositories;

import com.kidsonthegenius.fleetapp.models.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {

}
