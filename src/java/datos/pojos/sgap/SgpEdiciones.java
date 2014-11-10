package datos.pojos.sgap;
// Generated 23/04/2012 09:23:45 AM by Hibernate Tools 3.2.1.GA

//import datos.pojos.sgse.AmbitosServicios;
import ec.edu.ucuenca.gestionse.accesoDatos.modelo.AmbitosServicios;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SgpEdiciones generated by hbm2java
 */
public class SgpEdiciones implements java.io.Serializable {

    private SgpEdicionesId id;
    private SgpDocumentosBinarios sgpDocumentosBinariosByProyectoPdf;
    private SgpAutorizaciones sgpAutorizaciones;
    private SgpDocumentosBinarios sgpDocumentosBinariosByVistoBuenoPdf;
    private SgpMallas sgpMallas;
    private SgpDocumentosBinarios sgpDocumentosBinariosByProyectoPublicoPdf;
    private SgpSecciones sgpSecciones;
    private AmbitosServicios ambitosServicios;
    //private int placurId;
    private int perlecId;
    private String nombreEdicion;
    private int minimoEstudiantes;
    private int nroParalelos;
    private int maxEstudiantesParalelo;
    private int duracion;
    private double costo;
    private String estado;
    //private int ambserId;
    private char autorizado;
    private char estaactivo;
    private String creado;
    private Date fechaCreacion;
    private String actualizado;
    private Date fechaActualizacion;
    private Set sgpCursosEstudianteses = new HashSet(0);
    private Set sgpPresupuestoValoreses = new HashSet(0);
    private Set sgpEquipoResponsables = new HashSet(0);
    private Set sgpOfertaAsignaturas = new HashSet(0);
    private Set sgpDirectoresCursos = new HashSet(0);
    private Set sgpSilaboses = new HashSet(0);
    private Set sgpParametrosCursos = new HashSet(0);
    private Date fechaAprobacion;
    private Integer ambserId2;
    private Integer ambserId3;
    private Integer ambserId4;
    private Integer ambserId5;
    
    // prueba
    
      private int  idEd;

    public SgpEdiciones() {
    }

    public SgpEdiciones(SgpEdicionesId id, SgpDocumentosBinarios sgpDocumentosBinariosByProyectoPdf, SgpAutorizaciones sgpAutorizaciones, SgpDocumentosBinarios sgpDocumentosBinariosByVistoBuenoPdf, SgpMallas sgpMallas, SgpDocumentosBinarios sgpDocumentosBinariosByProyectoPublicoPdf, SgpSecciones sgpSecciones, AmbitosServicios ambitosServicios, /*
             * int placurId,
             */ int perlecId, String nombreEdicion, int minimoEstudiantes, int nroParalelos, int maxEstudiantesParalelo, int duracion, double costo, String estado, /*
             * int ambserId,
             */ char autorizado, char estaactivo, String creado, Date fechaCreacion) {
        this.id = id;
        this.sgpDocumentosBinariosByProyectoPdf = sgpDocumentosBinariosByProyectoPdf;
        this.sgpAutorizaciones = sgpAutorizaciones;
        this.sgpDocumentosBinariosByVistoBuenoPdf = sgpDocumentosBinariosByVistoBuenoPdf;
        this.sgpMallas = sgpMallas;
        this.sgpDocumentosBinariosByProyectoPublicoPdf = sgpDocumentosBinariosByProyectoPublicoPdf;
        this.sgpSecciones = sgpSecciones;
        this.ambitosServicios = ambitosServicios;
        this.perlecId = perlecId;
        this.nombreEdicion = nombreEdicion;
        this.minimoEstudiantes = minimoEstudiantes;
        this.nroParalelos = nroParalelos;
        this.maxEstudiantesParalelo = maxEstudiantesParalelo;
        this.duracion = duracion;
        this.costo = costo;
        this.estado = estado;
        this.autorizado = autorizado;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
    }

