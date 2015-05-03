/*
 * Paquete en el que se almacenan los modelos del sistema jordan.
 */
package com.sow.jordan.modelos;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import sun.misc.BASE64Encoder;

/**
 * Clase almacena la información de un local, crea una tabla para guardar 
 * la información en la base de datos.
 * @author GARCÍA CASTRO HÉCTOR JAVIER
 * @author OLIVOS NAVARRO CESAR JONATHAN
 * @author VILLEGAS MORENO ZEUXIS DANIEL
 */
@Entity
@Table(name="Local")
public class Local implements Serializable {
    
    /**
     * Variable que almacena el id del lugar, dicho valor se auto-incrementa.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    /**
     * Variable que almacena el nombre del local, dicho valor no puede ser nulo.
     */
    @NotNull
    private String nombre;
    /**
     * Variable que almacena el Alias del local.
     */
    private String sobrenombre;
    /**
     * Variable que almacena la latitud del local.
     */
    @NotNull
    private Double latitud;
    /**
     * Variable que almacena la longitud del local.
     */
    @NotNull
    private Double longitud;
    /**
     * Variable que almacena la especialidad del local.
     */
    private String especialidad;
    /**
     * Variable que almacena la descripción del local.
     */
    private String descripción;
    /**
     * Variable que almacena una imagen.
     */
    @Lob
    @Column(name = "imagen", columnDefinition = "LONGBLOB")
    @Basic(fetch = FetchType.LAZY)
    private byte[] imagen;  
    /**
     * Variable que almecena el lugar en el que se encuentra ubicado el local.
     */
    @ManyToOne
    private Lugar lugar;
     /**
     * Variable que almacena la referencia a los servicios del local.
     */
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Servicio> servicios;
    /**
     * Variable que almacena la referencia los menús del local.
     */
    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "local",
            orphanRemoval = true)
    private List<Menú> menú;
    /**
     * Variable que almacena la referencia a los transportes sercanos al local.
     */
    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "local",
            orphanRemoval = true)
    private List<Transporte> transportes;
    /**
     * Variable que almacena los comentarios que tiene el local.
     */
    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "usuario",
            orphanRemoval = true)
    private  List<Comentario> comentarios;
    /**
     * Variable que almacena la calificación promedio que tiene el local.
     */
    private double calificación;
    
    /**
     * Método que regresa el id del local.
     * @return Un entero con la información.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Método que asigna un nuevo id a un local.
     * @param id El nuevo id.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Método que regresa el nombre del local.
     * @return Una cadena con la información.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que asigna un nuevo nombre a un local.
     * @param nombre El nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que regresa el alias del local.
     * @return Una cadena con la información.
     */
    public String getAlias() {
        return sobrenombre;
    }

    /**
     * Método que asigna un nuevo alias al local.
     * @param alias El nuevo alias.
     */
    public void setAlias(String alias) {
        this.sobrenombre = alias;
    }

    /**
     * Método que regresa la latitud del local.
     * @return Un double con la información
     */
    public Double getLatitud() {
        return latitud;
    }

    /**
     * Método que asigna una nueva latitud.
     * @param latitud La nueva latitud.
     */
    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    /**
     * Método que regresa la longitud del local.
     * @return Un double con la información.
     */
    public Double getLongitud() {
        return longitud;
    }

    /**
     * Método que asigna una nueva longitud.
     * @param longitud Una nueva longitud.
     */
    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    /**
     * Método que regresa la especialidad del local.
     * @return Una cadena con la información
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * Método que asigna una nueva especialidad al local.
     * @param especialidad La nueva especialidad.
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * Método que regresa la descripción del local.
     * @return Una cadena con la información.
     */
    public String getDescripción() {
        return descripción;
    }

    /**
     * Método que asigna una nueva descripción al local.
     * @param descripción La nueva descripción.
     */
    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    /**
     * Método que regresa un arreglo de bytes con la información de la imagen.
     * @return 
     */
    public byte[] getImagen() {
        return imagen;
    }

    /**
     * Método que asigna una nueva imagen.
     * @param imagen Un arreglo con la información.
     */
    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
    
    /**
     * Método que regresa el lugar donde se encuentra el local.
     * @return Un lugar.
     */
    public Lugar getLugar() {
        return lugar;
    }

    /**
     * Método que asigna un nuevo lugar al local.
     * @param lugar Un lugar.
     */
    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }
    
    /**
     * Método que regresa los servicios con los que cuenta el local.
     * @return Una lista con los servicios.
     */
    public List<Servicio> getServicios() {
        return servicios;
    }

    /**
     * Método que asigna un nuevo servicio.
     * @param servicios El nuevo servicio.
     */
    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }
    
    /**
     * Método que regresa una lista con los menús.
     * @return Una lista con la información.
     */
    public List<Menú> getMenú() {
        return menú;
    }

    /**
     * Método para establecer un nuevo menú.
     * @param menú El nuevo menú.
     */
    public void setMenú(List<Menú> menú) {
        this.menú = menú;
    }
    
    /**
     * Método que regresa los transportes mas sercarnos al local.
     * @return Una lista con la información.
     */
    public List<Transporte> getTransportes() {
        return transportes;
    }

    /**
     * Método que establece un nuevo transporte.
     * @param transportes El nuevo transporte.
     */
    public void setTransportes(List<Transporte> transportes) {
        this.transportes = transportes;
    }

    /**
     * Método que regresa los comentrarios que tiene el local.
     * @return Una lista con la información.
     */
    public List<Comentario> getComentarios() {
        return comentarios;
    }

    /**
     * Método que asigna un nuevo comentario al local.
     * @param comentarios La lista actualizada.
     */
    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    
    /**
     * Método que regresa la calificaron promedio del local.
     * @return Un double con la información.
     */
    public double getCalificación() {
        return calificación;
    }

    /**
     * Método asigna la calificación promedio.
     * @param calificación La nueva calificación del local.
     */
    public void setCalificación(double calificación) {
        this.calificación = calificación;
    }
    
    /**
     * Método que regresa una cadena con la información de la imagen, para 
     * que pueda ser representada en la pagina.
     * @return Una cadena con la información.
     */
    public String getImagenUrl() {
        if (this != null && this.getImagen() != null) {
            BASE64Encoder encoder = new BASE64Encoder();
            String imageString = encoder.encode(this.getImagen());
            return imageString;
        } else {
            return null;
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.sobrenombre);
        hash = 97 * hash + Objects.hashCode(this.latitud);
        hash = 97 * hash + Objects.hashCode(this.longitud);
        hash = 97 * hash + Objects.hashCode(this.especialidad);
        hash = 97 * hash + Objects.hashCode(this.descripción);
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
        final Local other = (Local) obj;
        return true;
    }
    
}
