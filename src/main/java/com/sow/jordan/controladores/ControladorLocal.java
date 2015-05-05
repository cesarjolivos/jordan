/*
 * Paquete que contiene los controladores del sistema.
 */
package com.sow.jordan.controladores;

import com.sow.jordan.modelos.*;
import com.sow.jordan.servicios.ServicioLocal;
import com.sow.jordan.servicios.ServicioUsuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.map.*;
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
     * Variable que almacena el servicio de usuarios.
     */
    @Autowired
    private ServicioUsuario servicioUsuario;
    /**
     * Variable que almacena los locales del sistema
     */
    private List<Local> locales;
    /**
     * Variable que alamacena un local.
     */
    private Local local;
    /**
     * Variable que almacena los resultados de la buequeda.
     */
    private List<Local> resultados;
    /**
     * Variable que alamacena el catalogo de los lugares que hay en el sistema.
     */
    private List<Lugar> lugares;
    /**
     * Variable que almacena un lugar.
     */
    private Lugar lugar;
    /**
     * Variable que almacena el mapa.
     */
    private MapModel mapa;
    /**
     * Variable que almacena el catalogo de los servicios que hay en los locales.
     */
    private List<Servicio> servicios;
    /**
     * Variable que alamcena un servicio.
     */
    private Servicio servicio;
    /**
     * Variable que almacena un menú.
     */
    private Menú menú;
    /**
     * Variable que alamacena el catalogo de los transportes que hay en cu
     */
    private List<Transporte> transportes;
    /**
     * Variable que almacena un transporte.
     */
    private Transporte transporte;
    /**
     * Variable que almacena un usuario.
     */
    public Usuario usuario;
    /**
     * Variable que almacena un comentario.
     */
    private Comentario comentario;
    /**
     * Variables auxiliares.
     */
    private int idLugar;//indica el id del lugar seleccionado.
    private int idTransporte;//indica el id del transporte seleccionado.
    private String tipo;//indica el tipo de transporte seleccionado.
    private int posición;//indica la posición en el top 5
    private String opciónDeBúsqueda;//variable que almacena la opción de búsqueda.
    private String busqueda;//variable que almacena lo que se decea buscar.
    
    /**
     * Método que se ejecuta después de realizar la inyección de dependencias.
     */
    @PostConstruct
    public void inicio(){
        lugares = servicioLocal.cargarLugares();
        servicios = servicioLocal.cargarServicios();
        transportes = servicioLocal.cargarTransportes();
        locales = servicioLocal.cargarLocales();
        local.setMenú(new ArrayList<Menú>());
        local.setTransportes(new ArrayList<Transporte>());
        local.setComentarios(new ArrayList<Comentario>());
        mapa = new DefaultMapModel(); 
        lugar = new Lugar();
        servicio = new Servicio();
        menú = new Menú();
        transporte = new Transporte();
        comentario = new Comentario();
    }
    
    /**
     * Método que guarda un local en la base de datos.
     */
    public void guardarLocal() {
        lugar = servicioLocal.buscarLugar(idLugar);
        local.setLugar(lugar);
        servicioLocal.guardarLocal(local);
        locales = servicioLocal.cargarLocales();
        local = new Local();
        local.setMenú(new ArrayList<Menú>());
        local.setTransportes(new ArrayList<Transporte>());
        local.setComentarios(new ArrayList<Comentario>());
    }
    
    /**
     * Método que guarda los menús de un local.
     */
    public void guardarMenús() {
        local.getMenú().add(menú);
        menú = new Menú();
    }
    
    /**
     * Método que agrega un transporte a un local.
     */
    public void guardarTransporte() {
        transporte = servicioLocal.buscarTransporte(idTransporte);
        local.getTransportes().add(transporte);
        transporte = new Transporte();
    }
    
    /**
     * Método que guarda un comentario en la base de datos.
     */
    public void guardarComentario(){
        comentario.setUsuario(usuario);
        local.setComentarios( servicioLocal.comentarios(local, usuario) );
        local.getComentarios().add(comentario);
        local.actualizarCalificacion();
        servicioLocal.guardarLocal(local);
        locales = servicioLocal.cargarLocales();
    }
    
    /**
     * Método que agrega un lugar al catalogo de lugares.
     */
    public void agregarLugar(){
        servicioLocal.guardarLugar(lugar);
        lugares = servicioLocal.cargarLugares();
        lugar = new Lugar();
    }
    
    /**
     * Método que agrega un servicio al catalogo de servicios de los locales.
     */
    public void agregarServicio(){
        servicioLocal.guardarSercivio(servicio);
        servicios = servicioLocal.cargarServicios();
        servicio = new Servicio();
    }
    
    /**
     * Método que agrega un transporte al catalogo de transportes de cu.
     */
    public void agregarTransporte(){
        servicioLocal.guardarTransporte(transporte);
        transportes = servicioLocal.cargarTransportes();
        transporte = new Transporte();
    }
    
    /**
     * Método que elimina un local de la base de datos.
     * @param local El local a eliminar.
     */
    public void eliminarLocal(Local local) {
        servicioLocal.eliminarLocal(local);
        locales = servicioLocal.cargarLocales();
    }
    
    /**
     * Método que elimina un menú de un local.
     * @param menú El menú a aliminar.
     */
    public void eliminarMenú(Menú menú) {
        this.local.getMenú().remove(menú);
    }
    
    /**
     * Método que elimina un transporte de un local.
     * @param transporte El transporte a aliminar.
     */
    public void eliminarTransporte(Transporte transporte) {
        this.local.getTransportes().remove(transporte);
    }
    
    /**
     * Método que elimina un comentario de la base de datos.
     * @param usuario El usuario que publico el comentario.
     */
    public void eliminarComentario(Usuario usuario) {
        usuario = servicioUsuario.buscarUsuario(usuario.getUsuario());
        local.setComentarios( servicioLocal.comentarios(local, usuario) );
        local.actualizarCalificacion();
        servicioLocal.guardarLocal(local);
        locales = servicioLocal.cargarLocales();
        servicioUsuario.guardarUsuario(usuario);
    }
    
    /**
     * Método que indica si la sesión esta iniciada para poder realizar un 
     * comentario.
     * @param controladorSesión El controlador de la sesión.
     * @return True en caso de estar iniciada la sesión.
     */
    public boolean sesionIniciada(ControladorSesión controladorSesión) {
        usuario = controladorSesión.getUsuario();
        comentario = servicioLocal.buscarComentario(local, usuario);
        if(comentario == null){
            comentario = new Comentario();
        }
        return controladorSesión.getSesionIniciada();
    }    
    
    /**
     * Método que regresa la lista de locales.
     * @return Una lista con la información.
     */
    public List<Local> getLocales() {
        return locales;
    }
    
    /**
     * Método para agregar un local a la lista.
     * @param locales Una lista con la información.
     */
    public void setLocales(List<Local> locales) {
        this.locales = locales;
    }
    
    /**
     * Método que regresa un local.
     * @return Un local.
     */
    public Local getLocal() {
        return local;
    }

    /**
     * Método que asigna un local.
     * @param local Un local.
     */
    public void setLocal(Local local) {
        this.local = local;
    }    
    
    /**
     * Método que regresa los locales que cumplen con los parametros de las 
     * busqueda.
     * @return Una lista con los locales resultantes de la busqueda.
     */
    public List<Local> getResultados() {
        return resultados;
    }

    /**
     * Método que asigna un nuevo resultdo de la busqueda de los locales.
     * @param resultados La lista con con los el nuevo resultado.
     */
    public void setResultados(List<Local> resultados) {
        this.resultados = resultados;
    }
    
    /**
     * Método que regresa el mapa para ver el local.
     * @return Un MapModel.
     */
    public MapModel getMapa() {
        mapa = new DefaultMapModel();
        LatLng coord = new LatLng(local.getLatitud(), local.getLongitud());
        mapa.addOverlay(new Marker(coord, local.getNombre()));
        return mapa;
    }

    /**
     * Método que asigna un nuevo mapa del local.
     * @param mapa El nuevo mapa.
     */
    public void setMapa(MapModel mapa) {
        this.mapa = mapa;
    }
    
    /**
     * Método que regresa el id del lugar seleccionado.
     * @return Un entero con la informacion.
     */
    public int getIdLugar() {
        return idLugar;
    }

    /**
     * Método que asigna un id del lugar seleccionado.
     * @param idLugar El id del lugar.
     */
    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }
    
    /**
     * Método que regresa los lugares.
     * @return Una lista con la información.
     */
    public List<Lugar> getLugares() {
        return lugares;
    }
    
    /**
     * Método que agrega un lugar.
     * @param lugares Una lista con la información.
     */
    public void setLugares(List<Lugar> lugares) {
        this.lugares = lugares;
    }
    
    /**
     * Método que regresa un lugar.
     * @return Un lugar.
     */
    public Lugar getLugar() {
        return lugar;
    }

    /**
     * Método que asigna un nuevo lugar.
     * @param lugar El lugar a asignar.
     */
    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }
    
    /**
     * Método que regresa los servicios de los locales.
     * @return Una lista con la información.
     */
    public List<Servicio> getServicios() {
        return servicios;
    }

    /**
     * Método que agrega un servicio.
     * @param servicios Una lista con la nueva información
     */
    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    /**
     * Método que regresa un servicio.
     * @return Un servicio.
     */
    public Servicio getServicio() {
        return servicio;
    }

    /**
     * Método que asigna un nuevo servicio.
     * @param servicio El nuevo servicio.
     */
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    /**
     * Método que regresa un menú.
     * @return Un menú.
     */
    public Menú getMenú() {
        return menú;
    }

    /**
     * Método para agregar un menú.
     * @param menú El nuevo menú.
     */
    public void setMenú(Menú menú) {
        this.menú = menú;
    }
    
    /**
     * Método que regresa los tranportes que hay en CU.
     * @return Una lista con la información.
     */
    public List<Transporte> getTransportes() {
        return transportes;
    }

    /**
     * Método que agrega un nuevo transporte.
     * @param transportes Una lista con la nueva información
     */
    public void setTransportes(List<Transporte> transportes) {
        this.transportes = transportes;
    }
    
    /**
     * Método que regresa el id del transporte seleccionado.
     * @return Un entero con la información.
     */
    public int getIdTransporte() {
        return idTransporte;
    }

    /**
     * Método que asigna un nuevo id de transporte.
     * @param idTransporte El nuevo id.
     */
    public void setIdTransporte(int idTransporte) {
        this.idTransporte = idTransporte;
    }

    /**
     * Método que regresa un transporte.
     * @return Un transporte.
     */
    public Transporte getTransporte() {
        return transporte;
    }

    /**
     * Método que asigna un nuevo transporte.
     * @param transporte El n uevo transporte.
     */
    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }
    
    /**
     * Método que regresa los tipos de transporte que hay en cu
     * @return Una lista con la información.
     */
    public List<String> getTipos() {
        return servicioLocal.tipos();
    }
    
    /**
     * Método que regresa el tipo de trasnporte seleccionado.
     * @return Una cadena con la información.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Método que asigna un tipo de trasnporte.
     * @param tipo El tipo de transporte.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    /**
     * Método que busca los transportes del tipo elegido por el usuario.
     */
    public void buscarTransporte(){
        transportes = servicioLocal.porTipos(this.tipo);
    }
    
    /**
     * Método que regresa el comentario.
     * @return Un comentario
     */
    public Comentario getComentario() {
        return comentario;
    }

    /**
     * Método que actualiza el comentario.
     * @param comentario El comentario actualizado.
     */
    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }
    
    /**
     * Método que regresa la posición que ocupa un local en la lista de top 5.
     * @return Un entero con la información.
     */
    public int getPosición() {
        return posición++;
    }
    
    /**
     * Método que regresa la lista de lugares con mejor calificación.
     * @return Una lista de los mejores 5 locales.
     */
    public List<Local> getTop5() {
        posición = 1;
        return locales;
    }

    /**
     * Método que regresa la opción de busqueda.
     * @return Una cadena con la opción.
     */
    public String getOpciónDeBúsqueda() {
        return opciónDeBúsqueda;
    }

    /**
     * Método que establece la nueva opción de busqueda.
     * @param opciónDeBúsqueda La nueva opción.
     */
    public void setOpciónDeBúsqueda(String opciónDeBúsqueda) {
        this.opciónDeBúsqueda = opciónDeBúsqueda;
    }

    /**
     * Método que regresa el atributo de la busqueda.
     * @return Una cadena con el atributo de la busqueda.
     */
    public String getBusqueda() {
        return busqueda;
    }

    /**
     * Método que almacena la busqueda.
     * @param busqueda Una cadena con el atributo a buscar.
     */
    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda;
    }    
    
    /**
     * Método que realiza la busqueda.
     */
    public void realizarBúsqueda(){
        posición = 1;
        if (opciónDeBúsqueda.equals("Local")) {
            resultados = servicioLocal.buscarPorNombre(busqueda);
        }
    }
    
    /**
     * Método para guardar la imagen del local.
     * @param event El evento que se activa al agregar la imagen.
     */
    public void imagenLocal(FileUploadEvent event) {
        UploadedFile file = event.getFile();
        this.local.setImagen(file.getContents());
    }
    
    /**
     * Método que guarda la imagen de un servicio.
     * @param event El evento que se activa al agregar la imagen.
     */
    public void imagenServicio(FileUploadEvent event) {
        UploadedFile file = event.getFile();
        this.servicio.setImagen(file.getContents());
    }
    
}
