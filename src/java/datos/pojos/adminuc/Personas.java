package datos.pojos.adminuc;
// Generated 06/12/2011 05:07:25 PM by Hibernate Tools 3.2.1.GA


import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
/**
 * Personas generated by hbm2java
 */
public class Personas  implements java.io.Serializable {


     private String id;
     private String documentoId;
     private String tipdocId;
     private int ubicacId;
     private String direccion;
     private String numeroDireccion;
     private String email;
     private String personeria;
     private String estaactivo;
     private String creado;
     private Date fechaCreacion;
     private String actualizado;
     private Date fechaActualizacion;
     private Set personasNaturaleses = new HashSet(0);
     private List<TelefonosPersonas> telefonosPersonas = new ArrayList<TelefonosPersonas>();
     private String identificacion;

    public Personas() {
    }

	
    public Personas(String id, String documentoId, String tipdocId, int ubicacId, String direccion, String numeroDireccion, String personeria, String estaactivo, String creado, Date fechaCreacion) {
        this.id = id;
        this.documentoId = documentoId;
        this.tipdocId = tipdocId;
        this.ubicacId = ubicacId;
        this.direccion = direccion;
        this.numeroDireccion = numeroDireccion;
        this.personeria = personeria;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
    }
    public Personas(String id, String documentoId, String tipdocId, int ubicacId, String direccion, String numeroDireccion, String email, String personeria, String estaactivo, String creado, Date fechaCreacion, String actualizado, Date fechaActualizacion, Set personasNaturaleses) {
       this.id = id;
       this.documentoId = documentoId;
       this.tipdocId = tipdocId;
       this.ubicacId = ubicacId;
       this.direccion = direccion;
       this.numeroDireccion = numeroDireccion;
       this.email = email;
       this.personeria = personeria;
       this.estaactivo = estaactivo;
       this.creado = creado;
       this.fechaCreacion = fechaCreacion;
       this.actualizado = actualizado;
       this.fechaActualizacion = fechaActualizacion;
       this.personasNaturaleses = personasNaturaleses;
    }
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public String getDocumentoId() {
        return this.documentoId;
    }
    
    public void setDocumentoId(String documentoId) {
        this.documentoId = documentoId;
    }
    public String getTipdocId() {
        return this.tipdocId;
    }
    
    public void setTipdocId(String tipdocId) {
        this.tipdocId = tipdocId;
    }
    public int getUbicacId() {
        return this.ubicacId;
    }
    
    public void setUbicacId(int ubicacId) {
        this.ubicacId = ubicacId;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getNumeroDireccion() {
        return this.numeroDireccion;
    }
    
    public void setNumeroDireccion(String numeroDireccion) {
        this.numeroDireccion = numeroDireccion;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPersoneria() {
        return this.personeria;
    }
    
    public void setPersoneria(String personeria) {
        this.personeria = personeria;
    }
    public String getEstaactivo() {
        return this.estaactivo;
    }
    
    public void setEstaactivo(String estaactivo) {
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
    public Set getPersonasNaturaleses() {
        return this.personasNaturaleses;
    }
    
    public void setPersonasNaturaleses(Set personasNaturaleses) {
        this.personasNaturaleses = personasNaturaleses;
    }

    public List<TelefonosPersonas> getTelefonosPersonas() {
        return telefonosPersonas;
    }

    public void setTelefonosPersonas(List<TelefonosPersonas> telefonosPersonas) {
        this.telefonosPersonas = telefonosPersonas;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }   
    
}


