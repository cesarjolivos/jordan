/*
 * Paquete que contiene los controladores del sistema.
 */
package com.sow.jordan.controladores;

import com.sow.jordan.modelos.Usuario;
import com.sow.jordan.servicios.ServicioUsuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Clase se encarga de conectar las vistas con los modelos del sistema, conecta
 * a los usuarios del sistema con las vistas.
 * @author GARCÍA CASTRO HÉCTOR JAVIER
 * @author OLIVOS NAVARRO CESAR JONATHAN
 * @author VILLEGAS MORENO ZEUXIS DANIEL
 */
@Controller("controladorUsuario")
public class ControladorUsuario implements Serializable {
    
    /**
     * Variable que almacena el servicio de usuarios.
     */
    @Autowired
    private ServicioUsuario servicioUsuario;
    /**
     * Variable que almacena un usuario.
     */
    private List<Usuario> usuarios;
    /**
     * Variable que almacena los usuarios del sistema.
     */
    private Usuario usuario;
    
    /**
     * Método que se ejecuta después de realizar la inyección de dependencias.
     */
    @PostConstruct
    public void inicia() {
        usuarios = servicioUsuario.cargarUsuarios();
    }
    
    /**
     * Método que guarda la información de un usuario.
     */
    public void guardarUsuario(){
        servicioUsuario.guardarUsuario(usuario);
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
