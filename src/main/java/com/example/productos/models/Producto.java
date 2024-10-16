package com.example.productos.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name="nombre")
    private String nombre;

    @Column (name="descripcion")
    private String descripcion;

    @Column (name="precio")
    private double precio;
}
