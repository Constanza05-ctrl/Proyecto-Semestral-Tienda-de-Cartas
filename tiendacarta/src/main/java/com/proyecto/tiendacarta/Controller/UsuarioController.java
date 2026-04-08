package com.proyecto.tiendacarta.Controller;
import com.proyecto.tiendacarta.Model.Usuario;
import com.proyecto.tiendacarta.Service.UsuarioService;




import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    
    private final UsuarioService usuarioService;

    
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @PostMapping
    public Usuario crearLibro(@RequestBody Usuario usuario) {
        return usuarioService.guardarUsuario(usuario);
    }


    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioService.obtenerUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id){

        Optional<Usuario> usuario = usuarioService.obtenerPorId(id);
        if(usuario.isPresent()){
            return ResponseEntity.ok(usuario.get());
        } else{
            return ResponseEntity.notFound().build();
        }


    }



    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario detallesUsuario) {
        Usuario usuarioActualizado = usuarioService.actualizarUsuario(id, detallesUsuario);
        if (usuarioActualizado != null) {
            return ResponseEntity.ok(usuarioActualizado); 
        } else {
            return ResponseEntity.notFound().build(); 
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        boolean eliminado = usuarioService.eliminarUsuario(id);
        if (eliminado) {
            return ResponseEntity.noContent().build(); 
        } else {
            return ResponseEntity.notFound().build(); 
        }
    }
}
