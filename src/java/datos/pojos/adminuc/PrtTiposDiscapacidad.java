package datos.pojos.adminuc;
// Generated 16/01/2012 05:31:57 PM by Hibernate Tools 3.2.1.GA

import java.util.Date;

/**
 * PrtTiposDiscapacidad generated by hbm2java
 */
public class PrtTiposDiscapacidad implements java.io.Serializable {

    private int id;
    private String nombre;
    private String descripcion;
    private char estaactivo;
    private char especifique;
    private String creado;
    private Date fechaCreacion;
    private String actualizado;
    private Date fechaActualizacion;

    public PrtTiposDiscapacidad() {
    }

    public PrtTiposDiscapacidad(int id, String nombre, char estaactivo, String creado, Date fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
    }

    public PrtTiposDiscapacidad(int id, String nombre, String descripcion, char estaactivo, String creado, Date fechaCreacion, String actualizado, Date fechaActualizacion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public char getEspecifique() {
        return especifique;
    }

    public void setEspecifique(char especifique) {
        this.especifique = especifique;
    }
}