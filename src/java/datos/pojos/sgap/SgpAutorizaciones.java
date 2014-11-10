package datos.pojos.sgap;
// Generated 23/04/2012 09:23:45 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SgpAutorizaciones generated by hbm2java
 */
public class SgpAutorizaciones  implements java.io.Serializable {


     private int id;
     private String nroDocumento;
     private Date fechaAutorizacion;
     private String personaId;
     private String observaciones;
     private char estaactivo;
     private String creado;
     private Date fechaCreacion;
     private String actualizado;
     private Date fechaActualizacion;
     private Set sgpEdicioneses = new HashSet(0);

    public SgpAutorizaciones() {
    }

	
    public SgpAutorizaciones(int id, String nroDocumento, Date fechaAutorizacion, String personaId, char estaactivo, String creado, Date fechaCreacion) {
        this.id = id;
        this.nroDocumento = nroDocumento;
        this.fechaAutorizacion = fechaAutorizacion;
        this.personaId = personaId;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
    }
    public SgpAutorizaciones(int id, String nroDocumento, Date fechaAutorizacion, String personaId, String observaciones, char estaactivo, String creado, Date fechaCreacion, String actualizado, Date fechaActualizacion, Set sgpEdicioneses) {
       this.id = id;
       this.nroDocumento = nroDocumento;
       this.fechaAutorizacion = fechaAutorizacion;
       this.personaId = personaId;
       this.observaciones = observaciones;
       this.estaactivo = estaactivo;
       this.creado = creado;
       this.fechaCreacion = fechaCreacion;
       this.actualizado = actualizado;
       this.fechaActualizacion = fechaActualizacion;
       this.sgpEdicioneses = sgpEdicioneses;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getNroDocumento() {
        return this.nroDocumento;
    }
    
    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }
    public Date getFechaAutorizacion() {
        return this.fechaAutorizacion;
    }
    
    public void setFechaAutorizacion(Date fechaAutorizacion) {
        this.fechaAutorizacion = fechaAutorizacion;
    }
    public String getPersonaId() {
        return this.personaId;
    }
    
    public void setPersonaId(String personaId) {
        this.personaId = personaId;
    }
    public String getObservaciones() {
        return this.observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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
    public Set getSgpEdicioneses() {
        return this.sgpEdicioneses;
    }
    
    public void setSgpEdicioneses(Set sgpEdicioneses) {
        this.sgpEdicioneses = sgpEdicioneses;
    }




}

