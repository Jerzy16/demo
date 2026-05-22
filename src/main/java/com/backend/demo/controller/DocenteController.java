package com.backend.demo.controller;

import com.backend.demo.model.Docente;
import com.backend.demo.service.DocenteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/docentes")
@CrossOrigin("*")
public class DocenteController {

    @Autowired
    private DocenteService service;

    // LISTAR
    @GetMapping
    public ResponseEntity<List<Docente>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    // GUARDAR
    @PostMapping
    public ResponseEntity<Docente> guardar(@RequestBody Docente docente) {
        return ResponseEntity.ok(service.guardar(docente));
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable String id) {

        return service.buscarPorId(id)
                .map(docente -> ResponseEntity.ok(docente))
                .orElse(ResponseEntity.notFound().build());
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(
            @PathVariable String id,
            @RequestBody Docente docente) {

        try {
            return ResponseEntity.ok(service.actualizar(id, docente));

        } catch (Exception e) {

            return ResponseEntity.badRequest()
                    .body("Docente no encontrado");
        }
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable String id) {

        try {

            service.eliminar(id);

            return ResponseEntity.ok("Docente eliminado");

        } catch (Exception e) {

            return ResponseEntity.badRequest()
                    .body("No se pudo eliminar");
        }
    }
}