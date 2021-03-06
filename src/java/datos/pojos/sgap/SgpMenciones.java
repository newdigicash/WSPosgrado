package datos.pojos.sgap;
// Generated 23/04/2012 09:23:45 AM by Hibernate Tools 3.2.1.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SgpMenciones generated by hbm2java
 */
public class SgpMenciones implements java.io.Serializable {

    private SgpMencionesId id;
    private SgpMallas sgpMallas;
    private String nombre;
    private short minimoEstudiantes;
    private short maxEstudiantes;
    private char estaactivo;
    private String creado;
    private Date fechaCreacion;
    private String actualizado;
    private Date fechaActualizacion;
    private Set sgpMencionesAsignaturases = new HashSet(0);
     private Set sgpUnidadesMallas = new HashSet(0);
    

    public SgpMenciones() {
    }

    public SgpMenciones(SgpMencionesId id, SgpMallas sgpMallas, String nombre, short minimoEstudiantes, short maxEstudiantes, char estaactivo, String creado, Date fechaCreacion) {
        this.id = id;
        this.sgpMallas = sgpMallas;
        this.nombre = nombre;
        this.minimoEstudiantes = minimoEstudiantes;
        this.maxEstudiantes = maxEstudiantes;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
    }

    public SgpMenciones(SgpMencionesId id, SgpMallas sgpMallas, String nombre, short minimoEstudiantes, short maxEstudiantes, char estaactivo, String creado, Date fechaCreacion, String actualizado, Date fechaActualizacion, Set sgpMencionesAsignaturases) {
        this.id = id;
        this.sgpMallas = sgpMallas;
        this.nombre = nombre;
        this.minimoEstudiantes = minimoEstudiantes;
        this.maxEstudiantes = maxEstudiantes;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
        this.actualizado = actualizado;
        this.fechaActualizacion = fechaActualizacion;
        this.sgpMencionesAsignaturases = sgpMencionesAsignaturases;
    }

    public SgpMencionesId getId() {
        return this.id;
    }

    public void setId(SgpMencionesId id) {
        this.id = id;
    }

    public SgpMallas getSgpMallas() {
        return this.sgpMallas;
    }

    public void setSgpMallas(SgpMallas sgpMallas) {
        this.sgpMallas = sgpMallas;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public short getMinimoEstudiantes() {
        return this.minimoEstudiantes;
    }

    public void setMinimoEstudiantes(short minimoEstudiantes) {
        this.minimoEstudiantes = minimoEstudiantes;
    }

    public short getMaxEstudiantes() {
        return this.maxEstudiantes;
    }

    public void setMaxEstudiantes(short maxEstudiantes) {
        this.maxEstudiantes = maxEstudiantes;
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

    public Set getSgpMencionesAsignaturases() {
        return this.sgpMencionesAsignaturases;
    }

    public void setSgpMencionesAsignaturases(Set sgpMencionesAsignaturases) {
        this.sgpMencionesAsignaturases = sgpMencionesAsignaturases;
    }

    public Set getSgpUnidadesMallas() {
        return sgpUnidadesMallas;
    }

    public void setSgpUnidadesMallas(Set sgpUnidadesMallas) {
        this.sgpUnidadesMallas = sgpUnidadesMallas;
    }
    
}
