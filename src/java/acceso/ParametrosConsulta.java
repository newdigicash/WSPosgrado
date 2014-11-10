/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package acceso;

/**
 *
 * @author acuenca
 */
public class ParametrosConsulta {
    String nombreParametro;
    Object valor;

    public ParametrosConsulta() {
    }

    public ParametrosConsulta(String nombreParametro, Object valor) {
        this.nombreParametro = nombreParametro;
        this.valor = valor;
    }

    public String getNombreParametro() {
        return nombreParametro;
    }

    public void setNombreParametro(String nombreParametro) {
        this.nombreParametro = nombreParametro;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }


}
