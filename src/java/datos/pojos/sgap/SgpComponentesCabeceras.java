package datos.pojos.sgap;
// Generated 23/04/2012 09:23:45 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SgpComponentesCabeceras generated by hbm2java
 */
public class SgpComponentesCabeceras  implements java.io.Serializable {


     private int id;
     private int nivforId;
     private String nombre;
     private char envigencia;
     private char estaactivo;
     private String creado;
     private Date fechaCreacion;
     private String atualizado;
     private Date fechaActualizacion;
     private Set sgpComponentesDetalleses = new HashSet(0);
     private Set sgpPlanesCursos = new HashSet(0);

    public SgpComponentesCabeceras() {
    }

	
    public SgpComponentesCabeceras(int id, int nivforId, String nombre, char envigencia, char estaactivo, String creado, Date fechaCreacion) {
        this.id = id;
        this.nivforId = nivforId;
        this.nombre = nombre;
        this.envigencia = envigencia;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
    }
    public SgpComponentesCabeceras(int id, int nivforId, String nombre, char envigencia, char estaactivo, String creado, Date fechaCreacion, String atualizado, Date fechaActualizacion, Set sgpComponentesDetalleses, Set sgpPlanesCursos) {
       this.id = id;
       this.nivforId = nivforId;
       this.nombre = nombre;
       this.envigencia = envigencia;
       this.estaactivo = estaactivo;
       this.creado = creado;
       this.fechaCreacion = fechaCreacion;
       this.atualizado = atualizado;
       this.fechaActualizacion = fechaActualizacion;
       this.sgpComponentesDetalleses = sgpComponentesDetalleses;
       this.sgpPlanesCursos = sgpPlanesCursos;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public int getNivforId() {
        return this.nivforId;
    }
    
    public void setNivforId(int nivforId) {
        this.nivforId = nivforId;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public char getEnvigencia() {
        return this.envigencia;
    }
    
    public void setEnvigencia(char envigencia) {
        this.envigencia = envigencia;
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
    public String getAtualizado() {
        return this.atualizado;
    }
    
    public void setAtualizado(String atualizado) {
        this.atualizado = atualizado;
    }
    public Date getFechaActualizacion() {
        return this.fechaActualizacion;
    }
    
    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
    public Set getSgpComponentesDetalleses() {
        return this.sgpComponentesDetalleses;
    }
    
    public void setSgpComponentesDetalleses(Set sgpComponentesDetalleses) {
        this.sgpComponentesDetalleses = sgpComponentesDetalleses;
    }
    public Set getSgpPlanesCursos() {
        return this.sgpPlanesCursos;
    }
    
    public void setSgpPlanesCursos(Set sgpPlanesCursos) {
        this.sgpPlanesCursos = sgpPlanesCursos;
    }




}


