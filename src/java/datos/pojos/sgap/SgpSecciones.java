package datos.pojos.sgap;
// Generated 23/04/2012 09:23:45 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SgpSecciones generated by hbm2java
 */
public class SgpSecciones  implements java.io.Serializable {


     private int id;
     private String nombre;
     private String horaInicia;
     private String horaFin;
     private char estaactivo;
     private String creado;
     private Date fechaCreacion;
     private String actualizado;
     private Date fechaActualizacion;
     private Set sgpEdicioneses = new HashSet(0);
     private Set sgpCursosEstudianteses = new HashSet(0);
     private Set sgpOfertaAsignaturas = new HashSet(0);

    public SgpSecciones() {
    }

	
    public SgpSecciones(int id, String nombre, String horaInicia, String horaFin, char estaactivo, String creado, Date fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.horaInicia = horaInicia;
        this.horaFin = horaFin;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
    }
    public SgpSecciones(int id, String nombre, String horaInicia, String horaFin, char estaactivo, String creado, Date fechaCreacion, String actualizado, Date fechaActualizacion, Set sgpEdicioneses, Set sgpCursosEstudianteses, Set sgpOfertaAsignaturas) {
       this.id = id;
       this.nombre = nombre;
       this.horaInicia = horaInicia;
       this.horaFin = horaFin;
       this.estaactivo = estaactivo;
       this.creado = creado;
       this.fechaCreacion = fechaCreacion;
       this.actualizado = actualizado;
       this.fechaActualizacion = fechaActualizacion;
       this.sgpEdicioneses = sgpEdicioneses;
       this.sgpCursosEstudianteses = sgpCursosEstudianteses;
       this.sgpOfertaAsignaturas = sgpOfertaAsignaturas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   

    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getHoraInicia() {
        return this.horaInicia;
    }
    
    public void setHoraInicia(String horaInicia) {
        this.horaInicia = horaInicia;
    }
    public String getHoraFin() {
        return this.horaFin;
    }
    
    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
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
    public Set getSgpEdicioneses() {
        return this.sgpEdicioneses;
    }
    
    public void setSgpEdicioneses(Set sgpEdicioneses) {
        this.sgpEdicioneses = sgpEdicioneses;
    }
    public Set getSgpCursosEstudianteses() {
        return this.sgpCursosEstudianteses;
    }
    
    public void setSgpCursosEstudianteses(Set sgpCursosEstudianteses) {
        this.sgpCursosEstudianteses = sgpCursosEstudianteses;
    }
    public Set getSgpOfertaAsignaturas() {
        return this.sgpOfertaAsignaturas;
    }
    
    public void setSgpOfertaAsignaturas(Set sgpOfertaAsignaturas) {
        this.sgpOfertaAsignaturas = sgpOfertaAsignaturas;
    }




}


