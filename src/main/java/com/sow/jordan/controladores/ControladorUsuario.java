/*
 * Paquete que contiene los controladores del sistema.
 */
package com.sow.jordan.controladores;

import com.sow.jordan.modelos.Usuario;
import com.sow.jordan.servicios.ServicioUsuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
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
     * Variable que realiza las acciones del correo
     */
    @Autowired
    private JavaMailSenderImpl mailSender;
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
        usuarios =servicioUsuario.cargarUsuarios();
        usuario = new Usuario();
    }
    
    /**
     * Método que recupera la contraseña y la enviá por correo electrónico.
     */
    public void enviarContraseña() {
        SimpleMailMessage mail = new SimpleMailMessage();
        if (this.usuarios.isEmpty() == false) {
            for (Usuario u : this.usuarios) {
                mail.setTo(u.getCorreo());
                mail.setFrom("jordan.dantm@gmail.com");
                mail.setSubject("JORDAN");
                mail.setText("RECUPERACION DE CONTRASEÑA\n\n\n" + "Hola "
                        + u.getNombre() + " tu contraseña es: " + u.getCifrado());
                try {
                    mailSender.send(mail);
                    addMessage("Tu contraseña ha sido enviada al correo que "
                            + "proporcionaste");
                } catch (MailException ex) {
                    addMessage("No se pudo enviar el mensaje");
                }
            }
        } else {
            addMessage("El correo que proporcionaste no existe en el registro");
        }
    }

    /**
     * Método que agrega un mensaje al enviar la contraseña.
     * @param summary El mensaje.
     */
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    /**
     * Método que elimina un usuario del sistema.
     * @param usuario El usuario a aliminar.
     */
    public void eliminarUsuario(Usuario usuario){
        this.servicioUsuario.eliminarUsuario(usuario);
        usuarios = servicioUsuario.cargarUsuarios();
    }
    
    /**
     * Método que otorga privilegio de administrador al usuario que recibe como
     * parametro.
     * @param usuario El usuario a otrogar privilegio. 
     */
    public void privilegioDeAdmiistrador(Usuario usuario){
        this.usuario = usuario;
        this.usuario.setPrivilegio("ROLE_ADMIN");
        servicioUsuario.guardarUsuario(usuario);
        usuarios =servicioUsuario.cargarUsuarios();
        this.usuario = new Usuario();
    }
    
    /**
     * Método que otorga privilegio de usuerio registrado al usuario que recibe 
     * como parametro.
     * @param usuario El usuario a otrogar privilegio. 
     */
    public void privilegioDeUsuario(Usuario usuario){
        this.usuario = usuario;
        this.usuario.setPrivilegio("ROLE_USER");
        servicioUsuario.guardarUsuario(usuario);
        usuarios =servicioUsuario.cargarUsuarios();
        this.usuario = new Usuario();
    }
    
    /**
     * Método que otorga privilegio de usuerio registrado al usuario que recibe 
     * como parametro.
     * @param usuario El usuario a otrogar privilegio. 
     */
    public void privilegioDeRoot(Usuario usuario){
        this.usuario = usuario;
        this.usuario.setPrivilegio("ROLE_ROOT");
        servicioUsuario.guardarUsuario(usuario);
        usuarios =servicioUsuario.cargarUsuarios();
        this.usuario = new Usuario();
    }

    /**
     * Método que regresa los usuarios del sistema.
     * @return Una lista con la información.
     */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * Método que agrega un usuario al sistema.
     * @param usuarios La lsita actualizada.
     */
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * Método que regresa un usuario.
     * @return Un usuario.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Método que asigna un usuario.
     * @param usuario El usuario a asignar.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
