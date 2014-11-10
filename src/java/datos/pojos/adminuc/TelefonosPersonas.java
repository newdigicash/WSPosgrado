package datos.pojos.adminuc;
// Generated 11-jul-2011 8:26:19 by Hibernate Tools 3.2.1.GA

import java.util.Date;

/**
 * SgiRubrosPresupuestos generated by hbm2java
 */
public class TelefonosPersonas implements java.io.Serializable {

    private int id;
    private String numeroTelefono;
    private String estaactivo;
    private String creado;
    private Date fechaCreacion;
    private String actualizado;
    private Date fechaActualizacion;
    private TiposTelefonos tiposTelefonos;
    private Personas personas;
    private boolean seleccionado = false;
    /*otro*/
    private String _tipTelefono="";

    public TelefonosPersonas() {
    }

    public TelefonosPersonas(int id) {
        this.id = id;
    }

    public TelefonosPersonas(int id, String numeroTelefono, String estaactivo, String creado, Date fechaCreacion, String actualizado, Date fechaActualizacion, TiposTelefonos tiposTelefonos, Personas personas) {
        this.id = id;
        this.numeroTelefono = numeroTelefono;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
        this.actualizado = actualizado;
        this.fechaActualizacion = fechaActualizacion;
        this.tiposTelefonos = tiposTelefonos;
        this.personas = personas;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActualizado() {
        return actualizado;
    }

    public void setActualizado(String actualizado) {
        this.actualizado = actualizado;
    }

    public String getCreado() {
        return creado;
    }

    public void setCreado(String creado) {
        this.creado = creado;
    }

    public String getEstaactivo() {
        return estaactivo;
    }

    public void setEstaactivo(String estaactivo) {
        this.estaactivo = estaactivo;
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

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public TiposTelefonos getTiposTelefonos() {
        return tiposTelefonos;
    }

    public void setTiposTelefonos(TiposTelefonos tiposTelefonos) {
        this.tiposTelefonos = tiposTelefonos;
    }

    public Personas getPersonas() {
        return personas;
    }

    public void setPersonas(Personas personas) {
        this.personas = personas;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public String getTipTelefono() {
        return _tipTelefono;
    }

    public void setTipTelefono(String _tipTelefono) {
        this._tipTelefono = _tipTelefono;
    }
    
    
}