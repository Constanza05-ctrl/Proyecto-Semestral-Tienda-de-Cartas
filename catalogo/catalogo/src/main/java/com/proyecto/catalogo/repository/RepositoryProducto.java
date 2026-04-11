package com.proyecto.catalogo.repository;

import org.springframework.stereotype.Repository;
import com.proyecto.catalogo.model.*;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


@Repository
public interface RepositoryProducto extends JpaRepository<Producto, Long> {
    boolean existsByNombre(String nombre);

    Producto findByNombre(String nombre);
    @Transactional
    void deleteByNombre(String nombre);

    Producto findByCopyright(String copyright);

    List<Producto> findByNombreContaining(String nombre);
}
