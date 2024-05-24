package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.CentroSaludModel;
import com.example.demo.models.TimeslotModel;

@Repository
public interface TimeslotRepository extends CrudRepository<TimeslotModel, Long> { 

}
