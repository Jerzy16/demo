package com.backend.demo.service;

import com.backend.demo.model.Docente;
import com.backend.demo.repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocenteService {

    @Autowired
    private DocenteRepository repository;

    // LISTAR
    public List<Docente> listar() {
        return repository.findAll();
    }

    // GUARDAR
    public Docente guardar(Docente docente) {
        return repository.save(docente);
    }

    // BUSCAR POR ID
    public Optional<Docente> buscarPorId(String id) {
        return repository.findById(id);
    }

    // ACTUALIZAR
    public Docente actualizar(String id, Docente docente) {

        return repository.findById(id)
                .map(d -> {
                    d.setNombres(docente.getNombres());
                    d.setApellidos(docente.getApellidos());
                    d.setCorreo(docente.getCorreo());
                    d.setTelefono(docente.getTelefono());
                    d.setEspecialidad(docente.getEspecialidad());

                    return repository.save(d);
                }).orElseThrow(() -> new RuntimeException("Docente no encontrado"));
    }

    // ELIMINAR
    public void eliminar(String id) {
        repository.deleteById(id);
    }
}