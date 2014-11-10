package datos.pojos.sgap;
// Generated 23/04/2012 09:23:45 AM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SgpEvaluacionesAportes generated by hbm2java
 */
public class SgpEvaluacionesAportes  implements java.io.Serializable {


     private SgpEvaluacionesAportesId id;
     private SgpFormasEvaluacion sgpFormasEvaluacion;
     private String columnaNota;
     private String nombreAporte;
     private String abreviatura;
     private byte nroDecimales;
     private BigDecimal valorminimo;
     private BigDecimal valormaximo;
     private String esfinal;
     private char escalculado;
     private String reglaCalculo;
     private char imprimible;
     private char mostrarMaximo;
     private String reemplazado;
     private char estaactivo;
     private String creado;
     private Date fechaCreacion;
     private String actualizado;
     private Date fechaActualizacion;
     private Set sgpRegistrosAporteses = new HashSet(0);
     private Character redondear;
     private byte idColumnaNota;

    public SgpEvaluacionesAportes() {
    }

	
    public SgpEvaluacionesAportes(SgpEvaluacionesAportesId id, SgpFormasEvaluacion sgpFormasEvaluacion, String columnaNota, String nombreAporte, String abreviatura, byte nroDecimales, BigDecimal valorminimo, BigDecimal valormaximo, String esfinal, char escalculado, char imprimible, char mostrarMaximo, char estaactivo, String creado, Date fechaCreacion) {
        this.id = id;
        this.sgpFormasEvaluacion = sgpFormasEvaluacion;
        this.columnaNota = columnaNota;
        this.nombreAporte = nombreAporte;
        this.abreviatura = abreviatura;
        this.nroDecimales = nroDecimales;
        this.valorminimo = valorminimo;
        this.valormaximo = valormaximo;
        this.esfinal = esfinal;
        this.escalculado = escalculado;
        this.imprimible = imprimible;
        this.mostrarMaximo = mostrarMaximo;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
    }
    
    public SgpEvaluacionesAportes(SgpEvaluacionesAportesId id, SgpFormasEvaluacion sgpFormasEvaluacion, String columnaNota, String nombreAporte, String abreviatura, byte nroDecimales, BigDecimal valorminimo, BigDecimal valormaximo, String esfinal, char escalculado, String reglaCalculo, char imprimible, char mostrarMaximo, String reemplazado, char estaactivo, String creado, Date fechaCreacion, String actualizado, Date fechaActualizacion, Set sgpRegistrosAporteses) {
       this.id = id;
       this.sgpFormasEvaluacion = sgpFormasEvaluacion;
       this.columnaNota = columnaNota;
       this.nombreAporte = nombreAporte;
       this.abreviatura = abreviatura;
       this.nroDecimales = nroDecimales;
       this.valorminimo = valorminimo;
       this.valormaximo = valormaximo;
       this.esfinal = esfinal;
       this.escalculado = escalculado;
       this.reglaCalculo = reglaCalculo;
       this.imprimible = imprimible;
       this.mostrarMaximo = mostrarMaximo;
       this.reemplazado = reemplazado;
       this.estaactivo = estaactivo;
       this.creado = creado;
       this.fechaCreacion = fechaCreacion;
       this.actualizado = actualizado;
       this.fechaActualizacion = fechaActualizacion;
       this.sgpRegistrosAporteses = sgpRegistrosAporteses;
    }
   
    public SgpEvaluacionesAportesId getId() {
        return this.id;
    }
    
    public void setId(SgpEvaluacionesAportesId id) {
        this.id = id;
    }

    public byte getIdColumnaNota() {
        return id.getPosColumnaNota();
    }

    public void setIdColumnaNota(byte idColumnaNota) {
        this.idColumnaNota = idColumnaNota;
    }
    
    public SgpFormasEvaluacion getSgpFormasEvaluacion() {
        return this.sgpFormasEvaluacion;
    }
    
    public void setSgpFormasEvaluacion(SgpFormasEvaluacion sgpFormasEvaluacion) {
        this.sgpFormasEvaluacion = sgpFormasEvaluacion;
    }
    public String getColumnaNota() {
        return this.columnaNota;
    }
    
    public void setColumnaNota(String columnaNota) {
        this.columnaNota = columnaNota;
    }
    public String getNombreAporte() {
        return this.nombreAporte;
    }
    
    public void setNombreAporte(String nombreAporte) {
        this.nombreAporte = nombreAporte;
    }
    public String getAbreviatura() {
        return this.abreviatura;
    }
    
    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }
    public byte getNroDecimales() {
        return this.nroDecimales;
    }
    
    public void setNroDecimales(byte nroDecimales) {
        this.nroDecimales = nroDecimales;
    }
    public BigDecimal getValorminimo() {
        return this.valorminimo;
    }
    
    public void setValorminimo(BigDecimal valorminimo) {
        this.valorminimo = valorminimo;
    }
    public BigDecimal getValormaximo() {
        return this.valormaximo;
    }
    
    public void setValormaximo(BigDecimal valormaximo) {
        this.valormaximo = valormaximo;
    }
    public String getEsfinal() {
        return this.esfinal;
    }
    
    public void setEsfinal(String esfinal) {
        this.esfinal = esfinal;
    }
    public char getEscalculado() {
        return this.escalculado;
    }
    
    public void setEscalculado(char escalculado) {
        this.escalculado = escalculado;
    }
    public String getReglaCalculo() {
        return this.reglaCalculo;
    }
    
    public void setReglaCalculo(String reglaCalculo) {
        this.reglaCalculo = reglaCalculo;
    }
    public char getImprimible() {
        return this.imprimible;
    }
    
    public void setImprimible(char imprimible) {
        this.imprimible = imprimible;
    }
    public char getMostrarMaximo() {
        return this.mostrarMaximo;
    }
    
    public void setMostrarMaximo(char mostrarMaximo) {
        this.mostrarMaximo = mostrarMaximo;
    }
    public String getReemplazado() {
        return this.reemplazado;
    }
    
    public void setReemplazado(String reemplazado) {
        this.reemplazado = reemplazado;
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
    public Set getSgpRegistrosAporteses() {
        return this.sgpRegistrosAporteses;
    }
    
    public void setSgpRegistrosAporteses(Set sgpRegistrosAporteses) {
        this.sgpRegistrosAporteses = sgpRegistrosAporteses;
    }

    public Character getRedondear() {
        return redondear;
    }

    public void setRedondear(Character redondear) {
        this.redondear = redondear;
    }

}

