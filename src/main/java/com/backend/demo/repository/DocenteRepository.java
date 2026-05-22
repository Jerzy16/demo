package com.backend.demo.repository;

import com.backend.demo.model.Docente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DocenteRepository extends MongoRepository<Docente, String> {

}