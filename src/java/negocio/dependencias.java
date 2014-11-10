/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import acceso.Consultas;
import acceso.ParametrosConsulta;
import acceso.db;
import datos.pojos.adminuc.Dependencias;
import datos.pojos.sgap.SgpCursosPostgrado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author usuario
 */
public final class dependencias {

    /**
     * Devuelve la lista dependencias a la que tiene acceso el usuario actual
     *
     * @return Lista[dependencia_id,dependencia_id_padre,descripcion]
     */
    
    public List<Object[]> getIdsDependenciasAccesos() {
        String usuarioId = config.getUsuarioId();
        List<Object[]> resultado = null;
        Session s = null;
     
        try {
            s = db.abrirSesion();
            Connection c = s.connection();
            Statement st = c.createStatement();
            resultado = new ArrayList<Object[]>();
            /*String hql = "select distinct * from  "
                    + "(select id, depend_id_padre, descripcion from adminuc.dependencias where estaactivo ='S' start with id in ("
                    + " select distinct dependencia_id from adminuc.sgp_accesos where usuari_personid = 'XXXX' and estaactivo = 'S'"
                    + " ) CONNECT BY nocycle depend_id_padre = prior id"
                    + " union"
                    + " select id, depend_id_padre, descripcion from adminuc.dependencias where estaactivo ='S' start with id in ("
                    + " select distinct dependencia_id from adminuc.sgp_accesos where usuari_personid = 'XXXX' and estaactivo = 'S'"
                    + " )  CONNECT BY nocycle  prior depend_id_padre =  id ) a order by depend_id_padre, id,descripcion";
                    */
            //Me parece mejor  la consulta directa(daniel)
             String hql = "  select id, depend_id_padre, lpad(' ', 2*level) || descripcion "
                    + "  from adminuc.dependencias "
                    + "  where estaactivo ='S' "
                    + "  start with id in ("
                    + "      select distinct dependencia_id "
                    + "      from adminuc.sgp_accesos "
                    + "      where usuari_personid = 'XXXX' and estaactivo = 'S' ) "
                    + "  CONNECT BY nocycle depend_id_padre = prior id"
                    + "  order SIBLINGS by descripcion ";
            hql = hql.replace("XXXX", usuarioId);
            ResultSet rs = st.executeQuery(hql);
            while (rs.next()) {
                int a = rs.getInt(1);
                int b = rs.getInt(2);
                Object[] o = new Object[]{a, b};
                resultado.add(o);
            }
            rs.close();
        } catch (Exception e) {
//            System.err.println("listaIdDependencias() - " + e.getMessage());
            resultado = null;
        } finally {
            db.cerrarSesion();
        }
        return resultado;
    }
    
    
    public List<Object[]> getIdsDependenciasConPrograma() {
        String usuarioId = config.getUsuarioId();
        List<Object[]> resultado = null;
        Session s = null;
     
        try {
            s = db.abrirSesion();
            Connection c = s.connection();
            Statement st = c.createStatement();
            resultado = new ArrayList<Object[]>();
             String hql = "  select id, depend_id_padre, lpad(' ', 2*level) || descripcion "
                    + "  from adminuc.dependencias "
                    + "  where estaactivo ='S' "
                    + "  start with id in (0) "
                    + "  CONNECT BY nocycle depend_id_padre = prior id"
                    + "  order SIBLINGS by descripcion ";
            ResultSet rs = st.executeQuery(hql);
            while (rs.next()) {
                int a = rs.getInt(1);
                int b = rs.getInt(2);
                Object[] o = new Object[]{a, b};
                resultado.add(o);
            }
            rs.close();
        } catch (Exception e) {
//            System.err.println("listaIdDependencias() - " + e.getMessage());
            resultado = null;
        } finally {
            db.cerrarSesion();
        }
        return resultado;
    }
    
    

