/*
 * Paquete que contiene los repositorios del sistema Jordan
 */
package com.sow.jordan.repositorios;

import com.sow.jordan.modelos.*;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Interfaz que contiene las consultas a la base de datos.
 * @author GARCÍA CASTRO HÉCTOR JAVIER
 * @author LARA RAMÍREZ JOSÉ JAVIER
 * @author OLIVOS NAVARRO CESAR JONATHAN
 * @author VILLEGAS MORENO ZEUXIS DANIEL
 */
public interface RepositorioLocal extends CrudRepository<Local, Integer>{
    
    /**
     * Método que carga la información de los locales.
     * @return Una lista con la información.
     */
    @Query("SELECT local FROM Local local")
    List<Local> cargarLocales();

    /**
     * Método que se encarga de buscar un local por medio de su id.
     * @param id El id del local. 
     * @return Un local.
     */
    @Query("SELECT local FROM Local local WHERE local.id = ?")
    Local buscarLocal(Integer id);
    
}
