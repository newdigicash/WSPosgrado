package datos.pojos.sgap;
// Generated 28/03/2014 04:35:23 PM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SgpActaEstudiante generated by hbm2java
 */
public class SgpActaEstudiante  implements java.io.Serializable {


     private SgpActaEstudianteId id;
     private SgpActas sgpActas;
     private int aceNumeroActa;
     private String aceNumeroActaDescripcion;
     private int aceDependenciaId;
     private String aceNacionalidad;
     private String aceFechaActa;
     private int aceTituloId;
     private String aceTitulo;
     private String aceDecanoId;
     private String aceSecretarioAbogId;
     private Date aceIniciaEstudios;
     private Date aceTerminaEstudios;
     private String aceFechaCompleta;
     private String aceFormatoImpresion;
     private String aceNombreTesis;
     private int aceModalidadId;
     private Integer aceUbicacionId;
     private int aceDuracion;
     private BigDecimal aceCreditos;
     private BigDecimal aceTotal;
     private int aceEquivalenciaId;
     private String aceEstado;
     private char aceEstaactivo;
     private String aceCreado;
     private Date aceFechaCreacion;
     private String aceActualizado;
     private Date aceFechaActualizacion;
     private Set sgpActaEstudianteDetalles = new HashSet(0);
     private Set sgpActaAutorizacions = new HashSet(0);
     private int aceActaId;
    
    public SgpActaEstudiante() {
    }

	
    public SgpActaEstudiante(SgpActaEstudianteId id, SgpActas sgpActas, int aceNumeroActa, String aceNumeroActaDescripcion, int aceDependenciaId, String aceNacionalidad, String aceFechaActa, int aceTituloId, String aceTitulo, String aceDecanoId, String aceSecretarioAbogId, Date aceIniciaEstudios, Date aceTerminaEstudios, String aceFechaCompleta, String aceNombreTesis, int aceModalidadId, int aceDuracion, BigDecimal aceCreditos, BigDecimal aceTotal, int aceEquivalenciaId, String aceEstado, char aceEstaactivo, String aceCreado, Date aceFechaCreacion) {
        this.id = id;
        this.sgpActas = sgpActas;
        this.aceNumeroActa = aceNumeroActa;
        this.aceNumeroActaDescripcion = aceNumeroActaDescripcion;
        this.aceDependenciaId = aceDependenciaId;
        this.aceNacionalidad = aceNacionalidad;
        this.aceFechaActa = aceFechaActa;
        this.aceTituloId = aceTituloId;
        this.aceTitulo = aceTitulo;
        this.aceDecanoId = aceDecanoId;
        this.aceSecretarioAbogId = aceSecretarioAbogId;
        this.aceIniciaEstudios = aceIniciaEstudios;
        this.aceTerminaEstudios = aceTerminaEstudios;
        this.aceFechaCompleta = aceFechaCompleta;
        this.aceNombreTesis = aceNombreTesis;
        this.aceModalidadId = aceModalidadId;
        this.aceDuracion = aceDuracion;
        this.aceCreditos = aceCreditos;
        this.aceTotal = aceTotal;
        this.aceEquivalenciaId = aceEquivalenciaId;
        this.aceEstado = aceEstado;
        this.aceEstaactivo = aceEstaactivo;
        this.aceCreado = aceCreado;
        this.aceFechaCreacion = aceFechaCreacion;
    }
    public SgpActaEstudiante(SgpActaEstudianteId id, SgpActas sgpActas, int aceNumeroActa, String aceNumeroActaDescripcion, int aceDependenciaId, String aceNacionalidad, String aceFechaActa, int aceTituloId, String aceTitulo, String aceDecanoId, String aceSecretarioAbogId, Date aceIniciaEstudios, Date aceTerminaEstudios, String aceFechaCompleta, String aceFormatoImpresion, String aceNombreTesis, int aceModalidadId, Integer aceUbicacionId, int aceDuracion, BigDecimal aceCreditos, BigDecimal aceTotal, int aceEquivalenciaId, String aceEstado, char aceEstaactivo, String aceCreado, Date aceFechaCreacion, String aceActualizado, Date aceFechaActualizacion, Set sgpActaEstudianteDetalles, Set sgpActaAutorizacions) {
       this.id = id;
       this.sgpActas = sgpActas;
       this.aceNumeroActa = aceNumeroActa;
       this.aceNumeroActaDescripcion = aceNumeroActaDescripcion;
       this.aceDependenciaId = aceDependenciaId;
       this.aceNacionalidad = aceNacionalidad;
       this.aceFechaActa = aceFechaActa;
       this.aceTituloId = aceTituloId;
       this.aceTitulo = aceTitulo;
       this.aceDecanoId = aceDecanoId;
       this.aceSecretarioAbogId = aceSecretarioAbogId;
       this.aceIniciaEstudios = aceIniciaEstudios;
       this.aceTerminaEstudios = aceTerminaEstudios;
       this.aceFechaCompleta = aceFechaCompleta;
       this.aceFormatoImpresion = aceFormatoImpresion;
       this.aceNombreTesis = aceNombreTesis;
       this.aceModalidadId = aceModalidadId;
       this.aceUbicacionId = aceUbicacionId;
       this.aceDuracion = aceDuracion;
       this.aceCreditos = aceCreditos;
       this.aceTotal = aceTotal;
       this.aceEquivalenciaId = aceEquivalenciaId;
       this.aceEstado = aceEstado;
       this.aceEstaactivo = aceEstaactivo;
       this.aceCreado = aceCreado;
       this.aceFechaCreacion = aceFechaCreacion;
       this.aceActualizado = aceActualizado;
       this.aceFechaActualizacion = aceFechaActualizacion;
       this.sgpActaEstudianteDetalles = sgpActaEstudianteDetalles;
       this.sgpActaAutorizacions = sgpActaAutorizacions;
    }
   
