package com.backend.demo.controller;

import com.backend.demo.model.Producto;
import com.backend.demo.service.ProductoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin("*")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    // ======================================
    // LISTAR PRODUCTOS
    // ======================================
    @GetMapping
    public List<Producto> listar() {
        return service.listar();
    }

    // ======================================
    // CREAR PRODUCTO
    // ======================================
    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody Producto producto) {

        Producto creado = service.guardar(producto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(creado);
    }

    // ======================================
    // OBTENER POR ID
    // ======================================
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtener(@PathVariable String id) {

        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ======================================
    // ACTUALIZAR PRODUCTO
    // ======================================
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(
            @PathVariable String id,
            @RequestBody Producto producto) {

        Producto actualizado = service.actualizar(id, producto);

        return ResponseEntity.ok(actualizado);
    }

    // ======================================
    // ELIMINAR PRODUCTO
    // ======================================
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {

        service.eliminar(id);

        return ResponseEntity.noContent().build();
    }

    // ======================================
    // BUSCAR POR NOMBRE
    // ======================================
    @GetMapping("/buscar/{nombre}")
    public List<Producto> buscarPorNombre(@PathVariable String nombre) {
        return service.buscarPorNombre(nombre);
    }

    // ======================================
    // FILTRAR POR CATEGORIA
    // ======================================
    @GetMapping("/categoria/{categoria}")
    public List<Producto> buscarPorCategoria(@PathVariable String categoria) {
        return service.buscarPorCategoria(categoria);
    }

    // ======================================
    // FILTRAR POR ESTADO
    // ======================================
    @GetMapping("/estado/{estado}")
    public List<Producto> buscarPorEstado(@PathVariable String estado) {
        return service.buscarPorEstado(estado);
    }
}