package com.backend.demo.service;

import com.backend.demo.model.Estudiante;
import com.backend.demo.repository.EstudianteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository repository;

    // LISTAR
    public List<Estudiante> listar() {
        return repository.findAll();
    }

    // GUARDAR
    public Estudiante guardar(Estudiante estudiante) {
        return repository.save(estudiante);
    }

    // BUSCAR POR ID
    public Estudiante buscarPorId(String id) {

        Optional<Estudiante> estudiante = repository.findById(id);

        return estudiante.orElse(null);
    }

    // ELIMINAR
    public void eliminar(String id) {

        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
}