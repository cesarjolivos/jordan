/*
 * Paquete que contiene los servicios.
 */
package com.sow.jordan.servicios;

import com.sow.jordan.modelos.Usuario;
import java.util.List;

/**
 * Interfaz de los servicios de los usuarios.
 * @author GARCÍA CASTRO HÉCTOR JAVIER
 * @author OLIVOS NAVARRO CESAR JONATHAN
 * @author VILLEGAS MORENO ZEUXIS DANIEL
 */
public interface ServicioUsuario {
    
    /**
     * Método para guardar la información de los usuarios.
     * @param usuario El usuario a guardar.
     */
    public void guardarUsuario(Usuario usuario);
    
    /**
     * Método que carga la información de los usuarios.
     * @return Una lista con la información.
     */
    List<Usuario> cargarUsuarios();
    
    /**
     * Método para eliminar un usuario.
     * @param usuario El usuario a eliminar.
     */
    public void eliminarUsuario(Usuario usuario);
    
    /**
     * Metodo que busca un uduario mediante si id.
     * @param usuario El nombre del usuario.
     * @return Un usuario.
     */
    Usuario buscarUsuario(String usuario);
    
}
