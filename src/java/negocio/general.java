/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import acceso.db;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author usuario
 */
public class general {
    //Devuelve los postgrados a los que un usuario tiene acceso

    public List<VstAccesos> getVstAccesos() {
        List<VstAccesos> resultado = new ArrayList<VstAccesos>();
        Session sesion = null;
        Iterator it = null;
        try {
            sesion = db.abrirSesion();
            SQLQuery q = sesion.createSQLQuery("select * from vst_accesos where persona_id= '" + config.getUsuarioId() + "'");
            List<Object[]> list = q.list();
            for (Object[] fila : list) {
                VstAccesos acc = new VstAccesos();
                acc.setPersonaId(fila[0].toString());
                acc.setDependenciaId(Integer.valueOf(fila[1].toString()));
                acc.setDependenciaNombre(fila[2].toString());
                acc.setCursoId(Integer.valueOf(fila[3].toString()));
                acc.setCursoNombre(fila[4].toString());
                acc.setUnidadAcademicaId(Integer.valueOf(fila[5].toString()));
                acc.setUnidadAcademicaNombre(fila[6].toString());
                resultado.add(acc);
            }

            //t.commit();
        } catch (Exception e) {

            resultado.clear();
            //HibSession.rollbackTransacion(t);
        } finally {
            db.cerrarSesion();
        }
        return resultado;
    }

    //Devuelve los postgrados pertenecientes a una unidad academica sin filtrar por persona
    public List<VstAccesos> getVstAccesosSinFiltro(String idUAcademica) {
        List<VstAccesos> resultado = new ArrayList<VstAccesos>();
        Session sesion = null;
        Iterator it = null;
        try {
            sesion = db.abrirSesion();
            String sqlQuery = "select dpd.id as dependenciaId, dpd.descripcion as dependenciaNombre, crs.id as cursoId, crs.nombre as cursoNombre, crs.dependencia_id as unidadAcademicaId"
                    + " from (  SELECT id, descripcion FROM adminuc.dependencias"
                    + " START WITH id = " + idUAcademica + " CONNECT BY nocycle depend_id_padre = PRIOR id) dpd"
                    + " inner join sgp_cursos_postgrado crs on crs.dependencia_id = dpd.id and crs.estaactivo = 'S'";
            SQLQuery q = sesion.createSQLQuery(sqlQuery);
            List<Object[]> list = q.list();
            for (Object[] fila : list) {
                VstAccesos acc = new VstAccesos();
                acc.setPersonaId("");
                acc.setDependenciaId(Integer.valueOf(fila[0].toString()));
                acc.setDependenciaNombre(fila[1].toString());
                acc.setCursoId(Integer.valueOf(fila[2].toString()));
                acc.setCursoNombre(fila[3].toString());
                acc.setUnidadAcademicaId(Integer.valueOf(fila[4].toString()));
                acc.setUnidadAcademicaNombre("");
                resultado.add(acc);
            }

            //t.commit();
        } catch (Exception e) {

            resultado.clear();
            //HibSession.rollbackTransacion(t);
        } finally {
            db.cerrarSesion();
        }
        return resultado;
    }

    //Devuelve los postgrados pertenecientes a una unidad académica, filtra por personas
    public List<VstAccesos> getVstAccesosPath(String idUAcademica) {
        List<VstAccesos> resultado = new ArrayList<VstAccesos>();
        Session sesion = null;
        Iterator it = null;
        try {
            sesion = db.abrirSesion();
            SQLQuery q = sesion.createSQLQuery("select * from vst_accesos_path where persona_id= '"
                    + config.getUsuarioId() + "' and path like '%|" + idUAcademica + "|%' order by curso");
            List<Object[]> list = q.list();
            for (Object[] fila : list) {
                VstAccesos acc = new VstAccesos();
                acc.setPersonaId(fila[0].toString());
                acc.setDependenciaId(Integer.valueOf(fila[1].toString()));
                acc.setDependenciaNombre(fila[2].toString());
                acc.setCursoId(Integer.valueOf(fila[3].toString()));
                acc.setCursoNombre(fila[4].toString());
//                if (fila[5] == null) {
//                    acc.setUnidadAcademicaId(Integer.valueOf(fila[1].toString()));
//                } else {
                acc.setUnidadAcademicaId(Integer.valueOf(fila[5].toString()));
//                }
//                if (fila[6] == null) {
//                    acc.setUnidadAcademicaNombre(fila[2].toString());
//                } else {
                acc.setUnidadAcademicaNombre(fila[6].toString());
//                }
                resultado.add(acc);
            }
        } catch (Exception e) {
            resultado.clear();
        } finally {
            db.cerrarSesion();
        }
        return resultado;
    }
}
