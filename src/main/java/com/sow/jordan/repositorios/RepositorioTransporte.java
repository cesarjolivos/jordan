/*
 * Paquete que contiene los repositorios del sistema Jordan
 */
package com.sow.jordan.repositorios;

import com.sow.jordan.modelos.Transporte;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Interfaz que contiene las consultas a la base de datos.
 * @author GARCÍA CASTRO HÉCTOR JAVIER
 * @author OLIVOS NAVARRO CESAR JONATHAN
 * @author VILLEGAS MORENO ZEUXIS DANIEL
 */
public interface RepositorioTransporte extends CrudRepository<Transporte, Integer> {
    
    /**
     * Método que carga la información de los transportes.
     * @return Una lista con la información.
     */
    @Query("SELECT transporte FROM Transporte transporte")
    List<Transporte> cargarTranportes();
    
    /**
     * Método que se encarga de buscar un transporte por medio de su id.
     * @param id El id del transporte.
     * @return Un transporte
     */
    @Query("SELECT transporte FROM Transporte transporte WHERE transporte.id = ?")
    Transporte buscarTransporte(Integer id);
    
    /**
     * Método que regresa una lista con los tipos de transporte
     * @return 
     */
    @Query("SELECT transporte.tipo FROM Transporte transporte GROUP BY transporte.tipo")
    List<String> tipos();
    
    /**
     * Método que busca los transportes de acuerdo al tipo seleccionado
     * @param tipo El tipo de transporte
     * @return Una lista con la información.
     */
    @Query("SELECT transporte FROM Transporte transporte WHERE transporte.tipo = ?")
    List<Transporte> porTipos(String tipo);
    
}
