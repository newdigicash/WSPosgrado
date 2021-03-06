package datos.pojos.sgap;
// Generated 19/02/2014 09:01:00 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SgpMatriculas generated by hbm2java
 */
public class SgpMatriculas  implements java.io.Serializable {


     private SgpMatriculasId id;
     private SgpCursosPostgrado sgpCursosPostgrado;
     private SgpFinanciamiento sgpFinanciamiento;
     private int perlecId;
     private int nroMatricula;
     private Integer placarId;
     private Integer mallaId;
     private char esgratuita;
     private String garantia;
     private char estadoMatricula;
     private Date fechaMatricula;
     private char estaAnulada;
     private Date fechaAnulacion;
     private char estaactivo;
     private String creado;
     private Date fechaCreacion;
     private String actualizado;
     private Date fechaActualizacion;
     private Character beca;
     private Integer porcentajeBeca;
     private String institucionBeca;
     private char estaRetirado;
     private String otroFinanciamiento;
     private Character apoyoUniversidad;
     private Set sgpMatriculasAsignaturases = new HashSet(0);
     private String nroMatriculaCadena;

    public SgpMatriculas() {
    }

	
    public SgpMatriculas(SgpMatriculasId id, SgpCursosPostgrado sgpCursosPostgrado, SgpFinanciamiento sgpFinanciamiento, int perlecId, int nroMatricula, char esgratuita, String garantia, char estadoMatricula, Date fechaMatricula, char estaAnulada, char estaactivo, String creado, Date fechaCreacion, char estaRetirado) {
        this.id = id;
        this.sgpCursosPostgrado = sgpCursosPostgrado;
        this.sgpFinanciamiento = sgpFinanciamiento;
        this.perlecId = perlecId;
        this.nroMatricula = nroMatricula;
        this.esgratuita = esgratuita;
        this.garantia = garantia;
        this.estadoMatricula = estadoMatricula;
        this.fechaMatricula = fechaMatricula;
        this.estaAnulada = estaAnulada;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
        this.estaRetirado = estaRetirado;
    }
    public SgpMatriculas(SgpMatriculasId id, SgpCursosPostgrado sgpCursosPostgrado, SgpFinanciamiento sgpFinanciamiento, int perlecId, int nroMatricula, Integer placarId, Integer mallaId, char esgratuita, String garantia, char estadoMatricula, Date fechaMatricula, char estaAnulada, Date fechaAnulacion, char estaactivo, String creado, Date fechaCreacion, String actualizado, Date fechaActualizacion, Character beca, Integer porcentajeBeca, String institucionBeca, char estaRetirado, String otroFinanciamiento, Character apoyoUniversidad, Set sgpMatriculasAsignaturases) {
       this.id = id;
       this.sgpCursosPostgrado = sgpCursosPostgrado;
       this.sgpFinanciamiento = sgpFinanciamiento;
       this.perlecId = perlecId;
       this.nroMatricula = nroMatricula;
       this.placarId = placarId;
       this.mallaId = mallaId;
       this.esgratuita = esgratuita;
       this.garantia = garantia;
       this.estadoMatricula = estadoMatricula;
       this.fechaMatricula = fechaMatricula;
       this.estaAnulada = estaAnulada;
       this.fechaAnulacion = fechaAnulacion;
       this.estaactivo = estaactivo;
       this.creado = creado;
       this.fechaCreacion = fechaCreacion;
       this.actualizado = actualizado;
       this.fechaActualizacion = fechaActualizacion;
       this.beca = beca;
       this.porcentajeBeca = porcentajeBeca;
       this.institucionBeca = institucionBeca;
       this.estaRetirado = estaRetirado;
       this.otroFinanciamiento = otroFinanciamiento;
       this.apoyoUniversidad = apoyoUniversidad;
       this.sgpMatriculasAsignaturases = sgpMatriculasAsignaturases;
    }
   
    public SgpMatriculasId getId() {
        return this.id;
    }
    
