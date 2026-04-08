package com.proyecto.tiendacarta.Service;
import com.proyecto.tiendacarta.Model.Usuario;
import com.proyecto.tiendacarta.Repository.UsuarioRepositoy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    private final UsuarioRepositoy usuarioRepositoy;

    public UsuarioService(UsuarioRepositoy usuarioRepositoy){
        this.usuarioRepositoy = usuarioRepositoy;
    }
    /*crear */
    /*aqui realizar una validacion para que los correos no se reppitan  */
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepositoy.save(usuario);
    }


    /*Listar */
    public List<Usuario> obtenerUsuarios(){
        return usuarioRepositoy.findAll();
    }

    public Optional<Usuario> obtenerPorId(Long id){
        return usuarioRepositoy.findById(id);
    }

    /*actualizar */
    public Usuario actualizarUsuario(Long id,Usuario detalleUsuario){
        Optional<Usuario> usuarioExistente = usuarioRepositoy.findById(id);

        if(usuarioExistente.isPresent()){

            Usuario usuarioAActualizar = usuarioExistente.get();
            usuarioAActualizar.setNombre(detalleUsuario.getNombre());
            usuarioAActualizar.setApellidoP(detalleUsuario.getApellidoP());
            usuarioAActualizar.setApellidoM(detalleUsuario.getApellidoM());
            usuarioAActualizar.setNombreUser(detalleUsuario.getNombreUser());
            usuarioAActualizar.setCorreo(detalleUsuario.getCorreo());
            usuarioAActualizar.setPassword(detalleUsuario.getPassword());
            usuarioAActualizar.setEdad(detalleUsuario.getEdad());
            usuarioAActualizar.setGenero(detalleUsuario.getGenero());
            usuarioAActualizar.setTipoUser(detalleUsuario.getTipoUser());

            return usuarioRepositoy.save(usuarioAActualizar);
        } else{
            return null;
        }  
    } 

    /*Eliminar */

    public boolean eliminarUsuario(Long id){
        if (usuarioRepositoy.existsById(id)){
            usuarioRepositoy.deleteById(id);
            return true;
        }
        return false;
    }
}
    




