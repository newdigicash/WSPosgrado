/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author usuario
 */
public class VstAccesos {
    private String _personaId;
    private Integer _dependenciaId;
    private String _dependenciaNombre;
    private Integer _cursoId;
    private String _cursoNombre;
    private Integer _unidadAcademicaId;
    private String _unidadAcademicaNombre;

    public VstAccesos() {
    }

    public VstAccesos(String _personaId, Integer _dependenciaId, String _dependenciaNombre, Integer _cursoId, String _cursoNombre, Integer _unidadAcademicaId, String _unidadAcademicaNombre) {
        this._personaId = _personaId;
        this._dependenciaId = _dependenciaId;
        this._dependenciaNombre = _dependenciaNombre;
        this._cursoId = _cursoId;
        this._cursoNombre = _cursoNombre;
        this._unidadAcademicaId = _unidadAcademicaId;
        this._unidadAcademicaNombre = _unidadAcademicaNombre;
    }

    public Integer getCursoId() {
        return _cursoId;
    }

    public void setCursoId(Integer _cursoId) {
        this._cursoId = _cursoId;
    }

    public String getCursoNombre() {
        return _cursoNombre;
    }

    public void setCursoNombre(String _cursoNombre) {
        this._cursoNombre = _cursoNombre;
    }

    public Integer getDependenciaId() {
        return _dependenciaId;
    }

    public void setDependenciaId(Integer _dependenciaId) {
        this._dependenciaId = _dependenciaId;
    }

    public String getDependenciaNombre() {
        return _dependenciaNombre;
    }

    public void setDependenciaNombre(String _dependenciaNombre) {
        this._dependenciaNombre = _dependenciaNombre;
    }

    public String getPersonaId() {
        return _personaId;
    }

    public void setPersonaId(String _personaId) {
        this._personaId = _personaId;
    }

    public Integer getUnidadAcademicaId() {
        return _unidadAcademicaId;
    }

    public void setUnidadAcademicaId(Integer _unidadAcademicaId) {
        this._unidadAcademicaId = _unidadAcademicaId;
    }

    public String getUnidadAcademicaNombre() {
        return _unidadAcademicaNombre;
    }

    public void setUnidadAcademicaNombre(String _unidadAcademicaNombre) {
        this._unidadAcademicaNombre = _unidadAcademicaNombre;
    }
    
    
}
