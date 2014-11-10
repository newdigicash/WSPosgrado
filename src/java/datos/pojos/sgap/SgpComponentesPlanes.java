package datos.pojos.sgap;
// Generated 23/04/2012 09:23:45 AM by Hibernate Tools 3.2.1.GA


import java.sql.Clob;
import java.util.Date;

/**
 * SgpComponentesPlanes generated by hbm2java
 */
public class SgpComponentesPlanes  implements java.io.Serializable {


     private SgpComponentesPlanesId id;
     private SgpComponentesDetalles sgpComponentesDetalles;
     private SgpPlanesCurso sgpPlanesCurso;
     private String valor;
     private char estaactivo;
     private String creado;
     private Date fechaCreacion;
     private String actualizado;
     private Date fechaActualizacion;
     //otro
     private boolean _guardado=false;

    public SgpComponentesPlanes() {
    }

	
    public SgpComponentesPlanes(SgpComponentesPlanesId id, SgpComponentesDetalles sgpComponentesDetalles, SgpPlanesCurso sgpPlanesCurso, char estaactivo, String creado, Date fechaCreacion) {
        this.id = id;
        this.sgpComponentesDetalles = sgpComponentesDetalles;
        this.sgpPlanesCurso = sgpPlanesCurso;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
    }
    public SgpComponentesPlanes(SgpComponentesPlanesId id, SgpComponentesDetalles sgpComponentesDetalles, SgpPlanesCurso sgpPlanesCurso, String valor, char estaactivo, String creado, Date fechaCreacion, String actualizado, Date fechaActualizacion) {
       this.id = id;
       this.sgpComponentesDetalles = sgpComponentesDetalles;
       this.sgpPlanesCurso = sgpPlanesCurso;
       this.valor = valor;
       this.estaactivo = estaactivo;
       this.creado = creado;
       this.fechaCreacion = fechaCreacion;
       this.actualizado = actualizado;
       this.fechaActualizacion = fechaActualizacion;
    }
   
    public SgpComponentesPlanesId getId() {
        return this.id;
    }
    
    public void setId(SgpComponentesPlanesId id) {
        this.id = id;
    }
    public SgpComponentesDetalles getSgpComponentesDetalles() {
        return this.sgpComponentesDetalles;
    }
    
    public void setSgpComponentesDetalles(SgpComponentesDetalles sgpComponentesDetalles) {
        this.sgpComponentesDetalles = sgpComponentesDetalles;
    }
    public SgpPlanesCurso getSgpPlanesCurso() {
        return this.sgpPlanesCurso;
    }
    
    public void setSgpPlanesCurso(SgpPlanesCurso sgpPlanesCurso) {
        this.sgpPlanesCurso = sgpPlanesCurso;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public char getEstaactivo() {
        return estaactivo;
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

    public boolean isGuardado() {
        return _guardado;
    }

    public void setGuardado(boolean _guardado) {
        this._guardado = _guardado;
    }




}


