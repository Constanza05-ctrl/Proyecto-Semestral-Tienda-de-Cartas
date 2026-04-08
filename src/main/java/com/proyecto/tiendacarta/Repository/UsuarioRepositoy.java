package com.proyecto.tiendacarta.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.tiendacarta.Model.Usuario;



@Repository
public interface UsuarioRepositoy extends JpaRepository<Usuario,Long>{
    //nos ayuda la validacion del servico

    
}