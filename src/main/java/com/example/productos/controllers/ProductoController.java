package com.example.productos.controllers;

import com.example.productos.models.Producto;
import com.example.productos.services.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Producto> listarProductos() {
        return service.listarProductos();
    }

    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable Long id) {
        return service.obtenerProductoPorId(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return service.crearProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        return service.actualizarProducto(id, producto);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        service.eliminarProducto(id);
    }
}
