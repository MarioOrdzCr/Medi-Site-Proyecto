package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.AdminModel;

@Repository
public interface AdminRepository extends CrudRepository<AdminModel, Long>{

}
