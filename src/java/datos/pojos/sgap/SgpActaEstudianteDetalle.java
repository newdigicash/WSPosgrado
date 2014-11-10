package datos.pojos.sgap;
// Generated 27/02/2014 04:06:17 PM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.Date;

/**
 * SgpActaEstudianteDetalle generated by hbm2java
 */
public class SgpActaEstudianteDetalle  implements java.io.Serializable {


     private SgpActaEstudianteDetalleId id;
     private SgpActaEstudiante sgpActaEstudiante;
     private String aedNombre;
     private BigDecimal aedValor;
     private Short aedPorcentajeIncidencia;
     private char aedEstaactivo;
     private String aedCreado;
     private Date aedFechaCreacion;
     private String aedActualizado;
     private Date aedFechaActualizacion;

    public SgpActaEstudianteDetalle() {
    }

	
    public SgpActaEstudianteDetalle(SgpActaEstudianteDetalleId id, SgpActaEstudiante sgpActaEstudiante, String aedNombre, BigDecimal aedValor, char aedEstaactivo, String aedCreado, Date aedFechaCreacion) {
        this.id = id;
        this.sgpActaEstudiante = sgpActaEstudiante;
        this.aedNombre = aedNombre;
        this.aedValor = aedValor;
        this.aedEstaactivo = aedEstaactivo;
        this.aedCreado = aedCreado;
        this.aedFechaCreacion = aedFechaCreacion;
    }
    public SgpActaEstudianteDetalle(SgpActaEstudianteDetalleId id, SgpActaEstudiante sgpActaEstudiante, String aedNombre, BigDecimal aedValor, Short aedPorcentajeIncidencia, char aedEstaactivo, String aedCreado, Date aedFechaCreacion, String aedActualizado, Date aedFechaActualizacion) {
       this.id = id;
       this.sgpActaEstudiante = sgpActaEstudiante;
       this.aedNombre = aedNombre;
       this.aedValor = aedValor;
       this.aedPorcentajeIncidencia = aedPorcentajeIncidencia;
       this.aedEstaactivo = aedEstaactivo;
       this.aedCreado = aedCreado;
       this.aedFechaCreacion = aedFechaCreacion;
       this.aedActualizado = aedActualizado;
       this.aedFechaActualizacion = aedFechaActualizacion;
    }
   
    public SgpActaEstudianteDetalleId getId() {
        return this.id;
    }
    
    public void setId(SgpActaEstudianteDetalleId id) {
        this.id = id;
    }
    public SgpActaEstudiante getSgpActaEstudiante() {
        return this.sgpActaEstudiante;
    }
    
    public void setSgpActaEstudiante(SgpActaEstudiante sgpActaEstudiante) {
        this.sgpActaEstudiante = sgpActaEstudiante;
    }
    public String getAedNombre() {
        return this.aedNombre;
    }
    
    public void setAedNombre(String aedNombre) {
        this.aedNombre = aedNombre;
    }
    public BigDecimal getAedValor() {
        return this.aedValor;
    }
    
    public void setAedValor(BigDecimal aedValor) {
        this.aedValor = aedValor;
    }
    public Short getAedPorcentajeIncidencia() {
        return this.aedPorcentajeIncidencia;
    }
    
    public void setAedPorcentajeIncidencia(Short aedPorcentajeIncidencia) {
        this.aedPorcentajeIncidencia = aedPorcentajeIncidencia;
    }
    public char getAedEstaactivo() {
        return this.aedEstaactivo;
    }
    
    public void setAedEstaactivo(char aedEstaactivo) {
        this.aedEstaactivo = aedEstaactivo;
    }
    public String getAedCreado() {
        return this.aedCreado;
    }
    
    public void setAedCreado(String aedCreado) {
        this.aedCreado = aedCreado;
    }
    public Date getAedFechaCreacion() {
        return this.aedFechaCreacion;
    }
    
    public void setAedFechaCreacion(Date aedFechaCreacion) {
        this.aedFechaCreacion = aedFechaCreacion;
    }
    public String getAedActualizado() {
        return this.aedActualizado;
    }
    
    public void setAedActualizado(String aedActualizado) {
        this.aedActualizado = aedActualizado;
    }
    public Date getAedFechaActualizacion() {
        return this.aedFechaActualizacion;
    }
    
    public void setAedFechaActualizacion(Date aedFechaActualizacion) {
        this.aedFechaActualizacion = aedFechaActualizacion;
    }




}

