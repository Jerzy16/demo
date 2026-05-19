package com.backend.demo.service;

import com.backend.demo.model.Producto;
import com.backend.demo.repository.ProductoRepository;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    // ==========================================
    // LISTAR TODOS LOS PRODUCTOS
    // ==========================================
    public List<Producto> listar() {
        return repository.findAll();
    }

    // ==========================================
    // GUARDAR PRODUCTO
    // ==========================================
    public Producto guardar(Producto producto) {

        // FECHA AUTOMÁTICA
        producto.setFechaCreacion(Instant.now());

        // ESTADO POR DEFECTO
        if (producto.getEstado() == null || producto.getEstado().isBlank()) {
            producto.setEstado("Activo");
        }

        return repository.save(producto);
    }

    // ==========================================
    // BUSCAR PRODUCTO POR ID
    // ==========================================
    public Optional<Producto> buscarPorId(@NonNull String id) {
        return repository.findById(id);
    }

    // ==========================================
    // ACTUALIZAR PRODUCTO
    // ==========================================
    public Producto actualizar(@NonNull String id, Producto producto) {

        Producto existente = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Producto no encontrado con ID: " + id));

        existente.setNombre(producto.getNombre());
        existente.setCategoria(producto.getCategoria());
        existente.setPrecio(producto.getPrecio());
        existente.setStock(producto.getStock());
        existente.setDescripcion(producto.getDescripcion());
        existente.setImagenUrl(producto.getImagenUrl());
        existente.setEstado(producto.getEstado());

        return repository.save(existente);
    }

    // ==========================================
    // ELIMINAR PRODUCTO
    // ==========================================
    public void eliminar(@NonNull String id) {
        
        if (!repository.existsById(id)) {
            throw new RuntimeException("Producto no encontrado con ID: " + id);
        }

        repository.deleteById(id);
    }

    // ==========================================
    // BUSCAR POR NOMBRE
    // ==========================================
    public List<Producto> buscarPorNombre(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre);
    }

    // ==========================================
    // FILTRAR POR CATEGORÍ
    // ==========================================
    public List<Producto> buscarPorCategoria(String categoria) {
        return repository.findByCategoriaIgnoreCase(categoria);
    }

    // ==========================================
    // FILTRAR POR ESTADO
    // ==========================================
    public List<Producto> buscarPorEstado(String estado) {
        return repository.findByEstadoIgnoreCase(estado);
    }
}