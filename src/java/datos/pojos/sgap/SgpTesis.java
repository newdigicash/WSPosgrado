package datos.pojos.sgap;
// Generated 04/04/2014 10:30:05 AM by Hibernate Tools 3.2.1.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SgpTesis generated by hbm2java
 */
public class SgpTesis implements java.io.Serializable {

    private int tesId;
    private SgpEdiciones sgpEdiciones;
    private String tesTitulo;
    private String tesDescripcion;
    private String tesEstado;
    private String tesPalabrasClave;
    private Date tesFechaInicio;
    private Date tesFechaFin;
    private String tesDirectorId;
    private String tesLugar;
    private String tesDepartamento;
    private String tesResponsable;
    private String tesCargo;
    private String tesCorreoElectronico;
    private Long tesTelefono;
    private char tesEstaAnulada;
    private char tesEstaactivo;
    private String tesCreado;
    private Date tesFechaCreacion;
    private String tesActualizado;
    private Date tesFechaActualizacion;
    private Set sgpTesisAnulacions = new HashSet(0);
    private Set sgpTesisEstudiantes = new HashSet(0);
    private Set sgpTesisAvances = new HashSet(0);
    private Set sgpTesisProrrogas = new HashSet(0);
    private Set sgpTesisTribunals = new HashSet(0);
    private boolean Seleccionado;
    private String desEstado = "";

    public SgpTesis() {
    }

    public SgpTesis(int tesId, SgpEdiciones sgpEdiciones, String tesTitulo, String tesEstado, Date tesFechaInicio, String tesDirectorId, char tesEstaAnulada, char tesEstaactivo, String tesCreado, Date tesFechaCreacion) {
        this.tesId = tesId;
        this.sgpEdiciones = sgpEdiciones;
        this.tesTitulo = tesTitulo;
        this.tesEstado = tesEstado;
        this.tesFechaInicio = tesFechaInicio;
        this.tesDirectorId = tesDirectorId;
        this.tesEstaAnulada = tesEstaAnulada;
        this.tesEstaactivo = tesEstaactivo;
        this.tesCreado = tesCreado;
        this.tesFechaCreacion = tesFechaCreacion;
    }

    public SgpTesis(int tesId, SgpEdiciones sgpEdiciones, String tesTitulo, String tesDescripcion, String tesEstado, String tesPalabrasClave, Date tesFechaInicio, Date tesFechaFin, String tesDirectorId, String tesLugar, String tesDepartamento, String tesResponsable, String tesCargo, String tesCorreoElectronico, Long tesTelefono, char tesEstaAnulada, char tesEstaactivo, String tesCreado, Date tesFechaCreacion, String tesActualizado, Date tesFechaActualizacion, Set sgpTesisAnulacions, Set sgpTesisEstudiantes, Set sgpTesisAvances, Set sgpTesisProrrogas, Set sgpTesisTribunals) {
        this.tesId = tesId;
        this.sgpEdiciones = sgpEdiciones;
        this.tesTitulo = tesTitulo;
        this.tesDescripcion = tesDescripcion;
        this.tesEstado = tesEstado;
        this.tesPalabrasClave = tesPalabrasClave;
        this.tesFechaInicio = tesFechaInicio;
        this.tesFechaFin = tesFechaFin;
        this.tesDirectorId = tesDirectorId;
        this.tesLugar = tesLugar;
        this.tesDepartamento = tesDepartamento;
        this.tesResponsable = tesResponsable;
        this.tesCargo = tesCargo;
        this.tesCorreoElectronico = tesCorreoElectronico;
        this.tesTelefono = tesTelefono;
        this.tesEstaAnulada = tesEstaAnulada;
        this.tesEstaactivo = tesEstaactivo;
        this.tesCreado = tesCreado;
        this.tesFechaCreacion = tesFechaCreacion;
        this.tesActualizado = tesActualizado;
        this.tesFechaActualizacion = tesFechaActualizacion;
        this.sgpTesisAnulacions = sgpTesisAnulacions;
        this.sgpTesisEstudiantes = sgpTesisEstudiantes;
        this.sgpTesisAvances = sgpTesisAvances;
        this.sgpTesisProrrogas = sgpTesisProrrogas;
        this.sgpTesisTribunals = sgpTesisTribunals;
    }

    public int getTesId() {
        return this.tesId;
    }

    public void setTesId(int tesId) {
        this.tesId = tesId;
    }

    public SgpEdiciones getSgpEdiciones() {
        return this.sgpEdiciones;
    }

    public void setSgpEdiciones(SgpEdiciones sgpEdiciones) {
        this.sgpEdiciones = sgpEdiciones;
    }

    public String getTesTitulo() {
        return this.tesTitulo;
    }

    public void setTesTitulo(String tesTitulo) {
        this.tesTitulo = tesTitulo;
    }

    public String getTesDescripcion() {
        return this.tesDescripcion;
    }

    public void setTesDescripcion(String tesDescripcion) {
        this.tesDescripcion = tesDescripcion;
    }

