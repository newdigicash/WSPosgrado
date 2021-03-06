package datos.pojos.sgap;
// Generated 27/02/2014 04:06:17 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * SgpActaAutorizacion generated by hbm2java
 */
public class SgpActaAutorizacion  implements java.io.Serializable {


     private SgpActaAutorizacionId id;
     private SgpActaEstudiante sgpActaEstudiante;
     private String acaNumeroDocumento;
     private String acaAutorizado;
     private Date acaFechaAutorizacion;
     private String acaObservacion;
     private char acaEstaactivo;
     private String acaCreado;
     private Date acaFechaCreacion;
     private String acaActualizado;
     private Date acaFechaActualizacion;

    public SgpActaAutorizacion() {
    }

	
    public SgpActaAutorizacion(SgpActaAutorizacionId id, SgpActaEstudiante sgpActaEstudiante, String acaNumeroDocumento, String acaAutorizado, Date acaFechaAutorizacion, String acaObservacion, char acaEstaactivo, String acaCreado, Date acaFechaCreacion) {
        this.id = id;
        this.sgpActaEstudiante = sgpActaEstudiante;
        this.acaNumeroDocumento = acaNumeroDocumento;
        this.acaAutorizado = acaAutorizado;
        this.acaFechaAutorizacion = acaFechaAutorizacion;
        this.acaObservacion = acaObservacion;
        this.acaEstaactivo = acaEstaactivo;
        this.acaCreado = acaCreado;
        this.acaFechaCreacion = acaFechaCreacion;
    }
    public SgpActaAutorizacion(SgpActaAutorizacionId id, SgpActaEstudiante sgpActaEstudiante, String acaNumeroDocumento, String acaAutorizado, Date acaFechaAutorizacion, String acaObservacion, char acaEstaactivo, String acaCreado, Date acaFechaCreacion, String acaActualizado, Date acaFechaActualizacion) {
       this.id = id;
       this.sgpActaEstudiante = sgpActaEstudiante;
       this.acaNumeroDocumento = acaNumeroDocumento;
       this.acaAutorizado = acaAutorizado;
       this.acaFechaAutorizacion = acaFechaAutorizacion;
       this.acaObservacion = acaObservacion;
       this.acaEstaactivo = acaEstaactivo;
       this.acaCreado = acaCreado;
       this.acaFechaCreacion = acaFechaCreacion;
       this.acaActualizado = acaActualizado;
       this.acaFechaActualizacion = acaFechaActualizacion;
    }
   
    public SgpActaAutorizacionId getId() {
        return this.id;
    }
    
    public void setId(SgpActaAutorizacionId id) {
        this.id = id;
    }
    public SgpActaEstudiante getSgpActaEstudiante() {
        return this.sgpActaEstudiante;
    }
    
    public void setSgpActaEstudiante(SgpActaEstudiante sgpActaEstudiante) {
        this.sgpActaEstudiante = sgpActaEstudiante;
    }
    public String getAcaNumeroDocumento() {
        return this.acaNumeroDocumento;
    }
    
    public void setAcaNumeroDocumento(String acaNumeroDocumento) {
        this.acaNumeroDocumento = acaNumeroDocumento;
    }
    public String getAcaAutorizado() {
        return this.acaAutorizado;
    }
    
    public void setAcaAutorizado(String acaAutorizado) {
        this.acaAutorizado = acaAutorizado;
    }
    public Date getAcaFechaAutorizacion() {
        return this.acaFechaAutorizacion;
    }
    
    public void setAcaFechaAutorizacion(Date acaFechaAutorizacion) {
        this.acaFechaAutorizacion = acaFechaAutorizacion;
    }
    public String getAcaObservacion() {
        return this.acaObservacion;
    }
    
    public void setAcaObservacion(String acaObservacion) {
        this.acaObservacion = acaObservacion;
    }
    public char getAcaEstaactivo() {
        return this.acaEstaactivo;
    }
    
    public void setAcaEstaactivo(char acaEstaactivo) {
        this.acaEstaactivo = acaEstaactivo;
    }
    public String getAcaCreado() {
        return this.acaCreado;
    }
    
    public void setAcaCreado(String acaCreado) {
        this.acaCreado = acaCreado;
    }
    public Date getAcaFechaCreacion() {
        return this.acaFechaCreacion;
    }
    
    public void setAcaFechaCreacion(Date acaFechaCreacion) {
        this.acaFechaCreacion = acaFechaCreacion;
    }
    public String getAcaActualizado() {
        return this.acaActualizado;
    }
    
    public void setAcaActualizado(String acaActualizado) {
        this.acaActualizado = acaActualizado;
    }
    public Date getAcaFechaActualizacion() {
        return this.acaFechaActualizacion;
    }
    
    public void setAcaFechaActualizacion(Date acaFechaActualizacion) {
        this.acaFechaActualizacion = acaFechaActualizacion;
    }




}


