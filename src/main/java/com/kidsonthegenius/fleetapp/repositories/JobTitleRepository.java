package com.kidsonthegenius.fleetapp.repositories;

import com.kidsonthegenius.fleetapp.models.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobTitleRepository extends JpaRepository<JobTitle, Integer> {

}
