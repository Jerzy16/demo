package com.backend.demo.repository;

import com.backend.demo.model.Estudiante;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EstudianteRepository
        extends MongoRepository<Estudiante, String> {

}