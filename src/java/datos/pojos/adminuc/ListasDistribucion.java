package datos.pojos.adminuc;
// Generated 24/08/2011 09:18:12 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ListasDistribucion generated by hbm2java
 */
public class ListasDistribucion  implements java.io.Serializable {


     private int id;
     private String nombre;
     private String personId;
     private String emailPersonId;
     private String tipo;
     private String ambito;
     private char estaactivo;
     private String creado;
     private Date fechaCreacion;
     private String actualizado;
     private Date fechaActualizacion;
     private Set<ListaEntidades> listaEntidadeses = new HashSet<ListaEntidades>(0);

    public ListasDistribucion() {
    }

	
    public ListasDistribucion(int id, String nombre, String tipo, char estaactivo, String creado, Date fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
    }
    public ListasDistribucion(int id, String nombre, String personId, String emailPersonId, String tipo, String ambito, char estaactivo, String creado, Date fechaCreacion, String actualizado, Date fechaActualizacion, Set<ListaEntidades> listaEntidadeses) {
       this.id = id;
       this.nombre = nombre;
       this.personId = personId;
       this.emailPersonId = emailPersonId;
       this.tipo = tipo;
       this.ambito = ambito;
       this.estaactivo = estaactivo;
       this.creado = creado;
       this.fechaCreacion = fechaCreacion;
       this.actualizado = actualizado;
       this.fechaActualizacion = fechaActualizacion;
       this.listaEntidadeses = listaEntidadeses;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPersonId() {
        return this.personId;
    }
    
    public void setPersonId(String personId) {
        this.personId = personId;
    }
    public String getEmailPersonId() {
        return this.emailPersonId;
    }
    
    public void setEmailPersonId(String emailPersonId) {
        this.emailPersonId = emailPersonId;
    }
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getAmbito() {
        return this.ambito;
    }
    
    public void setAmbito(String ambito) {
        this.ambito = ambito;
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
    public Set<ListaEntidades> getListaEntidadeses() {
        return this.listaEntidadeses;
    }
    
    public void setListaEntidadeses(Set<ListaEntidades> listaEntidadeses) {
        this.listaEntidadeses = listaEntidadeses;
    }




}


