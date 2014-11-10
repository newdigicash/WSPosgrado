package datos.pojos.adminuc;
// Generated 06/12/2011 05:07:25 PM by Hibernate Tools 3.2.1.GA

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Titulos generated by hbm2java
 */
public class Titulos implements java.io.Serializable {

    private int id;
    private NivelesFormacion nivelesFormacion;
    private String nombre;
    private String estaactivo;
    private String creado;
    private Date fechaCreacion;
    private String actualizado;
    private Date fechaActualizacion;
    private Set titulosProfesionaleses = new HashSet(0);
    String campo = "Nombre";
    private boolean seleccionado = false;

    public Titulos() {
    }

    public Titulos(int id) {
        this.id = id;
    }

    public Titulos(int id, NivelesFormacion nivelesFormacion, String nombre, String estaactivo, String creado, Date fechaCreacion) {
        this.id = id;
        this.nivelesFormacion = nivelesFormacion;
        this.nombre = nombre;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
    }

    public Titulos(int id, NivelesFormacion nivelesFormacion, String nombre, String estaactivo, String creado, Date fechaCreacion, String actualizado, Date fechaActualizacion, Set titulosProfesionaleses) {
        this.id = id;
        this.nivelesFormacion = nivelesFormacion;
        this.nombre = nombre;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
        this.actualizado = actualizado;
        this.fechaActualizacion = fechaActualizacion;
        this.titulosProfesionaleses = titulosProfesionaleses;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NivelesFormacion getNivelesFormacion() {
        return this.nivelesFormacion;
    }

    public void setNivelesFormacion(NivelesFormacion nivelesFormacion) {
        this.nivelesFormacion = nivelesFormacion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Set getTitulosProfesionaleses() {
        return titulosProfesionaleses;
    }

    public void setTitulosProfesionaleses(Set titulosProfesionaleses) {
        this.titulosProfesionaleses = titulosProfesionaleses;
    }

    public String getCampo() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method getDescripcion = this.getClass().getMethod("get" + campo, new Class[0]);
        String descripcion = (String) getDescripcion.invoke(this, new Object[0]);
        return descripcion;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }
    
}
