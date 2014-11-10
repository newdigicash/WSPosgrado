package datos.pojos.sgap;
// Generated 23/04/2012 09:23:45 AM by Hibernate Tools 3.2.1.GA


import datos.pojos.adminuc.EspaciosFisicos;
import java.util.*;

/**
 * SgpHorariosOfertas generated by hbm2java
 */
public class SgpHorariosOfertas  implements java.io.Serializable {


     private SgpHorariosOfertasId id;
     private SgpOfertaAsignatura sgpOfertaAsignatura;
     private int dia;
     private String horaInicio;
     private String horaFin;
     private EspaciosFisicos espacioFisico;
     private char estaactivo;
     private String creado;
     private Date fechaCreacion;
     private String actualizado;
     private Date fechaActualizacion;
     private List <SgpHorariosDocentes> sgpHorariosDocenteses=new ArrayList<SgpHorariosDocentes>();
     /*Para selector*/
     private boolean selected=false;
     private String diaString="";

    public SgpHorariosOfertas() {
    }

	
    public SgpHorariosOfertas(SgpHorariosOfertasId id, SgpOfertaAsignatura sgpOfertaAsignatura, int dia, String horaInicio, char estaactivo, String creado, Date fechaCreacion) {
        this.id = id;
        this.sgpOfertaAsignatura = sgpOfertaAsignatura;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
    }
    public SgpHorariosOfertas(SgpHorariosOfertasId id, SgpOfertaAsignatura sgpOfertaAsignatura, int dia, String horaInicio, String horaFin, EspaciosFisicos espacioFisico, char estaactivo, String creado, Date fechaCreacion, String actualizado, Date fechaActualizacion, List<SgpHorariosDocentes> sgpHorariosDocenteses) {
       this.id = id;
       this.sgpOfertaAsignatura = sgpOfertaAsignatura;
       this.dia = dia;
       this.horaInicio = horaInicio;
       this.horaFin = horaFin;
       this.espacioFisico = espacioFisico;
       this.estaactivo = estaactivo;
       this.creado = creado;
       this.fechaCreacion = fechaCreacion;
       this.actualizado = actualizado;
       this.fechaActualizacion = fechaActualizacion;
       this.sgpHorariosDocenteses = sgpHorariosDocenteses;
    }
   
    public SgpHorariosOfertasId getId() {
        return this.id;
    }
    
    public void setId(SgpHorariosOfertasId id) {
        this.id = id;
    }
    public SgpOfertaAsignatura getSgpOfertaAsignatura() {
        return this.sgpOfertaAsignatura;
    }
    
    public void setSgpOfertaAsignatura(SgpOfertaAsignatura sgpOfertaAsignatura) {
        this.sgpOfertaAsignatura = sgpOfertaAsignatura;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
    
    public String getHoraInicio() {
        return this.horaInicio;
    }
    
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }
    public String getHoraFin() {
        return this.horaFin;
    }
    
    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public EspaciosFisicos getEspacioFisico() {
        return espacioFisico;
    }

    public void setEspacioFisico(EspaciosFisicos espacioFisico) {
        this.espacioFisico = espacioFisico;
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

    public List<SgpHorariosDocentes> getSgpHorariosDocenteses() {
        return sgpHorariosDocenteses;
    }

    public void setSgpHorariosDocenteses(List<SgpHorariosDocentes> sgpHorariosDocenteses) {
        this.sgpHorariosDocenteses = sgpHorariosDocenteses;
    }
    
//    public Set getSgpHorariosDocenteses() {
//        return this.sgpHorariosDocenteses;
//    }
//    
//    public void setSgpHorariosDocenteses(Set sgpHorariosDocenteses) {
//        this.sgpHorariosDocenteses = sgpHorariosDocenteses;
//    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getDiaString() {
        return diaString;
    }

    public void setDiaString(String diaString) {
        this.diaString = diaString;
    }




}