    public List<Dependencias> getDependenciasAccesos() {
        List<Dependencias> resultado = new ArrayList<Dependencias>();
        List<Object[]> aux = getIdsDependenciasAccesos();
        if (aux != null) {
            Session s = null;
            Transaction t = null;
            try {
                s = db.abrirSesion();
                t = s.beginTransaction();
                for (Object[] ob : aux) {
                    int id = Integer.valueOf(ob[0].toString());
                    Dependencias d = (Dependencias) s.get(Dependencias.class, id);
                    resultado.add(d);
                }
                t.commit();
            } catch (Exception e) {
                db.rollbackTransacion(t);
            } finally {
                db.cerrarSesion();
            }
        }
        return resultado;
    }

    /**
     * Devuelve el listado de las dependencias a las que tiene acceso el usuario
     * 
     * @return
     */
    public List<Dependencias> getVstDependencias() {
        List<Dependencias> dependenciasfiltrado = new ArrayList<Dependencias>();
        Session sesion = null;
        try {
            sesion = db.abrirSesion();
            // Consulta que obtiene las unidades academicas a las q tiene acceso el usuario
            //  SQLQuery q = sesion.createSQLQuery("select unidad_academica_id from vst_accesos where persona_id= '" + config.getUsuarioId() + "' group by unidad_academica_id");
            SQLQuery q = sesion.createSQLQuery(" select dependencia_id, dependencia from vst_accesos where persona_id= '" + config.getUsuarioId() + "' group by dependencia_id, dependencia order by dependencia");
            // List<Object> list = q.list();
            List<Object[]> list = q.list();
            if (list != null) {
                for (Object[] fila : list) {
                    //Se obtiene el id de la unidad academica
                    int idUAcademica = Integer.valueOf(fila[0].toString());
                    Dependencias dep = new Dependencias();
                    //se obtiene el objeto dependencia con el id
                    dep = (Dependencias) sesion.get(Dependencias.class, idUAcademica);
                    if (dep != null) {
                        //Se agrega el objeto a la lista de dependencias
                        dependenciasfiltrado.add(dep);
                    }
                }
            }
        } catch (Exception e) {
            dependenciasfiltrado.clear();
        } finally {
            db.cerrarSesion();
        }

        return dependenciasfiltrado;
    }
    
