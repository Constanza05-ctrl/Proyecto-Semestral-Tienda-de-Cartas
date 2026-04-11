package com.proyecto.catalogo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del producto es obligatorio")
    private String nombre;

    @NotBlank(message = "La descripción del producto es obligatoria")
    @Max(value = 500, message = "La descripción del producto no puede exceder los 500 caracteres")
    private String descripcion;

    @NotBlank(message = "El precio del producto es obligatorio")
    @Positive(message = "El precio del producto debe ser un valor positivo")
    private double precio;
    
    private String copyright;
}
