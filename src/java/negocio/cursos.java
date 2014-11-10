/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.pojos.adminuc.NivelesFormacion;
import datos.pojos.sgap.SgpAreasConocimiento;
import datos.pojos.sgap.SgpSubareas;
import org.hibernate.criterion.Restrictions;
import acceso.ParametrosConsulta;
import datos.pojos.sgap.SgpCursosPostgrado;
import acceso.Consultas;
import acceso.db;
import datos.pojos.sgap.SgpDocumentosBinarios;
import datos.pojos.sgap.SgpEdiciones;
import datos.pojos.sgap.SgpParametrosCurso;
import datos.pojos.sgap.SgpResolucionesSenescyt;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
//import java.sql.Date;
import java.util.List;
import oracle.jdbc.OracleTypes;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author usuario
 */
public class cursos {

    Date ahora = new Date();
    String usuario = config.getUsuarioId();

    /**
     * funcion que devuelve todo el pojo de curso segun el id del curso
     *
     * @param idCurso id del curso a buscar
     * @return curso
     */
    public SgpCursosPostgrado getCurso(int idCurso) {
        Consultas con = new Consultas();
        SgpCursosPostgrado curso = null;
        try {
            curso = (SgpCursosPostgrado) con.getOneHql(null, "SgpCursosPostgrado", "where id='" + idCurso + "' and estaactivo='S'", new ArrayList<ParametrosConsulta>());
            return curso;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * funcion que devuelve una lista de cursos
     *
     * @param filtro es el ambito de busqueda para filtrar los cursos
     * @return lista de cursos
     */
    public List<SgpCursosPostgrado> getCursosAccesos(String filtro) {
        filtro = filtro.replace("'", "");
        List<SgpCursosPostgrado> resultado = new ArrayList<SgpCursosPostgrado>();
        List<SgpCursosPostgrado> aux = Consultas.getListHql(" from SgpCursosPostgrado as c "
                                                          + " where "
                                                          + " ( c.nombre like '%" + filtro + "%' "
                                                          + " or c.abreviatura like '%" + filtro + "%' "
                                                          + " or c.dependencia.descripcion like '%" + filtro + "%' "
                                                          + " or c.titulo.nombre like '%" + filtro + "%' "
                                                          + "  ) "
                                                          + " and c.estaactivo = 'S' "
                                                          + " order by c.id");
        List<Integer> accesos = config.getAccesoCursos(null);
        try {
            for (SgpCursosPostgrado cur : aux) {
                for (Integer id : accesos) {                
                    if (cur.getId() == id) {
                        resultado.add(cur);
                        break;
                    }
                }
            }
        } catch (Exception e) {
        }
        return resultado;
    }
    /*
     * Funcion utilizada para la Generacion de Reporte de Horarios Docentes, la
     * misma que recibe como parÃ¡metro el la identificacion del docente, y los
     * rangos de fechas en los que se desea visualizar el horario. Devuelve la
     * lista de Cursos de postgrado a los q pertenece la oferta del horario del
     * docente
     */

    public List<Object[]> getCursosHorariosDocentes(String personaId, String fInicia, String fTermina) {
        List<Integer[]> listIdCursoEdicion = new ArrayList<Integer[]>();
        List<Object[]> listaCursos = new ArrayList<Object[]>();

        Session s = null;
        Transaction t = null;
        try {
            s = db.abrirSesion();
            /*
             * Procedimiento almacenado que devuelve la lista de horarios de un
             * docente especÃ­fico dentro de un rango de fechas establecido
             */
            
            CallableStatement proc = s.connection().prepareCall("{call PRC_LIST_HOR_DOC_FECHAS(?,?,?,?)}");
            proc.setString(1, personaId);            
            //proc.setString(2, fInicia);
            java.sql.Date fechaInicia = new java.sql.Date(util.util.getFecha(fInicia).getTime());
            proc.setDate(2, fechaInicia);
            //proc.setString(3, fTermina);
            java.sql.Date fechaTermina = new java.sql.Date(util.util.getFecha(fTermina).getTime());
            proc.setDate(3, fechaTermina);
            proc.registerOutParameter(4, OracleTypes.CURSOR);
            
            proc.execute();
            ResultSet rs = (ResultSet) proc.getObject(4);
            int i = 0;
            while (rs.next()) {
                int cur = rs.getInt(1);
                int edi = rs.getInt(2);
                String person = rs.getString(5);
                Date fechaI = rs.getDate(6);
                Date fechaT = rs.getDate(7);
                listIdCursoEdicion.add(new Integer[]{cur, edi});
            }
        } catch (Exception e) {
            listIdCursoEdicion.clear();
        } finally {
            db.cerrarSesion();
        }

        if (listIdCursoEdicion != null) {
            if (listIdCursoEdicion.size() > 0) {
                for (Integer[] idCursoEdicion : listIdCursoEdicion) {
                    SgpCursosPostgrado curso = new SgpCursosPostgrado();
                    int idC = idCursoEdicion[0];
                    int idE = idCursoEdicion[1];
                    Object objCurso = Consultas.get(SgpCursosPostgrado.class, idC);
                    curso = (SgpCursosPostgrado) objCurso;
                    listaCursos.add(new Object[]{curso,idE});
                }
            }
        }
        return listaCursos;
    }

//    public List<SgpCursosPostgrado> getCursosHorariosDocentes(String personaId, String fInicia, String fTermina) {
//        List<Integer> listIdCursos = new ArrayList<Integer>();
//        List<SgpCursosPostgrado> listaCursos = new ArrayList<SgpCursosPostgrado>();
//
//        Session s = null;
//        Transaction t = null;
//        try {
//            s = db.abrirSesion();
//            /*
//             * Procedimiento almacenado que devuelve la lista de horarios de un
//             * docente especÃ­fico dentro de un rango de fechas establecido
//             */
//            CallableStatement proc = s.connection().prepareCall("{call PRC_LIST_HOR_DOC_FECHAS(?,?,?,?)}");
//            proc.setString(1, personaId);
//            proc.setString(2, fInicia);
//            proc.setString(3, fTermina);
//            proc.registerOutParameter(4, OracleTypes.CURSOR);
//
//            proc.execute();
//            ResultSet rs = (ResultSet) proc.getObject(4);
//            int i = 0;
//            while (rs.next()) {
//                int aux = rs.getInt(1);
//                String person = rs.getString(5);
//                Date fechaI = rs.getDate(6);
//                Date fechaT = rs.getDate(7);
//                listIdCursos.add(aux);
//            }
//        } catch (Exception e) {
//        } finally {
//            db.cerrarSesion();
//        }
//
//        if (listIdCursos != null) {
//            for (Integer idCurso : listIdCursos) {
//                SgpCursosPostgrado curso = new SgpCursosPostgrado();
//                Object objCurso = Consultas.get(SgpCursosPostgrado.class, idCurso);
//                curso = (SgpCursosPostgrado) objCurso;
//                listaCursos.add(curso);
//            }
//        }
//        return listaCursos;
//    }
    /*
     * Funcion que recibe una lista de objetos (Cursos,facultad), y devuelve una
     * lista de objetos q contiene el curso de postgrado la edicion y la
     * Facultad a la que pertenece
     */
    public List<Object[]> getObjetoCursoEdicionFacultad(List<Object[]> listaCursoEdicion) {
        Session sesion = null;
        List<Object[]> listaObjetoCursoFacultad = new ArrayList<Object[]>();
        List<Object[]> Depefacutades = new ArrayList<Object[]>();
        for (Object[] objCursoEdicion : listaCursoEdicion) {
            try {
                sesion = db.abrirSesion();
                SgpCursosPostgrado sgpCurso = (SgpCursosPostgrado) objCursoEdicion[0];
                Integer edicion = (Integer) objCursoEdicion[1];
                String cadena = "select id, IdUnidadAcademicaHaciaArriba(cp.id)"
                        + " from sgp_cursos_postgrado cp"
                        + " where cp.id = " + sgpCurso.getId();
                SQLQuery sql = sesion.createSQLQuery(cadena);
                Depefacutades = sql.list();
                String idFac = (String) Depefacutades.get(0)[1];
                listaObjetoCursoFacultad.add(new Object[]{sgpCurso, edicion, idFac});
            } catch (Exception e) {
//                System.err.println("ERROR EN LISTA");
            } finally {
                db.cerrarSesion();
            }
        }

        return listaObjetoCursoFacultad;
    }
//    public List<Object[]> getObjetoCursoFacultad(List<SgpCursosPostgrado> listaCurso) {
//        Session sesion = null;
//        List<Object[]> listaObjetoCursoFacultad = new ArrayList<Object[]>();
//        List<Object[]> Depefacutades = new ArrayList<Object[]>();
//        for (SgpCursosPostgrado sgpCurso : listaCurso) {
//            try {
//                sesion = db.abrirSesion();
//                String cadena = "select id, IdUnidadAcademicaHaciaArriba(cp.id)"
//                        + " from sgp_cursos_postgrado cp"
//                        + " where cp.id = " + sgpCurso.getId();
//                SQLQuery sql = sesion.createSQLQuery(cadena);
//                Depefacutades = sql.list();
//                String idFac = (String) Depefacutades.get(0)[1];
//                listaObjetoCursoFacultad.add(new Object[]{sgpCurso, idFac});
//            } catch (Exception e) {
//                System.err.println("ERROR EN LISTA");
//            } finally {
//                db.cerrarSesion();
//            }
//        }
//
//        return listaObjetoCursoFacultad;
//    }

    /**
     * ***
     */
//    public List<Object[]> getCursosHorariosDocentes(String personaId, String fInicia, String fTermina) {
//        List<Object[]> listIdCursos = new ArrayList<Object[]>();
//        List<SgpCursosPostgrado> listaCursos = new ArrayList<SgpCursosPostgrado>();
//
//        Session s = null;
//        Transaction t = null;
//        try {
//            s = db.abrirSesion();
//            /*
//             * Procedimiento almacenado que devuelve la lista de horarios de un
//             * docente especÃ­fico dentro de un rango de fechas establecido
//             */
//            CallableStatement proc = s.connection().prepareCall("{call PRC_LIST_HOR_DOC_FECHAS(?,?,?,?)}");
//            proc.setString(1, personaId);
//            proc.setString(2, fInicia);
//            proc.setString(3, fTermina);
//            proc.registerOutParameter(4, OracleTypes.CURSOR);
//
//            proc.execute();
//            ResultSet rs = (ResultSet) proc.getObject(4);
//            int i = 0;
//            while (rs.next()) {
//                int aux = rs.getInt(1);
//                String person = rs.getString(5);
//                Date fechaI = rs.getDate(6);
//                Date fechaT = rs.getDate(7);
//                listIdCursos.add(new Object[]{rs.getInt(1), rs.getInt(2), rs.getString(5), rs.getString(8)});
//            }
//        } catch (Exception e) {
//        } finally {
//            db.cerrarSesion();
//        }
//
////        if (listIdCursos != null) {
////            for (Integer idCurso : listIdCursos) {
////                SgpCursosPostgrado curso = new SgpCursosPostgrado();
////                Object objCurso = Consultas.get(SgpCursosPostgrado.class, idCurso);
////                curso = (SgpCursosPostgrado) objCurso;
////                listaCursos.add(curso);
////            }
////        }
//        return listIdCursos;
//    }
    /**
     * ***
     */
    /**
     * funcion que devuelve los postgrados a los que el usuario tiene acceso en
     * base a la dependencia especificada
     *
     * @param uAcademicaId
     * @return
     */
    public List<SgpCursosPostgrado> getPostgrados(int uAcademicaId) {
        List<VstAccesos> _listClaseVista = new ArrayList<VstAccesos>();
        //obtengo la lista de postgrados a la q tiene acceso el usuario
        _listClaseVista = new general().getVstAccesosPath(String.valueOf(uAcademicaId));
        //inicializo la lista de objetos tipo SgpCursosPostgrado
        List<SgpCursosPostgrado> postgradosfiltrado = new ArrayList<SgpCursosPostgrado>();
        Session sesion = null;
        try {
            sesion = db.abrirSesion();
            if (_listClaseVista != null) {
                if (_listClaseVista.size() > 0) {
                    //recorro la lista de tipo accesos
                    for (VstAccesos vistaAcc : _listClaseVista) {
                            //tomo el id del curso de postgrado
                            Integer stcurso = vistaAcc.getCursoId();
                            SgpCursosPostgrado curso = new SgpCursosPostgrado();
                            //obtengo el objeto tipo SgpCursosPostgrado y agrego a la lista
                            curso = (SgpCursosPostgrado) sesion.get(SgpCursosPostgrado.class, stcurso);
                            postgradosfiltrado.add(curso);
                        
                    }
                }
            }
        } catch (Exception e) {
            postgradosfiltrado.clear();
        } finally {
            db.cerrarSesion();
        }
        return postgradosfiltrado;

    }
     
    /**
     * Función que devuelve los postgrados a los que el usuario tiene acceso en
     * base a la dependencia especificada y que tienen cohortes con plan y malla
     *
     * @param uAcademicaId
     * @return
     */
    public List<SgpCursosPostgrado> getPostgradosConEdiciones(int uAcademicaId) {
        List<VstAccesos> _listClaseVista = new ArrayList<VstAccesos>();
        //obtengo la lista de postgrados a la q tiene acceso el usuario
        //La función getVstAccesosPath verifica todas las dependencias hijas en la búsqueda
        _listClaseVista = new general().getVstAccesosPath(String.valueOf(uAcademicaId));
        //inicializo la lista de objetos tipo SgpCursosPostgrado
        List<SgpCursosPostgrado> postgradosfiltrado = new ArrayList<SgpCursosPostgrado>();
        Session sesion = null;
        try {
            sesion = db.abrirSesion();
            if (_listClaseVista != null) {
                if (_listClaseVista.size() > 0) {
                    //recorro la lista de tipo accesos
                    for (VstAccesos vistaAcc : _listClaseVista) {
                        //tomo el id del curso de postgrado
                        Integer stcurso = vistaAcc.getCursoId();
                        //obtengo el objeto tipo SgpCursosPostgrado y agrego a la lista
                        SgpCursosPostgrado curso = (SgpCursosPostgrado) sesion.get(SgpCursosPostgrado.class, stcurso);
                        String hql = "from SgpEdiciones e where e.estaactivo = 'S' and (e.nombreEdicion like '%%'"
                                + " or e.sgpMallas.nombre like '%%' or e.sgpMallas.sgpPlanesCurso.nombre like '%%')"
                                + " and e.id.curposId = " + curso.getId();
                        List<SgpEdiciones> aux = sesion.createQuery(hql).list();
                        if (!aux.isEmpty()) {
                            postgradosfiltrado.add(curso);
                        }
                    }
                }
            }
        } catch (Exception e) {
            postgradosfiltrado.clear();
        } finally {
            db.cerrarSesion();
        }
        return postgradosfiltrado;

    } 
    
    /**
     * funcion que obtiene los datos del curso de postgrado por id
     * @param id
     * @return postgrado
     */

    public SgpCursosPostgrado getPostgradoXId (String id){
        String objeto = "SgpCursosPostgrado";
        String where = "WHERE  estaactivo='S'  AND Id=:ID";
        List<ParametrosConsulta> lisPar = new ArrayList();
        lisPar.add(new ParametrosConsulta("ID", id));
        Consultas consulta = new Consultas();
        try {
            return (SgpCursosPostgrado) consulta.getOneHql(null, objeto, where, lisPar);
        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * funcion que lista todo los cursos sin filtro de usuario
     *
     * @param uAcademicaId = id de la unidad academica para filtrar los cursos
     * @return lista postgradosfiltrado
     */
    public List<SgpCursosPostgrado> getPostgradosSinFiltro(int uAcademicaId) {
        List<VstAccesos> _listClaseVista = new ArrayList<VstAccesos>();
        //obtengo la lista de postgrados a la q tiene acceso el usuario
        _listClaseVista = new general().getVstAccesosSinFiltro(String.valueOf(uAcademicaId));
        //inicializo la lista de objetos tipo SgpCursosPostgrado
        List<SgpCursosPostgrado> postgradosfiltrado = new ArrayList<SgpCursosPostgrado>();
        Session sesion = null;
        try {
            sesion = db.abrirSesion();
            if (_listClaseVista != null) {
                if (_listClaseVista.size() > 0) {
                    //recorro la lista de tipo accesos
                    for (VstAccesos vistaAcc : _listClaseVista) {
                        // if (vistaAcc.getUnidadAcademicaId() == uAcademicaId) {
                        //tomo el id del curso de postgrado
                        Integer stcurso = vistaAcc.getCursoId();
                        SgpCursosPostgrado curso = new SgpCursosPostgrado();
                        //obtengo el objeto tipo SgpCursosPostgrado y agrego a la lista
                        curso = (SgpCursosPostgrado) sesion.get(SgpCursosPostgrado.class, stcurso);
                        postgradosfiltrado.add(curso);
                        // }
                    }
                }
            }
        } catch (Exception e) {
            postgradosfiltrado.clear();
        } finally {
            db.cerrarSesion();
        }
        return postgradosfiltrado;

    }
    
    /**
     * Funcion para inscripciones por internet, que lista todos los cursos sin filtro de usuario, 
     * que tengan ediciones activas, habilitadas y que esten dentro de fechas para inscripcion por inter.
     *
     * @param 
     * @return lista postgrados List<SgpCursosPostgrado>
     */
    public List<SgpCursosPostgrado> getPostgradosConEdicionesSinFiltro() {
        List<SgpCursosPostgrado> resultado = new ArrayList<SgpCursosPostgrado>();
        try {
            List<SgpEdiciones> cohortes = Consultas.getListHql(" from SgpEdiciones as e "
                                                          + " where "
                                                          + " e.estado in ('VIG', 'CUR') "
                                                          + " and e.autorizado = 'S' "
                                                          + " and e.estaactivo = 'S' ");
            parametrosCurso parametros = new parametrosCurso();
            SgpParametrosCurso insc;
            boolean incluido;
            SgpCursosPostgrado cursoPosgrado = null;
            for (SgpEdiciones cohorte : cohortes) {
                insc = parametros.getParametroCurso(cohorte.getId(), String.valueOf(config.PARAMETRO_INSCRIPCIONES_INTERNET));
                java.util.Date hoy = new java.util.Date();
                //La edición está en el periodo de inscripción
                if (insc != null && util.util.fechaEnRango(hoy, insc.getFecha1(), insc.getFecha2())) {
                    incluido = false;
                    for (SgpCursosPostgrado posgrado : resultado) {
                        if (posgrado.getId() == cohorte.getId().getCurposId()) {
                            incluido = true;
                            break;
                        }
                    }
                    if (!incluido) {
                        resultado.add((SgpCursosPostgrado) Consultas.get(SgpCursosPostgrado.class, cohorte.getId().getCurposId()));
                    }
                }
            }
        } catch (Exception e) {
            resultado = new ArrayList<SgpCursosPostgrado>();
        }
        return resultado;
        
    }

    /**
     * funcion que devuleve una lista de Niveles de formacion
     *
     * @return lista niveles
     */
    public List<NivelesFormacion> getNivelesCurso() {
        List<NivelesFormacion> niveles = null;
        Session sesion = null;
        try {
            sesion = db.abrirSesion();
            niveles = sesion.createCriteria(NivelesFormacion.class).add(Restrictions.sqlRestriction("estaactivo = 'S' and nivel = 'C'")).list();
        } catch (Exception e) {
            niveles = null;
        } finally {
            db.cerrarSesion();
        }
        return niveles;
    }

    /**
     * funcion que devuleve una lista de areas de conocimiento
     *
     * @return lista areas
     */
    public List<SgpAreasConocimiento> getAreasConocimiento() {
        List<SgpAreasConocimiento> areas = null;
        Session sesion = null;
        try {
            sesion = db.abrirSesion();
            areas = sesion.createCriteria(SgpAreasConocimiento.class).add(Restrictions.sqlRestriction("estaactivo = 'S'")).list();
        } catch (Exception e) {
            areas = null;
        } finally {
            db.cerrarSesion();
        }
        return areas;
    }

    /**
     * funcion que devuleve una lista de sub areas de conocimiento
     *
     * @return lista subareas
     */
    public List<SgpSubareas> getSubAreasConocimiento(int area) {
        List<SgpSubareas> subareas = null;
        Session sesion = null;
        try {
            sesion = db.abrirSesion();
            subareas = sesion.createCriteria(SgpSubareas.class).add(Restrictions.sqlRestriction("estaactivo = 'S' and area_id= " + area)).list();
        } catch (Exception e) {
            subareas = null;
        } finally {
            db.cerrarSesion();
        }
        return subareas;
    }

    /**
     * funcion que devuelve el pojo de area segun el id de la subarea
     *
     * @param subar id de subarea
     * @return pojo de area
     */
    public SgpAreasConocimiento getAreaPojo(int subar) {
        Consultas con = new Consultas();
        SgpAreasConocimiento areac = null;
        SgpSubareas subareas = null;
        try {
            subareas = (SgpSubareas) con.getOneHql(null, "SgpSubareas", "where id='" + subar + "' and estaactivo='S'", new ArrayList<ParametrosConsulta>());
            areac = (SgpAreasConocimiento) con.getOneHql(null, "SgpAreasConocimiento", "where id='" + subareas.getSgpAreasConocimiento().getId() + "' and estaactivo='S'", new ArrayList<ParametrosConsulta>());
            return areac;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * funcion que devuelve el pojo de subarea segun el id de la subarea
     *
     * @param subar id de subarea
     * @return pojo de subarea
     */
    public SgpSubareas getSubAreaPojo(int subareaSel) {
        SgpSubareas subarea = null;
        subarea = (SgpSubareas) Consultas.get(SgpSubareas.class, subareaSel);
        return subarea;
    }

    /**
     * funcion que guarda el curso de postgrado en forma transaccional es decir,
     * guarda primero los pdf de las resoluciones del consejo y de la senescyt,
     * luego se guarda el curso y por ultimo la resolucion senescyt.
     *
     * @param curso pojo del curso a guardar
     * @param docPDF pojo del pdf de la resolucion del consejo
     * @param listResolconPDF lista de resoluciones del senescyt con sus
     * respectivos pdfs
     * @param listResolsAux lista de resoluciones para saber que resolucion se
     * borro y no se guarden
     * @return true si se guardaron correctamente, false si existe un error.
     */
    public boolean guardarCurso(SgpCursosPostgrado curso, SgpDocumentosBinarios docPDF, List<SgpResolucionesSenescyt> listResolconPDF, List<SgpResolucionesSenescyt> listResolsAux) {
        boolean resultado = false;
        Session s = null;
        Transaction t = null;
        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            s = db.abrirSesion();
            t = s.beginTransaction();

            BigDecimal idDocumentos = (BigDecimal) s.createSQLQuery("select SEQ_DOCUMENTOS.nextval from dual").list().get(0);
            String valor = String.valueOf(idDocumentos);
            int idPDFconsejo = Integer.valueOf(valor) + 1;

            docPDF.setId(idPDFconsejo);
            docPDF.setCreado(usuario);
            docPDF.setFechaCreacion(ahora);
            docPDF.setEstaActivo('S');
            s.save(docPDF);
            s.flush();

            BigDecimal idCurso = (BigDecimal) s.createSQLQuery("select SEQ_CURSO.nextval from dual").list().get(0);
            String idC = String.valueOf(idCurso);
            int idCUR = Integer.valueOf(idC) + 1;
            curso.setId(idCUR);
            curso.setFechaCreacion(ahora);
            curso.setCreado(usuario);
            curso.setEstaactivo('S');
            curso.setSgpDocumentosBinarios(docPDF);
            s.save(curso);
            s.flush();

            if (!listResolconPDF.isEmpty()) {
                for (SgpResolucionesSenescyt resolucion : listResolconPDF) {
                    if (resolucion.getTipoTramite().equals("CREACION")) {
                        resolucion.setTipoTramite("CRE");
                    } else if (resolucion.getTipoTramite().equals("AMPLIACION VIGENCIA")) {
                        resolucion.setTipoTramite("AMP");
                    } else {
                        resolucion.setTipoTramite("REE");
                    }
                    if (resolucion.isNuevo() && (!resolucion.isEliminado())) {
                        BigDecimal idDoc = (BigDecimal) s.createSQLQuery("select SEQ_DOCUMENTOS.nextval from dual").list().get(0);
                        String idRes = String.valueOf(idDoc);
                        int idPDFResol = Integer.valueOf(idRes) + 1;
                        //int idPDFResol = Integer.valueOf(idRes);
                        SgpDocumentosBinarios documento = resolucion.getSgpDocumentosBinarios();
                        documento.setId(idPDFResol);
                        s.save(documento);
                        s.flush();
                        BigDecimal idResol = (BigDecimal) s.createSQLQuery("select SEQ_RESOLUCION.nextval from dual").list().get(0);
                        String idR = String.valueOf(idResol);
                        int idres = Integer.valueOf(idR) + 1;
                        //int idres = Integer.valueOf(idR);
                        resolucion.setSgpDocumentosBinarios(documento);
                        resolucion.setId(idres);
                        resolucion.setSgpCursosPostgrado(curso);
                        resolucion.setEstaactivo('S');
                        resolucion.setCreado(usuario);
                        resolucion.setFechaCreacion(ahora);
                        s.save(resolucion);
                        s.flush();
                    }
                    if (!(resolucion.isNuevo()) && resolucion.isEditado()) {
                        SgpDocumentosBinarios documentoEditado = resolucion.getSgpDocumentosBinarios();
                        s.update(documentoEditado);
                        s.update(resolucion);
                    }
                }
                if (!listResolsAux.isEmpty()) {
                    for (SgpResolucionesSenescyt resolElim : listResolsAux) {
                        if (!(resolElim.isNuevo()) && resolElim.isEliminado()) {
                            s.delete(resolElim);
                        }
                    }
                }
            }
            t.commit();
            resultado = true;
        } catch (Exception e) {
            //System.err.println("guardarCurso() - " + e.getMessage());
            db.rollbackTransacion(t);
        } finally {
            db.cerrarSesion();
        }

        return resultado;
    }

    /**
     * funcion que edita el curso de postgrado de forma transaccional
     *
     * @param curso pojo del curso a guardar
     * @param docPDF pojo del pdf de la resolucion del consejo
     * @param listResolconPDF lista de resoluciones del senescyt con sus
     * respectivos pdfs
     * @param listResolsAux lista de resoluciones para saber que resolucion se
     * borro y no se guarden
     * @return true si se guardaron correctamente, false si existe un error.
     */
    public boolean editarCurso(SgpCursosPostgrado curso, SgpDocumentosBinarios docPDF, boolean bandArchivo, List<SgpResolucionesSenescyt> listResolconPDF, List<SgpResolucionesSenescyt> listResolsAux) {

        boolean resultado = false;
        Session s = null;
        Transaction t = null;
        try {

            s = db.abrirSesion();
            t = s.beginTransaction();
            if (bandArchivo) {
                docPDF.setCreado(usuario);
                docPDF.setFechaCreacion(ahora);
                docPDF.setEstaActivo('S');
                s.update(docPDF);
            }
            curso.setFechaActualizacion(ahora);
            curso.setActualizado(usuario);
            if (bandArchivo) {
                curso.setSgpDocumentosBinarios(docPDF);
            }
            s.update(curso);
            s.flush();

            if (!listResolconPDF.isEmpty()) {
                for (SgpResolucionesSenescyt resolucion : listResolconPDF) {
                    if (resolucion.getTipoTramite().equals("CREACION")) {
                        resolucion.setTipoTramite("CRE");
                    } else if (resolucion.getTipoTramite().equals("AMPLIACION VIGENCIA")) {
                        resolucion.setTipoTramite("AMP");
                    } else {
                        resolucion.setTipoTramite("REE");
                    }
                    if (resolucion.isNuevo() && (!resolucion.isEliminado())) {
                        BigDecimal idDoc = (BigDecimal) s.createSQLQuery("select SEQ_DOCUMENTOS.nextval from dual").list().get(0);
                        String idRes = String.valueOf(idDoc);
                        int idPDFResol = Integer.valueOf(idRes) + 1;
                        SgpDocumentosBinarios documento = resolucion.getSgpDocumentosBinarios();
                        documento.setId(idPDFResol);
                        s.save(documento);
                        s.flush();
                        BigDecimal idResol = (BigDecimal) s.createSQLQuery("select SEQ_RESOLUCION.nextval from dual").list().get(0);
                        String idR = String.valueOf(idResol);
                        int idres = Integer.valueOf(idR) + 1;
                        resolucion.setSgpDocumentosBinarios(documento);
                        resolucion.setId(idres);
                        resolucion.setSgpCursosPostgrado(curso);
                        resolucion.setEstaactivo('S');
                        resolucion.setCreado(usuario);
                        resolucion.setFechaCreacion(ahora);
                        s.save(resolucion);
                        s.flush();
                    }
                    if (!(resolucion.isNuevo()) && resolucion.isEditado()) {
                        SgpDocumentosBinarios documentoEditado = resolucion.getSgpDocumentosBinarios();
                        s.update(documentoEditado);
                        s.update(resolucion);
                    }
                }
                if (!listResolsAux.isEmpty()) {
                    for (SgpResolucionesSenescyt resolElim : listResolsAux) {
                        if (!(resolElim.isNuevo()) && resolElim.isEliminado()) {
                            s.delete(resolElim);
                        }
                    }
                }
            }

            t.commit();
            resultado = true;
        } catch (Exception e) {
            //System.err.println("updateCurso() - " + e.getMessage());
            db.rollbackTransacion(t);
        } finally {
            db.cerrarSesion();
        }
        return resultado;
    }

    /**
     * elimina el curso de postgrado
     *
     * @param curso pojo del curso a eliminar
     * @param accion envia la accion de eliminar
     * @param _listaResols al eliminar el curso se debe primero eliminar todas
     * las resoluciones que pertenecen a ese curso.
     * @return
     */
    public boolean deleteCurso(SgpCursosPostgrado curso, String accion, List<SgpResolucionesSenescyt> _listaResols) {

        boolean resultado = false;
        Session s = null;
        Transaction t = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            s = db.abrirSesion();
            t = s.beginTransaction();
            for (SgpResolucionesSenescyt delResol : _listaResols) {
                s.delete(delResol);
                s.flush();
            }
            s.delete(curso);
            t.commit();
            resultado = true;
        } catch (Exception e) {
            //System.err.println("deleteCurso() - " + e.getMessage());
            db.rollbackTransacion(t);
        } finally {
            db.cerrarSesion();
        }
        return resultado;
    }

    /**
     * Recuperar los cursos de postgrado activos segun una dependencia incluyendo los
     * hijos, nietos, etc de esta.
     *
     * @param dependenciaId opcional, Id de la dependencia
     * @param filtro opcional filtro aplicado a la descripcion de la dependencia
     * @return
     */
    public List<SgpCursosPostgrado> getCursosCascada(Integer dependenciaId, String filtro) {
        List<SgpCursosPostgrado> resultado = new ArrayList<SgpCursosPostgrado>();
        Session s = null;
        Transaction t = null;
        try {
            s = db.abrirSesion();
            t = s.beginTransaction();
            String sql = "select id from vst_cursos_path where estaactivo = 'S'";
            if (dependenciaId != null) {
                sql += " and path like '%|" + dependenciaId + "|%'";
            }
            if (filtro != null) {
                sql += " and nombre like '%" + filtro + "%'";
            }
            List ids = s.createSQLQuery(sql).list();
            for (Object id : ids) {
                Integer curposId = new Integer(id.toString());
                SgpCursosPostgrado curs = (SgpCursosPostgrado) s.get(SgpCursosPostgrado.class, curposId);
                if (curs != null) {
                    resultado.add(curs);
                }
            }
            t.commit();
        } catch (Exception e) {
            //System.err.println("getCursosCascada(Integer dependenciaId, String filtro) - " + e.getMessage());
            db.rollbackTransacion(t);
        } finally {
            db.cerrarSesion();
        }
        return resultado;
    }
    
    public List<SgpCursosPostgrado> getCursosPersona(String idPersona){
        List<SgpCursosPostgrado> resultado = new ArrayList<SgpCursosPostgrado>();
        Session s;
        Transaction t = null;
        try {
            s = db.abrirSesion();
            t = s.beginTransaction();
            String sql = "SELECT CP.ID, CP.NOMBRE " +
                        "FROM SGP_CURSOS_POSTGRADO CP " +
                        "INNER JOIN SGP_MATRICULAS MAT ON MAT.CURPOS_ID = CP.ID " +
                        "INNER JOIN VST_ACCESOS ACC ON ACC.CURPOS_ID = CP.ID " +
                        "WHERE CP.ESTAACTIVO = 'S' " +
                        "AND MAT.ESTAACTIVO = 'S' " +
                        "AND MAT.ESTA_ANULADA = 'N' " +
                        "AND MAT.ESTA_RETIRADO = 'N' " +
                        "AND MAT.PERSONA_ID = '" + idPersona + "' " +
                        "AND ACC.PERSONA_ID = '" + config.getUsuarioId() + "' ";
            List<Object[]> resultadoLista = s.createSQLQuery(sql).list();
            for (Object[] curPosArr : resultadoLista){
                SgpCursosPostgrado curPos = new SgpCursosPostgrado();
                curPos.setId(Integer.valueOf(curPosArr[0].toString()));
                curPos.setNombre(String.valueOf(curPosArr[1]));
                resultado.add(curPos);
            }
            t.commit();
        } catch (Exception e){
            db.rollbackTransacion(t);
        } finally {
            db.cerrarSesion();
        }
        return resultado;
    }
    
    /**
     * Obtiene el listado de los posgrados en los que el docente tiene asignaturas ofertadas
     * @param idDocente id del docente a consultar
     * @param dependenciaId id de la dependencia que ha sido seleccionada
     * @return 
     */
    public List<SgpCursosPostgrado> getCursosDocente(String idDocente, String dependenciaId){
        List<SgpCursosPostgrado> resultado = new ArrayList<SgpCursosPostgrado>();
        Session s;
        Transaction t = null;
        try {
            s = db.abrirSesion();
            t = s.beginTransaction();
            String sql = "SELECT DISTINCT CP.ID, CP.NOMBRE " +
                        "FROM SGP_CURSOS_POSTGRADO CP " +
                        "INNER JOIN SGP_OFERTA_DOCENTES OD ON OD.CURPOS_ID = CP.ID " +
                        "INNER JOIN VST_ACCESOS ACC ON ACC.CURPOS_ID = CP.ID " +
                        "WHERE CP.ESTAACTIVO = 'S' " +
                        "AND CP.DEPENDENCIA_ID = " + dependenciaId + " " +
                        "AND OD.ESTAACTIVO = 'S' " +
                        "AND OD.PERSONA_ID = '" + idDocente + "' " +
                        "AND ACC.PERSONA_ID = '" + config.getUsuarioId() + "' ";
            List<Object[]> resultadoLista = s.createSQLQuery(sql).list();
            for (Object[] curPosArr : resultadoLista){
                SgpCursosPostgrado curPos = new SgpCursosPostgrado();
                curPos.setId(Integer.valueOf(curPosArr[0].toString()));
                curPos.setNombre(String.valueOf(curPosArr[1]));
                resultado.add(curPos);
            }
            t.commit();
        } catch (Exception e){
            db.rollbackTransacion(t);
        } finally {
            db.cerrarSesion();
        }
        return resultado;
    }
    
}