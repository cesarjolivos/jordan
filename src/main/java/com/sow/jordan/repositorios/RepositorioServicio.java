/*
 * Paquete que contiene los repositorios del sistema Jordan
 */
package com.sow.jordan.repositorios;

import com.sow.jordan.modelos.Servicio;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Interfaz que contiene las consultas a la base de datos.
 * @author GARCÍA CASTRO HÉCTOR JAVIER
 * @author OLIVOS NAVARRO CESAR JONATHAN
 * @author VILLEGAS MORENO ZEUXIS DANIEL
 */
public interface RepositorioServicio extends CrudRepository<Servicio, Integer> {
    
    /**
     * Método que carga la información de los servicios.
     * @return Una lista con la información.
     */
    @Query("SELECT servicio FROM Servicio servicio")
    List<Servicio> cargarServicios();
}
