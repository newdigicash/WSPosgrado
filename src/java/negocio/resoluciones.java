/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import acceso.Consultas;
import acceso.ParametrosConsulta;
import datos.pojos.sgap.SgpCursosPostgrado;
import datos.pojos.sgap.SgpDocumentosBinarios;
import datos.pojos.sgap.SgpResolucionesSenescyt;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class resoluciones {

    Date ahora = new Date();
    String usuario = config.getUsuarioId();

    /**
     * funcion que devuelve una lista de resoluciones segun el id del curso de
     * postgrado
     *
     * @param idCurso id del curso de postgrado
     * @return
     */
    public List<SgpResolucionesSenescyt> getListaResols(int idCurso) {
        try {
            List listResols = Consultas.getListHql(null, "SgpResolucionesSenescyt", "where sgpCursosPostgrado.id='" + idCurso + "' and estaactivo='S'", new ArrayList<ParametrosConsulta>());
            return listResols;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * funcion que agrega informacion adicional a los pojos de resolucion y
     * documentosBinarios
     *
     * @param resol resolucion a guardar
     * @param docPDFResol documento pdf de la resolucion de la senescyt
     * @return resol agregado la informacion
     * @throws ParseException
     */
    public SgpResolucionesSenescyt guardarResolucion(SgpResolucionesSenescyt resol, SgpDocumentosBinarios docPDFResol) throws ParseException {
        docPDFResol.setCreado(usuario);
        docPDFResol.setFechaCreacion(ahora);
        docPDFResol.setEstaActivo('S');
        resol.setFechaCreacion(ahora);
        resol.setCreado(usuario);
        resol.setEstaactivo('S');
        resol.setSgpDocumentosBinarios(docPDFResol);
        resol.setNuevo(true);
        return resol;
    }

    /**
     * funcion que agrega informacion adicional a los pojos de resolucion y
     * documentosBinarios
     *
     * @param cursosre es el curso que tiene la resolucion
     * @param resol es la resolucion actual
     * @param docPDFResol es el pdf de la resolucion de la senescyt
     * @param bandArchivoS es una bandera para mostrar el pdf guardado
     * @return resol agregado la informacion
     */
    public SgpResolucionesSenescyt editarResolucion(SgpCursosPostgrado cursosre, SgpResolucionesSenescyt resol, SgpDocumentosBinarios docPDFResol, boolean bandArchivoS) {
        resol.setFechaActualizacion(ahora);
        resol.setActualizado(usuario);
        resol.setSgpCursosPostgrado(cursosre);
        resol.setEditado(true);
        if (bandArchivoS) {
            docPDFResol.setCreado(usuario);
            docPDFResol.setFechaCreacion(ahora);
            docPDFResol.setEstaActivo('S');
            resol.setSgpDocumentosBinarios(docPDFResol);

        }

        return resol;
    }

    /**
     * agrega informacion adicional a pojo de resoluciones
     *
     * @param resol resolucion a eliminar
     * @param accion es la accion que indica que se va a eliminar
     * @return
     */
    public SgpResolucionesSenescyt deleteResolucion(SgpResolucionesSenescyt resol, String accion) {
        resol.setEliminado(true);
        return resol;

    }

    public SgpResolucionesSenescyt getResolucion(int idCurso) {
        Consultas con = new Consultas();
        SgpResolucionesSenescyt res = null;
        try {
            res = (SgpResolucionesSenescyt) con.getOneHql(null, "SgpResolucionesSenescyt", "where sgpCursosPostgrado.id='" + idCurso + "'", new ArrayList<ParametrosConsulta>());
            return res;
        } catch (Exception e) {
            return null;
        }
    }

    public SgpResolucionesSenescyt getListResolucion(int idCurso) {
        Consultas con = new Consultas();
        List<SgpResolucionesSenescyt> res = new ArrayList<SgpResolucionesSenescyt>();
        SgpResolucionesSenescyt resolucion = new SgpResolucionesSenescyt();

        String hql = "from SgpResolucionesSenescyt where sgpCursosPostgrado.id= " + idCurso + " and estaactivo = 'S'";
        try {
            res = Consultas.getListHql(hql);
            if (res != null) {
                if (res.size() > 0) {
                    resolucion = res.get(0);
                } else {
                    resolucion = null;
                }
            }
        } catch (Exception e) {
            resolucion = null;
            //System.err.println("ERROR AL OBTENER OBJETO");
        }
        return resolucion;
    }
}
