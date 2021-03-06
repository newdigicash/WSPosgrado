package datos.pojos.sgap;
// Generated 13-mar-2014 16:04:07 by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * SgpRegistrosDefinitivos generated by hbm2java
 */
public class SgpRegistrosDefinitivos  implements java.io.Serializable {


     private SgpRegistrosDefinitivosId id;
     private char registroDefinitivo;
     private Date fechaRegistro;
     private char estaactivo;
     private String creado;
     private Date fechaCreacion;
     private String actualizado;
     private Date fechaActualizacion;

    public SgpRegistrosDefinitivos() {
    }

	
    public SgpRegistrosDefinitivos(SgpRegistrosDefinitivosId id, char registroDefinitivo, char estaactivo, String creado, Date fechaCreacion) {
        this.id = id;
        this.registroDefinitivo = registroDefinitivo;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
    }
    public SgpRegistrosDefinitivos(SgpRegistrosDefinitivosId id, char registroDefinitivo, Date fechaRegistro, char estaactivo, String creado, Date fechaCreacion, String actualizado, Date fechaActualizacion) {
       this.id = id;
       this.registroDefinitivo = registroDefinitivo;
       this.fechaRegistro = fechaRegistro;
       this.estaactivo = estaactivo;
       this.creado = creado;
       this.fechaCreacion = fechaCreacion;
       this.actualizado = actualizado;
       this.fechaActualizacion = fechaActualizacion;
    }
   
    public SgpRegistrosDefinitivosId getId() {
        return this.id;
    }
    
    public void setId(SgpRegistrosDefinitivosId id) {
        this.id = id;
    }
    public char getRegistroDefinitivo() {
        return this.registroDefinitivo;
    }
    
    public void setRegistroDefinitivo(char registroDefinitivo) {
        this.registroDefinitivo = registroDefinitivo;
    }
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
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


