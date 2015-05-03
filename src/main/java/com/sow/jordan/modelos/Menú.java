/*
 * Paquete en el que se almacenan los modelos del sistema jordan.
 */
package com.sow.jordan.modelos;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Clase guarda la informacion de los menús de los locales, crea una tabla para 
 * guardar la información en la base de datos.
 * @author GARCÍA CASTRO HÉCTOR JAVIER
 * @author OLIVOS NAVARRO CESAR JONATHAN
 * @author VILLEGAS MORENO ZEUXIS DANIEL
 */
@Entity
@Table(name = "Menú")
public class Menú implements Serializable {
    
    /**
     * Variable que indica el id del menú, dicho valor se auto-incrementa.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * Variable que almacena la categiria del menu, dicho valor no puede ser nulo.
     */
    @NotNull
    private String categoria;

    /**
     * Variable que almacena el precio minimo.
     */
    private Double precioMin;

    /**
     * Variable que almacena el precio maximo.
     */
    private Double precioMax;

    /**
     * Variable que almacena la referencia al local del que proviene.
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Local local;

    /**
     * Método que regresa el id del menuú.
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
     * Método que regresa la categoria del menú.
     * @return Una cadena con la información.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Método que asigna una nueva categoria.
     * @param categoria La nueva categoria.
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Método que regresa el precio minimo.
     * @return Un double con la información.
     */
    public Double getPrecioMin() {
        return precioMin;
    }

    /**
     * Método que asigna un nuevo precio minimo.
     * @param precioMin El nuevo precio.
     */
    public void setPrecioMin(Double precioMin) {
        this.precioMin = precioMin;
    }

    /**
     * Método que regresa el precio maximo.
     * @return Un double con la información.
     */
    public Double getPrecioMax() {
        return precioMax;
    }

    /**
     * Método que asigna un nuevo precio maximo.
     * @param precioMax El nuevo precio.
     */
    public void setPrecioMax(Double precioMax) {
        this.precioMax = precioMax;
    }

    /**
     * Método que regresa el local del que proviene.
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.categoria);
        hash = 67 * hash + Objects.hashCode(this.precioMin);
        hash = 67 * hash + Objects.hashCode(this.precioMax);
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
        final Menú other = (Menú) obj;
        return true;
    }
}
