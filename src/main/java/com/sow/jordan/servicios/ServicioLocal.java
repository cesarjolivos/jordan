/*
 * Paquete que contiene los servicios.
 */
package com.sow.jordan.servicios;

import com.sow.jordan.modelos.Local;
import java.util.List;

/**
 * Interfaz de los servicios de los locales.
 * @author GARCÍA CASTRO HÉCTOR JAVIER
 * @author LARA RAMÍREZ JOSÉ JAVIER
 * @author OLIVOS NAVARRO CESAR JONATHAN
 * @author VILLEGAS MORENO ZEUXIS DANIEL
 */
public interface ServicioLocal {
    
    /**
     * Método para guardar la información de los locales.
     * @param local El local a guardar.
     */
    void guardarLocal(Local local);
    
    /**
     * Método que carga la información de los locales.
     * @return Una lista con la información.
     */
    List<Local> cargarLocales();
    
    /**
     * Método para eliminar un local.
     * @param local El local a eliminar.
     */
    void eliminarLocal(Local local);
    
    /**
     * Método que busca un local mediante su id.
     * @param id El id del local.
     * @return Un local.
     */
    Local buscarLocal(int id);
    
}
