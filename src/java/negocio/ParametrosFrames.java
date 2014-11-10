/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class ParametrosFrames<A, B> implements Serializable {

    private A value1 = null;
    private B value2 = null;
    private String _regresar = "";
    private String _regresarControlador = "";
    private String _path = "";
    private String _titulo = "";
    private String _accion = "";
    private boolean _boolAccion=false;
    private List<Object> lista = new ArrayList<Object>();

    public String getAccion() {
        return _accion;
    }

    public void setAccion(String _accion) {
        this._accion = _accion;
    }

    public String getPath() {
        return _path;
    }

    public void setPath(String _path) {
        this._path = _path;
    }

    public String getRegresar() {
        return _regresar;
    }

    public void setRegresar(String _regresar) {
        this._regresar = _regresar;
    }

    public String getRegresarControlador() {
        return _regresarControlador;
    }

    public void setRegresarControlador(String _regresarControlador) {
        this._regresarControlador = _regresarControlador;
    }

    public String getTitulo() {
        return _titulo;
    }

    public void setTitulo(String _titulo) {
        this._titulo = _titulo;
    }

    public A getValue1() {
        return value1;
    }

    public void setValue1(A value1) {
        this.value1 = value1;
    }

    public B getValue2() {
        return value2;
    }

    public void setValue2(B value2) {
        this.value2 = value2;
    }

    public List<Object> getLista() {
        return lista;
    }

    public void setLista(List<Object> lista) {
        this.lista = lista;
    }

    public boolean isBoolAccion() {
        return _boolAccion;
    }

    public void setBoolAccion(boolean _boolAccion) {
        this._boolAccion = _boolAccion;
    }
    
}
