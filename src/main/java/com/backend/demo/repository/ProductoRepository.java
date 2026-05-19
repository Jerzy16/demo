package com.backend.demo.repository;

import com.backend.demo.model.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductoRepository extends MongoRepository<Producto, String> {

    // ==========================
    // BUSCAR POR NOMBRE
    // ==========================
    List<Producto> findByNombreContainingIgnoreCase(String nombre);

    // ==========================
    // BUSCAR POR CATEGORIA
    // ==========================
    List<Producto> findByCategoriaIgnoreCase(String categoria);

    // ==========================
    // BUSCAR POR ESTADO
    // ==========================
    List<Producto> findByEstadoIgnoreCase(String estado);
}