    public SgpActaEstudianteId getId() {
        return this.id;
    }
    
    public void setId(SgpActaEstudianteId id) {
        this.id = id;
    }
    public SgpActas getSgpActas() {
        return this.sgpActas;
    }
    
    public void setSgpActas(SgpActas sgpActas) {
        this.sgpActas = sgpActas;
    }
    public int getAceNumeroActa() {
        return this.aceNumeroActa;
    }
    
    public void setAceNumeroActa(int aceNumeroActa) {
        this.aceNumeroActa = aceNumeroActa;
    }
    public String getAceNumeroActaDescripcion() {
        return this.aceNumeroActaDescripcion;
    }
    
    public void setAceNumeroActaDescripcion(String aceNumeroActaDescripcion) {
        this.aceNumeroActaDescripcion = aceNumeroActaDescripcion;
    }
    public int getAceDependenciaId() {
        return this.aceDependenciaId;
    }
    
    public void setAceDependenciaId(int aceDependenciaId) {
        this.aceDependenciaId = aceDependenciaId;
    }
    public String getAceNacionalidad() {
        return this.aceNacionalidad;
    }
    
    public void setAceNacionalidad(String aceNacionalidad) {
        this.aceNacionalidad = aceNacionalidad;
    }
    public String getAceFechaActa() {
        return this.aceFechaActa;
    }
    
    public void setAceFechaActa(String aceFechaActa) {
        this.aceFechaActa = aceFechaActa;
    }
    public int getAceTituloId() {
        return this.aceTituloId;
    }
    
    public void setAceTituloId(int aceTituloId) {
        this.aceTituloId = aceTituloId;
    }
    public String getAceTitulo() {
        return this.aceTitulo;
    }
    
    public void setAceTitulo(String aceTitulo) {
        this.aceTitulo = aceTitulo;
    }
    public String getAceDecanoId() {
        return this.aceDecanoId;
    }
    
    public void setAceDecanoId(String aceDecanoId) {
        this.aceDecanoId = aceDecanoId;
    }
    public String getAceSecretarioAbogId() {
        return this.aceSecretarioAbogId;
    }
    
    public void setAceSecretarioAbogId(String aceSecretarioAbogId) {
        this.aceSecretarioAbogId = aceSecretarioAbogId;
    }
    public Date getAceIniciaEstudios() {
        return this.aceIniciaEstudios;
    }
    
