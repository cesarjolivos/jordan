/*
 * Paquete que contiene los modelos del sistema Jordan
 */
package com.sow.jordan.modelos;

import java.io.Serializable;
//import java.security.*;
import java.util.List;
import java.util.Objects;
//import javax.crypto.*;
//import javax.crypto.spec.SecretKeySpec;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Clase que almacena la información de los usuarios del sistema.
 * @author GARCÍA CASTRO HÉCTOR JAVIER
 * @author OLIVOS NAVARRO CESAR JONATHAN
 * @author VILLEGAS MORENO ZEUXIS DANIEL
 */
@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {
    
    /**
     * Variable que almacena el nombre de usuario.
     */
    @Id
    private String usuario;
    /**
     * Variable que almacena la contraseña del usuario.
     */
    @NotNull
    private String contraseña;
    /**
     * Variable que almacena el nombre de la persona.
     */
    @NotNull
    private String nombre;
    /**
     * Variable que almacena el correo electrónico.
     */
    @NotNull
    private String correo;
    /**
     * Variable que almacena el privilegio del usuario.
     */
    @NotNull
    private String privilegio;
    /**
     * Variable que almacena el estado del usuario.
     */
    @NotNull
    private Boolean activo; 
    /**
     * 
     */
    private byte[] cifrado;
    
    /**
     * Variable que almacena los comentarios que a realizado el usuario.
     */
    @OneToMany()
    private  List<Comentario> comentarios;

    /**
     * Método que regrea el nombre de usuario.
     * @return Una cadena con la información.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Método que asigna un nuevo nombre de usuario.
     * @param usuario El nuevo nombre de usuario.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Método que regregsa la contraseña.
     * @return Una cadena con la información.
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Método que asigna una nueva contraseña.
     * @param contraseña La nueva contraseña.
     */
    public void setContraseña(String contraseña) {
        /**
        String llaveSimetrica = "holamundocruel12";
        SecretKeySpec key = new SecretKeySpec(llaveSimetrica.getBytes(), "AES");
        Cipher cipher;
        try {
            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] campoCifrado = cipher.doFinal(contraseña.getBytes());
            cifrado = campoCifrado;
            this.contraseña = new String(campoCifrado);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException 
                | IllegalBlockSizeException | BadPaddingException e) {
        }*/
        this.contraseña = contraseña;
    }

    /**
     * Método que regresa el nombre.
     * @return El nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que asigna un nuevo nombre.
     * @param nombre El nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que regresa el correo electrónico.
     * @return Una cadena con la información.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Método que asinga un nuevo correo electrónico.
     * @param correo El nuevo correo electrónico.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Métdofo que regresa el privilegio del usuario.
     * @return Una cadena con la información.
     */
    public String getPrivilegio() {
        return privilegio;
    }

    /**
     * Método que asigna un nuevo privilegio.
     * @param privilegio El nuevo privilegio.
     */
    public void setPrivilegio(String privilegio) {
        this.privilegio = privilegio;
    }

    /**
     * Método que indica si el usuario esta activo en el sistema.
     * @return True en caso de estar activo.
     */
    public Boolean getActivo() {
        return activo;
    }

    /**
     * Método que cambia el estado activo del usuario.
     * @param activo El nuevo estado.
     */
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    /**
     * Método que regresa los comentarios que a publicado el usuario.
     * @return Una lista con la información.
     */
    public List<Comentario> getComentarios() {
        return comentarios;
    }

    /**
     * Método que asigna un nuevo comentario.
     * @param comentarios La lista actualizada.
     */
    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    
    /**
     * 
     * @return 
     */
    public byte[] getCifrado() {
        return cifrado;
    }

    /**
     * 
     * @param cifrado 
     */
    public void setCifrado(byte[] cifrado) {
        this.cifrado = cifrado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.usuario);
        hash = 79 * hash + Objects.hashCode(this.contraseña);
        hash = 79 * hash + Objects.hashCode(this.nombre);
        hash = 79 * hash + Objects.hashCode(this.correo);
        hash = 79 * hash + Objects.hashCode(this.privilegio);
        hash = 79 * hash + Objects.hashCode(this.activo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return true;
    }
    
}
