/*
 * Paquete en el que se almacenan los modelos del sistema jordan.
 */
package com.sow.jordan.modelos;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Clase que servirá como un catalogo que muestra los lugares dentro de Ciudad
 * Universitaria, crea una tabla para guardar la información en la base de datos.
 * @author GARCÍA CASTRO HÉCTOR JAVIER
 * @author LARA RAMÍREZ JOSÉ JAVIER
 * @author OLIVOS NAVARRO CESAR JONATHAN
 * @author VILLEGAS MORENO ZEUXIS DANIEL
 */
@Entity
@Table(name = "Lugar")
public class Lugar implements Serializable {
    
    /**
     * Variable que indica el id del lugar, dicho valor se auto-incrementa.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    /**
     * Variable que almacena el nombre del lugar, dicho valor no puede ser nulo.
     */
    @NotNull
    private String nombre;
    
    /**
     * Constructor de la clase, crea un lugar con los datos que recibe como
     * parametro.
     * @param id El id del lugar
     * @param nombre El nombre del lugar.
     */
    public Lugar(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }
    
    /**
     * Constructor de la clase, crea un lugar sin información.
     */
    public Lugar() {
        this.id = null;
        this.nombre = null;
    }

    /**
     * Método que regresa el id del lugar.
     * @return un entero con la información.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Método que asigna un nuevo id.
     * @param id El nuevo valor del id.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Método que regresa el nombre del lugar.
     * @return Una cadena con la información.
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.id);
        hash = 19 * hash + Objects.hashCode(this.nombre);
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
        final Lugar other = (Lugar) obj;
        return true;
    }
    
}
