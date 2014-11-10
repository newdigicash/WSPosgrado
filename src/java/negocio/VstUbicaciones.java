/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author usuario
 */
public class VstUbicaciones {
    
    private int id;
    private String descripcion;
    private String abreviatura;
    private String nacionalidad;
    private String continente;
    private char escapital;
    private char tipo;
    private int nivel;
    private int padre;
    private String descripcionCompuesta;

    public VstUbicaciones() {
    }
    
    

    public VstUbicaciones(int id, String descripcion, String abreviatura, String nacionalidad, String continente, char escapital, char tipo, int nivel, String descripcionCompuesta) {
        this.id = id;
        this.descripcion = descripcion;
        this.abreviatura = abreviatura;
        this.nacionalidad = nacionalidad;
        this.continente = continente;
        this.escapital = escapital;
        this.tipo = tipo;
        this.nivel = nivel;
        this.descripcionCompuesta = descripcionCompuesta;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcionCompuesta() {
        return descripcionCompuesta;
    }

    public void setDescripcionCompuesta(String descripcionCompuesta) {
        this.descripcionCompuesta = descripcionCompuesta;
    }

    public char getEscapital() {
        return escapital;
    }

    public void setEscapital(char escapital) {
        this.escapital = escapital;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPadre() {
        return padre;
    }

    public void setPadre(int padre) {
        this.padre = padre;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    
    
    
    
}
