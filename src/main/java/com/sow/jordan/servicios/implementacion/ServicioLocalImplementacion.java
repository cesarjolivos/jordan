/*
 * Paquete en el que se implementan los Servicios
 */
package com.sow.jordan.servicios.implementacion;

import com.sow.jordan.modelos.*;
import com.sow.jordan.repositorios.*;
import com.sow.jordan.servicios.ServicioLocal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Clase que implementa los servicios de local.
 * @author GARCÍA CASTRO HÉCTOR JAVIER
 * @author OLIVOS NAVARRO CESAR JONATHAN
 * @author VILLEGAS MORENO ZEUXIS DANIEL
 */
public class ServicioLocalImplementacion implements ServicioLocal {
    
    @Autowired
    private RepositorioLocal repositorioLocal; 
    
    /**
     * Método para guardar la información de los locales.
     * @param local El local a guardar.
     */
    @Override
    public void guardarLocal(Local local) {
        repositorioLocal.save(local);
    }
    
    /**
     * Método que carga la información de los locales.
     * @return Una lista con la información.
     */
    @Override
    public List<Local> cargarLocales() {
        return repositorioLocal.cargarLocales();
    }
    
    /**
     * Método para eliminar un local.
     * @param local El local a eliminar.
     */
    @Override
    public void eliminarLocal(Local local) {
        repositorioLocal.delete(local);
    }
    
    /**
     * Método que busca un local mediante su id.
     * @param id El nombre del local.
     * @return Un local.
     */
    @Override
    public Local buscarLocal(int id) {
        return repositorioLocal.buscarLocal(id);
    }
    
}
