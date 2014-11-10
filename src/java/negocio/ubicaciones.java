/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import acceso.Consultas;
import acceso.ParametrosConsulta;
import acceso.db;
import datos.pojos.adminuc.Ubicaciones;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author usuario
 */
public class ubicaciones {

    public List<VstUbicaciones> getVstUbicaciones() {
        List<VstUbicaciones> resultado = new ArrayList<VstUbicaciones>();
        Session s = null;
        Transaction t = null;
        try {
            s = db.abrirSesion();
            t = s.beginTransaction();
//            List<Object[]> aux = s.createSQLQuery("Select * from vst_ubicaciones where id != 0 order by padre,id").list();
            List<Object[]> aux = s.createSQLQuery("Select * from vst_ubicaciones where id != 0 order by descripcion").list();
            if (aux != null) {
                for (Object[] obj : aux) {
                    VstUbicaciones u = new VstUbicaciones();
                    u.setId(Integer.valueOf(obj[0].toString()));
                    u.setDescripcion(obj[1].toString());
                    try {
                        u.setAbreviatura(obj[2].toString());
                    } catch (Exception e) {
                        u.setAbreviatura("");
                    }
                    try {
                        u.setNacionalidad(obj[3].toString());
                    } catch (Exception e) {
                        u.setNacionalidad("");
                    }
                    u.setContinente(obj[4].toString());
                    try {
                        u.setEscapital(obj[5].toString().charAt(0));
                    } catch (Exception e) {
                        u.setEscapital('N');
                    }
                    try {
                        u.setTipo(obj[6].toString().charAt(0));
                    } catch (Exception e) {
                        u.setTipo('N');
                    }
                    try {
                        u.setNivel(Integer.valueOf(obj[7].toString()));
                    } catch (Exception e) {
                        u.setNivel(0);
                    }
                    u.setPadre(Integer.valueOf(obj[8].toString()));
                    try {
                        u.setDescripcionCompuesta(obj[9].toString());
                    } catch (Exception e) {
                        u.setDescripcionCompuesta(u.getDescripcion());
                    }
                    resultado.add(u);
                }
            }
            t.commit();
        } catch (Exception e) {
            db.rollbackTransacion(t);
        } finally {
            db.cerrarSesion();
        }
        return resultado;
    }

    public VstUbicaciones getVstUbicacion(int idUbicacion) {
        VstUbicaciones resultado = null;
        Session s = null;
        Transaction t = null;
        try {
            s = db.abrirSesion();
            t = s.beginTransaction();
            Object[] obj = (Object[]) s.createSQLQuery("Select * from vst_ubicaciones where id=" + idUbicacion).uniqueResult();
            if (obj != null) {
                VstUbicaciones u = new VstUbicaciones();
                u.setId(Integer.valueOf(obj[0].toString()));
                u.setDescripcion(obj[1].toString());
                u.setAbreviatura(obj[2].toString());
                u.setNacionalidad(obj[3].toString());
                u.setContinente(obj[4].toString());
                u.setEscapital(obj[5].toString().charAt(0));
                u.setTipo(obj[6].toString().charAt(0));
                u.setNivel(Integer.valueOf(obj[7].toString()));
                u.setPadre(Integer.valueOf(obj[8].toString()));
                u.setDescripcionCompuesta(obj[9].toString());
                resultado = u;
            }
            t.commit();
        } catch (Exception e) {
            db.rollbackTransacion(t);
        } finally {
            db.cerrarSesion();
        }
        return resultado;
    }

    /**
     * Devuelve el objeto ubicacion
     *
     * @param idUbicacion
     * @return
     */
    public Ubicaciones getOneUbicacion(int idUbicacion) {
        Consultas cons = new Consultas();
        try {
            Ubicaciones ubc = (Ubicaciones) cons.getOneHql(null, "Ubicaciones", "where id='" + idUbicacion + "'", new ArrayList<ParametrosConsulta>());
            if (ubc != null) {
                return ubc;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public String getUbicacionEscala(int Ubicacion) {
        Session s = null;
        Transaction t = null;
        String ubicacion = "";
        try {
            s = db.abrirSesion();
            t = s.beginTransaction();

            String sql = "select "
                    + " decode(nivel,3,parroquia,2,'--',1,'--',canton) canton,"
                    + " decode(nivel,3,canton,2,parroquia,1,'--',provincia) provincia,"
                    + " decode(nivel,3,provincia,2,canton,1,parroquia,pais) pais"
                    + " from("
                    + " select ubi.nivel nivel,ubi.id idPar, ubi.descripcion parroquia,"
                    + " canton.id idCan, canton.descripcion canton, "
                    + " provincia.id idProv, provincia.descripcion provincia,"
                    + " pais.id idPais, pais.descripcion pais"
                    + " from  adminuc.ubicaciones ubi"
                    + " inner join (select id, descripcion, padre from adminuc.ubicaciones) canton on (canton.id=ubi.padre)"
                    + " inner join (select id, descripcion, padre from adminuc.ubicaciones) provincia on (provincia.id=canton.padre)"
                    + " inner join (select id, descripcion, padre from adminuc.ubicaciones) pais on (pais.id=provincia.padre)"
                    + " where ubi.id=" + Ubicacion + " )";
            List<Object[]> obj = s.createSQLQuery(sql).list();
            if (obj != null) {
                for (Object[] aux : obj) {
                    ubicacion = aux[2].toString().concat(" - ").concat(aux[1].toString()).concat(" - ").concat(aux[0].toString());
                }
            }
            t.commit();
        } catch (Exception e) {
            db.rollbackTransacion(t);
        } finally {
            db.cerrarSesion();
        }
        //PAIS/PROVINCIA/CANTON
        return ubicacion;
    }
}