    public SgpEdiciones(SgpEdicionesId id, SgpDocumentosBinarios sgpDocumentosBinariosByProyectoPdf, SgpAutorizaciones sgpAutorizaciones, SgpDocumentosBinarios sgpDocumentosBinariosByVistoBuenoPdf, SgpMallas sgpMallas, SgpDocumentosBinarios sgpDocumentosBinariosByProyectoPublicoPdf, SgpSecciones sgpSecciones, AmbitosServicios ambitosServicios,
            int perlecId, String nombreEdicion, int minimoEstudiantes, int nroParalelos, int maxEstudiantesParalelo, int duracion, double costo, String estado,
            char autorizado, char estaactivo, String creado, Date fechaCreacion, String actualizado, Date fechaActualizacion, Set sgpCursosEstudianteses, Set sgpPresupuestoValoreses, Set sgpEquipoResponsables, Set sgpOfertaAsignaturas, Set sgpDirectoresCursos, Set sgpSilaboses) {
        this.id = id;
        this.sgpDocumentosBinariosByProyectoPdf = sgpDocumentosBinariosByProyectoPdf;
        this.sgpAutorizaciones = sgpAutorizaciones;
        this.sgpDocumentosBinariosByVistoBuenoPdf = sgpDocumentosBinariosByVistoBuenoPdf;
        this.sgpMallas = sgpMallas;
        this.sgpDocumentosBinariosByProyectoPublicoPdf = sgpDocumentosBinariosByProyectoPublicoPdf;
        this.sgpSecciones = sgpSecciones;
        this.ambitosServicios = ambitosServicios;
        this.perlecId = perlecId;
        this.nombreEdicion = nombreEdicion;
        this.minimoEstudiantes = minimoEstudiantes;
        this.nroParalelos = nroParalelos;
        this.maxEstudiantesParalelo = maxEstudiantesParalelo;
        this.duracion = duracion;
        this.costo = costo;
        this.estado = estado;
        this.autorizado = autorizado;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
        this.actualizado = actualizado;
        this.fechaActualizacion = fechaActualizacion;
        this.sgpCursosEstudianteses = sgpCursosEstudianteses;
        this.sgpPresupuestoValoreses = sgpPresupuestoValoreses;
        this.sgpEquipoResponsables = sgpEquipoResponsables;
        this.sgpOfertaAsignaturas = sgpOfertaAsignaturas;
        this.sgpDirectoresCursos = sgpDirectoresCursos;
        this.sgpSilaboses = sgpSilaboses;
    }

    public SgpEdicionesId getId() {
        return this.id;
    }

    public void setId(SgpEdicionesId id) {
        this.id = id;
    }

    public SgpDocumentosBinarios getSgpDocumentosBinariosByProyectoPdf() {
        return this.sgpDocumentosBinariosByProyectoPdf;
    }

    public void setSgpDocumentosBinariosByProyectoPdf(SgpDocumentosBinarios sgpDocumentosBinariosByProyectoPdf) {
        this.sgpDocumentosBinariosByProyectoPdf = sgpDocumentosBinariosByProyectoPdf;
    }

    public SgpAutorizaciones getSgpAutorizaciones() {
        return this.sgpAutorizaciones;
    }

    public void setSgpAutorizaciones(SgpAutorizaciones sgpAutorizaciones) {
        this.sgpAutorizaciones = sgpAutorizaciones;
    }

    public SgpDocumentosBinarios getSgpDocumentosBinariosByVistoBuenoPdf() {
        return this.sgpDocumentosBinariosByVistoBuenoPdf;
    }

    public void setSgpDocumentosBinariosByVistoBuenoPdf(SgpDocumentosBinarios sgpDocumentosBinariosByVistoBuenoPdf) {
        this.sgpDocumentosBinariosByVistoBuenoPdf = sgpDocumentosBinariosByVistoBuenoPdf;
    }

    public SgpMallas getSgpMallas() {
        return this.sgpMallas;
    }

    public void setSgpMallas(SgpMallas sgpMallas) {
        this.sgpMallas = sgpMallas;
    }

    public SgpDocumentosBinarios getSgpDocumentosBinariosByProyectoPublicoPdf() {
        return this.sgpDocumentosBinariosByProyectoPublicoPdf;
    }

    public void setSgpDocumentosBinariosByProyectoPublicoPdf(SgpDocumentosBinarios sgpDocumentosBinariosByProyectoPublicoPdf) {
        this.sgpDocumentosBinariosByProyectoPublicoPdf = sgpDocumentosBinariosByProyectoPublicoPdf;
    }

