/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author usuario
 */
public class Pojo<T> {

    private T _value = null;
    private boolean _selected = false;
    private boolean _nuevo = false;
    private boolean _modificado = false;
    private boolean _verificado = false;
    private String _texto = "";
    private String _texto1 = "";
    private String _texto2 = "";
    private String _texto3 = "";
    private String _texto4 = "";
    private int _numero = 0;
    private int _numero1 = 0;
    private int _numero2 = 0;
    private double _decimal = 0d;
    private Object _objeto = null;

    public Pojo(T tipo) {
        _value = tipo;
    }

    public double getDecimal() {
        return _decimal;
    }

    public void setDecimal(double _decimal) {
        this._decimal = _decimal;
    }

    public boolean isModificado() {
        return _modificado;
    }

    public void setModificado(boolean _modificado) {
        this._modificado = _modificado;
    }

    public boolean isNuevo() {
        return _nuevo;
    }

    public void setNuevo(boolean _nuevo) {
        this._nuevo = _nuevo;
    }

    public int getNumero() {
        return _numero;
    }

    public void setNumero(int _numero) {
        this._numero = _numero;
    }

    public Object getObjeto() {
        return _objeto;
    }

    public void setObjeto(Object _objeto) {
        this._objeto = _objeto;
    }

    public boolean isSelected() {
        return _selected;
    }

    public void setSelected(boolean _selected) {
        this._selected = _selected;
    }

    public String getTexto() {
        return _texto;
    }

    public void setTexto(String _texto) {
        this._texto = _texto;
    }

    public T getValue() {
        return _value;
    }

    public void setValue(T _value) {
        this._value = _value;
    }

    public String getTexto1() {
        return _texto1;
    }

    public void setTexto1(String _texto1) {
        this._texto1 = _texto1;
    }

    public String getTexto2() {
        return _texto2;
    }

    public void setTexto2(String _texto2) {
        this._texto2 = _texto2;
    }

    public String getTexto3() {
        return _texto3;
    }

    public void setTexto3(String _texto3) {
        this._texto3 = _texto3;
    }

    public int getNumero1() {
        return _numero1;
    }

    public void setNumero1(int _numero1) {
        this._numero1 = _numero1;
    }

    public int getNumero2() {
        return _numero2;
    }

    public void setNumero2(int _numero2) {
        this._numero2 = _numero2;
    }

    public boolean isVerificado() {
        return _verificado;
    }

    public void setVerificado(boolean _verificado) {
        this._verificado = _verificado;
    }

    public String getTexto4() {
        return _texto4;
    }

    public void setTexto4(String _texto4) {
        this._texto4 = _texto4;
    }
}