    public void setAceIniciaEstudios(Date aceIniciaEstudios) {
        this.aceIniciaEstudios = aceIniciaEstudios;
    }
    public Date getAceTerminaEstudios() {
        return this.aceTerminaEstudios;
    }
    
    public void setAceTerminaEstudios(Date aceTerminaEstudios) {
        this.aceTerminaEstudios = aceTerminaEstudios;
    }
    public String getAceFechaCompleta() {
        return this.aceFechaCompleta;
    }
    
    public void setAceFechaCompleta(String aceFechaCompleta) {
        this.aceFechaCompleta = aceFechaCompleta;
    }
    public String getAceFormatoImpresion() {
        return this.aceFormatoImpresion;
    }
    
    public void setAceFormatoImpresion(String aceFormatoImpresion) {
        this.aceFormatoImpresion = aceFormatoImpresion;
    }
    public String getAceNombreTesis() {
        return this.aceNombreTesis;
    }
    
    public void setAceNombreTesis(String aceNombreTesis) {
        this.aceNombreTesis = aceNombreTesis;
    }
    public int getAceModalidadId() {
        return this.aceModalidadId;
    }
    
    public void setAceModalidadId(int aceModalidadId) {
        this.aceModalidadId = aceModalidadId;
    }
    public Integer getAceUbicacionId() {
        return this.aceUbicacionId;
    }
    
    public void setAceUbicacionId(Integer aceUbicacionId) {
        this.aceUbicacionId = aceUbicacionId;
    }
    public int getAceDuracion() {
        return this.aceDuracion;
    }
    
    public void setAceDuracion(int aceDuracion) {
        this.aceDuracion = aceDuracion;
    }
    public BigDecimal getAceCreditos() {
        return this.aceCreditos;
    }
    
    public void setAceCreditos(BigDecimal aceCreditos) {
        this.aceCreditos = aceCreditos;
    }
    public BigDecimal getAceTotal() {
        return this.aceTotal;
    }
    
    public void setAceTotal(BigDecimal aceTotal) {
        this.aceTotal = aceTotal;
    }
    public int getAceEquivalenciaId() {
        return this.aceEquivalenciaId;
    }
    
    public void setAceEquivalenciaId(int aceEquivalenciaId) {
        this.aceEquivalenciaId = aceEquivalenciaId;
    }
    public String getAceEstado() {
        return this.aceEstado;
    }
    
    public void setAceEstado(String aceEstado) {
        this.aceEstado = aceEstado;
    }
    public char getAceEstaactivo() {
        return this.aceEstaactivo;
    }
    
    public void setAceEstaactivo(char aceEstaactivo) {
        this.aceEstaactivo = aceEstaactivo;
    }
    public String getAceCreado() {
        return this.aceCreado;
    }
    
    public void setAceCreado(String aceCreado) {
        this.aceCreado = aceCreado;
    }
    public Date getAceFechaCreacion() {
        return this.aceFechaCreacion;
    }
    
    public void setAceFechaCreacion(Date aceFechaCreacion) {
        this.aceFechaCreacion = aceFechaCreacion;
    }
    public String getAceActualizado() {
        return this.aceActualizado;
    }
    
    public void setAceActualizado(String aceActualizado) {
        this.aceActualizado = aceActualizado;
    }
    public Date getAceFechaActualizacion() {
        return this.aceFechaActualizacion;
    }
    
    public void setAceFechaActualizacion(Date aceFechaActualizacion) {
        this.aceFechaActualizacion = aceFechaActualizacion;
    }
    public Set getSgpActaEstudianteDetalles() {
        return this.sgpActaEstudianteDetalles;
    }
    
    public void setSgpActaEstudianteDetalles(Set sgpActaEstudianteDetalles) {
        this.sgpActaEstudianteDetalles = sgpActaEstudianteDetalles;
    }
    public Set getSgpActaAutorizacions() {
        return this.sgpActaAutorizacions;
    }
    
    public void setSgpActaAutorizacions(Set sgpActaAutorizacions) {
        this.sgpActaAutorizacions = sgpActaAutorizacions;
    }

    public int getAceActaId() {
        return aceActaId;
    }

    public void setAceActaId(int aceActaId) {
        this.aceActaId = aceActaId;
    }

}


