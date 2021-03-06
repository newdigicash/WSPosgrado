package datos.pojos.sgap;
// Generated 27/02/2014 04:34:12 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SgpActas generated by hbm2java
 */
public class SgpActas  implements java.io.Serializable {


     private SgpActasId id;
     private SgpEdiciones sgpEdiciones;
     private String actNombre;
     private String actCalculoNotafinal;
     private char actRedondea;
     private byte actNumeroDecimales;
     private char actEnvigencia;
     private Date actFechaVigencia;
     private char actEstaactivo;
     private String actCreado;
     private Date actFechaCreacion;
     private String actActualizado;
     private Date actFechaActualizacion;
     private Set sgpActasConfiguracioneses = new HashSet(0);
     private Set sgpActaEstudiantes = new HashSet(0);

    public SgpActas() {
    }

	
    public SgpActas(SgpActasId id, SgpEdiciones sgpEdiciones, String actNombre, String actCalculoNotafinal, char actRedondea, byte actNumeroDecimales, char actEnvigencia, char actEstaactivo, String actCreado, Date actFechaCreacion) {
        this.id = id;
        this.sgpEdiciones = sgpEdiciones;
        this.actNombre = actNombre;
        this.actCalculoNotafinal = actCalculoNotafinal;
        this.actRedondea = actRedondea;
        this.actNumeroDecimales = actNumeroDecimales;
        this.actEnvigencia = actEnvigencia;
        this.actEstaactivo = actEstaactivo;
        this.actCreado = actCreado;
        this.actFechaCreacion = actFechaCreacion;
    }
    public SgpActas(SgpActasId id, SgpEdiciones sgpEdiciones, String actNombre, String actCalculoNotafinal, char actRedondea, byte actNumeroDecimales, char actEnvigencia, Date actFechaVigencia, char actEstaactivo, String actCreado, Date actFechaCreacion, String actActualizado, Date actFechaActualizacion, Set sgpActasConfiguracioneses, Set sgpActaEstudiantes) {
       this.id = id;
       this.sgpEdiciones = sgpEdiciones;
       this.actNombre = actNombre;
       this.actCalculoNotafinal = actCalculoNotafinal;
       this.actRedondea = actRedondea;
       this.actNumeroDecimales = actNumeroDecimales;
       this.actEnvigencia = actEnvigencia;
       this.actFechaVigencia = actFechaVigencia;
       this.actEstaactivo = actEstaactivo;
       this.actCreado = actCreado;
       this.actFechaCreacion = actFechaCreacion;
       this.actActualizado = actActualizado;
       this.actFechaActualizacion = actFechaActualizacion;
       this.sgpActasConfiguracioneses = sgpActasConfiguracioneses;
       this.sgpActaEstudiantes = sgpActaEstudiantes;
    }
   
    public SgpActasId getId() {
        return this.id;
    }
    
    public void setId(SgpActasId id) {
        this.id = id;
    }
    public SgpEdiciones getSgpEdiciones() {
        return this.sgpEdiciones;
    }
    
    public void setSgpEdiciones(SgpEdiciones sgpEdiciones) {
        this.sgpEdiciones = sgpEdiciones;
    }
    public String getActNombre() {
        return this.actNombre;
    }
    
    public void setActNombre(String actNombre) {
        this.actNombre = actNombre;
    }
    public String getActCalculoNotafinal() {
        return this.actCalculoNotafinal;
    }
    
    public void setActCalculoNotafinal(String actCalculoNotafinal) {
        this.actCalculoNotafinal = actCalculoNotafinal;
    }
    public char getActRedondea() {
        return this.actRedondea;
    }
    
    public void setActRedondea(char actRedondea) {
        this.actRedondea = actRedondea;
    }
    public byte getActNumeroDecimales() {
        return this.actNumeroDecimales;
    }
    
    public void setActNumeroDecimales(byte actNumeroDecimales) {
        this.actNumeroDecimales = actNumeroDecimales;
    }
    public char getActEnvigencia() {
        return this.actEnvigencia;
    }
    
    public void setActEnvigencia(char actEnvigencia) {
        this.actEnvigencia = actEnvigencia;
    }
    public Date getActFechaVigencia() {
        return this.actFechaVigencia;
    }
    
    public void setActFechaVigencia(Date actFechaVigencia) {
        this.actFechaVigencia = actFechaVigencia;
    }
    public char getActEstaactivo() {
        return this.actEstaactivo;
    }
    
    public void setActEstaactivo(char actEstaactivo) {
        this.actEstaactivo = actEstaactivo;
    }
    public String getActCreado() {
        return this.actCreado;
    }
    
    public void setActCreado(String actCreado) {
        this.actCreado = actCreado;
    }
    public Date getActFechaCreacion() {
        return this.actFechaCreacion;
    }
    
    public void setActFechaCreacion(Date actFechaCreacion) {
        this.actFechaCreacion = actFechaCreacion;
    }
    public String getActActualizado() {
        return this.actActualizado;
    }
    
    public void setActActualizado(String actActualizado) {
        this.actActualizado = actActualizado;
    }
    public Date getActFechaActualizacion() {
        return this.actFechaActualizacion;
    }
    
    public void setActFechaActualizacion(Date actFechaActualizacion) {
        this.actFechaActualizacion = actFechaActualizacion;
    }
    public Set getSgpActasConfiguracioneses() {
        return this.sgpActasConfiguracioneses;
    }
    
    public void setSgpActasConfiguracioneses(Set sgpActasConfiguracioneses) {
        this.sgpActasConfiguracioneses = sgpActasConfiguracioneses;
    }
    public Set getSgpActaEstudiantes() {
        return this.sgpActaEstudiantes;
    }
    
    public void setSgpActaEstudiantes(Set sgpActaEstudiantes) {
        this.sgpActaEstudiantes = sgpActaEstudiantes;
    }




}


