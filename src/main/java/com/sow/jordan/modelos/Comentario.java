/*
 * Paquete en el que se almacenan los modelos del sistema jordan.
 */
package com.sow.jordan.modelos;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

/**
 * Clase almacena la información de los comentarios, crea una tabla para guardar
 * la información en la base de datos.
 * @author GARCÍA CASTRO HÉCTOR JAVIER
 * @author OLIVOS NAVARRO CESAR JONATHAN
 * @author VILLEGAS MORENO ZEUXIS DANIEL
 */
@Entity
@Table(name = "Comentario")
public class Comentario implements Serializable {

    /**
     * Variable que almacena el id del comentario, dicho valor se
     * auto-incrementa.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    /**
     * Variable que almacena el comentario.
     */
    private String comentario;
    /**
     * Variable que almacena la calificación otorgada.
     */
    private Integer calificación;
    /**
     * Variable que almacena la referencia al local.
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Local local;
    /**
     * Variable que almacena la referencia al usuario.
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Usuario usuario;

    /**
     * Método que regresa el id del comentario.
     * @return Un entero con la información.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Método que asigna un nuevo id a un comentario.
     * @param id El nuevo id.
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * Método que regresa el comentario.
     * @return Una cadena con la información.
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * Método que asigna un nuevo comentario.
     * @param comentario El nuevo comentario.
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * Método que regresa la calificación otorgada.
     * @return Un entero con la información.
     */
    public Integer getCalificación() {
        return calificación;
    }

    /**
     * Método que asigna una nueva calificación.
     * @param calificación 
     */
    public void setCalificación(Integer calificación) {
        this.calificación = calificación;
    }

    /**
     * Método que regresa el local del que proviene el comentario.
     * @return Un local.
     */
    public Local getLocal() {
        return local;
    }

    /**
     * Método que asigna un nuevo local.
     * @param local El nuevo local.
     */
    public void setLocal(Local local) {
        this.local = local;
    }

    /**
     * Método que regresa el usuario que publico el comentario.
     * @return Un usuario.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Método que asigna un nuevo usuario.
     * @param usuario El nuevo usuario.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.comentario);
        hash = 67 * hash + Objects.hashCode(this.calificación);
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
        final Comentario other = (Comentario) obj;
        return true;
    }

}
