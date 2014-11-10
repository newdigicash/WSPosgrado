/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import acceso.Consultas;
import acceso.ParametrosConsulta;
import acceso.db;
//import datos.pojos.investigacion.SgiLineas;
import datos.pojos.sgap.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author usuario
 */
public class planes {

    /**
     * funcion que almacena,edita o elimina un objeto del tipo:
     * SgpPlanesCurso,SgpEjesTematicos, SgpLineasInvestigacion, SgiLineas,
     * SgpComponentesPlanes, SgpPlanesModalidades, SgpInstitucionesCurso,
     * SgpInstitucionesCurso
     *
     * @param objeto del tipo SgpPlanesCurso,
     * @param listaEjes
     * @param listaLineas
     * @param sgiLineas
     * @param Listacomp
     * @param listamodalidades
     * @param listaInstituciones
     * @param listaAuspiciantes
     * @param opcion
     * @return
     */
    public static final int _INSERT_PLAN = 0;
    public static final int _UPDATE_PLAN = 1;
    public static final int _DELETE_PLAN = 2;
    //lineas lin = new lineas();

    /*public boolean saveUpdate(SgpPlanesCurso objeto, List<SgpLineasInvestigacion> listaLineas, List<SgpComponentesPlanes> Listacomp, List<SgpPlanesModalidades> listamodalidades, List<SgpInstitucionesCurso> listaInstituciones, List<SgpInstitucionesJuridicas> listaAuspiciantes, int opcion) {
        boolean resultado = false, bandl = false, bandc = false, bandmod = false;
        SgpPlanesCurso pc = null;
        Session s = null;
        Transaction t = null;
        try {
            s = db.abrirSesion();
            t = s.beginTransaction();

            switch (opcion) {
                case _INSERT_PLAN: {
                    //PLANES
                    objeto.setEstaactivo('S');
                    objeto.setCreado(config.getUsuarioId());
                    objeto.setFechaCreacion(new Date());
                    s.save(objeto);
                    s.flush();
                    //int idp = idPlan(s);

                    try {
                        int idp = Integer.valueOf(s.createQuery("select  nvl(max(id.id),1) from SgpPlanesCurso where estaactivo='S' and id.curposId=" + objeto.getId().getCurposId()).uniqueResult().toString());
                        SgpPlanesCursoId pcid = new SgpPlanesCursoId(idp, objeto.getId().getCurposId());
                        if (pcid != null) {
                            pc = (SgpPlanesCurso) Consultas.getP(SgpPlanesCurso.class, pcid, s);
                            if (pc == null) {
                                break;
                            }
                        }
                    } catch (Exception e) {
                    }

                    //UNIVERSIDADES ORGANIZADORAS
                    if (listaInstituciones.size() > 0 && objeto != null && pc != null) {
                        for (int i = 0; i <= listaInstituciones.size() - 1; i++) {
                            if (!listaInstituciones.get(i).isGuardado()) {
                                SgpInstitucionesCurso l = new SgpInstitucionesCurso();
                                SgpInstitucionesCursoId idL = new SgpInstitucionesCursoId();
                                idL.setCurposId(listaInstituciones.get(i).getId().getCurposId());
                                idL.setPlacurId(pc.getId().getId());
                                idL.setInstitucionId(listaInstituciones.get(i).getId().getInstitucionId());
                                l.setId(idL);
                                l.setTipoConvenio(listaInstituciones.get(i).getTipoConvenio());
                                l.setTipoFinanciamiento(listaInstituciones.get(i).getTipoFinanciamiento());
                                l.setTipoInstitucion("EDU");
                                l.setSgpPlanesCurso(pc);
                                l.setEstaactivo('S');
                                l.setCreado(config.getUsuarioId());
                                l.setFechaCreacion(new Date());
                                s.save(l);
                            }
                        }
                    }

                    //INSTITUCIONES AUSPICIANTES
                    if (listaAuspiciantes.size() > 0 && objeto != null && pc != null) {
                        for (int i = 0; i <= listaAuspiciantes.size() - 1; i++) {
                            if (!listaAuspiciantes.get(i).isGuardado()) {
                                SgpInstitucionesJuridicas l = new SgpInstitucionesJuridicas();
                                SgpInstitucionesJuridicasId idL = new SgpInstitucionesJuridicasId();
                                idL.setCurposId(listaAuspiciantes.get(i).getId().getCurposId());
                                idL.setPlacurId(pc.getId().getId());
                                idL.setInstitucionId(listaAuspiciantes.get(i).getId().getInstitucionId());
                                l.setId(idL);
                                l.setSgpPlanesCurso(pc);
                                l.setEstaactivo('S');
                                l.setCreado(config.getUsuarioId());
                                l.setFechaCreacion(new Date());
                                s.save(l);
                            }
                        }
                    }

                    //MODALIDADES 
                    if (objeto != null && pc != null) {
                        for (int i = 0; i <= listamodalidades.size() - 1; i++) {
                            SgpPlanesModalidades l = new SgpPlanesModalidades();
                            SgpPlanesModalidadesId idL = new SgpPlanesModalidadesId();
                            idL.setCurposId(pc.getId().getCurposId());
                            idL.setPlacurId(pc.getId().getId());
                            idL.setModalidadId(listamodalidades.get(i).getId().getModalidadId());
                            l.setId(idL);
                            l.setSgpPlanesCurso(pc);
                            l.setEstaactivo('S');
                            l.setCreado(config.getUsuarioId());
                            l.setFechaCreacion(new Date());
                            s.save(l);
                        }
                        bandmod = true;
                    }

                    //LINEAS DE INVESTIGACION
                    if (objeto != null && pc != null) {
                        for (int i = 0; i <= listaLineas.size() - 1; i++) {//sgilineas
                            if (!listaLineas.get(i).isGuardado()) {//lineas investigacion
                                int idp = Integer.valueOf(s.createSQLQuery("select SEQ_LINEAS_INVESTIGACION.nextval from dual").uniqueResult().toString());
                                SgpLineasInvestigacion l = new SgpLineasInvestigacion();
                                l.setId(idp);
                                l.setAreaId(listaLineas.get(i).getAreaId());
                                if (listaLineas.get(i).getLineaId() != null && listaLineas.get(i).getLineaId() != 0) {
                                    l.setLineaId(listaLineas.get(i).getLineaId());
                                }
                                l.setSgpPlanesCurso(pc);
                                l.setEstaactivo('S');
                                l.setCreado(config.getUsuarioId());
                                l.setFechaCreacion(new Date());
                                s.save(l);
                                bandl = true;
                            }
                        }
                    }

                    //COMPONENTES PLAN

                    if (objeto != null && pc != null && bandl) {

                        if (Listacomp.size() > 0) {
                            for (int k = 0; k <= Listacomp.size() - 1; k++) {
                                if (!Listacomp.get(k).isGuardado()) {
                                    SgpComponentesPlanes comp = new SgpComponentesPlanes();
                                    SgpComponentesPlanesId compId = new SgpComponentesPlanesId();
                                    compId.setCurposId(pc.getId().getCurposId());
                                    compId.setPlacurId(pc.getId().getId());
                                    compId.setCabcomId(pc.getSgpComponentesCabeceras().getId());
                                    compId.setComponenteId(Listacomp.get(k).getId().getComponenteId());
                                    comp.setId(compId);
                                    comp.setValor(Listacomp.get(k).getValor());
                                    comp.setEstaactivo('S');
                                    comp.setCreado(config.getUsuarioId());
                                    comp.setFechaCreacion(new Date());
                                    s.save(comp);
                                }
                            }
                            bandc = true;
                        }
                    } else {
                        bandc = true;
                    }
                }
                break;


                case _UPDATE_PLAN: {

                    // PLANES
                    s.evict(objeto);
                    objeto.setActualizado(config.getUsuarioId());
                    objeto.setFechaActualizacion(new Date());
                    s.update(objeto);


                    //UNIVERSIDADES ORGANIZADORAS
                    if (listaInstituciones.size() > 0) {

                        for (int i = 0; i <= listaInstituciones.size() - 1; i++) {
                            SgpInstitucionesCurso l = new SgpInstitucionesCurso();
                            SgpInstitucionesCursoId idL = new SgpInstitucionesCursoId();
                            idL.setCurposId(listaInstituciones.get(i).getId().getCurposId());
                            idL.setPlacurId(objeto.getId().getId());
                            idL.setInstitucionId(listaInstituciones.get(i).getId().getInstitucionId());
                            l.setId(idL);
                            l.setTipoFinanciamiento(listaInstituciones.get(i).getTipoFinanciamiento());
                            l.setTipoConvenio(listaInstituciones.get(i).getTipoConvenio());
                            l.setTipoInstitucion("EDU");
                            l.setSgpPlanesCurso(objeto);
                            l.setEstaactivo('S');
                            l.setCreado(config.getUsuarioId());
                            l.setFechaCreacion(new Date());
                            s.save(l);
                        }
                    }


                    //INSTITUCIONES AUSPICIANTES

                    if (listaAuspiciantes.size() > 0) {
                        for (int i = 0; i <= listaAuspiciantes.size() - 1; i++) {
                            SgpInstitucionesJuridicas l = new SgpInstitucionesJuridicas();
                            SgpInstitucionesJuridicasId idL = new SgpInstitucionesJuridicasId();
                            idL.setCurposId(objeto.getId().getCurposId());
                            idL.setPlacurId(objeto.getId().getId());
                            idL.setInstitucionId(listaAuspiciantes.get(i).getId().getInstitucionId());
                            l.setId(idL);
                            l.setSgpPlanesCurso(objeto);
                            l.setEstaactivo('S');
                            l.setCreado(config.getUsuarioId());
                            l.setFechaCreacion(new Date());
                            s.save(l);
                        }
                    }


                    //MODALIDADES 

                    if (listamodalidades.size() > 0) {//investigacion actualizar
                        for (int j = 0; j <= listamodalidades.size() - 1; j++) {
                            SgpPlanesModalidades l = new SgpPlanesModalidades();
                            SgpPlanesModalidadesId idL = new SgpPlanesModalidadesId();
                            idL.setCurposId(objeto.getId().getCurposId());
                            idL.setPlacurId(objeto.getId().getId());
                            idL.setModalidadId(listamodalidades.get(j).getId().getModalidadId());
                            l.setId(idL);
                            l.setSgpPlanesCurso(objeto);
                            l.setEstaactivo('S');
                            l.setCreado(config.getUsuarioId());
                            l.setFechaCreacion(new Date());
                            s.save(l);
                        }
                    }
                    //LINEAS DE INVESTIGACION
                    if (objeto != null) {
                        if (!listaLineas.isEmpty()) {//investigacion actualizar
                            for (int j = 0; j <= listaLineas.size() - 1; j++) {
                                SgpLineasInvestigacion l = new SgpLineasInvestigacion();
                                int idp = Integer.valueOf(s.createSQLQuery("select SEQ_LINEAS_INVESTIGACION.nextval from dual").uniqueResult().toString());
                                l.setId(idp);
                                l.setAreaId(listaLineas.get(j).getAreaId());
                                if (listaLineas.get(j).getLineaId() != null && listaLineas.get(j).getLineaId() != 0) {
                                    l.setLineaId(listaLineas.get(j).getLineaId());
                                } else {
                                    l.setLineaId(null);
                                }
                                l.setSgpPlanesCurso(objeto);
                                l.setEstaactivo('S');
                                l.setCreado(config.getUsuarioId());
                                l.setFechaCreacion(new Date());
                                s.save(l);
                            }
                        }
                        bandl = true;
                    }

                    //COMPONENTES PLAN

                    if (objeto != null && bandl) {
                        if (Listacomp.size() > 0) {

                            for (int k = 0; k <= Listacomp.size() - 1; k++) {
                                if (Listacomp.get(k).isGuardado()) {
                                    SgpComponentesPlanes comp = new SgpComponentesPlanes();
                                    SgpComponentesPlanesId compId = new SgpComponentesPlanesId();
                                    compId.setCurposId(objeto.getId().getCurposId());
                                    compId.setPlacurId(objeto.getId().getId());
                                    compId.setCabcomId(objeto.getSgpComponentesCabeceras().getId());
                                    compId.setComponenteId(Listacomp.get(k).getId().getComponenteId());
                                    comp.setId(compId);
                                    comp.setValor(Listacomp.get(k).getValor());
                                    comp.setEstaactivo(Listacomp.get(k).getEstaactivo());
                                    comp.setCreado(Listacomp.get(k).getCreado());
                                    comp.setFechaCreacion(Listacomp.get(k).getFechaCreacion());
                                    comp.setActualizado(config.getUsuarioId());
                                    comp.setFechaActualizacion(new Date());
                                    s.update(comp);

                                } else {
                                    SgpComponentesPlanes comp = new SgpComponentesPlanes();
                                    SgpComponentesPlanesId compId = new SgpComponentesPlanesId();
                                    compId.setCurposId(objeto.getId().getCurposId());
                                    compId.setPlacurId(objeto.getId().getId());
                                    compId.setCabcomId(objeto.getSgpComponentesCabeceras().getId());
                                    compId.setComponenteId(Listacomp.get(k).getId().getComponenteId());
                                    comp.setId(compId);
                                    comp.setValor(Listacomp.get(k).getValor());
                                    comp.setEstaactivo('S');
                                    comp.setCreado(config.getUsuarioId());
                                    comp.setFechaCreacion(new Date());
                                    s.save(comp);

                                }
                            }
                            bandc = true;
                        }
                    } else {
                        bandc = true;
                    }
                }
                break;


                case _DELETE_PLAN: {

                    //UNIVERSIDADES ORGANIZADORAS
                    if (listaInstituciones.size() > 0) {
                        for (int i = 0; i <= listaInstituciones.size() - 1; i++) {
                            s.delete(listaInstituciones.get(i));
                        }
                    }

                    //INSTITUCIONES AUSPICIANTES
                    if (listaAuspiciantes.size() > 0) {
                        for (int i = 0; i <= listaAuspiciantes.size() - 1; i++) {
                            s.delete(listaAuspiciantes.get(i));
                        }
                    }

                    //MODALIDADES 
                    if (listamodalidades.size() > 0) {//investigacion actualizar
                        for (int j = 0; j <= listamodalidades.size() - 1; j++) {
                            s.delete(listamodalidades.get(j));
                            bandmod = true;
                        }
                    }

                    //LINEAS DE INVESTIGACION
                    if (listaLineas.size() > 0) {//investigacion actualizar
                        for (int i = 0; i <= listaLineas.size() - 1; i++) {
                            s.delete(listaLineas.get(i));
                            bandl = true;
                        }
                    }
                    //COMPONENTES PLAN
                    if (Listacomp.size() > 0 && bandl) {
                        for (int k = 0; k <= Listacomp.size() - 1; k++) {
                            s.delete(Listacomp.get(k));
                            bandc = true;
                        }
                    }

                    // PLANES
                    s.delete(objeto);
                }
                break;
                default:
            }
            if (bandc) {
                t.commit();
            }
            resultado = true;
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
            db.rollbackTransacion(t);
            db.cerrarSesion();
        } finally {
            db.cerrarSesion();
        }
        return resultado;
    }
*/
//    public boolean saveUpdate(SgpPlanesCurso objeto, List<SgpLineasInvestigacion> listaLineas, List<SgiLineas> sgiLineas, List<SgpComponentesPlanes> Listacomp, List<SgpPlanesModalidades> listamodalidades, List<SgpInstitucionesCurso> listaInstituciones, List<SgpInstitucionesJuridicas> listaAuspiciantes, int opcion) {
//        boolean resultado = false, bandl = false, bandc = false, bandmod = false;
//
//        ejestematicos ej = new ejestematicos();
//        SgpPlanesCurso pc = null;
//        SgiLineas slinea = null;
//        Session s = null;
//        Transaction t = null;
//        try {
//            s = db.abrirSesion();
//            t = s.beginTransaction();
//
//            switch (opcion) {
//                case _INSERT_PLAN: {
//                    //PLANES
//                    objeto.setEstaactivo('S');
//                    objeto.setCreado(config.getUsuarioId());
//                    objeto.setFechaCreacion(new Date());
//                    s.save(objeto);
//                    s.flush();
//                    //int idp = idPlan(s);
//
//
//                    try {
//                        int idp = Integer.valueOf(s.createQuery("select  nvl(max(id.id),1) from SgpPlanesCurso where estaactivo='S' and id.curposId=" + objeto.getId().getCurposId()).uniqueResult().toString());
//                        SgpPlanesCursoId pcid = new SgpPlanesCursoId(idp, objeto.getId().getCurposId());
//
//
//                        if (pcid != null) {
//                            pc = (SgpPlanesCurso) Consultas.getP(SgpPlanesCurso.class, pcid, s);
//                            if (pc
//                                    == null) {
//                                break;
//                            }
//                        }
//                    } catch (Exception e) {
//                    }
//
//                    //UNIVERSIDADES ORGANIZADORAS
//                    if (listaInstituciones.size() > 0 && objeto != null && pc != null) {
//                        for (int i = 0; i <= listaInstituciones.size() - 1; i++) {
//                            if (!listaInstituciones.get(i).isGuardado()) {
//                                SgpInstitucionesCurso l = new SgpInstitucionesCurso();
//                                SgpInstitucionesCursoId idL = new SgpInstitucionesCursoId();
//                                idL.setCurposId(listaInstituciones.get(i).getId().getCurposId());
//                                idL.setPlacurId(pc.getId().getId());
//                                idL.setInstitucionId(listaInstituciones.get(i).getId().getInstitucionId());
//                                l.setId(idL);
//                                l.setTipoConvenio(listaInstituciones.get(i).getTipoConvenio());
//                                l.setTipoFinanciamiento(listaInstituciones.get(i).getTipoFinanciamiento());
//                                l.setTipoInstitucion("EDU");
//                                l.setSgpPlanesCurso(pc);
//                                l.setEstaactivo('S');
//                                l.setCreado(config.getUsuarioId());
//                                l.setFechaCreacion(new Date());
//                                s.save(l);
//                            }
//                        }
//                    }
//
//                    //INSTITUCIONES AUSPICIANTES
//                    if (listaAuspiciantes.size() > 0 && objeto != null && pc != null) {
//                        for (int i = 0; i <= listaAuspiciantes.size() - 1; i++) {
//                            if (!listaAuspiciantes.get(i).isGuardado()) {
//                                SgpInstitucionesJuridicas l = new SgpInstitucionesJuridicas();
//                                SgpInstitucionesJuridicasId idL = new SgpInstitucionesJuridicasId();
//                                idL.setCurposId(listaAuspiciantes.get(i).getId().getCurposId());
//                                idL.setPlacurId(pc.getId().getId());
//                                idL.setInstitucionId(listaAuspiciantes.get(i).getId().getInstitucionId());
//                                l.setId(idL);
//                                l.setSgpPlanesCurso(pc);
//                                l.setEstaactivo('S');
//                                l.setCreado(config.getUsuarioId());
//                                l.setFechaCreacion(new Date());
//                                s.save(l);
//                            }
//                        }
//                    }
//
//                    //MODALIDADES 
//                    if (objeto != null && pc != null) {
//                        for (int i = 0; i <= listamodalidades.size() - 1; i++) {
//                            SgpPlanesModalidades l = new SgpPlanesModalidades();
//                            SgpPlanesModalidadesId idL = new SgpPlanesModalidadesId();
//                            idL.setCurposId(pc.getId().getCurposId());
//                            idL.setPlacurId(pc.getId().getId());
//                            idL.setModalidadId(listamodalidades.get(i).getId().getModalidadId());
//                            l.setId(idL);
//                            l.setSgpPlanesCurso(pc);
//                            l.setEstaactivo('S');
//                            l.setCreado(config.getUsuarioId());
//                            l.setFechaCreacion(new Date());
//                            s.save(l);
//                        }
//                        bandmod = true;
//
//                    }
//                    //LINEAS DE INVESTIGACION
//
//                    if (objeto != null && pc != null) {
//
//                        for (int i = 0; i <= sgiLineas.size() - 1; i++) {//sgilineas
//                            if (sgiLineas.get(i).getId() == 0) {
//                                SgiLineas sgi = new SgiLineas();
//                                sgi.setSgiAreas(sgiLineas.get(i).getSgiAreas());
//                                sgi.setSgiTiposLineas(sgiLineas.get(i).getSgiTiposLineas());
//                                sgi.setDescripcion(sgiLineas.get(i).getDescripcion().toUpperCase());
//                                sgi.setEstado("S");
//                                sgi.setEstaactivo("S");
//                                sgi.setAbreviatura("");
//                                sgi.setOrden(0);
//                                sgi.setCreado(config.getUsuarioId());
//                                sgi.setFechaCreacion(new Date());
//                                s.save(sgi);
//
//                                int idl = lin.idLinea(s);
//
//
//                                if (idl != 0) {
//                                    slinea = (SgiLineas) Consultas.getP(SgiLineas.class, idl, s);
//                                    if (slinea
//                                            != null) {//lineas investigacion
//                                        SgpLineasInvestigacion l = new SgpLineasInvestigacion();
////                                        SgpLineasInvestigacionId idL = new SgpLineasInvestigacionId();
////                                        idL.setCurposId(pc.getId().getCurposId());
////                                        idL.setPlacurId(pc.getId().getId());
////                                        idL.setLineaId(slinea.getId());
////                                        l.setId(idL);
////                                        l.setSgpPlanesCurso(pc);
////                                        l.setEstaactivo('S');
////                                        l.setCreado(config.getUsuarioId());
////                                        l.setFechaCreacion(new Date());
//                                        s.save(l);
//                                        bandl = true;
//                                    }
//                                }
//                            } else {
//                                SgpLineasInvestigacion l = new SgpLineasInvestigacion();
////                                SgpLineasInvestigacionId idL = new SgpLineasInvestigacionId();
////                                idL.setCurposId(pc.getId().getCurposId());
////                                idL.setPlacurId(pc.getId().getId());
////                                idL.setLineaId(sgiLineas.get(i).getId());
////                                l.setId(idL);
////                                l.setSgpPlanesCurso(pc);
////                                l.setEstaactivo('S');
////                                l.setCreado(config.getUsuarioId());
////                                l.setFechaCreacion(new Date());
//                                s.save(l);
//                                bandl = true;
//
//                            }
//                        }
//
//                    }
//
//                    //COMPONENTES PLAN
//
//                    if (objeto != null && pc != null && bandl) {
//
//                        if (Listacomp.size() > 0) {
//                            for (int k = 0; k <= Listacomp.size() - 1; k++) {
//                                if (!Listacomp.get(k).isGuardado()) {
//                                    SgpComponentesPlanes comp = new SgpComponentesPlanes();
//                                    SgpComponentesPlanesId compId = new SgpComponentesPlanesId();
//                                    compId.setCurposId(pc.getId().getCurposId());
//                                    compId.setPlacurId(pc.getId().getId());
//                                    compId.setCabcomId(pc.getSgpComponentesCabeceras().getId());
//                                    compId.setComponenteId(Listacomp.get(k).getId().getComponenteId());
//                                    comp.setId(compId);
//                                    comp.setValor(Listacomp.get(k).getValor());
//                                    comp.setEstaactivo('S');
//                                    comp.setCreado(config.getUsuarioId());
//                                    comp.setFechaCreacion(new Date());
//                                    s.save(comp);
//                                }
//                            }
//                            bandc = true;
//                        }
//                    } else {
//                        bandc = true;
//                    }
//                }
//                break;
//
//
//
//                case _UPDATE_PLAN: {
//
//                    // PLANES
//                    s.evict(objeto);
//                    objeto.setActualizado(config.getUsuarioId());
//                    objeto.setFechaActualizacion(new Date());
//                    s.update(objeto);
//
//
//                    //UNIVERSIDADES ORGANIZADORAS
//                    if (listaInstituciones.size() > 0) {
//                        for (int i = 0; i <= listaInstituciones.size() - 1; i++) {
//                            SgpInstitucionesCurso l = new SgpInstitucionesCurso();
//                            SgpInstitucionesCursoId idL = new SgpInstitucionesCursoId();
//                            idL.setCurposId(listaInstituciones.get(i).getId().getCurposId());
//                            idL.setPlacurId(objeto.getId().getId());
//                            idL.setInstitucionId(listaInstituciones.get(i).getId().getInstitucionId());
//                            l.setId(idL);
//                            l.setTipoFinanciamiento(listaInstituciones.get(i).getTipoFinanciamiento());
//                            l.setTipoConvenio(listaInstituciones.get(i).getTipoConvenio());
//                            l.setTipoInstitucion("EDU");
//                            l.setSgpPlanesCurso(objeto);
//                            l.setEstaactivo('S');
//                            l.setCreado(config.getUsuarioId());
//                            l.setFechaCreacion(new Date());
//                            s.save(l);
//                        }
//                    }
//
//
//                    //INSTITUCIONES AUSPICIANTES
//
//                    if (listaAuspiciantes.size() > 0) {
//                        for (int i = 0; i <= listaAuspiciantes.size() - 1; i++) {
//                            if (listaAuspiciantes.get(i).isGuardado()) {
//                                SgpInstitucionesJuridicas l = new SgpInstitucionesJuridicas();
//                                SgpInstitucionesJuridicasId idL = new SgpInstitucionesJuridicasId();
//                                idL.setCurposId(objeto.getId().getCurposId());
//                                idL.setPlacurId(objeto.getId().getId());
//                                idL.setInstitucionId(listaAuspiciantes.get(i).getId().getInstitucionId());
//                                l.setId(idL);
//                                l.setSgpPlanesCurso(objeto);
//                                l.setEstaactivo(listaAuspiciantes.get(i).getEstaactivo());
//                                l.setCreado(listaAuspiciantes.get(i).getCreado());
//                                l.setFechaCreacion(listaAuspiciantes.get(i).getFechaCreacion());
//                                l.setActualizado(config.getUsuarioId());
//                                l.setFechaActualizacion(new Date());
//                                s.update(l);
//
//                            } else {
//                                SgpInstitucionesJuridicas l = new SgpInstitucionesJuridicas();
//                                SgpInstitucionesJuridicasId idL = new SgpInstitucionesJuridicasId();
//                                idL.setCurposId(objeto.getId().getCurposId());
//                                idL.setPlacurId(objeto.getId().getId());
//                                idL.setInstitucionId(listaAuspiciantes.get(i).getId().getInstitucionId());
//                                l.setId(idL);
//                                l.setSgpPlanesCurso(objeto);
//                                l.setEstaactivo('S');
//                                l.setCreado(config.getUsuarioId());
//                                l.setFechaCreacion(new Date());
//                                s.save(l);
//                            }
//                        }
//                    }
//
//
//                    //MODALIDADES 
//
//                    if (listamodalidades.size() > 0) {//investigacion actualizar
//                        for (int j = 0; j <= listamodalidades.size() - 1; j++) {
//                            if (listamodalidades.get(j).isGuardado()) {
//                                SgpPlanesModalidades li = new SgpPlanesModalidades();
//                                li.setId(listamodalidades.get(j).getId());
//                                li.setEstaactivo(listamodalidades.get(j).getEstaactivo());
//                                li.setCreado(listamodalidades.get(j).getCreado());
//                                li.setFechaCreacion(listamodalidades.get(j).getFechaCreacion());
//                                li.setActualizado(config.getUsuarioId());
//                                li.setFechaActualizacion(new Date());
//                                s.update(li);
//                            } else {
//                                SgpPlanesModalidades l = new SgpPlanesModalidades();
//                                SgpPlanesModalidadesId idL = new SgpPlanesModalidadesId();
//                                idL.setCurposId(objeto.getId().getCurposId());
//                                idL.setPlacurId(objeto.getId().getId());
//                                idL.setModalidadId(listamodalidades.get(j).getId().getModalidadId());
//                                l.setId(idL);
//                                l.setSgpPlanesCurso(objeto);
//                                l.setEstaactivo('S');
//                                l.setCreado(config.getUsuarioId());
//                                l.setFechaCreacion(new Date());
//                                s.save(l);
//
//                            }
//
//                        }
//                    }
//
//                    //LINEAS DE INVESTIGACION
//                    if (objeto != null) {
//
//                        for (int i = 0; i <= sgiLineas.size() - 1; i++) {
//                            if (sgiLineas.get(i).isGuardado()) {//actualiza
//                                SgiLineas sgi = new SgiLineas();
//                                sgi.setId(sgiLineas.get(i).getId());
//                                sgi.setSgiAreas(sgiLineas.get(i).getSgiAreas());
//                                sgi.setSgiTiposLineas(sgiLineas.get(i).getSgiTiposLineas());
//                                sgi.setDescripcion(sgiLineas.get(i).getDescripcion().toUpperCase());
//                                sgi.setEstado(sgiLineas.get(i).getEstado());
//                                sgi.setCreado(sgiLineas.get(i).getCreado());
//                                sgi.setFechaCreacion(sgiLineas.get(i).getFechaCreacion());
//                                sgi.setActualizado(config.getUsuarioId());
//                                sgi.setFechaActualizacion(new Date());
//                                s.update(sgi);
//                            } else if (sgiLineas.get(i).getId() == 0) {
//                                SgiLineas sgi = new SgiLineas();
//                                sgi.setSgiAreas(sgiLineas.get(i).getSgiAreas());
//                                sgi.setSgiTiposLineas(sgiLineas.get(i).getSgiTiposLineas());
//                                sgi.setDescripcion(sgiLineas.get(i).getDescripcion().toUpperCase());
//                                sgi.setEstado("S");
//                                sgi.setEstaactivo("S");
//                                sgi.setAbreviatura("");
//                                sgi.setOrden(0);
//                                sgi.setCreado(config.getUsuarioId());
//                                sgi.setFechaCreacion(new Date());
//                                s.save(sgi);
//                                int idl = lin.idLinea(s);
//
//
//                                if (idl != 0) {
//                                    slinea = (SgiLineas) Consultas.getP(SgiLineas.class, idl, s);
//                                    if (slinea
//                                            != null) {//lineas investigacion guardar
//                                        SgpLineasInvestigacion l = new SgpLineasInvestigacion();
////                                        SgpLineasInvestigacionId idL = new SgpLineasInvestigacionId();
////                                        idL.setCurposId(objeto.getId().getCurposId());
////                                        idL.setPlacurId(objeto.getId().getId());
////                                        idL.setLineaId(slinea.getId());
////                                        l.setId(idL);
////                                        l.setSgpPlanesCurso(objeto);
////                                        l.setEstaactivo('S');
////                                        l.setCreado(config.getUsuarioId());
////                                        l.setFechaCreacion(new Date());
//                                        s.save(l);
//                                    }
//                                }
//                            }
//                        }
//                        if (listaLineas.size() > 0) {//investigacion actualizar
//                            for (int j = 0; j <= listaLineas.size() - 1; j++) {
//                                if (listaLineas.get(j).isGuardado()) {
//                                    SgpLineasInvestigacion li = new SgpLineasInvestigacion();
//                                    li.setId(listaLineas.get(j).getId());
//                                    li.setEstaactivo(listaLineas.get(j).getEstaactivo());
//                                    li.setCreado(listaLineas.get(j).getCreado());
//                                    li.setFechaCreacion(listaLineas.get(j).getFechaCreacion());
//                                    li.setActualizado(config.getUsuarioId());
//                                    li.setFechaActualizacion(new Date());
//                                    s.update(li);
//                                } else {
//                                    SgpLineasInvestigacion l = new SgpLineasInvestigacion();
////                                    SgpLineasInvestigacionId idL = new SgpLineasInvestigacionId();
////                                    idL.setCurposId(objeto.getId().getCurposId());
////                                    idL.setPlacurId(objeto.getId().getId());
////                                    idL.setLineaId(listaLineas.get(j).getId().getLineaId());
////                                    l.setId(idL);
////                                    l.setSgpPlanesCurso(objeto);
////                                    l.setEstaactivo('S');
////                                    l.setCreado(config.getUsuarioId());
////                                    l.setFechaCreacion(new Date());
//                                    s.save(l);
//
//                                }
//
//                            }
//                        }
//                        bandl = true;
//                    }
//
//                    //COMPONENTES PLAN
//
//                    if (objeto != null && bandl) {
//                        if (Listacomp.size() > 0) {
//
//                            for (int k = 0; k <= Listacomp.size() - 1; k++) {
//                                if (Listacomp.get(k).isGuardado()) {
//                                    SgpComponentesPlanes comp = new SgpComponentesPlanes();
//                                    SgpComponentesPlanesId compId = new SgpComponentesPlanesId();
//                                    compId.setCurposId(objeto.getId().getCurposId());
//                                    compId.setPlacurId(objeto.getId().getId());
//                                    compId.setCabcomId(objeto.getSgpComponentesCabeceras().getId());
//                                    compId.setComponenteId(Listacomp.get(k).getId().getComponenteId());
//                                    comp.setId(compId);
//                                    comp.setValor(Listacomp.get(k).getValor());
//                                    comp.setEstaactivo(Listacomp.get(k).getEstaactivo());
//                                    comp.setCreado(Listacomp.get(k).getCreado());
//                                    comp.setFechaCreacion(Listacomp.get(k).getFechaCreacion());
//                                    comp.setActualizado(config.getUsuarioId());
//                                    comp.setFechaActualizacion(new Date());
//                                    s.update(comp);
//
//                                } else {
//                                    SgpComponentesPlanes comp = new SgpComponentesPlanes();
//                                    SgpComponentesPlanesId compId = new SgpComponentesPlanesId();
//                                    compId.setCurposId(objeto.getId().getCurposId());
//                                    compId.setPlacurId(objeto.getId().getId());
//                                    compId.setCabcomId(objeto.getSgpComponentesCabeceras().getId());
//                                    compId.setComponenteId(Listacomp.get(k).getId().getComponenteId());
//                                    comp.setId(compId);
//                                    comp.setValor(Listacomp.get(k).getValor());
//                                    comp.setEstaactivo('S');
//                                    comp.setCreado(config.getUsuarioId());
//                                    comp.setFechaCreacion(new Date());
//                                    s.save(comp);
//
//                                }
//                            }
//                            bandc = true;
//                        }
//                    } else {
//                        bandc = true;
//                    }
//                }
//                break;
//
//
//                case _DELETE_PLAN: {
//
//                    //UNIVERSIDADES ORGANIZADORAS
//                    if (listaInstituciones == null) {
//                        listaInstituciones = new ArrayList<SgpInstitucionesCurso>();
//                    }
//                    if (!listaInstituciones.isEmpty()) {
//                        for (int i = 0; i <= listaInstituciones.size() - 1; i++) {
//                            s.delete(listaInstituciones.get(i));
//
//                        }
//                    }
//                    if (listaAuspiciantes == null) {
//                        listaAuspiciantes = new ArrayList<SgpInstitucionesJuridicas>();
//                    }
//
//                    //INSTITUCIONES AUSPICIANTES
//                    if (!listaAuspiciantes.isEmpty()) {
//                        for (int i = 0; i <= listaAuspiciantes.size() - 1; i++) {
//                            s.delete(listaAuspiciantes.get(i));
//                        }
//                    }
//
//                    //MODALIDADES 
//                    if (!listamodalidades.isEmpty()) {//investigacion actualizar
//                        for (int j = 0; j <= listamodalidades.size() - 1; j++) {
//                            s.delete(listamodalidades.get(j));
//                            bandmod = true;
//                        }
//                    }
//
//                    //LINEAS DE INVESTIGACION
//                    if (!listaLineas.isEmpty()) {//investigacion actualizar
//                        for (int i = 0; i <= listaLineas.size() - 1; i++) {
//                            s.delete(listaLineas.get(i));
//                            bandl = true;
//                        }
//                    } else {
//                        bandl = true;
//                    }
//
//                    //COMPONENTES PLAN
//                    if (!Listacomp.isEmpty() && bandl) {
//                        for (int k = 0; k <= Listacomp.size() - 1; k++) {
//                            s.delete(Listacomp.get(k));
//                            bandc = true;
//                        }
//                    }
//
//                    // PLANES
//
//                    s.delete(objeto);
//                }
//                break;
//
//
//
//                default:
//            }
//            if (bandc) {
//                t.commit();
//            }
//            resultado = true;
//        } catch (Exception e) {
//            //System.err.println(e.getLocalizedMessage());
//            db.rollbackTransacion(t);
//            db.cerrarSesion();
//        } finally {
//            db.cerrarSesion();
//        }
//        return resultado;
//    }

