package datos.pojos.sgap;
// Generated 23/04/2012 09:23:45 AM by Hibernate Tools 3.2.1.GA

import java.util.Date;

public class SgpParametrosCurso implements java.io.Serializable {

    private SgpParametrosCursoId id;
    private SgpParametros sgpParametros;
    private SgpEdiciones sgpEdiciones;
    private Date fecha1;
    private Date fecha2;
    private Integer numero1;
    private Integer numero2;
    private String cadena1;
    private String cadena2;
    private String descripcion;
    private char estaactivo;
    private String creado;
    private Date fechaCreacion;
    private String actualizado;
    private Date fechaActualizacion;

    public SgpParametrosCurso() {
    }

    public SgpParametrosCurso(SgpParametrosCursoId id, SgpParametros sgpParametros, String descripcion, char estaactivo, String creado, Date fechaCreacion) {
        this.id = id;
        this.sgpParametros = sgpParametros;
        this.descripcion = descripcion;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
    }

    public SgpParametrosCurso(SgpParametrosCursoId id, SgpParametros sgpParametros, Date fecha1, Date fecha2, Integer numero1, Integer numero2, String cadena1, String cadena2, String descripcion, char estaactivo, String creado, Date fechaCreacion, String actualizado, Date fechaActualizacion) {
        this.id = id;
        this.sgpParametros = sgpParametros;
        this.fecha1 = fecha1;
        this.fecha2 = fecha2;
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.cadena1 = cadena1;
        this.cadena2 = cadena2;
        this.descripcion = descripcion;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
        this.actualizado = actualizado;
        this.fechaActualizacion = fechaActualizacion;
    }

    public SgpParametrosCursoId getId() {
        return this.id;
    }

    public void setId(SgpParametrosCursoId id) {
        this.id = id;
    }

    public SgpParametros getSgpParametros() {
        return this.sgpParametros;
    }

    public void setSgpParametros(SgpParametros sgpParametros) {
        this.sgpParametros = sgpParametros;
    }

    public Date getFecha1() {
        return this.fecha1;
    }

    public void setFecha1(Date fecha1) {
        this.fecha1 = fecha1;
    }

    public Date getFecha2() {
        return this.fecha2;
    }

    public void setFecha2(Date fecha2) {
        this.fecha2 = fecha2;
    }

    public Integer getNumero1() {
        return this.numero1;
    }

    public void setNumero1(Integer numero1) {
        this.numero1 = numero1;
    }

    public Integer getNumero2() {
        return this.numero2;
    }

    public void setNumero2(Integer numero2) {
        this.numero2 = numero2;
    }

    public String getCadena1() {
        return this.cadena1;
    }

    public void setCadena1(String cadena1) {
        this.cadena1 = cadena1;
    }

    public String getCadena2() {
        return this.cadena2;
    }

    public void setCadena2(String cadena2) {
        this.cadena2 = cadena2;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public SgpEdiciones getSgpEdiciones() {
        return sgpEdiciones;
    }

    public void setSgpEdiciones(SgpEdiciones sgpEdiciones) {
        this.sgpEdiciones = sgpEdiciones;
    }
}
