package datos.pojos.adminuc;
// Generated 06/12/2011 05:07:25 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Menus generated by hbm2java
 */
public class Menus  implements java.io.Serializable {


     private int id;
     private Integer menuIdPadre;
     private String descripcion;
     private String abreviatura;
     private String pagina;
     private Integer nivel;
     private String estaactivo;
     private String creado;
     private Date fechaCreacion;
     private String actualizado;
     private Date fechaActualizacion;
     private String imagen;
     private int orden;
     private String sistema;
    // private Set permisosMenuses = new HashSet(0);
   //  private Set menusRoleses = new HashSet(0);
     public DefaultMutableTreeNode Nodo;
     private Set<MenusRoles> menusRoleses = new HashSet<MenusRoles>(0);
     private Set<PermisosMenus> permisosMenuses = new HashSet<PermisosMenus>(0);

    public Menus() {
    }

	
    public Menus(int id, String descripcion, String abreviatura, String pagina, String estaactivo, String creado, Date fechaCreacion, int orden) {
        this.id = id;
        this.descripcion = descripcion;
        this.abreviatura = abreviatura;
        this.pagina = pagina;
        this.estaactivo = estaactivo;
        this.creado = creado;
        this.fechaCreacion = fechaCreacion;
        this.orden = orden;
    }
    public Menus(int id, Integer menuIdPadre, String descripcion, String abreviatura, String pagina, Integer nivel, String estaactivo, String creado, Date fechaCreacion, String actualizado, Date fechaActualizacion, String imagen, int orden, String sistema, Set permisosMenuses, Set menusRoleses) {
       this.id = id;
       this.menuIdPadre = menuIdPadre;
       this.descripcion = descripcion;
       this.abreviatura = abreviatura;
       this.pagina = pagina;
       this.nivel = nivel;
       this.estaactivo = estaactivo;
       this.creado = creado;
       this.fechaCreacion = fechaCreacion;
       this.actualizado = actualizado;
       this.fechaActualizacion = fechaActualizacion;
       this.imagen = imagen;
       this.orden = orden;
       this.sistema = sistema;
       this.permisosMenuses = permisosMenuses;
       this.menusRoleses = menusRoleses;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Integer getMenuIdPadre() {
        return this.menuIdPadre;
    }
    
    public void setMenuIdPadre(Integer menuIdPadre) {
        this.menuIdPadre = menuIdPadre;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getAbreviatura() {
        return this.abreviatura;
    }
    
    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }
    public String getPagina() {
        return this.pagina;
    }
    
    public void setPagina(String pagina) {
        this.pagina = pagina;
    }
    public Integer getNivel() {
        return this.nivel;
    }
    
    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
    public String getEstaactivo() {
        return this.estaactivo;
    }
    
    public void setEstaactivo(String estaactivo) {
        this.estaactivo = estaactivo;
    }
    public String getCreado() {
        return this.creado;
    }
    
    public void setCreado(String creado) {
        this.creado = creado;
    }
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }
    
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public String getActualizado() {
        return this.actualizado;
    }
    
    public void setActualizado(String actualizado) {
        this.actualizado = actualizado;
    }
    public Date getFechaActualizacion() {
        return this.fechaActualizacion;
    }
    
    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
    public String getImagen() {
        return this.imagen;
    }
    
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public int getOrden() {
        return this.orden;
    }
    
    public void setOrden(int orden) {
        this.orden = orden;
    }
    public String getSistema() {
        return this.sistema;
    }
    
    public void setSistema(String sistema) {
        this.sistema = sistema;
    }
//    public Set getPermisosMenuses() {
//        return this.permisosMenuses;
//    }
//    
//    public void setPermisosMenuses(Set permisosMenuses) {
//        this.permisosMenuses = permisosMenuses;
//    }
//    public Set getMenusRoleses() {
//        return this.menusRoleses;
//    }
//    
//    public void setMenusRoleses(Set menusRoleses) {
//        this.menusRoleses = menusRoleses;
//    }

    public DefaultMutableTreeNode getNodo() {
        return Nodo;
    }

    public void setNodo(DefaultMutableTreeNode Nodo) {
        this.Nodo = Nodo;
    }

    public Set<MenusRoles> getMenusRoleses() {
        return menusRoleses;
    }

    public void setMenusRoleses(Set<MenusRoles> menusRoleses) {
        this.menusRoleses = menusRoleses;
    }

    public Set<PermisosMenus> getPermisosMenuses() {
        return permisosMenuses;
    }

    public void setPermisosMenuses(Set<PermisosMenus> permisosMenuses) {
        this.permisosMenuses = permisosMenuses;
    }




}