    /*
     * Funcion que actualiza un objeto de tipo SgpPlanesCurso y SgpMallas @param
     * lista @param listaMallas
     */
   /* public boolean UpdateVigenciaPlanesMallas(List<SgpPlanesCurso> lista, List<SgpMallas> listaMallas) {
        boolean resultado = false;
        Session s = null;
        Transaction t = null;
        boolean _mallas = false, _planes = false;
        try {
            s = db.abrirSesion();
            t = s.beginTransaction();
            if (listaMallas.size() > 0) {
                for (int i = 0; i <= listaMallas.size() - 1; i++) {
                    SgpMallas malla = new SgpMallas();
                    malla = listaMallas.get(i);
                    malla.setActualizado(config.getUsuarioId());
                    malla.setFechaActualizacion(new Date());
                    malla.setEnvigencia('N');
                    s.update(malla);
                    _mallas = true;
                }
                if (_mallas = true) {
                    for (int i = 0; i <= lista.size() - 1; i++) {
                        SgpPlanesCurso plan = new SgpPlanesCurso();
                        plan = lista.get(i);
                        plan.setActualizado(config.getUsuarioId());
                        plan.setFechaActualizacion(new Date());
                        plan.setEnvigencia('N');
                        s.update(plan);

                    }
                    _planes = true;
                }
            } else {
                for (int i = 0; i <= lista.size() - 1; i++) {
                    SgpPlanesCurso plan = new SgpPlanesCurso();
                    plan = lista.get(i);
                    plan.setActualizado(config.getUsuarioId());
                    plan.setFechaActualizacion(new Date());
                    plan.setEnvigencia('N');
                    s.update(plan);

                }
                _planes = true;

            }


            if (_planes) {
                t.commit();
                resultado = true;
            }
        } catch (Exception e) {
            //System.err.print("VIGENCIAS:" + e.getMessage() + "causa:" + e.getCause());
            db.rollbackTransacion(t);

        } finally {
            db.cerrarSesion();
        }
        return resultado;


    }
*/
    /**
     * funcion de devuelve un objeto plan vigente con un curso especificado
     *
     * @param idCurso
     * @return
     */
    public SgpPlanesCurso getPlanVigente(int idCurso) {
        SgpPlanesCurso plan = new SgpPlanesCurso();
        List<SgpPlanesCurso> planes = new ArrayList<SgpPlanesCurso>();
        String hql = "from SgpPlanesCurso where id.curposId = " + idCurso + " and envigencia = 'S'";
        try {
            planes = Consultas.getListHql(hql);
            if (planes != null) {
                if (planes.size() > 0) {
                    plan = planes.get(0);
                } else {
                    plan = null;
                }
            }
        } catch (Exception e) {
            plan = null;
            //System.err.print("ERROR AL OBTENER OBJETO");
        }
        return plan;
    }
    
