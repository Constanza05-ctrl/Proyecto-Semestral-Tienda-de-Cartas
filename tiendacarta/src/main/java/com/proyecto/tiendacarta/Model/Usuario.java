package com.proyecto.tiendacarta.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data   
@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    
    private String nombre;
    /*apellido paterno */
    private String apellidoP;
    /*apellido materno */
    private String apellidoM;
    /*nombre de usuario */
    private String nombreUser;
    private String correo;
    private String password;
    private Number edad; 
    private String genero;
    /*tipo usuario como si es vendedor o es el comrpador */
    private String tipoUser;



}
