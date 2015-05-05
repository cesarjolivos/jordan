/*
 * Paquete que contiene los controladores del sistema.
 */
package com.sow.jordan.controladores;

import com.sow.jordan.modelos.Usuario;
import com.sow.jordan.servicios.ServicioUsuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

/**
 * Clase se encarga el control de la sesión del usuario.
 * @author GARCÍA CASTRO HÉCTOR JAVIER
 * @author OLIVOS NAVARRO CESAR JONATHAN
 * @author VILLEGAS MORENO ZEUXIS DANIEL
 */
@Controller("controladorSesión")
@Scope("request")
public class ControladorSesión implements Serializable {
    
    /**
     * Variable que almacena el servicio de usuarios.
     */
    @Autowired
    private ServicioUsuario servicioUsuario;
    /**
     * Variable que almacena al usuario de la sesión.
     */
    private Usuario usuario;
    /**
     * Variable que indica si la sesión esta iniciada.
     */
    private boolean sesionIniciada = false;
    /**
     * Variable que almacena si el usuario es administrador.
     */
    private boolean administrador = false;
    
    /**
     * Método que obtiene el usuario que a iniciado sesión.
     */
    @PostConstruct
    public void inicia() {
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken) && (user instanceof UserDetails)) {
            usuario = servicioUsuario.buscarUsuario( ((UserDetails) user).getUsername() );
            sesionIniciada = true;
        } else if (user instanceof String) {
            sesionIniciada = false;
        }
    }
    
    /**
     * Método que regresa la url dependiendo del privilegio del usuario.
     * @return La url de la pagina a la cual tiene privilegio.
     */
    public String url(){
        switch (usuario.getPrivilegio()) {
            case "ROLE_ROOT":
                return "superAdministrador.xhtml";
            case "ROLE_ADMIN":
                return "administrador.xhtml";
        }
        return "index.xhtml";
    }
    
    /**
     * Método que indica si el usuario es administrador.
     * @return True en caso de ser administrador.
     */
    public boolean getAdministrador(){
        if(sesionIniciada){
            switch (usuario.getPrivilegio()) {
                case "ROLE_ADMIN":
                    administrador = true;
                    return administrador;
                case "ROLE_ROOT":
                    administrador = true;
                    return administrador;
            }
            administrador = false;
            return administrador;
        }
        administrador = false;
        return administrador;
    }

    /**
     * Método que indica si la sesión esta iniciada.
     * @return True en caso de que este iniciada.
     */
    public boolean getSesionIniciada() {
        return sesionIniciada;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
}
