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
    
    /**
     * Método que se encarga de buscar un local por medio de su nombre o alias.
     * @param nombre El nombre del local.
     * @param alias El alias del local.
     * @return Una lista con el resultado de la busqueda.
     */
    @Query("SELECT local FROM Local local WHERE local.nombre LIKE CONCAT('%',?,'%') "
            + "OR local.sobrenombre LIKE CONCAT('%',?,'%')")
    List<Local> buscarPorNombre(String nombre,String alias);
    
    /**
     * Método que se encarga de buscar un local que se encuentre en el lugar 
     * indicado.
     * @param lugar El lugar donde se pretende buscar los locales.
     * @return Una lista con el resultado de la busqueda.
     */
    @Query("SELECT local FROM Local local WHERE local.lugar.nombre LIKE CONCAT('%',?,'%')")
    List<Local> buscarPorLugar(String lugar);
    
    /**
     * Método que carga los comentarios del local que resibe como parametro.
     * @param local El local que se desea obtener los comentarios.
     * @return Una lista con la información.
     */
    @Query("SELECT comentario FROM Comentario comentario WHERE comentario.local = ?")
    List<Comentario> cargarComentarios(Local local);
    
    /**
     * Método que busca el comentario de un local que fuere realizado por un usuario.
     * @param local El local del que se desea obtener el comentario.
     * @param usuario El usuario que realiza el comentario.
     * @return Un comentario.
     */
    @Query("SELECT comentario FROM Comentario comentario WHERE comentario.local = ?"
            + "AND comentario.usuario = ?")
    Comentario buscarComentario(Local local, Usuario usuario);
    
    /**
     * Método que regresa los comentarios de un local, que no sean del usuario 
     * que recibe como parametro.
     * @param local El local.
     * @param usuario El usuario del que no se agrega el comentario.
     * @return Una lista con la información.
     */
    @Query("SELECT comentario FROM Comentario comentario WHERE comentario.local = ?"
            + "AND comentario.usuario != ?")
    List<Comentario> comentarios(Local local, Usuario usuario);
    
    /**
     * Método que elimina comenmtario de un local.
     * @param local El local.
     * @param id  El comentario a eliminar.
     * @return Los comentarios del local sin el comentario a eliminar.
     */
    @Query("SELECT comentario FROM Comentario comentario WHERE comentario.local = ?"
            + "AND comentario.id <> ?")
    List<Comentario> eliminarComentario(Local local, Integer id);
    
}
