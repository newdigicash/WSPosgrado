package datos.pojos.sgap;
// Generated 23/04/2012 09:23:45 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SgpPresupuestoCabeceras generated by hbm2java
 */
public class SgpPresupuestoCabeceras  implements java.io.Serializable {


     private int id;
     private String nombre;
     private int nivforId;
     private char envigencia;
     private char estaactivo;
     private String creado;
     private Date fechaCreacion;
     private String actualizado;
     private Date fechaActualizacion;
     private Set sgpPresupuestoRubroses = new HashSet(0);

    public SgpPresupuestoCabeceras() {
    }

	
    public SgpPresupuestoCabeceras(int id, String nombre, int nivforId, char envigencia, char estaactivo, String creado, Date fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.nivforId = nivforId;
        this.envigencia = envigencia;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
    }
    public SgpPresupuestoCabeceras(int id, String nombre, int nivforId, char envigencia, char estaactivo, String creado, Date fechaCreacion, String actualizado, Date fechaActualizacion, Set sgpPresupuestoRubroses) {
       this.id = id;
       this.nombre = nombre;
       this.nivforId = nivforId;
       this.envigencia = envigencia;
       this.estaactivo = estaactivo;
       this.creado = creado;
       this.fechaCreacion = fechaCreacion;
       this.actualizado = actualizado;
       this.fechaActualizacion = fechaActualizacion;
       this.sgpPresupuestoRubroses = sgpPresupuestoRubroses;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getNivforId() {
        return this.nivforId;
    }
    
    public void setNivforId(int nivforId) {
        this.nivforId = nivforId;
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
    public Set getSgpPresupuestoRubroses() {
        return this.sgpPresupuestoRubroses;
    }
    
    public void setSgpPresupuestoRubroses(Set sgpPresupuestoRubroses) {
        this.sgpPresupuestoRubroses = sgpPresupuestoRubroses;
    }




}


