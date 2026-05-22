package com.backend.demo.controller;

import com.backend.demo.model.Estudiante;
import com.backend.demo.service.EstudianteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
@CrossOrigin("*")
public class EstudianteController {

    @Autowired
    private EstudianteService service;

    // LISTAR
    @GetMapping
    public List<Estudiante> listar() {
        return service.listar();
    }

    // GUARDAR
    @PostMapping
    public Estudiante guardar(@RequestBody Estudiante estudiante) {
        return service.guardar(estudiante);
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public Estudiante buscar(@PathVariable String id) {
        return service.buscarPorId(id);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        service.eliminar(id);
    }
      // ==========================
    // ACTUALIZAR
    // ==========================

    @PutMapping("/{id}")
    public Estudiante actualizar(@PathVariable String id,
                                 @RequestBody Estudiante estudiante) {

        estudiante.setId(id);

        return service.guardar(estudiante);
    }
}