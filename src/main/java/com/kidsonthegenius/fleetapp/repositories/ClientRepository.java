package com.kidsonthegenius.fleetapp.repositories;

import com.kidsonthegenius.fleetapp.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
