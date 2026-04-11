package com.proyecto.catalogo.service;
import com.proyecto.catalogo.repository.*;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.proyecto.catalogo.model.*;

@Service
public class ServiceProducto {
    private final RepositoryProducto repositoryProducto;
    private final RepositoryCarta repositoryCarta;
    private final RepositoryMerchandise repositoryMerchandise;
    private final RepositoryAccesorios repositoryAccesorios;


    public ServiceProducto(RepositoryProducto repositoryProducto, RepositoryCarta repositoryCarta, RepositoryMerchandise repositoryMerchandise, RepositoryAccesorios repositoryAccesorios) {
        this.repositoryProducto = repositoryProducto;
        this.repositoryCarta = repositoryCarta;
        this.repositoryMerchandise = repositoryMerchandise;
        this.repositoryAccesorios = repositoryAccesorios;
    }

    // Método para validar si un producto existe por su nombre
    public List<String> validarProducto(String nombre) {
        if (repositoryProducto.existsByNombre(nombre)) {
            return List.of("El producto ya existe en el catálogo.");
        } else {
            return List.of("El producto no existe en el catálogo.");
        }
    }
    // Método para validar manualmente un producto antes de guardarlo
    public List<String> ValidacionManualProducto(Producto producto) {
        List<String> errores = new java.util.ArrayList<>();
        if (producto.getNombre() == null || producto.getNombre().isEmpty()) {
            errores.add("El nombre del producto es obligatorio.");
        }
        if (producto.getPrecio() < 0 ) {
            errores.add("El precio del producto es obligatorio y debe ser un valor positivo.");
        }
        if (producto.getDescripcion() == null || producto.getDescripcion().isEmpty()) {
            errores.add("La descripción del producto es obligatoria.");
        } else if (producto.getDescripcion().length() > 500) {
            errores.add("La descripción del producto no puede exceder los 500 caracteres.");
        }
        if (producto instanceof Carta) {
            Carta carta = (Carta) producto;
            if (carta.getTipo() == null || carta.getTipo().isEmpty()) {
                errores.add("El tipo de carta es obligatorio.");
            }
            if (carta.getIdioma() == null || carta.getIdioma().isEmpty()) {
                errores.add("El idioma de la carta es obligatorio.");
            }
        } else if (producto instanceof Merchandise) {
            Merchandise merchandise = (Merchandise) producto;
            if (merchandise.getTipo() == null || merchandise.getTipo().isEmpty()) {
                errores.add("El tipo de merchandise es obligatorio.");
            }
            if (merchandise.getMarca() == null || merchandise.getMarca().isEmpty()) {
                errores.add("La marca del merchandise es obligatoria.");
            }
            if (merchandise.getMaterial() == null || merchandise.getMaterial().isEmpty()) {
                errores.add("El material del merchandise es obligatorio.");
            }
        } else if (producto instanceof Accesorios) {
            Accesorios accesorios = (Accesorios) producto;
            if (accesorios.getTipo() == null || accesorios.getTipo().isEmpty()) {
                errores.add("El tipo de accesorio es obligatorio.");
            }
        }
        return errores;
    }

    // Métodos para crear productos específicos
    public Carta CrearCarta(Carta carta) {
        return repositoryCarta.save(carta);
    }
    public Merchandise CrearMerchandise(Merchandise merchandise) {
        return repositoryMerchandise.save(merchandise);
    }
    public Accesorios CrearAccesorio(Accesorios accesorios) {
        return repositoryAccesorios.save(accesorios);
    }

    // Métodos para obtener Todos los productos o específicos
    public List<Producto> obtenerTodosLosProductos() {
        return repositoryProducto.findAll();
    }
    public List<Producto> obtenerTodasLasCartas() {
        return repositoryCarta.findAll();
    } 
    public List<Producto> obtenerTodoElMerchandise() {
        return repositoryMerchandise.findAll();
    }
    public List<Producto> obtenerTodosLosAccesorios() {
        return repositoryAccesorios.findAll();
    }

    // Métodos para eliminar productos por su ID o nombre
    public void eliminarProducto(Long id) {
        repositoryProducto.deleteById(id);
    }
    //---------------------------------------------------------
    public void eliminarCarta(Long id) {
            repositoryCarta.deleteById(id);
    }
    public void eliminarProductoPorNombre(String nombre) {
        repositoryProducto.deleteByNombre(nombre);
    }
    //---------------------------------------------------------
    public void eliminarMerchandise(Long id) {
            repositoryMerchandise.deleteById(id);
    }
    public void eliminarMerchandisePorNombre(String nombre) {
        repositoryMerchandise.deleteByNombre(nombre);
    }
    //---------------------------------------------------------
    public void eliminarAccesorio(Long id) {
            repositoryAccesorios.deleteById(id);
    }
    public void eliminarAccesorioPorNombre(String nombre) {
        repositoryAccesorios.deleteByNombre(nombre);
    }

    public Producto actualizarProducto(Long id, Producto productoActualizado) {
        Optional<Producto> productoExistente = repositoryProducto.findById(id);
        if (productoExistente.isPresent()) {
            Producto producto = productoExistente.get();
            producto.setNombre(productoActualizado.getNombre());
            producto.setDescripcion(productoActualizado.getDescripcion());
            producto.setPrecio(productoActualizado.getPrecio());
            if (productoActualizado instanceof Carta && producto instanceof Carta) {
                Carta cartaActualizada = (Carta) productoActualizado;
                Carta cartaExistente = (Carta) producto;
                cartaExistente.setTipo(cartaActualizada.getTipo());
                cartaExistente.setIdioma(cartaActualizada.getIdioma());
                return repositoryCarta.save(cartaExistente);
            } else if (productoActualizado instanceof Merchandise && producto instanceof Merchandise) {
                Merchandise merchandiseActualizado = (Merchandise) productoActualizado;
                Merchandise merchandiseExistente = (Merchandise) producto;
                merchandiseExistente.setTipo(merchandiseActualizado.getTipo());
                merchandiseExistente.setMarca(merchandiseActualizado.getMarca());
                merchandiseExistente.setMaterial(merchandiseActualizado.getMaterial());
                return repositoryMerchandise.save(merchandiseExistente);
            } else if (productoActualizado instanceof Accesorios && producto instanceof Accesorios) {
                Accesorios accesoriosActualizado = (Accesorios) productoActualizado;
                Accesorios accesorionuevo = (Accesorios) producto;
                accesorionuevo.setTipo(accesoriosActualizado.getTipo());
                accesorionuevo.setMarca(accesoriosActualizado.getMarca());
                accesorionuevo.setFranquicia(accesoriosActualizado.getFranquicia());
                return repositoryAccesorios.save(accesorionuevo);
            } else {
                return repositoryProducto.save(producto);
            }
        } else {
            return null;
        }
    }

}