    public List<SgpPlanesCurso> getPlanesXCurso(int idCurso) {
        SgpPlanesCurso plan = new SgpPlanesCurso();
        List<SgpPlanesCurso> resultado = new ArrayList<SgpPlanesCurso>();
        String hql = "from SgpPlanesCurso where id.curposId = " + idCurso + " and estaactivo = 'S'";
        try {
            List<SgpPlanesCurso> planes = Consultas.getListHql(hql);
            if (planes != null) {
                resultado = planes;
            }
        } catch (Exception e) {
            resultado = new ArrayList<SgpPlanesCurso>();
            //System.err.print("ERROR AL OBTENER OBJETO");
        }
        return resultado;
    }

    /**
     * funcion de devuelve un objeto plan vigente con resolucion del senescyt de
     * un curso especificado
     *
     * @param idCurso
     * @return
     */
    public SgpPlanesCurso getPlanVigenteConResols(int idCurso, int idResol) {
        SgpPlanesCurso plan = new SgpPlanesCurso();
        List<SgpPlanesCurso> planes = new ArrayList<SgpPlanesCurso>();
        String hql = "from SgpPlanesCurso where id.curposId = " + idCurso + " and  sgpResolucionesSenescyt.id=" + idResol + " and envigencia = 'S'";
        try {
            planes = Consultas.getListHql(hql);
            if (planes != null) {
                if (planes.size() > 0) {
                    plan = planes.get(0);
                } else {
                    plan = null;
                }
            }
        } catch (Exception e) {
            plan = null;
            //System.err.print("ERROR AL OBTENER OBJETO");
        }
        return plan;
    }

