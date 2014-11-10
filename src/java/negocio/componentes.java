/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import acceso.Consultas;
import acceso.db;
import datos.pojos.sgap.SgpComponentes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jackeline Fernández
 */
public class componentes {

    /**
     * Devuelve los Componentes ACTIVOS que coinciden con el criterio de
     * busqueda
     *
     * @param filtro = filtro que se aplicara al nombre, nombre largo y
     * abreviatura
     * @param pagina = numero de pagina que se necesita, si no se implementa
     * paginacion enviar NULL
     * @param maxResults = numero de resultado por pagina si no se implementa
     * paginacion enviar NULL
     * @return lista de Asignaturas que coinciden con el criterio
     */
    public List<SgpComponentes> getComponentes(String filtro, Integer pagina, Integer maxResults) {
        List<SgpComponentes> resultado = new ArrayList<SgpComponentes>();
        List<SgpComponentes> aux = null;
        String hql = "from SgpComponentes where nombre like '%" + filtro + "%' and estaactivo = 'S' order by nombre";
        if (pagina != null) {
            aux = Consultas.getListHqlPaginado(null, "SgpComponentes", "where nombre like '%" + filtro + "%' and estaactivo = 'S' order by nombre", maxResults, pagina, null);
        } else {
            aux = Consultas.getListHql(hql);
        }
        if (aux != null) {
            resultado.addAll(aux);
        }
        return resultado;
    }

    public boolean esComponenteEliminable(SgpComponentes asig) {
        boolean resultado = false;
        Session s = null;
        Transaction t = null;
        try {
            s = db.abrirSesion();
            t = s.beginTransaction();
            List list = s.createSQLQuery("select * from sgp_componentes_detalles where componente_id = " + asig.getId()).list();
            if (list == null) {
                resultado = true;
            } else if (list.isEmpty()) {
                resultado = true;
            } else {
                resultado = false;
            }
            t.commit();
        } catch (Exception e) {
//            System.err.println("esAsignaturaEliminable(SgpAsignaturas asig) - " + e.getMessage());
            db.rollbackTransacion(t);
        } finally {
            db.cerrarSesion();
        }
        return resultado;
    }

    public boolean saveUpdateComponente(SgpComponentes comp) {
        boolean resultado = false;
        Session s = null;
        Transaction t = null;
        try {
            s = db.abrirSesion();
            t = s.beginTransaction();
        
            if (comp.getId() == null) {
                comp.setEstaactivo('S');
                comp.setCreado(config.getUsuarioId());
                comp.setFechaCreacion(new Date());
                s.save(comp);
            } else {
                comp.setActualizado(config.getUsuarioId());
                comp.setFechaActualizacion(new Date());
                s.update(comp);
            }
            t.commit();
            resultado = true;
        } catch (Exception e) {
//            System.err.println("saveUpdateAsignatura(SgpAsignaturas asig) - " + e.getMessage());
            db.rollbackTransacion(t);
        } finally {
            db.cerrarSesion();
        }
        return resultado;
    }
}
