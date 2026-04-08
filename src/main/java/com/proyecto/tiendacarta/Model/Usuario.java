package com.proyecto.tiendacarta.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/*hola */

@Data   
@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @NotBlank(message = "el Nombre no puede estar vacio")
    private String nombre;
    /*apellido paterno */
    @NotBlank(message = "el Apellido Paterno no puede estar vacio")
    private String apellidoP;
    /*apellido materno */
    @NotBlank(message = "el Apellido Materno no puede estar vacio")
    private String apellidoM;
    /*nombre de usuario */
    @NotBlank(message = "el Nombre de usuario no puede estar vacio")
    private String nombreUser;
    @NotBlank(message = "el Correo  no puede estar vacio")
    private String correo;
    @NotBlank(message = "Tiene que ingresar una contraseña")
    private String password;
    @NotBlank(message = "la ededad no tiene que estar vacia")
    @Size(message = "no es mayor de edad ")
    @Min(value = 18,message = "Eres menor de edad")
    @Max(value = 80,message = "Eres menor de edad")
    private String edad; 
    @NotBlank(message = "el genero no puede estar vacio")
    private String genero;
    /*tipo usuario como si es vendedor o es el comrpador */
    @NotBlank(message = "ingrese el tipo de usuario vendedor o comprador")
    private String tipoUser;



}
