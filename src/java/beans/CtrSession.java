/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import acceso.Consultas;
import datos.pojos.adminuc.PerNatIdentificacion;
import datos.pojos.adminuc.Personas;
import datos.pojos.adminuc.PersonasNaturales;
import datos.pojos.adminuc.Usuarios;
import datos.pojos.sgap.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import negocio.ParametrosFrames;
import negocio.Pojo;
import negocio.config;
import util.ClaseGeneral;

/**
 * Controlador encargado de almacenar las variables que se pasaran entre los
 * diferentes frames del sistema
 *
 * @author usuario
 */
@ManagedBean
@SessionScoped
public class CtrSession implements Serializable {

    private Usuarios _usuario = null;
    private Personas _persona = null;
    private PersonasNaturales usuarioLogueado;
    private String _personaId = "";
    private String _strTitulo = "Sistema de Gestión Académica Postgrados";
    private String _strTituloMenu = "Sistema de Gestión Académica Postgrados";
    private ParametrosFrames<SgpMallas, SgpMallasId> _paramCtrMallas = new ParametrosFrames<SgpMallas, SgpMallasId>();
    private ParametrosFrames<SgpPlanesCurso, Object> _paramCtrListadoMallas = new ParametrosFrames<SgpPlanesCurso, Object>();
    private ParametrosFrames<SgpMallas, Object> _paramCtrListadoMenciones = new ParametrosFrames<SgpMallas, Object>();
    private ParametrosFrames<SgpMallas, Object> _paramCtrAsignaturasMalla = new ParametrosFrames<SgpMallas, Object>();
    //private ParametrosFrames<SgpMenciones, SgpMencionesId> _paramCtrMenciones = new ParametrosFrames<SgpMenciones, SgpMencionesId>();
    //private ParametrosFrames<SgpMenciones, Object> _paramCtrAsignaturasMencion = new ParametrosFrames<SgpMenciones, Object>();
    //private ParametrosFrames<SgpEdiciones, Object> _paramCtrOfertaCurso = new ParametrosFrames<SgpEdiciones, Object>();
    //private ParametrosFrames<SgpAsignaturas, Object> _paramCtrAsignaturas = new ParametrosFrames<SgpAsignaturas, Object>();
    //private ParametrosFrames<SgpTesis, Object[]> _paramCtrNuevoTrabajoTitulacion = new ParametrosFrames<SgpTesis, Object[]>();
    //private ParametrosFrames<SgpTesisAvance, Object[]> _paramCtrAvanceTrabajoTitulacion = new ParametrosFrames<SgpTesisAvance, Object[]>();
    //private ParametrosFrames<SgpTesisProrroga, Object[]> _paramCtrProrrogaTrabajoTitulacion = new ParametrosFrames<SgpTesisProrroga, Object[]>();
    //private ParametrosFrames<SgpTemas, SgpTemasId> _paramCtrTemas = new ParametrosFrames<SgpTemas, SgpTemasId>();
    private ParametrosFrames<SgpCursosPostgrado, Object> _paramCtrListadoTemas = new ParametrosFrames<SgpCursosPostgrado, Object>();
    private ParametrosFrames<Object, Object> _paramCtrConfigParametro = new ParametrosFrames<Object, Object>();
    private ParametrosFrames<Object, Object> _paramCtrListadoConfigParametro = new ParametrosFrames<Object, Object>();
    private ParametrosFrames<SgpEdiciones, Object> _paramCtrEditarParametro = new ParametrosFrames<SgpEdiciones, Object>();
    private ParametrosFrames<SgpEdiciones, Object> _paramCtrMatricula = new ParametrosFrames<SgpEdiciones, Object>();
    private ParametrosFrames<Object, Object> _paramCtrCalificacionesSecre = new ParametrosFrames<Object, Object>();
    private ParametrosFrames<Object, Object> _paramCtrCalificaciones = new ParametrosFrames<Object, Object>();
    private ParametrosFrames<Object, Object> _paramCtrRecalifRectif = new ParametrosFrames<Object, Object>();
    //private ParametrosFrames<SgpMatriculas, Object> _paramCtrAnularMatricula = new ParametrosFrames<SgpMatriculas, Object>();
    //private ParametrosFrames<Pojo<SgpMatriculas>, PerNatIdentificacion> _paramCtrCambiarGrupo = new ParametrosFrames<Pojo<SgpMatriculas>, PerNatIdentificacion>();
    //private ParametrosFrames<Pojo<SgpMatriculas>, PerNatIdentificacion> _paramCtrConvalidarAsignatura = new ParametrosFrames<Pojo<SgpMatriculas>, PerNatIdentificacion>();
    private ParametrosFrames<Pojo<Object[]>, Object[]> _paramCtrRecuperarAsignatura = new ParametrosFrames<Pojo<Object[]>, Object[]>();
    private ParametrosFrames<SgpFormasEvaluacion, Object> _paramCtrFormaEvaluacion = new ParametrosFrames<SgpFormasEvaluacion, Object>();
    private ParametrosFrames<SgpParametros, Object> _paramCtrParametro = new ParametrosFrames<SgpParametros, Object>();
    //private ParametrosFrames<SgpEjesFormacion, Object> _paramCtrEjeFormacion = new ParametrosFrames<SgpEjesFormacion, Object>();
    //private ParametrosFrames<SgpFinanciamiento, Object> _paramCtrFinanciamiento = new ParametrosFrames<SgpFinanciamiento, Object>();
    //private ParametrosFrames<SgpMallas, SgpAsignaturasMallas> _paramCtrAsignaturasMallaUnidades = new ParametrosFrames<SgpMallas, SgpAsignaturasMallas>();
    private ParametrosFrames<SgpComponentes, Object> _paramCtrComponentes = new ParametrosFrames<SgpComponentes, Object>();
    private ParametrosFrames<SgpParametros, Object> _paramCtrParametros = new ParametrosFrames<SgpParametros, Object>();
    private ParametrosFrames<SgpPlanesCurso, Object> _paramCtrPlanes = new ParametrosFrames<SgpPlanesCurso, Object>();
    private ParametrosFrames<Object, Object> _paramCtrListadoPlanes = new ParametrosFrames<Object, Object>();
    //private ParametrosFrames<Pojo<SgpMatriculas>, PerNatIdentificacion> _paramCtrCompanerosClase = new ParametrosFrames<Pojo<SgpMatriculas>, PerNatIdentificacion>();
    private ParametrosFrames<Object, Object> _paramCtrEdiciones = new ParametrosFrames<Object, Object>();
    private ParametrosFrames<Object, Object> _paramCtrOfertaCarrera = new ParametrosFrames<Object, Object>();
    //private ParametrosFrames<SgpMatriculas, Object> _paramCtrAdicionarAsignaturas = new ParametrosFrames<SgpMatriculas, Object>();
    private ParametrosFrames<Pojo<Object[]>, Object> _paramCtrConfigActa = new ParametrosFrames<Pojo<Object[]>, Object>();
    private ParametrosFrames<SgpCursosPostgrado, SgpEdiciones> _paramCtrCohortes = new ParametrosFrames<SgpCursosPostgrado, SgpEdiciones>();

