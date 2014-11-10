/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import acceso.db;
import beans.CtrSession;
import datos.pojos.adminuc.Usuarios;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author usuario
 */
public class config {

    public static final int PARAMETRO_INSCRIPCIONES_SECRETARIA = 1;
    public static final int PARAMETRO_INSCRIPCIONES_INTERNET = 2;
    public static final int PARAMETRO_MATRICULAS_SECRETARIA = 3;
    public static final int PARAMETRO_MATRICULAS_INTERNET = 4;
    public static final int PARAMETRO_URL_CONEXION_JASPERREPORTS = 95;
    public static final int PARAMETRO_USUARIO_JASPERREPORTS = 96;
    public static final int PARAMETRO_PASSWORD_JASPERREPORTS = 97;
    public static final int ROL_ESTUDIATE = 100;
    
    //Variables Globales
    public static final int PARAMETRO_FECHAS_PAGOS_MATRICULA = 5;
    public static final int PARAMETRO_FECHAS_PAGOS_INSCRIPCION = 12;
    public static final int PARAMETRO_SITE_SIUC = 8; //172.16.1.67 PARA DESARROLLO, siuc.ucuenca.edu.ec PARA PRODUCCION
    public static final int PARAMETRO_DIRECCION_PAPELETA = 9; //Dirección para imprimir cuotas (reimprimir papeletas)
    
    public static void getUsuario() {
    }

    public static String getUsuarioId() {
        String resultado = "---";
        CtrSession bean = util.util.getSessionSistema();
        if (bean != null) {
            Usuarios usuario = bean.getUsuario();
            if (usuario != null) {
                resultado = usuario.getLogin();
            }
        }
        return resultado;
    }

    public static String getUsuarioNombre() {
        String resultado = "---";
        CtrSession bean = util.util.getSessionSistema();
        if (bean != null) {
            Usuarios usuario = bean.getUsuario();
            if (usuario != null) {
                resultado = usuario.getNombreCorto();
            }
        }
        return resultado;
    }

    public static List<Integer> getAccesoCursos(String dependenciaId) {
        List<Integer> resultado = new ArrayList<Integer>();
        Session s = null;
        Transaction t = null;
        try {
            s = db.abrirSesion();
            t = s.beginTransaction();
            String sql = "select curpos_id from vst_accesos_path where persona_id = '" + getUsuarioId() + "'";
            if (dependenciaId != null) {
                sql += " and path like '%|" + dependenciaId + "|%'";
            }
            List list = s.createSQLQuery(sql).list();
            t.commit();
            for (Object str : list) {
                resultado.add(Integer.valueOf(str.toString()));
            }
        } catch (Exception e) {
            resultado = new ArrayList<Integer>();
            db.rollbackTransacion(t);
        } finally {
            db.cerrarSesion();
        }
        return resultado;
    }
}
