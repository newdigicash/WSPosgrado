package restful;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import restful.util.*;

/**
 * REST Web Service
 * Obtiene el plan de posgrado en JSON
 * @author @edwinsigcha
 * @version 1.0
 * @since 2014-11-04
 */
@Path("consultar/{args}/{callback}")
@RequestScoped
public class PosgradoResource {

    public PosgradoResource() { }

    /**
     * Obtiene la información del plan de posgrado.
     * @param prm parametros Id de plan e id de curso
     * @param callback función generada por el cliente rest
     * @return JSON plan de posgrado
     */
    @GET
    @Produces("application/json")
    public String getJson(@PathParam("args") String prm, @PathParam("callback") String callback) {
        try {
            ReportePlan rp=new ReportePlan(); //instancia del plan de posgrado
            rp.setParametros(prm.trim().split("\\.")[0], prm.trim().split("\\.")[1]); //ID de plan, ID de curso
            String dg= JsonWriter.objectToJson(rp.getPlanPosgrado()); //datos generales serializados
            String comp= JsonWriter.objectToJson(rp.getComponentes()); //componentes serializados
            String mod=JsonWriter.objectToJson(rp.getModalidad()); //modalidad serializada
            String json="["+dg+","+comp+","+mod+"]"; //arma el json
            return callback+"("+json+")"; //embebe en el callback y envia el objeto
        } catch (IOException ex) {
            Logger.getLogger(PosgradoResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return callback + "({})"; //objeto vacio en caso de error
        //throw new UnsupportedOperationException();
    }
}
