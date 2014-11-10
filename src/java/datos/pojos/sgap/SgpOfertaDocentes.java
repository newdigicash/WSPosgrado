package datos.pojos.sgap;
// Generated 23/04/2012 09:23:45 AM by Hibernate Tools 3.2.1.GA

import java.util.Date;

/**
 * SgpOfertaDocentes generated by hbm2java
 */
public class SgpOfertaDocentes implements java.io.Serializable {

    private SgpOfertaDocentesId id;
    private SgpOfertaAsignatura sgpOfertaAsignatura;
    private String personaId;
    private char esprincipal;
    private char estaactivo;
    private String creado;
    private Date fechaCreacion;
    private String actualizado;
    private Date fechaActualizacion;
    /*
     * Principal
     */
    private Boolean estaGuardado;
    private Boolean opcionPrincipal;
    //private Boolean opcionEliminar;
    private String nombres;
    private String apellidos;
    private String identificacion;
    private String principal;
    /*
     * ROW SELECTOR DE HORARIOS DOCENTES
     */
    private boolean _selected = false;

    public SgpOfertaDocentes() {
    }

    public SgpOfertaDocentes(SgpOfertaDocentesId id, SgpOfertaAsignatura sgpOfertaAsignatura, String personaId, char esprincipal, char estaactivo, String creado, Date fechaCreacion) {
        this.id = id;
        this.sgpOfertaAsignatura = sgpOfertaAsignatura;
        this.personaId = personaId;
        this.esprincipal = esprincipal;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
    }

    public SgpOfertaDocentes(SgpOfertaDocentesId id, SgpOfertaAsignatura sgpOfertaAsignatura, String personaId, char esprincipal, char estaactivo, String creado, Date fechaCreacion, String actualizado, Date fechaActualizacion) {
        this.id = id;
        this.sgpOfertaAsignatura = sgpOfertaAsignatura;
        this.personaId = personaId;
        this.esprincipal = esprincipal;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
        this.actualizado = actualizado;
        this.fechaActualizacion = fechaActualizacion;
    }

    public SgpOfertaDocentesId getId() {
        return this.id;
    }

    public void setId(SgpOfertaDocentesId id) {
        this.id = id;
    }

    public SgpOfertaAsignatura getSgpOfertaAsignatura() {
        return this.sgpOfertaAsignatura;
    }

    public void setSgpOfertaAsignatura(SgpOfertaAsignatura sgpOfertaAsignatura) {
        this.sgpOfertaAsignatura = sgpOfertaAsignatura;
    }

    public String getPersonaId() {
        return this.personaId;
    }

    public void setPersonaId(String personaId) {
        this.personaId = personaId;
    }

    public char getEsprincipal() {
        return this.esprincipal;
    }

    public void setEsprincipal(char esprincipal) {
        this.esprincipal = esprincipal;
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
    
    /*Campos Adicionados*/

    public boolean isSelected() {
        return _selected;
    }

    public void setSelected(boolean _selected) {
        this._selected = _selected;
    }

    public Boolean getEstaGuardado() {
        return estaGuardado;
    }

    public void setEstaGuardado(Boolean estaGuardado) {
        this.estaGuardado = estaGuardado;
    }

//    public Boolean getOpcionEliminar() {
//        return opcionEliminar;
//    }
//
//    public void setOpcionEliminar(Boolean opcionEliminar) {
//        this.opcionEliminar = opcionEliminar;
//    }

    public Boolean getOpcionPrincipal() {
        return opcionPrincipal;
    }

    public void setOpcionPrincipal(Boolean opcionPrincipal) {
        this.opcionPrincipal = opcionPrincipal;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }   
    
}