    /**
     * Devuelve los planes por curso que esten activos
     *
     * @param curposId
     * @return
     */
    public List<SgpPlanesCurso> getPlanesByCurso(int curposId, String filtro) {
        filtro = filtro.replace("'", "").toUpperCase();
        List<SgpPlanesCurso> resultado = new ArrayList<SgpPlanesCurso>();
        String hql = "from SgpPlanesCurso where id.curposId = " + String.valueOf(curposId) + " and nombre like '%" + filtro + "%' and estaactivo = 'S' order by nombre";
        List aux = Consultas.getListHql(hql);
        if (aux != null) {
            resultado.addAll(aux);
        }
        return resultado;
    }

    /**
     * Devuelve la cabecera de los componentes vigente
     *
     * @param nivelformId
     * @return
     */
    public SgpComponentesCabeceras getCabeceraComponente(int nivelformId) {
        Consultas con = new Consultas();
        SgpComponentesCabeceras sgpcabecera = null;
        try {
            sgpcabecera = (SgpComponentesCabeceras) con.getOneHql(null, "SgpComponentesCabeceras", "where nivforId='" + nivelformId + "' and envigencia='S'", new ArrayList<ParametrosConsulta>());

        } catch (Exception e) {
            return null;
        }
        return sgpcabecera;
    }

