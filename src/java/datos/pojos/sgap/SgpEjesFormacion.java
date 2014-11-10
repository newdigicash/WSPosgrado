package datos.pojos.sgap;
// Generated 23/04/2012 09:23:45 AM by Hibernate Tools 3.2.1.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SgpEjesFormacion generated by hbm2java
 */
public class SgpEjesFormacion implements java.io.Serializable {

    private int id;
    private String nombre;
    private String abreviatura;
    private String color;
    private char estaactivo;
    private String creado;
    private Date fechaCreacion;
    private String actualizado;
    private Date fechaActualizacion;
    private Set sgpAsignaturasMallases = new HashSet(0);
    private Set sgpAsignaturases = new HashSet(0);

    public SgpEjesFormacion() {
    }

    public SgpEjesFormacion(int id) {
        this.id = id;
    }

    
    public SgpEjesFormacion(int id, String nombre, String abreviatura, char estaactivo, String creado, Date fechaCreacion, String actualizado) {
        this.id = id;
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
        this.actualizado = actualizado;
    }

    public SgpEjesFormacion(int id, String nombre, String abreviatura, String color, char estaactivo, String creado, Date fechaCreacion, String actualizado, Date fechaActualizacion, Set sgpAsignaturasMallases) {
        this.id = id;
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.color = color;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
        this.actualizado = actualizado;
        this.fechaActualizacion = fechaActualizacion;
        this.sgpAsignaturasMallases = sgpAsignaturasMallases;
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

    public String getAbreviatura() {
        return this.abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public Set getSgpAsignaturasMallases() {
        return this.sgpAsignaturasMallases;
    }

    public void setSgpAsignaturasMallases(Set sgpAsignaturasMallases) {
        this.sgpAsignaturasMallases = sgpAsignaturasMallases;
    }

    public Set getSgpAsignaturases() {
        return sgpAsignaturases;
    }

    public void setSgpAsignaturases(Set sgpAsignaturases) {
        this.sgpAsignaturases = sgpAsignaturases;
    }

  
}
