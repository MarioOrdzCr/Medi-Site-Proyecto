package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.HistorialMedicoModel;

@Repository
public interface HistorialMedicoRepository extends CrudRepository<HistorialMedicoModel, Long>{

}
