/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import acceso.Consultas;
import acceso.db;
import datos.pojos.sgap.SgpEdicionesId;
import datos.pojos.sgap.SgpParametrosCurso;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author usuario
 */
public class parametrosCurso {

    public List<SgpParametrosCurso> getParametroCursoByEdicion(SgpEdicionesId id) {
        List<SgpParametrosCurso> resultado = new ArrayList<SgpParametrosCurso>();
        String hql = "from SgpParametrosCurso p where p.id.curposId = " + id.getCurposId() + " and p.id.edicionId = " + id.getId();
        List<SgpParametrosCurso> aux = Consultas.getListHql(hql);
        if (aux != null) {
            resultado.addAll(aux);
        }
        return resultado;
    }
    
    public SgpParametrosCurso getParametroCurso(SgpEdicionesId id, String parametroId) {
        String hql = "from SgpParametrosCurso p where p.id.curposId = " + id.getCurposId() 
                + " and p.id.edicionId = " + id.getId() + " and p.id.paramteroId = " + parametroId;
        SgpParametrosCurso resultado = (SgpParametrosCurso) Consultas.getHqlOne(hql);
        return resultado;
    }

    public boolean guardarParametros(List<SgpParametrosCurso> params) {
        boolean resultado = false;
        Session s = null;
        Transaction t = null;
        try {
            s = db.abrirSesion();
            t = s.beginTransaction();

            for (SgpParametrosCurso par : params) {
                if (par.getId().getId() < 0) {
                    String hql = "select max(p.id.id) from SgpParametrosCurso p where p.id.curposId = " + par.getId().getCurposId() + " "
                            + "and p.id.edicionId = " + par.getId().getEdicionId() + " "
                            + "and p.id.paramteroId = " + par.getId().getParamteroId() + " "
                            + "and p.id.perlecId = " + par.getId().getPerlecId();
                    int id = 0;
                    try {
                        id = Integer.valueOf(s.createQuery(hql).uniqueResult().toString());
                    } catch (Exception e) {
                        id = 0;
                    }
                    id++;
                    par.getId().setId(id);
                }
                s.saveOrUpdate(par);
            }
            t.commit();
            resultado = true;
        } catch (Exception e) {
            //System.err.println("guardarParametros(List<SgpParametrosCurso> params) - " + e.getMessage());
            db.rollbackTransacion(t);
        } finally {
            db.cerrarSesion();
        }
        return resultado;
    }
}
