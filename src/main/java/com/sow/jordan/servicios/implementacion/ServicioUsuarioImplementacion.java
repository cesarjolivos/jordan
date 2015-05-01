/*
 * Paquete en el que se implementan los Servicios
 */
package com.sow.jordan.servicios.implementacion;

import com.sow.jordan.modelos.Usuario;
import com.sow.jordan.repositorios.RepositorioUsuario;
import com.sow.jordan.servicios.ServicioUsuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Clase que implementa los servicios de usuario.
 * @author GARCÍA CASTRO HÉCTOR JAVIER
 * @author OLIVOS NAVARRO CESAR JONATHAN
 * @author VILLEGAS MORENO ZEUXIS DANIEL
 */
public class ServicioUsuarioImplementacion implements ServicioUsuario {
    
    @Autowired
    private RepositorioUsuario repositorioUsuario;
    
    /**
     * Método para guardar la información de los usuarios.
     * @param usuario El usuario a guardar.
     */
    @Override
    public void guardarUsuario(Usuario usuario){
        repositorioUsuario.save(usuario);
    }
    
    /**
     * Método que carga la información de los usuarios.
     * @return Una lista con la información.
     */
    @Override
    public List<Usuario> cargarUsuarios(){
        return repositorioUsuario.cargarUsuarios();
    }
    
    /**
     * Método para eliminar un usuario.
     * @param usuario El usuario a eliminar.
     */
    @Override
    public void eliminarUsuario(Usuario usuario){
        repositorioUsuario.delete(usuario);
    }
    
    /**
     * Metodo que busca un uduario mediante si id.
     * @param usuario El nombre del usuario.
     * @return Un usuario.
     */
    @Override
    public Usuario buscarUsuario(String usuario){
        return repositorioUsuario.buscarUsuario(usuario);
    }
    
    /**
     * Método que busca un usuario mediante su correo electrónico.
     * @param correo El correo del usuario.
     * @return Una lista con la información.
     */
    @Override
    public List<Usuario> buscarPorCorreo(String correo){
        return repositorioUsuario.buscarPorCorreo(correo);
    }
    
}
