/*
 * Paquete que contiene los controladores del sistema.
 */
package com.sow.jordan.controladores;

import com.sow.jordan.modelos.Local;
import com.sow.jordan.servicios.ServicioLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Clase se encarga de conectar las vistas con los modelos del sistema, conecta
 * los locales y clases relacionadas con las vistas.
 * @author GARCÍA CASTRO HÉCTOR JAVIER
 * @author OLIVOS NAVARRO CESAR JONATHAN
 * @author VILLEGAS MORENO ZEUXIS DANIEL
 */
@Controller("controladorLocal")
@Scope("session")
public class ControladorLocal implements Serializable {
    
    /**
     * Variable que almacela los servicios de los locales.
     */
    @Autowired
    private ServicioLocal servicioLocal;
    /**
     * Variable que almacena los locales del sistema
     */
    private List<Local> locales;
    /**
     * Variable que alamacena un local.
     */
    private Local local;
    
    /**
     * Método que se ejecuta después de realizar la inyección de dependencias.
     */
    @PostConstruct
    public void inicio(){
        locales = servicioLocal.cargarLocales();
    }
    
}
