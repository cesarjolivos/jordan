/*
 * Paquete que contienje los repositorios del sistema Jordan
 */
package com.sow.jordan.repositorios;

import com.sow.jordan.modelos.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


/**
 * Interfaz que contiene las consultas a la base de datos.
 * @author GARCÍA CASTRO HÉCTOR JAVIER
 * @author LARA RAMÍREZ JOSÉ JAVIER
 * @author OLIVOS NAVARRO CESAR JONATHAN
 * @author VILLEGAS MORENO ZEUXIS DANIEL
 */
public interface RepositorioUsuario extends CrudRepository<Usuario, String>{
    
    /**
     * Método que carga la información de los usuarios.
     * @return Una lista con la información.
     */
    @Query("SELECT usuario FROM Usuario usuario")
    List<Usuario> cargarUsuarios();
    
    /**
     * Método que se encarga de buscar un usuario.
     * @param usuario El nombre del usuario.
     * @return Un usuario.
     */
    @Query("SELECT usuario FROM Usuario usuario WHERE usuario.usuario = ?")
    Usuario buscarUsuario(String usuario);
   
}
