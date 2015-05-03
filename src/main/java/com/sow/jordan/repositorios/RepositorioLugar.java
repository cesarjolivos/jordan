/*
 * Paquete que contiene los repositorios del sistema Jordan
 */
package com.sow.jordan.repositorios;

import com.sow.jordan.modelos.Lugar;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Interfaz que contiene las consultas a la base de datos.
 * @author GARCÍA CASTRO HÉCTOR JAVIER
 * @author OLIVOS NAVARRO CESAR JONATHAN
 * @author VILLEGAS MORENO ZEUXIS DANIEL
 */
public interface RepositorioLugar extends CrudRepository<Lugar, Integer> {
    
    /**
     * Método que carga la información de los lugares.
     * @return Una lista con la información.
     */
    @Query("SELECT lugar FROM Lugar lugar")
    List<Lugar> cargarLugares();
    
    /**
     * Método que se encarga de buscar un lugar por medio de su id.
     * @param id El id del lugar.
     * @return Un lugar
     */
    @Query("SELECT lugar FROM Lugar lugar WHERE lugar.id = ?")
    Lugar buscarLugar(Integer id);
    
}
