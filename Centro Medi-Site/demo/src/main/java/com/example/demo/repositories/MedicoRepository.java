package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.*;

@Repository
public interface MedicoRepository extends CrudRepository<MedicoModel, Long> {
}