    public CtrSession() {
    }

    public String cerrarSession() {
        _usuario = null;
        _persona = null;
        ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
        //String ctxPath =((ServletContext) ctx.getContext()).getContextPath();
        ctx.getRequest();
        try {
            // Usar el contexto de JSF para invalidar la sesión,
            // NO EL DE SERVLETS (nada de HttpServletRequest)
            String u = "http://siuc.ucuenca.edu.ec";
            //String u = "http://172.16.1.67";
            FacesContext faces = FacesContext.getCurrentInstance();
            ExternalContext context = faces.getExternalContext();
            //  System.out.println("Redirecciona a: "+url);
            context.redirect(u);
            ((HttpSession) ctx.getSession(false)).invalidate();
            // Redirección de nuevo con el contexto de JSF,
            // si se usa una HttpServletResponse fallará.
            // Sin embargo, como ya está fuera del ciclo de vida
            // de JSF se debe usar la ruta completa -_-U
            faces.responseComplete();
//            ctx.redirect(u);
//            this.processAction();
            //ctx.redirect(ctxPath + "/frmLogin.jsf");
            return "";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }
    //GETTERS Y SETTERS

    public String getUsuarioId() {
        String resultado = "---";
        if (_usuario != null) {
            resultado = _usuario.getLogin();
        }
        return resultado;
    }

    public String getUsuarioNombre() {
        String resultado = "---";
        if (_usuario != null) {
            resultado = _usuario.getNombreCorto();
        }
        return resultado;
    }

    public String getUsuarioNombreHeader() {
        String resultado = getUsuarioNombre();
        if (_persona != null) {
            resultado += " [" + _persona.getEmail() + "]";
        }
        return resultado;
    }

    public String getStrTitulo() {
        return _strTitulo;
    }

    public void setStrTitulo(String _strTitulo) {
        this._strTitulo = _strTitulo;
    }

    public String getStrTituloMenu() {
        return _strTituloMenu;
    }

    public void setStrTituloMenu(String _strTituloMenu) {
        this._strTituloMenu = _strTituloMenu;
    }

    public Usuarios getUsuario() {
        return _usuario;
    }

    public void setUsuario(Usuarios _usuario) {
        this._usuario = _usuario;
    }

    public Personas getPersona() {
        return _persona;
    }

    public void setPersona(Personas _persona) {
        this._persona = _persona;
    }

    public ParametrosFrames<SgpMallas, SgpMallasId> getParamCtrMallas() {
        return _paramCtrMallas;
    }

    public ParametrosFrames<SgpPlanesCurso, Object> getParamCtrListadoMallas() {
        return _paramCtrListadoMallas;
    }

    public ParametrosFrames<SgpMallas, Object> getParamCtrListadoMenciones() {
        return _paramCtrListadoMenciones;
    }

    public ParametrosFrames<SgpMallas, Object> getParamCtrAsignaturasMalla() {
        return _paramCtrAsignaturasMalla;
    }

    /*public ParametrosFrames<SgpMenciones, SgpMencionesId> getParamCtrMenciones() {
        return _paramCtrMenciones;
    }*/

    /*public ParametrosFrames<SgpMenciones, Object> getParamCtrAsignaturasMencion() {
        return _paramCtrAsignaturasMencion;
    }*/

    /*public void setParamCtrAsignaturasMencion(ParametrosFrames<SgpMenciones, Object> _paramCtrAsignaturasMencion) {
        this._paramCtrAsignaturasMencion = _paramCtrAsignaturasMencion;
    }*/

   /*public ParametrosFrames<SgpEdiciones, Object> getParamCtrOfertaCurso() {
        return _paramCtrOfertaCurso;
    }*/

    /*public ParametrosFrames<SgpAsignaturas, Object> getParamCtrAsignaturas() {
        return _paramCtrAsignaturas;
    }*/

    /*public void setParamCtrAsignaturas(ParametrosFrames<SgpAsignaturas, Object> _paramCtrAsignaturas) {
        this._paramCtrAsignaturas = _paramCtrAsignaturas;
    }*/

    /*public ParametrosFrames<SgpTemas, SgpTemasId> getParamCtrTemas() {
        return _paramCtrTemas;
    }*/

    /*public void setParamCtrTemas(ParametrosFrames<SgpTemas, SgpTemasId> _paramCtrTemas) {
        this._paramCtrTemas = _paramCtrTemas;
    }*/

    public ParametrosFrames<SgpCursosPostgrado, Object> getParamCtrListadoTemas() {
        return _paramCtrListadoTemas;
    }

    public void setParamCtrListadoTemas(ParametrosFrames<SgpCursosPostgrado, Object> _paramCtrListadoTemas) {
        this._paramCtrListadoTemas = _paramCtrListadoTemas;
    }

    public ParametrosFrames<Object, Object> getParamCtrConfigParametro() {
        return _paramCtrConfigParametro;
    }

    public void setParamCtrConfigParametro(ParametrosFrames<Object, Object> _paramCtrConfigParametro) {
        this._paramCtrConfigParametro = _paramCtrConfigParametro;
    }

    public ParametrosFrames<Object, Object> getParamCtrListadoConfigParametro() {
        return _paramCtrListadoConfigParametro;
    }

    public void setParamCtrListadoConfigParametro(ParametrosFrames<Object, Object> _paramCtrListadoConfigParametro) {
        this._paramCtrListadoConfigParametro = _paramCtrListadoConfigParametro;
    }

    public ParametrosFrames<SgpEdiciones, Object> getParamCtrMatricula() {
        return _paramCtrMatricula;
    }

    public void setParamCtrMatricula(ParametrosFrames<SgpEdiciones, Object> _paramCtrMatricula) {
        this._paramCtrMatricula = _paramCtrMatricula;
    }

    /*public ParametrosFrames<SgpMatriculas, Object> getParamCtrAnularMatricula() {
        return _paramCtrAnularMatricula;
    }*/
    /*public void setParamCtrAnularMatricula(ParametrosFrames<SgpMatriculas, Object> _paramCtrAnularMatricula) {
        this._paramCtrAnularMatricula = _paramCtrAnularMatricula;
    }*/

    /*public ParametrosFrames<Pojo<SgpMatriculas>, PerNatIdentificacion> getParamCtrCambiarGrupo() {
        return _paramCtrCambiarGrupo;
    }*/

   /* public void setParamCtrCambiarGrupo(ParametrosFrames<Pojo<SgpMatriculas>, PerNatIdentificacion> _paramCtrCambiarGrupo) {
        this._paramCtrCambiarGrupo = _paramCtrCambiarGrupo;
    }*/

    public ParametrosFrames<SgpEdiciones, Object> getParamCtrEditarParametro() {
        return _paramCtrEditarParametro;
    }

    public void setParamCtrEditarParametro(ParametrosFrames<SgpEdiciones, Object> _paramCtrEditarParametro) {
        this._paramCtrEditarParametro = _paramCtrEditarParametro;
    }

    public ParametrosFrames<Object, Object> getParamCtrCalificaciones() {
        return _paramCtrCalificaciones;
    }

    public void setParamCtrCalificaciones(ParametrosFrames<Object, Object> _paramCtrCalificaciones) {
        this._paramCtrCalificaciones = _paramCtrCalificaciones;
    }

    public ParametrosFrames<Object, Object> getParamCtrCalificacionesSecre() {
        return _paramCtrCalificacionesSecre;
    }

    public void setParamCtrCalificacionesSecre(ParametrosFrames<Object, Object> _paramCtrCalificacionesSecre) {
        this._paramCtrCalificacionesSecre = _paramCtrCalificacionesSecre;
    }

    /*public ParametrosFrames<Pojo<SgpMatriculas>, PerNatIdentificacion> getParamCtrConvalidarAsignatura() {
        return _paramCtrConvalidarAsignatura;
    }*/

    /*public void setParamCtrConvalidarAsignatura(ParametrosFrames<Pojo<SgpMatriculas>, PerNatIdentificacion> _paramCtrConvalidarAsignatura) {
        this._paramCtrConvalidarAsignatura = _paramCtrConvalidarAsignatura;
    }*/

    public ParametrosFrames<Object, Object> getParamCtrRecalifRectif() {
        return _paramCtrRecalifRectif;
    }

    public void setParamCtrRecalifRectif(ParametrosFrames<Object, Object> _paramCtrRecalifRectif) {
        this._paramCtrRecalifRectif = _paramCtrRecalifRectif;
    }

    public ParametrosFrames<Pojo<Object[]>, Object[]> getParamCtrRecuperarAsignatura() {
        return _paramCtrRecuperarAsignatura;
    }

    public void setParamCtrRecuperarAsignatura(ParametrosFrames<Pojo<Object[]>, Object[]> _paramCtrRecuperarAsignatura) {
        this._paramCtrRecuperarAsignatura = _paramCtrRecuperarAsignatura;
    }

    public ParametrosFrames<SgpFormasEvaluacion, Object> getParamCtrFormaEvaluacion() {
        return _paramCtrFormaEvaluacion;
    }

    public void setParamCtrFormaEvaluacion(ParametrosFrames<SgpFormasEvaluacion, Object> _paramCtrFormaEvaluacion) {
        this._paramCtrFormaEvaluacion = _paramCtrFormaEvaluacion;
    }

  public ParametrosFrames<SgpParametros, Object> getParamCtrParametro() {
    return _paramCtrParametro;
  }

  public void setParamCtrParametro(ParametrosFrames<SgpParametros, Object> _paramCtrParametro) {
    this._paramCtrParametro = _paramCtrParametro;
  }

  /*public ParametrosFrames<SgpEjesFormacion, Object> getParamCtrEjeFormacion() {
    return _paramCtrEjeFormacion;
  }*/

  /*public void setParamCtrEjeFormacion(ParametrosFrames<SgpEjesFormacion, Object> _paramCtrEjeFormacion) {
    this._paramCtrEjeFormacion = _paramCtrEjeFormacion;
  }*/
  
  
  
  
   
    //----funcion para convertir el S o N a SI o NO
    public String sn(Character sn) {
        if (sn == null) {
            return "";
        } else if (sn == 'S') {
            return "SI";
        } else if (sn == 'N') {
            return "NO";
        } else {
            return "";
        }
    }

    //----------parametros
    public String configurablex(String sn) {
        if (sn == null) {
            return "";
        } else if (sn.equals("NVR")) {
            return "UNIVERSIDAD";
        } else if (sn.equals("CCR")) {
            return "CARRERA";
        } else {
            return "";
        }

    }

    /*public ParametrosFrames<SgpMallas, SgpAsignaturasMallas> getParamCtrAsignaturasMallaUnidades() {
        return _paramCtrAsignaturasMallaUnidades;
    }*/

    /*public void setParamCtrAsignaturasMallaUnidades(ParametrosFrames<SgpMallas, SgpAsignaturasMallas> paramCtrAsignaturasMallaUnidades) {
        this._paramCtrAsignaturasMallaUnidades = paramCtrAsignaturasMallaUnidades;
    }*/

    public ParametrosFrames<SgpComponentes, Object> getParamCtrComponentes() {
        return _paramCtrComponentes;
    }

    public void setParamCtrComponentes(ParametrosFrames<SgpComponentes, Object> _paramCtrComponentes) {
        this._paramCtrComponentes = _paramCtrComponentes;
    }

    public ParametrosFrames<SgpParametros, Object> getParamCtrParametros() {
        return _paramCtrParametros;
    }

    public void setParamCtrParametros(ParametrosFrames<SgpParametros, Object> _paramCtrParametros) {
        this._paramCtrParametros = _paramCtrParametros;
    }

    public PersonasNaturales getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public void setUsuarioLogueado(PersonasNaturales usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
    }

    public String getPersonaId() {
        return _personaId;
    }

    public void setPersonaId(String _personaId) {
        this._personaId = _personaId;
    }

    public ParametrosFrames<SgpPlanesCurso, Object> getParamCtrPlanes() {
        return _paramCtrPlanes;
    }

    public void setParamCtrPlanes(ParametrosFrames<SgpPlanesCurso, Object> _paramCtrPlanes) {
        this._paramCtrPlanes = _paramCtrPlanes;
    }

    public ParametrosFrames<Object, Object> getParamCtrListadoPlanes() {
        return _paramCtrListadoPlanes;
    }

    public void setParamCtrListadoPlanes(ParametrosFrames<Object, Object> _paramCtrListadoPlanes) {
        this._paramCtrListadoPlanes = _paramCtrListadoPlanes;
    }

    /*public ParametrosFrames<Pojo<SgpMatriculas>, PerNatIdentificacion> getParamCtrCompanerosClase() {
        return _paramCtrCompanerosClase;
    }*/

    /*public void setParamCtrCompanerosClase(ParametrosFrames<Pojo<SgpMatriculas>, PerNatIdentificacion> _paramCtrCompanerosClase) {
        this._paramCtrCompanerosClase = _paramCtrCompanerosClase;
    }*/

    public ParametrosFrames<Object, Object> getParamCtrEdiciones() {
        return _paramCtrEdiciones;
    }

    public void setParamCtrEdiciones(ParametrosFrames<Object, Object> _paramCtrEdiciones) {
        this._paramCtrEdiciones = _paramCtrEdiciones;
    }

    public ParametrosFrames<Object, Object> getParamCtrOfertaCarrera() {
        return _paramCtrOfertaCarrera;
    }

    public void setParamCtrOfertaCarrera(ParametrosFrames<Object, Object> _paramCtrOfertaCarrera) {
        this._paramCtrOfertaCarrera = _paramCtrOfertaCarrera;
    }

    /*public ParametrosFrames<SgpMatriculas, Object> getParamCtrAdicionarAsignaturas() {
        return _paramCtrAdicionarAsignaturas;
    }*/

    /*public void setParamCtrAdicionarAsignaturas(ParametrosFrames<SgpMatriculas, Object> _paramCtrAdicionarAsignaturas) {
        this._paramCtrAdicionarAsignaturas = _paramCtrAdicionarAsignaturas;
    }*/

    public ParametrosFrames<Pojo<Object[]>, Object> getParamCtrConfigActa() {
        return _paramCtrConfigActa;
    }

    public void setParamCtrConfigActa(ParametrosFrames<Pojo<Object[]>, Object> _paramCtrConfigActa) {
        this._paramCtrConfigActa = _paramCtrConfigActa;
    }    

    public ParametrosFrames<SgpCursosPostgrado, SgpEdiciones> getParamCtrCohortes() {
        return _paramCtrCohortes;
    }

    public void setParamCtrCohortes(ParametrosFrames<SgpCursosPostgrado, SgpEdiciones> _paramCtrCohortes) {
        this._paramCtrCohortes = _paramCtrCohortes;
    }

    /*public ParametrosFrames<SgpTesis, Object[]> getParamCtrNuevoTrabajoTitulacion() {
        return _paramCtrNuevoTrabajoTitulacion;
    }*/

    /*public void setParamCtrNuevoTrabajoTitulacion(ParametrosFrames<SgpTesis, Object[]> _paramCtrNuevoTrabajoTitulacion) {
        this._paramCtrNuevoTrabajoTitulacion = _paramCtrNuevoTrabajoTitulacion;
    }*/

    /*public ParametrosFrames<SgpTesisAvance, Object[]> getParamCtrAvanceTrabajoTitulacion() {
        return _paramCtrAvanceTrabajoTitulacion;
    }*/

    /*public void setParamCtrAvanceTrabajoTitulacion(ParametrosFrames<SgpTesisAvance, Object[]> _paramCtrAvanceTrabajoTitulacion) {
        this._paramCtrAvanceTrabajoTitulacion = _paramCtrAvanceTrabajoTitulacion;
    }*/

    /*public ParametrosFrames<SgpTesisProrroga, Object[]> getParamCtrProrrogaTrabajoTitulacion() {
        return _paramCtrProrrogaTrabajoTitulacion;
    }*/

    /*public void setParamCtrProrrogaTrabajoTitulacion(ParametrosFrames<SgpTesisProrroga, Object[]> _paramCtrProrrogaTrabajoTitulacion) {
        this._paramCtrProrrogaTrabajoTitulacion = _paramCtrProrrogaTrabajoTitulacion;
    }*/

  /*public ParametrosFrames<SgpFinanciamiento, Object> getParamCtrFinanciamiento() {
    return _paramCtrFinanciamiento;
  }*/

  /*public void setParamCtrFinanciamiento(ParametrosFrames<SgpFinanciamiento, Object> _paramCtrFinanciamiento) {
    this._paramCtrFinanciamiento = _paramCtrFinanciamiento;
  }*/
    
    
}