    /**
     * Devuelve objeto dependencia
     *
     * @param idDependencia
     * @return
     */
    public Dependencias getDependencia(int idDependencia) {
        Consultas con = new Consultas();
        Dependencias dependencia = null;
        try {
            dependencia = (Dependencias) con.getOneHql(null, "Dependencias", "where id='" + idDependencia + "' and estaactivo='S'", new ArrayList<ParametrosConsulta>());
            return dependencia;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Dependencias> getDependencias() {
        List<Dependencias> dep = new ArrayList<Dependencias>();
        String where = "from Dependencias where estaactivo = 'S' and (tipdepId = 1 or tipdepId = 6)";

        dep = Consultas.getListHql(where);
        return dep;
    }

    /**
     * Devuelve la lista dependencias a la que tiene acceso el usuario actual
     *
     * @return Lista[dependencia_id,dependencia_id_padre,descripcion]
     */
    public List<Object[]> getIdsDependencias() {

        List<Object[]> resultado = null;
        Session s = null;
        try {
            s = db.abrirSesion();
            Connection c = s.connection();
            Statement st = c.createStatement();
            resultado = new ArrayList<Object[]>();
            String hql = "select distinct * from ("
                    + "select id, depend_id_padre, descripcion "
                    + "from adminuc.dependencias "
                    + "where estaactivo ='S'  "
                    + "CONNECT BY nocycle  prior depend_id_padre =  id)  "
                    + "a order by depend_id_padre, id, descripcion";
            
             hql = "  select id, depend_id_padre, lpad(' ', 2*level) || descripcion "
                    + "  from adminuc.dependencias "
                    + "  where estaactivo ='S' "
                    + "  start with id=0 "
                    + "  CONNECT BY nocycle depend_id_padre = prior id"
                    + "  order SIBLINGS by descripcion ";
            
            
            ResultSet rs = st.executeQuery(hql);
            while (rs.next()) {
                int a = rs.getInt(1);
                int b = rs.getInt(2);
                Object[] o = new Object[]{a, b};
                resultado.add(o);
            }
            rs.close();
        } catch (Exception e) {
            //System.err.println("listaIdDependencias() - " + e.getMessage());
            resultado = null;
        } finally {
            db.cerrarSesion();
        }
        return resultado;
    }
    /*
     * Funcion Utilizada para Reporte de Horarios Docentes, que recibe como
     * parametro una lista de Cursos de Postgrado y devuelve una lista de
     * FACULTADES no repetidas
     */

    public List<Dependencias> getListaDependenciasUnicas(List<Object[]> lista) {
        //public List<Dependencias> getListaDependenciasUnicas(List<Object[]> lista) {


        List<Integer> listaIntDepCurso = new ArrayList<Integer>();
        List<Dependencias> listadoDepend = new ArrayList<Dependencias>();
        List<Object[]> Depefacutades = new ArrayList<Object[]>();
        Session sesion = null;
        //recorre la lista de cursos y obtiene una lista unica de dependencias
        for (Object[] cursosEdicion : lista) {
            //     for (Object[] cursos : lista) {
            Boolean existe = false;
            SgpCursosPostgrado curso = (SgpCursosPostgrado) cursosEdicion[0];
            Integer idDep = curso.getDependencia().getId();
            if (listaIntDepCurso.isEmpty()) {
                listaIntDepCurso.add(idDep);
            } else {
                for (Integer dependencias : listaIntDepCurso) {
                    if (idDep == dependencias) {
                        existe = true;
                    }
                }
                if (existe == false) {
                    listaIntDepCurso.add(idDep);
                }
            }

        }
        //obtiene el id de la facultad del la dependencia del curso.
        for (Integer lInteger : listaIntDepCurso) {
            try {
                sesion = db.abrirSesion();
                String cadena = "select id, IdUnidadAcademicaHaciaArriba(dep.id) "
                        + " from ADMINUC.DEPENDENCIAS dep where dep.id = " + lInteger;
                SQLQuery sql = sesion.createSQLQuery(cadena);
                Depefacutades = sql.list();
            } catch (Exception e) {
                //System.err.println("ERROR EN LISTA");
            } finally {
                db.cerrarSesion();
            }
            //Obtiene los Objetos de las FACULTADES.
            if (Depefacutades != null) {
                if (Depefacutades.size() > 0) {
                    for (Object[] objects : Depefacutades) {
                        Object objDep = Consultas.get(Dependencias.class, Integer.valueOf(objects[1].toString()));
                        Dependencias dependencia = (Dependencias) objDep;
                        boolean existe = false;
                        for (Dependencias dep: listadoDepend) {
                            if (Integer.valueOf(objects[1].toString()) == dep.getId()) {
                                existe = true;
                            }
                        }
                        if (existe == false) {
                            listadoDepend.add(dependencia);
                        }
                    }
                }
            }

        }
        return listadoDepend;
    }
//   public List<Dependencias> getListaDependenciasUnicas(List<SgpCursosPostgrado> lista) {
//    //public List<Dependencias> getListaDependenciasUnicas(List<Object[]> lista) {
//        
//        
//        List<Integer> listaIntDepCurso = new ArrayList<Integer>();
//        List<Dependencias> listadoDepend = new ArrayList<Dependencias>();
//        List<Object[]> Depefacutades = new ArrayList<Object[]>();
//        Session sesion = null;
//        //recorre la lista de cursos y obtiene una lista unica de dependencias
//        for (SgpCursosPostgrado cursos : lista) {
//   //     for (Object[] cursos : lista) {
//            Boolean existe = false;
//            Integer idDep = cursos.getDependencia().getId();
//            if (listaIntDepCurso.isEmpty()) {
//                listaIntDepCurso.add(idDep);
//            } else {
//                for (Integer dependencias : listaIntDepCurso) {
//                    if (idDep == dependencias) {
//                        existe = true;
//                    }
//                }
//                if (existe == false) {
//                    listaIntDepCurso.add(idDep);
//                }
//            }
//            
//        }
//        //obtiene el id de la facultad del la dependencia del curso.
//        for (Integer lInteger : listaIntDepCurso) {
//            try {
//                sesion = db.abrirSesion();
//                String cadena = "select id, IdUnidadAcademicaHaciaArriba(cp.id)"
//                        + " from sgp_cursos_postgrado cp"
//                        + " where cp.id = " + lInteger;
//                SQLQuery sql = sesion.createSQLQuery(cadena);
//                Depefacutades = sql.list();
//            } catch (Exception e) {
//                System.err.println("ERROR EN LISTA");
//            } finally {
//                db.cerrarSesion();
//            }
//            //Obtiene los Objetos de las FACULTADES.
//            if (Depefacutades != null) {
//                if (Depefacutades.size() > 0) {
//                    for (Object[] objects : Depefacutades) {
//                        Object objDep = Consultas.get(Dependencias.class, Integer.valueOf(objects[1].toString()));
//                        Dependencias dependencia = (Dependencias) objDep;
//                        listadoDepend.add(dependencia);
//                    }
//                }
//            }
//            
//        }
//        return listadoDepend;
//    }
    
    public List<Dependencias> getDependenciasDocente(String idDocente){
        List<Dependencias> resultado = new ArrayList<Dependencias>();
        Session s;
        Transaction t = null;
        try {
            s = db.abrirSesion();
            t = s.beginTransaction();
            String sql = "SELECT DISTINCT DEP.ID, DEP.DESCRIPCION " 
                    + "FROM SGP_CURSOS_POSTGRADO CP " 
                    + "INNER JOIN SGP_OFERTA_DOCENTES OD ON OD.CURPOS_ID = CP.ID "
                    + "INNER JOIN VST_ACCESOS ACC ON ACC.CURPOS_ID = CP.ID "
                    + "INNER JOIN ADMINUC.DEPENDENCIAS DEP ON DEP.ID = CP.DEPENDENCIA_ID "
                    + "WHERE CP.ESTAACTIVO = 'S' " 
                    + "AND OD.ESTAACTIVO = 'S' " 
                    + "AND OD.PERSONA_ID = '" + idDocente + "' " 
                    + "AND ACC.PERSONA_ID = '" + config.getUsuarioId() + "'";
            List<Object[]> resultadoLista = s.createSQLQuery(sql).list();
            for (Object[] curPosArr : resultadoLista){
                Dependencias dependencia = new Dependencias();
                dependencia.setId(Integer.valueOf(curPosArr[0].toString()));
                dependencia.setDescripcion(String.valueOf(curPosArr[1]));
                resultado.add(dependencia);
            }
            t.commit();
        } catch (Exception e){
            db.rollbackTransacion(t);
        } finally {
            db.cerrarSesion();
        }
        return resultado;
    }
    
    public String getNombreFacultad (String idDependencia) {
        String facultad = "";
        Session s;
        Transaction t = null;
        try {
            s = db.abrirSesion();
            t = s.beginTransaction();
            String sql = "SELECT POSTGRADO.UNIDADACADEMICAHACIAARRIBA(" 
                    + idDependencia + ") FROM DUAL";
            Object resultadoObj = s.createSQLQuery(sql).uniqueResult();
            if (resultadoObj == null) {
                facultad = "";
            } else {
                facultad = String.valueOf(resultadoObj);
            }
            t.commit();
        } catch (Exception e){
            db.rollbackTransacion(t);
        } finally {
            db.cerrarSesion();
        }
        return facultad;
    }
    
}
