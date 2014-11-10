package datos.pojos.sgap;
// Generated 23/04/2012 09:23:45 AM by Hibernate Tools 3.2.1.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SgpComponentes generated by hbm2java
 */
public class SgpComponentes implements java.io.Serializable {

    private Integer id;
    private String nombre;
    private char estaactivo;
    private String creado;
    private Date fechaCreacion;
    private String actualizado;
    private Date fechaActualizacion;
    private Set sgpComponentesDetalleses = new HashSet(0);
    private Set sgpSilaboDetalleses = new HashSet(0);
    //otros
    private boolean _selected = false;

    public SgpComponentes() {
    }

    public SgpComponentes(Integer id, String nombre, char estaactivo, String creado, Date fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
    }

    public SgpComponentes(Integer id, String nombre, char estaactivo, String creado, Date fechaCreacion, String actualizado, Date fechaActualizacion, Set sgpComponentesDetalleses, Set sgpSilaboDetalleses) {
        this.id = id;
        this.nombre = nombre;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
        this.actualizado = actualizado;
        this.fechaActualizacion = fechaActualizacion;
        this.sgpComponentesDetalleses = sgpComponentesDetalleses;
        this.sgpSilaboDetalleses = sgpSilaboDetalleses;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Set getSgpComponentesDetalleses() {
        return this.sgpComponentesDetalleses;
    }

    public void setSgpComponentesDetalleses(Set sgpComponentesDetalleses) {
        this.sgpComponentesDetalleses = sgpComponentesDetalleses;
    }

    public Set getSgpSilaboDetalleses() {
        return this.sgpSilaboDetalleses;
    }

    public void setSgpSilaboDetalleses(Set sgpSilaboDetalleses) {
        this.sgpSilaboDetalleses = sgpSilaboDetalleses;
    }

    public boolean isSelected() {
        return _selected;
    }

    public void setSelected(boolean _selected) {
        this._selected = _selected;
    }
    
}