    public void setId(SgpMatriculasId id) {
        this.id = id;
    }
    public SgpCursosPostgrado getSgpCursosPostgrado() {
        return this.sgpCursosPostgrado;
    }
    
    public void setSgpCursosPostgrado(SgpCursosPostgrado sgpCursosPostgrado) {
        this.sgpCursosPostgrado = sgpCursosPostgrado;
    }
    public SgpFinanciamiento getSgpFinanciamiento() {
        return this.sgpFinanciamiento;
    }
    
    public void setSgpFinanciamiento(SgpFinanciamiento sgpFinanciamiento) {
        this.sgpFinanciamiento = sgpFinanciamiento;
    }
    public int getPerlecId() {
        return this.perlecId;
    }
    
    public void setPerlecId(int perlecId) {
        this.perlecId = perlecId;
    }
    public int getNroMatricula() {
        return this.nroMatricula;
    }
    
    public void setNroMatricula(int nroMatricula) {
        this.nroMatricula = nroMatricula;
    }
    public Integer getPlacarId() {
        return this.placarId;
    }
    
    public void setPlacarId(Integer placarId) {
        this.placarId = placarId;
    }
    public Integer getMallaId() {
        return this.mallaId;
    }
    
    public void setMallaId(Integer mallaId) {
        this.mallaId = mallaId;
    }
    public char getEsgratuita() {
        return this.esgratuita;
    }
    
    public void setEsgratuita(char esgratuita) {
        this.esgratuita = esgratuita;
    }
    public String getGarantia() {
        return this.garantia;
    }
    
    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }
    public char getEstadoMatricula() {
        return this.estadoMatricula;
    }
    
    public void setEstadoMatricula(char estadoMatricula) {
        this.estadoMatricula = estadoMatricula;
    }
    public Date getFechaMatricula() {
        return this.fechaMatricula;
    }
    
    public void setFechaMatricula(Date fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }
    public char getEstaAnulada() {
        return this.estaAnulada;
    }
    
    public void setEstaAnulada(char estaAnulada) {
        this.estaAnulada = estaAnulada;
    }
    public Date getFechaAnulacion() {
        return this.fechaAnulacion;
    }
    
    public void setFechaAnulacion(Date fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
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
    public Character getBeca() {
        return this.beca;
    }
    
    public void setBeca(Character beca) {
        this.beca = beca;
    }
    public Integer getPorcentajeBeca() {
        return this.porcentajeBeca;
    }
    
    public void setPorcentajeBeca(Integer porcentajeBeca) {
        this.porcentajeBeca = porcentajeBeca;
    }
    public String getInstitucionBeca() {
        return this.institucionBeca;
    }
    
    public void setInstitucionBeca(String institucionBeca) {
        this.institucionBeca = institucionBeca;
    }
    public char getEstaRetirado() {
        return this.estaRetirado;
    }
    
    public void setEstaRetirado(char estaRetirado) {
        this.estaRetirado = estaRetirado;
    }
    public String getOtroFinanciamiento() {
        return this.otroFinanciamiento;
    }
    
    public void setOtroFinanciamiento(String otroFinanciamiento) {
        this.otroFinanciamiento = otroFinanciamiento;
    }
    public Character getApoyoUniversidad() {
        return this.apoyoUniversidad;
    }
    
    public void setApoyoUniversidad(Character apoyoUniversidad) {
        this.apoyoUniversidad = apoyoUniversidad;
    }
    
    public String getNroMatriculaCadena() {
        return this.nroMatriculaCadena;
    }
    
    public void setNroMatriculaCadena(String nroMatriculaCadena) {
        this.nroMatriculaCadena = nroMatriculaCadena;
    }
    
    public Set getSgpMatriculasAsignaturases() {
        return this.sgpMatriculasAsignaturases;
    }
    
    public void setSgpMatriculasAsignaturases(Set sgpMatriculasAsignaturases) {
        this.sgpMatriculasAsignaturases = sgpMatriculasAsignaturases;
    }
}