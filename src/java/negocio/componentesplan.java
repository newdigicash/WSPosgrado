/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import acceso.Consultas;
import acceso.db;
import datos.pojos.sgap.SgpComponentes;
import datos.pojos.sgap.SgpComponentesPlanes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author usuario
 */
public class componentesplan {

    /**
     * funcion de devuelve lista de compontentes en base a una cabecera
     * componente
     *
     * @param idCabecera
     * @return
     */
    public List<SgpComponentes> listaComponentes(Integer idCabecera) {

        List<SgpComponentes> _lstComponentes = new ArrayList<SgpComponentes>();
        try {
            Session session = db.abrirSesion();
            Query q;
            q = (Query) session.createQuery("Select c from SgpComponentesDetalles cd, SgpComponentes c, SgpComponentesCabeceras cc where cd.sgpComponentes.id=c.id and cd.sgpComponentesCabeceras.id=cc.id and cd.sgpComponentesCabeceras.id='" + String.valueOf(idCabecera) + "' and cc.envigencia ='S' order by cd.orden");
            Iterator it1 = q.list().iterator();
            while (it1.hasNext()) {
                SgpComponentes componentes = (SgpComponentes) it1.next();
                _lstComponentes.add(componentes);
            }
        } catch (Exception e) {
            db.cerrarSesion();
        } finally {
            db.cerrarSesion();
        }
        return _lstComponentes;
    }

    /**
     * funcion de devuelve lista de compontentes planes en base a una cabecera,
     * plan y el curso componente
     *
     * @param idCabecera
     * @return
     */
    public List<SgpComponentesPlanes> ListadoCompPlanes(int _planId, int _cursoId, int _cabcomId) {

        List<SgpComponentesPlanes> deps = new ArrayList<SgpComponentesPlanes>();
        String hql = "from SgpComponentesPlanes where estaactivo='S' and placur_id='" + String.valueOf(_planId) + "'and cabcom_id='" + String.valueOf(_cabcomId) + "'and curpos_id='" + String.valueOf(_cursoId) + "' order by cabcom_id";
        try {
            List aux = Consultas.getListHql(hql);
            if (aux != null) {
                deps.addAll(aux);
            }
        } catch (Exception e) {
        }
        return deps;
    }
}
