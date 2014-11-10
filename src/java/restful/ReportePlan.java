package restful;

import acceso.Consultas;
import datos.pojos.academico.SgaModalidades;
import datos.pojos.adminuc.Dependencias;
import datos.pojos.adminuc.NivelesFormacion;
import datos.pojos.adminuc.Titulos;
import datos.pojos.sgap.SgpAreasConocimiento;
import datos.pojos.sgap.SgpComponentes;
import datos.pojos.sgap.SgpComponentesPlanes;
import datos.pojos.sgap.SgpCursosPostgrado;
import datos.pojos.sgap.SgpPlanesCurso;
import datos.pojos.sgap.SgpResolucionesSenescyt;
import datos.pojos.sgap.SgpSubareas;
import java.text.SimpleDateFormat;
import java.util.List;
import negocio.VstUbicaciones;
import negocio.componentes;
import negocio.componentesplan;
import negocio.cursos;
import negocio.modalidades;
import negocio.planes;
import negocio.resoluciones;
import negocio.ubicaciones;

/**
 * Clase para obtener información del plan de posgrado.
 * Basado en CtrReportesPlanes.java
 * @author @edwinsigcha
 * @version 1.0
 * @since 2014-11-04
 * @see CtrReportesPlanes.java
 */
public class ReportePlan {
    private String _selectedCurso; //id de curso
    private String _selectedPlan; //id de plan
    private String _selectedCab; //id de cabecera de componente

    public ReportePlan() {
        this._selectedPlan=this._selectedCurso=this._selectedCab="-1";
    }
    
