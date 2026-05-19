package com.backend.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "productos")
public class Producto {

    @Id
    private String id;

    private String nombre;

    private String categoria;

    private Double precio;

    private Integer stock;

    private String descripcion;

    private String imagenUrl;

    private String estado;

    private Instant fechaCreacion;

    public Producto() {
        this.fechaCreacion = Instant.now();
        this.estado = "Activo";
    }

    public Producto(String nombre,
                     String categoria,
                     Double precio,
                     Integer stock,
                     String descripcion,
                     String imagenUrl,
                     String estado) {

        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
        this.descripcion = descripcion;
        this.imagenUrl = imagenUrl;
        this.estado = estado;
        this.fechaCreacion = Instant.now();
    }

    // ==========================
    // GETTERS AND SETTERS
    // ==========================

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // NOMBRE
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // CATEGORIA
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // PRECIO
    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    // STOCK
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    // DESCRIPCION
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // IMAGEN URL
    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    // ESTADO
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // FECHA CREACION
    public Instant getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Instant fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}