    /**
     * Devuelve id Resoluciones senescyt
     *
     * @param idCurso, tabla
     * @return
     */
    public int getIdResolucionesSenescyt(int idCurso, String tabla) {
        int val = 0;
        try {
            Session session = db.abrirSesion();
            Query q;
            q = (Query) session.createQuery("select max(id) from " + tabla + " where sgpCursosPostgrado.id='" + String.valueOf(idCurso) + "'and estaactivo='S'");
            List res = q.list();
            if (res != null) {
                val = Integer.valueOf(res.get(0).toString());
            }
        } catch (Exception e) {
            db.cerrarSesion();
            val = 0;
        } finally {
            db.cerrarSesion();
        }
        return val;
    }

    /**
     * Devuelve id de un ultimo registro planes
     *
     * @param tabla
     * @return
     */
    public String ultimoRegistro() {

        String val = "";
        try {
            Session session = db.abrirSesion();
            Query q;
            q = (Query) session.createQuery("select  nvl(max(id.id),1) from SgpPlanesCurso where estaactivo='S'").uniqueResult();
            List res = q.list();
            if (res != null) {
                val = res.get(0).toString();
            }
        } catch (Exception e) {
            db.cerrarSesion();
        } finally {
            db.cerrarSesion();
        }
        return val;
    }

    /**
     * Copia metodo anterior pero session por parametro
     *
     * @param sesion
     * @return
     */
    public int idPlan(Session session) {

        int val = 0;
        try {
            val = Integer.valueOf(session.createQuery("select  nvl(max(id.id),1) from SgpPlanesCurso where estaactivo='S'").uniqueResult().toString());
        } catch (Exception e) {
            val = 0;
        }
        return val;
    }
}
