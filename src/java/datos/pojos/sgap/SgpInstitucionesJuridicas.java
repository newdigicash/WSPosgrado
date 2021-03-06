package datos.pojos.sgap;
// Generated 24/01/2014 11:30:34 AM by Hibernate Tools 3.2.1.GA

import java.util.Date;

/**
 * SgpInstitucionesJuridicas generated by hbm2java
 */
public class SgpInstitucionesJuridicas implements java.io.Serializable {

    private SgpInstitucionesJuridicasId id;
    private SgpPlanesCurso sgpPlanesCurso;
    private char estaactivo;
    private String creado;
    private Date fechaCreacion;
    private String actualizado;
    private Date fechaActualizacion;
    /*otros*/
    private boolean _selected = false;
    private boolean _guardado = false;
    private String _descripcion="";

    public SgpInstitucionesJuridicas() {
    }

    public SgpInstitucionesJuridicas(SgpInstitucionesJuridicasId id, SgpPlanesCurso sgpPlanesCurso, char estaactivo, String creado, Date fechaCreacion) {
        this.id = id;
        this.sgpPlanesCurso = sgpPlanesCurso;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
    }

    public SgpInstitucionesJuridicas(SgpInstitucionesJuridicasId id, SgpPlanesCurso sgpPlanesCurso, char estaactivo, String creado, Date fechaCreacion, String actualizado, Date fechaActualizacion) {
        this.id = id;
        this.sgpPlanesCurso = sgpPlanesCurso;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
        this.actualizado = actualizado;
        this.fechaActualizacion = fechaActualizacion;
    }

    public SgpInstitucionesJuridicasId getId() {
        return this.id;
    }

    public void setId(SgpInstitucionesJuridicasId id) {
        this.id = id;
    }

    public SgpPlanesCurso getSgpPlanesCurso() {
        return this.sgpPlanesCurso;
    }

    public void setSgpPlanesCurso(SgpPlanesCurso sgpPlanesCurso) {
        this.sgpPlanesCurso = sgpPlanesCurso;
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

    public boolean isSelected() {
        return _selected;
    }

    public void setSelected(boolean _selected) {
        this._selected = _selected;
    }

    public boolean isGuardado() {
        return _guardado;
    }

    public void setGuardado(boolean _guardado) {
        this._guardado = _guardado;
    }

    public String getDescripcion() {
        return _descripcion;
    }

    public void setDescripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    
}
