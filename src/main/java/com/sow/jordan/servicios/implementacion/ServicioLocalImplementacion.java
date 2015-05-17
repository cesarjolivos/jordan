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
 *
 * @author GARCÍA CASTRO HÉCTOR JAVIER
 * @author OLIVOS NAVARRO CESAR JONATHAN
 * @author VILLEGAS MORENO ZEUXIS DANIEL
 */
public class ServicioLocalImplementacion implements ServicioLocal {

    @Autowired
    private RepositorioLocal repositorioLocal;

    @Autowired
    private RepositorioLugar repositorioLugar;

    @Autowired
    private RepositorioServicio repositorioServicio;

    @Autowired
    private RepositorioTransporte repositorioTransporte;
    
    @Autowired
    private RepositorioComentario repositorioComentario;

    /**
     * Método para guardar la información de los locales.
     *
     * @param local El local a guardar.
     */
    @Override
    public void guardarLocal(Local local) {
        for (Menú menú : local.getMenú()) {
            menú.setLocal(local);
        }
        for (Comentario c : local.getComentarios()) {
            c.setLocal(local);
        }
        repositorioLocal.save(local);
    }

    /**
     * Método para guardar la información de los lugares
     *
     * @param lugar El lugar a guardar
     */
    @Override
    public void guardarLugar(Lugar lugar) {
        repositorioLugar.save(lugar);
    }

    /**
     * Método para guardar la información de los servicios
     *
     * @param servicio El servicio a guardar
     */
    @Override
    public void guardarSercivio(Servicio servicio) {
        repositorioServicio.save(servicio);
    }

    /**
     * Método para guardar la información de los transportes.
     *
     * @param transporte El transporte a guardar.
     */
    @Override
    public void guardarTransporte(Transporte transporte) {
        repositorioTransporte.save(transporte);
    }

    /**
     * Método que carga la información de los locales.
     *
     * @return Una lista con la información.
     */
    @Override
    public List<Local> cargarLocales() {
        return repositorioLocal.cargarLocales();
    }

    /**
     * Metodo que carga ls informacion de los lugares
     *
     * @return
     */
    @Override
    public List<Lugar> cargarLugares() {
        return repositorioLugar.cargarLugares();
    }

    /**
     * Método que carga la información de los servicios
     *
     * @return Una lista con la información
     */
    @Override
    public List<Servicio> cargarServicios() {
        return repositorioServicio.cargarServicios();
    }

    /**
     * Método que carga la información de los tranportes.
     *
     * @return Una lista con la información.
     */
    @Override
    public List<Transporte> cargarTransportes() {
        return repositorioTransporte.cargarTranportes();
    }

    /**
     * Método para eliminar un local.
     *
     * @param local El local a eliminar.
     */
    @Override
    public void eliminarLocal(Local local) {
        repositorioLocal.delete(local);
    }

    /**
     * Método que busca un local mediante su id.
     *
     * @param id El nombre del local.
     * @return Un local.
     */
    @Override
    public Local buscarLocal(int id) {
        return repositorioLocal.buscarLocal(id);
    }

    /**
     * Método que se encarga de buscar un local por medio de su nombre o alias.
     *
     * @param local El nombre o alias del local.
     * @return Una lista con el resultado de la busqueda.
     */
    @Override
    public List<Local> buscarPorNombre(String local) {
        return repositorioLocal.buscarPorNombre(local, local);
    }

    /**
     * Método que busca los locales que se encuentre en el lugar indicado.
     *
     * @param lugar El lugar donde se pretende buscar los locales.
     * @return Una lista con el resultado de la busqueda.
     */
    @Override
    public List<Local> buscarPorLugar(String lugar) {
        return repositorioLocal.buscarPorLugar(lugar);
    }

    /**
     * Método que busca los locales que contenga una categoria de un menú.
     *
     * @param categoria La categoria que deben tener.
     * @return Una lista con el resultado de la busqueda.
     */
    @Override
    public List<Local> buscarPorMenú(String categoria) {
        return repositorioLocal.buscarPorMenú(categoria);
    }

    /**
     * Método que busca un lugar mediante su id.
     *
     * @param id El id del lugar.
     * @return Una lista con la información
     */
    @Override
    public Lugar buscarLugar(int id) {
        return repositorioLugar.buscarLugar(id);
    }

    /**
     * Método que busca un transporte mediante su id.
     *
     * @param id El id del transporte.
     * @return Un transporte.
     */
    @Override
    public Transporte buscarTransporte(int id) {
        return repositorioTransporte.buscarTransporte(id);
    }

    /**
     * Método que regres una lista de los tipos de transporte.
     *
     * @return Una lista con la información.
     */
    @Override
    public List<String> tipos() {
        return repositorioTransporte.tipos();
    }

    /**
     * Método que regresa los transportes de acuerdo al tipo seleccionado.
     *
     * @param tipo El tipo de transporte
     * @return Una lista con la información.
     */
    @Override
    public List<Transporte> porTipos(String tipo) {
        return repositorioTransporte.porTipos(tipo);
    }

    /**
     * Método que carga los comentarios del local que resibe como parametro.
     *
     * @param local El local que se desea obtener los comentarios.
     * @return Una lista con la información.
     */
    @Override
    public List<Comentario> cargarComentarios(Local local) {
        return repositorioLocal.cargarComentarios(local);
    }

    /**
     * Método que busca el comentario de un local que fuere realizado por un
     * usuario.
     *
     * @param local El local del que se desea obtener el comentario.
     * @param usuario El usuario que realiza el comentario.
     * @return Un comentario.
     */
    @Override
    public Comentario buscarComentario(Local local, Usuario usuario) {
        return repositorioLocal.buscarComentario(local, usuario);
    }

    @Override
    public List<Comentario> comentarios(Local local, Usuario usuario) {
        return repositorioLocal.comentarios(local, usuario);
    }
    
    @Override
    public List<Comentario> comentarios2(Local local) {
        return repositorioLocal.comentarios2(local);
    }
    
    /**
     * Método que elimina comenmtario de un local.
     *
     * @param local El local.
     * @param id El comentario a eliminar.
     * @return Los comentarios del local sin el comentario a eliminar.
     */
    @Override
    public List<Comentario> eliminarComentario(Local local, Integer id) {
        return repositorioLocal.eliminarComentario(local, id);
    }

    /**
     * Método que regresa la lista del top 5.
     *
     * @return Una lista de 5 locales con mejor puntuación.
     */
    @Override
    public List<Local> top5() {
        return repositorioLocal.top5();
    }

    @Override
    public void eliminarServicio(Servicio servicio) {
        repositorioServicio.delete(servicio);
    }

    @Override
    public void eliminarTransporteCat(Transporte transporte) {
        repositorioTransporte.delete(transporte);
    }

    @Override
    public void eliminarComentario2(Comentario comentario) {
        repositorioComentario.delete(comentario);
    }

    @Override
    public void guardarComentario(Comentario comentario) {
        repositorioComentario.save(comentario);
    }
}
