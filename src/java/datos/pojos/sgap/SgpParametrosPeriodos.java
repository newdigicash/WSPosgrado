package datos.pojos.sgap;
// Generated 23/04/2012 09:23:45 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * SgpParametrosPeriodos generated by hbm2java
 */
public class SgpParametrosPeriodos  implements java.io.Serializable {


     private SgpParametrosPeriodosId id;
     private SgpParametros sgpParametros;
     private Date fechaInicio;
     private Date fechaFinal;
     private String valor1;
     private String valor2;
     private char estaactivo;
     private String creado;
     private Date fechaCreacion;
     private String actualizado;
     private Date fechaActualizacion;

    public SgpParametrosPeriodos() {
    }

	
    public SgpParametrosPeriodos(SgpParametrosPeriodosId id, SgpParametros sgpParametros, char estaactivo, String creado, Date fechaCreacion) {
        this.id = id;
        this.sgpParametros = sgpParametros;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
    }
    public SgpParametrosPeriodos(SgpParametrosPeriodosId id, SgpParametros sgpParametros, Date fechaInicio, Date fechaFinal, String valor1, String valor2, char estaactivo, String creado, Date fechaCreacion, String actualizado, Date fechaActualizacion) {
       this.id = id;
       this.sgpParametros = sgpParametros;
       this.fechaInicio = fechaInicio;
       this.fechaFinal = fechaFinal;
       this.valor1 = valor1;
       this.valor2 = valor2;
       this.estaactivo = estaactivo;
       this.creado = creado;
       this.fechaCreacion = fechaCreacion;
       this.actualizado = actualizado;
       this.fechaActualizacion = fechaActualizacion;
    }
   
    public SgpParametrosPeriodosId getId() {
        return this.id;
    }
    
    public void setId(SgpParametrosPeriodosId id) {
        this.id = id;
    }
    public SgpParametros getSgpParametros() {
        return this.sgpParametros;
    }
    
    public void setSgpParametros(SgpParametros sgpParametros) {
        this.sgpParametros = sgpParametros;
    }
    public Date getFechaInicio() {
        return this.fechaInicio;
    }
    
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Date getFechaFinal() {
        return this.fechaFinal;
    }
    
    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
    public String getValor1() {
        return this.valor1;
    }
    
    public void setValor1(String valor1) {
        this.valor1 = valor1;
    }
    public String getValor2() {
        return this.valor2;
    }
    
    public void setValor2(String valor2) {
        this.valor2 = valor2;
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