    public SgpSecciones getSgpSecciones() {
        return this.sgpSecciones;
    }

    public void setSgpSecciones(SgpSecciones sgpSecciones) {
        this.sgpSecciones = sgpSecciones;
    }

    public AmbitosServicios getAmbitosServicios() {
        return ambitosServicios;
    }

    public void setAmbitosServicios(AmbitosServicios ambitosServicios) {
        this.ambitosServicios = ambitosServicios;
    }

    public int getPerlecId() {
        return this.perlecId;
    }

    public void setPerlecId(int perlecId) {
        this.perlecId = perlecId;
    }

    public String getNombreEdicion() {
        return this.nombreEdicion;
    }

    public void setNombreEdicion(String nombreEdicion) {
        this.nombreEdicion = nombreEdicion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getMaxEstudiantesParalelo() {
        return maxEstudiantesParalelo;
    }

    public void setMaxEstudiantesParalelo(int maxEstudiantesParalelo) {
        this.maxEstudiantesParalelo = maxEstudiantesParalelo;
    }

    public int getMinimoEstudiantes() {

        return minimoEstudiantes;
    }

    public void setMinimoEstudiantes(int minimoEstudiantes) {
        this.minimoEstudiantes = minimoEstudiantes;
    }

    public int getNroParalelos() {
        return nroParalelos;
    }

    public void setNroParalelos(int nroParalelos) {
        this.nroParalelos = nroParalelos;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public char getAutorizado() {
        return this.autorizado;
    }

    public void setAutorizado(char autorizado) {
        this.autorizado = autorizado;
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

    public Set getSgpCursosEstudianteses() {
        return this.sgpCursosEstudianteses;
    }

    public void setSgpCursosEstudianteses(Set sgpCursosEstudianteses) {
        this.sgpCursosEstudianteses = sgpCursosEstudianteses;
    }

    public Set getSgpPresupuestoValoreses() {
        return this.sgpPresupuestoValoreses;
    }

    public void setSgpPresupuestoValoreses(Set sgpPresupuestoValoreses) {
        this.sgpPresupuestoValoreses = sgpPresupuestoValoreses;
    }

    public Set getSgpEquipoResponsables() {
        return this.sgpEquipoResponsables;
    }

    public void setSgpEquipoResponsables(Set sgpEquipoResponsables) {
        this.sgpEquipoResponsables = sgpEquipoResponsables;
    }

    public Set getSgpOfertaAsignaturas() {
        return this.sgpOfertaAsignaturas;
    }

    public void setSgpOfertaAsignaturas(Set sgpOfertaAsignaturas) {
        this.sgpOfertaAsignaturas = sgpOfertaAsignaturas;
    }

    public Set getSgpDirectoresCursos() {
        return this.sgpDirectoresCursos;
    }

    public void setSgpDirectoresCursos(Set sgpDirectoresCursos) {
        this.sgpDirectoresCursos = sgpDirectoresCursos;
    }

    public Set getSgpSilaboses() {
        return this.sgpSilaboses;
    }

    public void setSgpSilaboses(Set sgpSilaboses) {
        this.sgpSilaboses = sgpSilaboses;
    }

    public Set getSgpParametrosCursos() {
        return sgpParametrosCursos;
    }

    public void setSgpParametrosCursos(Set sgpParametrosCursos) {
        this.sgpParametrosCursos = sgpParametrosCursos;
    }

    public int getIdEd() {
        return id.getId();
    }

    public void setIdEd(int idEd) {
        this.idEd = idEd;
    }

    public Date getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }
    public Integer getAmbserId2() {
        return this.ambserId2;
    }
    
    public void setAmbserId2(Integer ambserId2) {
        this.ambserId2 = ambserId2;
    }
    public Integer getAmbserId3() {
        return this.ambserId3;
    }
    
    public void setAmbserId3(Integer ambserId3) {
        this.ambserId3 = ambserId3;
    }
    public Integer getAmbserId4() {
        return this.ambserId4;
    }
    
    public void setAmbserId4(Integer ambserId4) {
        this.ambserId4 = ambserId4;
    }
    public Integer getAmbserId5() {
        return this.ambserId5;
    }
    
    public void setAmbserId5(Integer ambserId5) {
        this.ambserId5 = ambserId5;
    }
}
