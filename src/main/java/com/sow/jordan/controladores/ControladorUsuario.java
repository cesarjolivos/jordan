/*
 * Paquete que contiene los controladores del sistema.
 */
package com.sow.jordan.controladores;

import com.sow.jordan.modelos.Usuario;
import com.sow.jordan.servicios.ServicioUsuario;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
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
     *
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
        /**
        String llaveSimetrica = "holamundocruel12";
        SecretKeySpec key = new SecretKeySpec(llaveSimetrica.getBytes(), "AES");
        Cipher cipher;
        usuarios = servicioUsuario.buscarPorCorreo(usuario.getCorreo());
        SimpleMailMessage mail = new SimpleMailMessage();
        if (this.usuarios.isEmpty() == false) {
            for (Usuario u : this.usuarios) {
                try {
                    cipher = Cipher.getInstance("AES");
                    cipher.init(Cipher.DECRYPT_MODE, key);
                    byte[] datosDecifrados = cipher.doFinal(u.getCifrado());
                    String contrasenia = new String(datosDecifrados);
                    mail.setTo(u.getCorreo());
                    mail.setFrom("jordan.dantm@gmail.com");
                    mail.setSubject("JORDAN");
                    mail.setText("RECUPERACION DE CONTRASEÑA\n\n\n" + "Hola "
                            + u.getNombre() + " tu contraseña es: " + contrasenia);
                    try {
                        mailSender.send(mail);
                        addMessage("Tu contraseña ha sido enviada al correo que "
                                + "proporcionaste");
                    } catch (MailException ex) {
                        addMessage("No se pudo enviar el mensaje");
                    }
                } catch (NoSuchAlgorithmException | NoSuchPaddingException |
                        InvalidKeyException | IllegalBlockSizeException |
                        BadPaddingException e) {
                    addMessage("No se pudo desencriptar");
                }
            }
        } else {
            addMessage("El correo que proporcionaste no existe en el registro");
        }*/
        SimpleMailMessage mail = new SimpleMailMessage();
        if (this.usuarios.isEmpty() == false) {
            for (Usuario u : this.usuarios) {
                String contrasenia = u.getContraseña();
                mail.setTo(u.getCorreo());
                mail.setFrom("jordan.dantm@gmail.com");
                mail.setSubject("JORDAN");
                mail.setText("RECUPERACION DE CONTRASEÑA\n\n\n" + "Hola "
                        + u.getNombre() + " tu contraseña es: " + contrasenia);
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
     *
     * @param summary El mensaje.
     */
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
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
