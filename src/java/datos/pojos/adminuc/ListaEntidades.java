package datos.pojos.adminuc;
// Generated 24/08/2011 09:18:12 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * ListaEntidades generated by hbm2java
 */
public class ListaEntidades  implements java.io.Serializable {


     private ListaEntidadesId id;
     private ListasDistribucion listasDistribucion;
     private Dependencias dependencias;
     private Integer carreraId;
     private char estaactivo;
     private String creado;
     private Date fechaCreacion;
     private String actualizado;
     private Date fechaActualizacion;

    public ListaEntidades() {
    }

	
    public ListaEntidades(ListaEntidadesId id, ListasDistribucion listasDistribucion, Dependencias dependencias, char estaactivo, String creado, Date fechaCreacion) {
        this.id = id;
        this.listasDistribucion = listasDistribucion;
        this.dependencias = dependencias;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
    }
    public ListaEntidades(ListaEntidadesId id, ListasDistribucion listasDistribucion, Dependencias dependencias, Integer carreraId, char estaactivo, String creado, Date fechaCreacion, String actualizado, Date fechaActualizacion) {
       this.id = id;
       this.listasDistribucion = listasDistribucion;
       this.dependencias = dependencias;
       this.carreraId = carreraId;
       this.estaactivo = estaactivo;
       this.creado = creado;
       this.fechaCreacion = fechaCreacion;
       this.actualizado = actualizado;
       this.fechaActualizacion = fechaActualizacion;
    }
   
    public ListaEntidadesId getId() {
        return this.id;
    }
    
    public void setId(ListaEntidadesId id) {
        this.id = id;
    }
    public ListasDistribucion getListasDistribucion() {
        return this.listasDistribucion;
    }
    
    public void setListasDistribucion(ListasDistribucion listasDistribucion) {
        this.listasDistribucion = listasDistribucion;
    }
    public Dependencias getDependencias() {
        return this.dependencias;
    }
    
    public void setDependencias(Dependencias dependencias) {
        this.dependencias = dependencias;
    }
    public Integer getCarreraId() {
        return this.carreraId;
    }
    
    public void setCarreraId(Integer carreraId) {
        this.carreraId = carreraId;
    }
    public char getEstaactivo() {
        return this.estaactivo;
    }
    
    public void setEstaactivo(char estaactivo) {
        this.estaactivo = estaactivo;
    }
    public String getCreado() {
        return this.creado;
    }
    
    public void setCreado(String creado) {
        this.creado = creado;
    }
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }
    
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public String getActualizado() {
        return this.actualizado;
    }
    
    public void setActualizado(String actualizado) {
        this.actualizado = actualizado;
    }
    public Date getFechaActualizacion() {
        return this.fechaActualizacion;
    }
    
    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }




}