    public String getTesEstado() {
        return this.tesEstado;
    }

    public void setTesEstado(String tesEstado) {
        this.tesEstado = tesEstado;
    }

    public String getTesPalabrasClave() {
        return this.tesPalabrasClave;
    }

    public void setTesPalabrasClave(String tesPalabrasClave) {
        this.tesPalabrasClave = tesPalabrasClave;
    }

    public Date getTesFechaInicio() {
        return this.tesFechaInicio;
    }

    public void setTesFechaInicio(Date tesFechaInicio) {
        this.tesFechaInicio = tesFechaInicio;
    }

    public Date getTesFechaFin() {
        return this.tesFechaFin;
    }

    public void setTesFechaFin(Date tesFechaFin) {
        this.tesFechaFin = tesFechaFin;
    }

    public String getTesDirectorId() {
        return this.tesDirectorId;
    }

    public void setTesDirectorId(String tesDirectorId) {
        this.tesDirectorId = tesDirectorId;
    }

    public String getTesLugar() {
        return this.tesLugar;
    }

    public void setTesLugar(String tesLugar) {
        this.tesLugar = tesLugar;
    }

    public String getTesDepartamento() {
        return this.tesDepartamento;
    }

    public void setTesDepartamento(String tesDepartamento) {
        this.tesDepartamento = tesDepartamento;
    }

    public String getTesResponsable() {
        return this.tesResponsable;
    }

    public void setTesResponsable(String tesResponsable) {
        this.tesResponsable = tesResponsable;
    }

    public String getTesCargo() {
        return this.tesCargo;
    }

    public void setTesCargo(String tesCargo) {
        this.tesCargo = tesCargo;
    }

    public String getTesCorreoElectronico() {
        return this.tesCorreoElectronico;
    }

    public void setTesCorreoElectronico(String tesCorreoElectronico) {
        this.tesCorreoElectronico = tesCorreoElectronico;
    }

    public Long getTesTelefono() {
        return this.tesTelefono;
    }

    public void setTesTelefono(Long tesTelefono) {
        this.tesTelefono = tesTelefono;
    }

    public char getTesEstaAnulada() {
        return this.tesEstaAnulada;
    }

    public void setTesEstaAnulada(char tesEstaAnulada) {
        this.tesEstaAnulada = tesEstaAnulada;
    }

    public char getTesEstaactivo() {
        return this.tesEstaactivo;
    }

    public void setTesEstaactivo(char tesEstaactivo) {
        this.tesEstaactivo = tesEstaactivo;
    }

    public String getTesCreado() {
        return this.tesCreado;
    }

    public void setTesCreado(String tesCreado) {
        this.tesCreado = tesCreado;
    }

    public Date getTesFechaCreacion() {
        return this.tesFechaCreacion;
    }

    public void setTesFechaCreacion(Date tesFechaCreacion) {
        this.tesFechaCreacion = tesFechaCreacion;
    }

    public String getTesActualizado() {
        return this.tesActualizado;
    }

    public void setTesActualizado(String tesActualizado) {
        this.tesActualizado = tesActualizado;
    }

    public Date getTesFechaActualizacion() {
        return this.tesFechaActualizacion;
    }

    public void setTesFechaActualizacion(Date tesFechaActualizacion) {
        this.tesFechaActualizacion = tesFechaActualizacion;
    }

    public Set getSgpTesisAnulacions() {
        return this.sgpTesisAnulacions;
    }

    public void setSgpTesisAnulacions(Set sgpTesisAnulacions) {
        this.sgpTesisAnulacions = sgpTesisAnulacions;
    }

    public Set getSgpTesisEstudiantes() {
        return this.sgpTesisEstudiantes;
    }

    public void setSgpTesisEstudiantes(Set sgpTesisEstudiantes) {
        this.sgpTesisEstudiantes = sgpTesisEstudiantes;
    }

    public Set getSgpTesisAvances() {
        return this.sgpTesisAvances;
    }

    public void setSgpTesisAvances(Set sgpTesisAvances) {
        this.sgpTesisAvances = sgpTesisAvances;
    }

    public Set getSgpTesisProrrogas() {
        return this.sgpTesisProrrogas;
    }

    public void setSgpTesisProrrogas(Set sgpTesisProrrogas) {
        this.sgpTesisProrrogas = sgpTesisProrrogas;
    }

    public Set getSgpTesisTribunals() {
        return this.sgpTesisTribunals;
    }

    public void setSgpTesisTribunals(Set sgpTesisTribunals) {
        this.sgpTesisTribunals = sgpTesisTribunals;
    }

    public boolean isSeleccionado() {
        return Seleccionado;
    }

    public void setSeleccionado(boolean Seleccionado) {
        this.Seleccionado = Seleccionado;
    }

    public String getDesEstado() {
        if (this.tesEstado.equals("EC")) {
            desEstado = "EN CURSO";
        } else if (this.tesEstado.equals("FI")) {
            desEstado = "FINALIZADO";
        } else {
            desEstado = "ANULADO";
        }
        return desEstado;
    }
}