    /**
     * Asigna los parametros para consultar el plan de posgrado
     * @param plan  Id del plan vigente
     * @param curso Id del curso vigente
     */
    public void setParametros(String plan,String curso) {
        this._selectedCurso = curso;
        this._selectedPlan=plan;
    }
    /**
     * Obtiene la(s) modalidad(es) del plan y curso en vigencia
     * @return Objeto[] modalidades
     */
    public Object getModalidad(){
        try{
            //lista las modalidades del plan y curso indicado
            List<SgaModalidades> listamod=new modalidades().listarSgaModalidades(Integer.parseInt(this._selectedPlan),Integer.parseInt(this._selectedCurso));
            String[] tb=new String[listamod.size()]; //para guardar resultado
            for(int i=0; i<listamod.size(); i++){
                tb[i]=listamod.get(i).getNombre(); //guarda la modalidad
            }
            return tb;
        }catch(Exception ex){
            System.out.println("Modalidad > Error: "+ex.getMessage());
        }
        return new Object();
    }
    /**
     * Obtiene los componentes del plan de posgrado consultado
     * @return Object[][] tabla de componentes con título, valor, e ID
     */
    public Object getComponentes(){ 
        try{
            //obtiene los componentes de un plan y curso especifico
            List<SgpComponentesPlanes> componentes=new componentesplan().ListadoCompPlanes(Integer.parseInt(this._selectedPlan),Integer.parseInt(this._selectedCurso),Integer.parseInt(this._selectedCab));
            List<SgpComponentes> cabecera=new componentes().getComponentes("", null, null); //obtiene toda la cabecera
            String[][] tb=new String[3][componentes.size()]; //para guardar resultado
            for(int i=0; i<componentes.size(); i++){ //une la tabla de componentes con la cabecera
                for(int j=0;j<cabecera.size(); j++){
                    if(componentes.get(i).getId().getComponenteId()==cabecera.get(j).getId()){ //compara IDs de tablas
                        tb[0][i]=cabecera.get(j).getNombre(); //guarda el titulo
                        tb[1][i]=componentes.get(i).getValor(); //guarda el contenido
                        tb[2][i]=String.valueOf(componentes.get(i).getId().getComponenteId()); //guarda numero del componente
                        break;
                    }
                }
            }
            return tb;
        }catch(Exception ex){
            System.out.println("Componentes > Error: "+ex.getMessage());
        }
        return new Object();
    }
    /**
     * Obtiene el registro del plan de posgrado dado el ID plan e ID curso
     * @return Object[][] tabla de resultados con datos generales del plan
     */
    public Object getPlanPosgrado(){
        SgpPlanesCurso plan=null; 
        try{
            SgpCursosPostgrado curso = new cursos().getCurso(Integer.parseInt(this._selectedCurso)); //Programa de postgrado
            List<SgpPlanesCurso> planes = new planes().getPlanesXCurso(Integer.valueOf(this._selectedCurso)); //extrar todos los planes asociados al curso
            for(int i=0; i<planes.size(); i++){ //elige unicamente el plan indicado como parametro
                if(planes.get(i).getId().getId()==Integer.valueOf(this._selectedPlan)){
                    plan=planes.get(i); //extrae el plan
                    break;
                }
            }            
            //informacion de datos generales
            Dependencias depen = curso.getDependencia(); //obtiene la dependencia (facultad)
            VstUbicaciones vstub = new ubicaciones().getVstUbicacion(plan.getUbicacionId()); //obtiene la ubicacion de la sede
            NivelesFormacion nivel = (NivelesFormacion) Consultas.get(NivelesFormacion.class, curso.getNivforId()); //grado academico
            Titulos titulo = curso.getTitulo(); //titulo del curso
            Dependencias sede = (Dependencias) Consultas.get(Dependencias.class, plan.getDependenciaId()); //obtiene la sede
            SgpSubareas subarea = (SgpSubareas) Consultas.get(SgpSubareas.class, curso.getSgpSubareas().getId()); //obtiene subarea
            SgpAreasConocimiento area = null;
            if (subarea != null) { //obtiene el area
                area = (SgpAreasConocimiento) Consultas.get(SgpAreasConocimiento.class, subarea.getSgpAreasConocimiento().getId());
            }
            SgpResolucionesSenescyt resolucion = new resoluciones().getListResolucion(plan.getId().getCurposId()); //obtiene resolucion
            this._selectedCab=String.valueOf(plan.getSgpComponentesCabeceras().getId()); //asigna la cabecera de componentes
            //arma la tabla de datos generales
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMM yyyy"); //formato de fecha
            String[][] tb=new String[2][18]; //para guardar resultados
            //prepara la salida (matriz)
            tb[0][0]="CODSENESCYT"; tb[1][0]=String.valueOf(curso.getAbreviatura()); 
            tb[0][1]="NOMBREPLAN"; tb[1][1]=String.valueOf(plan.getNombre());
            tb[0][2]="DENOMINACION"; tb[1][2]=String.valueOf(curso.getNombre());
            tb[0][3]="GRADOACADEMICO"; tb[1][3]=String.valueOf(nivel.getNombre());
            tb[0][4]="TITULO";tb[1][4]=String.valueOf(titulo.getNombre()); 
            tb[0][5]="UNIDAD";tb[1][5]=String.valueOf(depen.getDescripcion()); 
            tb[0][6]="SEDE";tb[1][6]=String.valueOf(sede.getDescripcion()); 
            tb[0][7]="DESCRIPCIONCOMPUESTA";tb[1][7]=String.valueOf(vstub.getDescripcionCompuesta()); 
            tb[0][8]="FECHAFACULTAD";tb[1][8]=String.valueOf(sdf.format(curso.getFechaAprobacionFacultad())); 
            tb[0][9]="FECHADIRECCION";tb[1][9]=String.valueOf(sdf.format(curso.getFechaAprobacionDireccion()));
            tb[0][10]="NRORESOLUCION";tb[1][10]=String.valueOf(curso.getNroResolucionConsejo()); 
            tb[0][11]="FECHARESOLUCION";tb[1][11]=String.valueOf(sdf.format(curso.getFechaAprobacionConsejo())); 
            tb[0][12]="AREACONOCIMIENTO";tb[1][12]=String.valueOf(area.getNombre()); 
            tb[0][13]="SUBAREACONOCIMIENTO";tb[1][13]=String.valueOf(subarea.getNombre()); 
            tb[0][14]="CREDITOSESTUDIO";tb[1][14]=String.valueOf(plan.getCreditosGrado()); 
            tb[0][15]="CREDITOSTRABAJO";tb[1][15]=String.valueOf(plan.getCreditosTesis()); 
            tb[0][16]="NROSENESCYT";tb[1][16]=String.valueOf(resolucion.getNroResolucion()); 
            tb[0][17]="FECHASENESCYT";tb[1][17]=String.valueOf(sdf.format(resolucion.getFechaResolucion())); 
            //tb[0][1]="PLAN_ID"; tb[1][1]="0";//String.valueOf(plan.getId().getId()); 
            //tb[0][2]="CABCOM_ID"; tb[1][2]="0";//String.valueOf(plan.getSgpComponentesCabeceras().getId());
            //tb[0][20]="CURSO_ID"; tb[1][20]="0";//this._selectedCurso;
            return tb;
        }catch(Exception ex){
            System.out.println("Rest Error: "+ex.getMessage());
        }
        return new Object();
    }
}
