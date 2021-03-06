package datos.pojos.sgap;
// Generated 23/04/2012 09:23:45 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SgpRegistrosCabeceras generated by hbm2java
 */
public class SgpRegistrosCabeceras  implements java.io.Serializable {


     private SgpRegistrosCabecerasId id;
     private SgpFormasEvaluacion sgpFormasEvaluacion;
     private byte nroRegistroDefinitivo;
     private String nombreCabecera;
     private char estaactivo;
     private String creado;
     private Date fechaCreacion;
     private String actualizado;
     private Date fechaActualizacion;
     private String ayuda;
     private Set sgpRegistrosAporteses = new HashSet(0);
     private int idRegistro;

    public SgpRegistrosCabeceras() {
    }

	
    public SgpRegistrosCabeceras(SgpRegistrosCabecerasId id, SgpFormasEvaluacion sgpFormasEvaluacion, byte nroRegistroDefinitivo, String nombreCabecera, char estaactivo, String creado, Date fechaCreacion) {
        this.id = id;
        this.sgpFormasEvaluacion = sgpFormasEvaluacion;
        this.nroRegistroDefinitivo = nroRegistroDefinitivo;
        this.nombreCabecera = nombreCabecera;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
    }
    public SgpRegistrosCabeceras(SgpRegistrosCabecerasId id, SgpFormasEvaluacion sgpFormasEvaluacion, byte nroRegistroDefinitivo, String nombreCabecera, char estaactivo, String creado, Date fechaCreacion, String actualizado, Date fechaActualizacion, String ayuda, Set sgpRegistrosAporteses) {
       this.id = id;
       this.sgpFormasEvaluacion = sgpFormasEvaluacion;
       this.nroRegistroDefinitivo = nroRegistroDefinitivo;
       this.nombreCabecera = nombreCabecera;
       this.estaactivo = estaactivo;
       this.creado = creado;
       this.fechaCreacion = fechaCreacion;
       this.actualizado = actualizado;
       this.fechaActualizacion = fechaActualizacion;
       this.ayuda = ayuda;
       this.sgpRegistrosAporteses = sgpRegistrosAporteses;
    }

    public int getIdRegistro() {
        return id.getId();
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }   
    
    public SgpRegistrosCabecerasId getId() {
        return this.id;
    }   
    
    public void setId(SgpRegistrosCabecerasId id) {
        this.id = id;
    }
    public SgpFormasEvaluacion getSgpFormasEvaluacion() {
        return this.sgpFormasEvaluacion;
    }
    
    public void setSgpFormasEvaluacion(SgpFormasEvaluacion sgpFormasEvaluacion) {
        this.sgpFormasEvaluacion = sgpFormasEvaluacion;
    }
    public byte getNroRegistroDefinitivo() {
        return this.nroRegistroDefinitivo;
    }
    
    public void setNroRegistroDefinitivo(byte nroRegistroDefinitivo) {
        this.nroRegistroDefinitivo = nroRegistroDefinitivo;
    }
    public String getNombreCabecera() {
        return this.nombreCabecera;
    }
    
    public void setNombreCabecera(String nombreCabecera) {
        this.nombreCabecera = nombreCabecera;
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
    public String getAyuda() {
        return this.ayuda;
    }
    
    public void setAyuda(String ayuda) {
        this.ayuda = ayuda;
    }
    public Set getSgpRegistrosAporteses() {
        return this.sgpRegistrosAporteses;
    }
    
    public void setSgpRegistrosAporteses(Set sgpRegistrosAporteses) {
        this.sgpRegistrosAporteses = sgpRegistrosAporteses;
    }




}


