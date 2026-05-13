package com.backend.demo.service;

import com.backend.demo.model.Producto;
import com.backend.demo.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<Producto> listar() {
        return repository.findAll();
    }

    public Producto guardar(Producto producto) {
        return repository.save(producto);
    }

    public Optional<Producto> buscarPorId(String id) {
        return repository.findById(id);
    }

    public Producto actualizar(String id, Producto producto) {
        producto.setId(id);
        return repository.save(producto);
    }

    public void eliminar(String id) {
        repository.deleteById(id);
    }
}