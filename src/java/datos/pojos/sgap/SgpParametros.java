package datos.pojos.sgap;
// Generated 23/04/2012 09:23:45 AM by Hibernate Tools 3.2.1.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SgpParametros generated by hbm2java
 */
public class SgpParametros implements java.io.Serializable {

    private Integer id;
    private String nombre;
    private String valor;
    private String descripcion;
    private Character esconfigurable;
    private Character esinternet;
    private String configurablePor;
    private Character estaactivo;
    private String creado;
    private Date fechaCreacion;
    private String actualizado;
    private Date fechaActualizacion;
    private Set sgpParametrosPeriodoses = new HashSet(0);
    private Set sgpParametrosCursos = new HashSet(0);
    //otros
    private String lblesconfigurable;
    private String lblesinternet;
    private String lblconfigurablePor;

    public SgpParametros() {
    }

    public SgpParametros(Integer id, String nombre, String descripcion, char esconfigurable, char esIntegerernet, String configurablePor, char estaactivo, String creado, Date fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.esconfigurable = esconfigurable;
        this.esinternet = esIntegerernet;
        this.configurablePor = configurablePor;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
    }

    public SgpParametros(Integer id, String nombre, String valor, String descripcion, char esconfigurable, char esIntegerernet, String configurablePor, char estaactivo, String creado, Date fechaCreacion, String actualizado, Date fechaActualizacion, Set sgpParametrosPeriodoses, Set sgpParametrosCursos) {
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
        this.descripcion = descripcion;
        this.esconfigurable = esconfigurable;
        this.esinternet = esIntegerernet;
        this.configurablePor = configurablePor;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
        this.actualizado = actualizado;
        this.fechaActualizacion = fechaActualizacion;
        this.sgpParametrosPeriodoses = sgpParametrosPeriodoses;
        this.sgpParametrosCursos = sgpParametrosCursos;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor() {
        return this.valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getEsconfigurable() {
        return this.esconfigurable;
    }

    public void setEsconfigurable(Character esconfigurable) {
        this.esconfigurable = esconfigurable;
    }

    public String getConfigurablePor() {
        return this.configurablePor;
    }

    public void setConfigurablePor(String configurablePor) {
        this.configurablePor = configurablePor;
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

    public Set getSgpParametrosPeriodoses() {
        return this.sgpParametrosPeriodoses;
    }

    public void setSgpParametrosPeriodoses(Set sgpParametrosPeriodoses) {
        this.sgpParametrosPeriodoses = sgpParametrosPeriodoses;
    }

    public Set getSgpParametrosCursos() {
        return this.sgpParametrosCursos;
    }

    public void setSgpParametrosCursos(Set sgpParametrosCursos) {
        this.sgpParametrosCursos = sgpParametrosCursos;
    }

    public Character getEsinternet() {
        return esinternet;
    }

    public void setEsinternet(Character esinternet) {
        this.esinternet = esinternet;
    }

    public String getLblesconfigurable() {
        return lblesconfigurable;
    }

    public void setLblesconfigurable(String lblesconfigurable) {
        if (esconfigurable == 'S') {
            lblesconfigurable = "SI";
        } else if (esconfigurable == 'N') {
            lblesconfigurable = "NO";
        } else {
            lblesconfigurable = "";
        }
        this.lblesconfigurable = lblesconfigurable;
    }

    public String getLblesinternet() {
        return lblesinternet;
    }

    public void setLblesinternet(String lblesinternet) {
        if (esinternet == 'S') {
            lblesinternet = "SI";
        } else if (esinternet == 'N') {
            lblesinternet = "NO";
        } else {
            lblesinternet = "";
        }
        this.lblesinternet = lblesinternet;
    }

    public String getLblconfigurablePor() {
        return lblconfigurablePor;
    }

    public void setLblconfigurablePor(String lblconfigurablePor) {
        if (configurablePor.equals("CRR")) {
            lblconfigurablePor = "CARRERA";
        } else {
            lblconfigurablePor = "UNIVERSIDAD";
        }
        this.lblconfigurablePor = lblconfigurablePor;
    }
}