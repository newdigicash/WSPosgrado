/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import acceso.Consultas;
import acceso.ParametrosConsulta;
import acceso.db;
import datos.pojos.academico.SgaModalidades;
import datos.pojos.sgap.SgpPlanesModalidades;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author usuario
 */
public class modalidades {

    //eliminar modalidad
    public boolean Delete(SgpPlanesModalidades l) {
        boolean resultado = false;
        Session s = null;
        Transaction t = null;
        try {
            s = db.abrirSesion();
            t = s.beginTransaction();
            s.delete(l);
            t.commit();
            resultado = true;
        } catch (Exception e) {
            db.rollbackTransacion(t);
        } finally {
            db.cerrarSesion();
        }
        return resultado;
    }

    //lista modalidades
    public List<SgaModalidades> getModalidades() {
        List<SgaModalidades> niveles = null;
        Session sesion = null;
        try {
            sesion = db.abrirSesion();
            niveles = sesion.createCriteria(SgaModalidades.class).add(Restrictions.sqlRestriction("estaactivo = 'S'")).list();
        } catch (Exception e) {
            niveles = null;
        } finally {
            db.cerrarSesion();
        }
        return niveles;
    }
    
    //modalidad por id
    public SgaModalidades getModalidad(int _id){
        Consultas cons = new Consultas();
        SgaModalidades modalidad = (SgaModalidades) cons.getOneHql(null, "SgaModalidades", "Where id="+_id, new ArrayList<ParametrosConsulta>());
        return modalidad;
    }
    
    //lista lineas
    public List<SgpPlanesModalidades> listarModalidades(int _idPlan, int _idCurso) {
        Consultas cons = new Consultas();
        List<SgpPlanesModalidades> auxList = cons.getListHql(null, "SgpPlanesModalidades", "where sgpPlanesCurso.id.id= '" + String.valueOf(_idPlan) + "' and sgpPlanesCurso.id.curposId='" + String.valueOf(_idCurso) + "'and estaactivo='S' ", new ArrayList<ParametrosConsulta>());
        return auxList;
    }
    
    /**
     * Listado de modalidades 
     * @param _idPlan
     * @param _idCurso
     * @return Listado de modalidades SgaModalidades 
     */
    public List<SgaModalidades> listarSgaModalidades(int _idPlan, int _idCurso) {
        List<SgaModalidades> resultado = new ArrayList<SgaModalidades>();
        SgaModalidades modalidad = new SgaModalidades();
        try {
            Consultas cons = new Consultas();
            List<SgpPlanesModalidades> auxList = cons.getListHql(null, "SgpPlanesModalidades", "where sgpPlanesCurso.id.id= '" + String.valueOf(_idPlan) + "' and sgpPlanesCurso.id.curposId='" + String.valueOf(_idCurso) + "'and estaactivo='S' ", new ArrayList<ParametrosConsulta>());
            for (SgpPlanesModalidades planMod : auxList) {
                modalidad = (SgaModalidades) cons.getOneHql(null, "SgaModalidades", "where id='" + planMod.getId().getModalidadId() + "' and estaactivo='S'", new ArrayList<ParametrosConsulta>());
                if (modalidad != null) {
                    resultado.add(modalidad);
                }
            }
        } catch (Exception e) {
            resultado = new ArrayList<SgaModalidades>();
        }
        return resultado;
    }
}
