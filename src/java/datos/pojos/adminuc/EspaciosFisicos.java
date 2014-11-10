/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.pojos.adminuc;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author usuario
 */
public class EspaciosFisicos {

    private int id;
    private String nombre;
    private String abreviatura;
    private int tipespId;
    private int capacidad;
    private Dependencias dependencia;
    private int bloqueId;
    private BigDecimal area;
    private int piso;
    private char esApto;
    private String observaciones;
    private char estado;
    private char estaactivo;
    private String creado;
    private Date fechaCreacion;
    private String actualizado;
    private Date fechaActualizacion;
    /*Selector*/
    private boolean _selected = false;

    public EspaciosFisicos() {
    }

    public EspaciosFisicos(int id, String nombre, String abreviatura, int tipespId, int capacidad, Dependencias dependencia, int bloqueId, BigDecimal area, int piso, char esApto, String observaciones, char estado, char estaactivo, String creado, Date fechaCreacion, String actualizado, Date fechaActualizacion) {
        this.id = id;
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.tipespId = tipespId;
        this.capacidad = capacidad;
        this.dependencia = dependencia;
        this.bloqueId = bloqueId;
        this.area = area;
        this.piso = piso;
        this.esApto = esApto;
        this.observaciones = observaciones;
        this.estado = estado;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
        this.actualizado = actualizado;
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getActualizado() {
        return actualizado;
    }

    public void setActualizado(String actualizado) {
        this.actualizado = actualizado;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public int getBloqueId() {
        return bloqueId;
    }

    public void setBloqueId(int bloqueId) {
        this.bloqueId = bloqueId;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getCreado() {
        return creado;
    }

    public void setCreado(String creado) {
        this.creado = creado;
    }

    public Dependencias getDependencia() {
        return dependencia;
    }

    public void setDependencia(Dependencias dependencia) {
        this.dependencia = dependencia;
    }

    public char getEsApto() {
        return esApto;
    }

    public void setEsApto(char esApto) {
        this.esApto = esApto;
    }

    public char getEstaactivo() {
        return estaactivo;
    }

    public void setEstaactivo(char estaactivo) {
        this.estaactivo = estaactivo;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getTipespId() {
        return tipespId;
    }

    public void setTipespId(int tipespId) {
        this.tipespId = tipespId;
    }
    /*Selector*/

    public boolean isSelected() {
        return _selected;
    }

    public void setSelected(boolean _selected) {
        this._selected = _selected;
    }
    
}
