package datos.pojos.adminuc;
// Generated 06/12/2011 05:07:25 PM by Hibernate Tools 3.2.1.GA

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * PersonasNaturales generated by hbm2java
 */
public class PersonasNaturales implements java.io.Serializable {

    private String personId;
    private Integer ubicacId;
    private String apellidos;
    private String nombres;
    private String lugarNacimiento;
    private Date fechaNacimiento;
    private String genero;
    private String tipoSangre;
    private String estadoCivil;
    private String ruc;
    private String numeroIess;
    private String libretaMilitar;
    private String emailPersonal;
    private String estaactivo;
    private String creado;
    private Date fechaCreacion;
    private String actualizado;
    private Date fechaActualizacion;
    private String diestro;
    private List<PrtParientesDiscapacitados> prtParientesDiscapacitadoses = new ArrayList<PrtParientesDiscapacitados>();

    public PersonasNaturales() {
    }

    public String getPersonId() {
        return this.personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Integer getUbicacId() {
        return this.ubicacId;
    }

    public void setUbicacId(Integer ubicacId) {
        this.ubicacId = ubicacId;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getLugarNacimiento() {
        return this.lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTipoSangre() {
        return this.tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getEstadoCivil() {
        return this.estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getRuc() {
        return this.ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNumeroIess() {
        return this.numeroIess;
    }

    public void setNumeroIess(String numeroIess) {
        this.numeroIess = numeroIess;
    }

    public String getLibretaMilitar() {
        return this.libretaMilitar;
    }

    public void setLibretaMilitar(String libretaMilitar) {
        this.libretaMilitar = libretaMilitar;
    }

    public String getEmailPersonal() {
        return this.emailPersonal;
    }

    public void setEmailPersonal(String emailPersonal) {
        this.emailPersonal = emailPersonal;
    }

    public String getEstaactivo() {
        return this.estaactivo;
    }

    public void setEstaactivo(String estaactivo) {
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

    public String getDiestro() {
        return this.diestro;
    }

    public void setDiestro(String diestro) {
        this.diestro = diestro;
    }
    
    public List<PrtParientesDiscapacitados> getPrtParientesDiscapacitadoses() {
        return prtParientesDiscapacitadoses;
    }

    public void setPrtParientesDiscapacitadoses(List<PrtParientesDiscapacitados> prtParientesDiscapacitadoses) {
        this.prtParientesDiscapacitadoses = prtParientesDiscapacitadoses;
    }
}
