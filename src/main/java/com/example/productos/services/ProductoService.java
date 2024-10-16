package com.example.productos.services;

import com.example.productos.models.Producto;
import com.example.productos.repositories.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<Producto> listarProductos() {
        return repository.findAll();
    }

    public Optional<Producto> obtenerProductoPorId(Long id) {
        return repository.findById(id);
    }

    public Producto crearProducto(Producto producto) {
        return repository.save(producto);
    }

    public Producto actualizarProducto(Long id, Producto producto) {
        if (repository.existsById(id)) {
            producto.setId(id);
            return repository.save(producto);
        } else {
            throw new RuntimeException("Producto no encontrado");
        }
    }

    public void eliminarProducto(Long id) {
        repository.deleteById(id);
    }
}
