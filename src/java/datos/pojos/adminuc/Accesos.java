package datos.pojos.adminuc;
// Generated 24/02/2012 03:32:41 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Accesos generated by hbm2java
 */
public class Accesos  implements java.io.Serializable {


     private int id;
     private RolesUsuarios rolesUsuarios;
     private int dependenciaId;
     private Integer carreraId;
     private char estaactivo;
     private String creado;
     private Date fechaCreacion;
     private String actualizado;
     private Date fechaActualizacion;
     public DefaultMutableTreeNode Nodo;

    public Accesos() {
    }

	
    public Accesos(int id, RolesUsuarios rolesUsuarios, int dependenciaId, char estaactivo, String creado) {
        this.id = id;
        this.rolesUsuarios = rolesUsuarios;
        this.dependenciaId = dependenciaId;
        this.estaactivo = estaactivo;
        this.creado = creado;
    }
    public Accesos(int id, RolesUsuarios rolesUsuarios, int dependenciaId, Integer carreraId, char estaactivo, String creado, Date fechaCreacion, String actualizado, Date fechaActualizacion) {
       this.id = id;
       this.rolesUsuarios = rolesUsuarios;
       this.dependenciaId = dependenciaId;
       this.carreraId = carreraId;
       this.estaactivo = estaactivo;
       this.creado = creado;
       this.fechaCreacion = fechaCreacion;
       this.actualizado = actualizado;
       this.fechaActualizacion = fechaActualizacion;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public RolesUsuarios getRolesUsuarios() {
        return this.rolesUsuarios;
    }
    
    public void setRolesUsuarios(RolesUsuarios rolesUsuarios) {
        this.rolesUsuarios = rolesUsuarios;
    }
    public int getDependenciaId() {
        return this.dependenciaId;
    }
    
    public void setDependenciaId(int dependenciaId) {
        this.dependenciaId = dependenciaId;
    }
    public Integer getCarreraId() {
        return this.carreraId;
    }
    
    public void setCarreraId(Integer carreraId) {
        this.carreraId = carreraId;
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

    public DefaultMutableTreeNode getNodo() {
        return Nodo;
    }

    public void setNodo(DefaultMutableTreeNode Nodo) {
        this.Nodo = Nodo;
    }




}


