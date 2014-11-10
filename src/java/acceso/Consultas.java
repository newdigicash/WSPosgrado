/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acceso;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.ClaseGeneral;
import util.util;

/**
 *
 * @author usuario
 */
public class Consultas {

  private static final String formatoFecha = "dd/MM/yyyy";

  public int guardar(Object objetoGuardar, int nuevo) {
    Session conn = null;
    util utilidades = new util();
    try {
      conn = db.abrirSesion();
      conn.getTransaction().begin();
      objetoGuardar = utilidades.transformarObjetoMayusculas(objetoGuardar);
      if (nuevo == 0) {
        conn.update(objetoGuardar);
      } else {
        conn.save(objetoGuardar);
        // conn.flush();
      }
      conn.getTransaction().commit();
      return 1;
    } catch (Exception e) {
      conn.getTransaction().rollback();
      System.out.println("err: " + e.getMessage());
      System.out.println(e.getCause().getMessage());
      db.cerrarSesion();
      return 0;
    } finally {
      db.cerrarSesion();
    }
  }

  
    public int guardarActualizar(Object objetoGuardar) {
    Session conn = null;
    util utilidades = new util();
    try {
      conn = db.abrirSesion();
      conn.getTransaction().begin();
      objetoGuardar = utilidades.transformarObjetoMayusculas(objetoGuardar);
      
        conn.update(objetoGuardar);
        conn.saveOrUpdate(objetoGuardar);
      conn.getTransaction().commit();
      return 1;
    } catch (Exception e) {
      conn.getTransaction().rollback();
      System.out.println("err: " + e.getMessage());
      System.out.println(e.getCause().getMessage());
      db.cerrarSesion();
      return 0;
    } finally {
      db.cerrarSesion();
    }
  }
  
  
  
  public int eliminar(Object objetoEliminar) {
    Session conn = null;
    try {
      conn = db.abrirSesion();
      conn.getTransaction().begin();
      conn.flush();
      conn.delete(objetoEliminar);
      conn.getTransaction().commit();
      return 1;
    } catch (Exception e) {
      conn.getTransaction().rollback();
      db.cerrarSesion();
      return 0;
    } finally {
      db.cerrarSesion();
    }
  }

  public static Object getHqlOne(String hql) {
    Object resultado = null;
    Session s = null;
    Transaction t = null;
    try {
      s = db.abrirSesion();
      t = s.beginTransaction();
      resultado = s.createQuery(hql).uniqueResult();
      t.commit();
    } catch (Exception e) {
//            System.err.println("getHqlOne() - " + e.getMessage());
      db.rollbackTransacion(t);
    } finally {
      db.cerrarSesion();
    }
    return resultado;
  }

  public static List getListHql(String hqlQuery) {
    List resultado = null;
    Session s = null;
    Transaction t = null;
    try {
      s = db.abrirSesion();
      t = s.beginTransaction();
      List aux = s.createQuery(hqlQuery).list();
      t.commit();
      resultado = aux;
    } catch (Exception e) {
//            System.err.println("-HQL- " + hqlQuery);
      System.err.println("Consultas.getListHql - " + e.getMessage());
      resultado = null;
      db.rollbackTransacion(t);
    } finally {
      db.cerrarSesion();
    }
    return resultado;
  }

  /**
   * Creado: Angel Cuenca
   *
   * @param strSelect : nombre del objeto a retornar, si desea que retorne todo
   * se debe enviar null
   * @param strObj: Nombre de la clase de la cual se obtendrÃ¡n los datos
   * @param strWhere: predicado de la consulta hql
   * @param parametros: parÃ¡metros para en enlace de las variables que se
   * usarÃ¡n con el strWhere tiene la forma tipoDato|nombre|valor
   * @return : lista de datos
   */
  public static List getListHql(String strSelect,
          String strObj,
          String strWhere,
          List<ParametrosConsulta> parametros) {
    try {
      return getList(strSelect, strObj, strWhere, 0, 0, parametros, "N", "H", null);
    } catch (Exception e) {
      return null;
    }
  }

  /**
   * Creado: Angel Cuenca
   *
   * @param strSelect : nombre del objeto a retornar, si desea que retorne todo
   * se debe enviar null
   * @param strObj: Nombre de la clase de la cual se obtendrÃ¡n los datos
   * @param strWhere: predicado de la consulta hql
   * @param numRegistros: nÃºmero de registros a recuperar
   * @param numPagina: posiciÃ³n de la paginaciÃ³n
   * @param parametros: parÃ¡metros para en enlace de las variables que se
   * usarÃ¡n con el strWhere tiene la forma tipoDato|nombre|valor
   * @param paginado : utilizado para setear los valores de paginación si es que
   * fue invocado desde el evento getListHqlPaginado
   * @param tipoQuery : tipo de consulta que se va a generar (H:HQL / S:SQL)
   * @return : lista de datos
   */
  private static List getList(String strSelect,
          String strObj,
          String strWhere,
          int numRegistros,
          int numPagina,
          List<ParametrosConsulta> parametros,
          String paginado,
          String tipoQuery,
          Session sesion) {
    boolean bandera = false;
    Session conn = null;
    if (sesion == null) {
      conn = db.abrirSesion();
    } else {
      bandera = true;
      conn = sesion;
    }
    try {
      String strSql = null;
      /*
       * Si se trata de una consulta que devuelve todos los objetos
       * encontrados, se ejecutarás la consulta desde el from, caso
       * contrario ejecuta también el comando select con su respectivo
       * objeto a retornar
       */
      strSql = getSqlArmado(strSelect, strObj, strWhere, tipoQuery);
      Query q = null;
      /*
       * Dependiendo del tipo de Consulta creo el query
       */
      if (tipoQuery.equals("H")) {//H:HQL / S:SQL
        q = conn.createQuery(strSql);
      } else {
        q = conn.createSQLQuery(strSql);
      }

      /*
       * Agrego cada uno de los valores a las variables ligadas de la
       * consulta hql
       */
      if (parametros != null) {
        q = getQueryParametros(q, parametros);
      }

      /*
       * unicamente se coloca la paginación si es que fue invocado desde
       * el evento getListHqlPaginado
       */
      if (paginado.equals("S")) {
        /*
         * Tomo el total de registros recuperados
         */
        //this.totalRegistros = q.list().size();
        q.setMaxResults(numRegistros);
        q.setFirstResult(numPagina);
      }
      return q.list();
    } catch (Exception e) {
//            e.printStackTrace();
      return null;
    } finally {
      /*
       * sólo si no se envió la sesion se la debe cerrar, caso contrario
       * se la debe mantener abierta
       */
      if (!bandera) {
        db.cerrarSesion();
      }
    }
  }

  /**
   * Creado: Angel Cuenca
   *
   * @param q : query a la que se agregará cada uno de los valores de las
   * variables ligadas
   * @param parametros : variable con los valores de las variables ligadas
   * @return q : query listo para ejecutarse
   */
  private static Query getQueryParametros(Query q, List<ParametrosConsulta> parametros) {
    try {
      /*
       * Agrego cada uno de los valores a las variables ligadas de la
       * consulta hql
       */
      for (int i = 0; i < parametros.size(); i++) {
        ParametrosConsulta parametro = parametros.get(i);
        if (parametro.getValor() instanceof java.lang.String) {
          q.setString(parametro.getNombreParametro(), (String) parametro.getValor());
        } else if (parametro.getValor() instanceof java.lang.Boolean) {
          q.setBoolean(parametro.getNombreParametro(), (Boolean) parametro.getValor());
        } else if (parametro.getValor() instanceof java.math.BigDecimal) {
          q.setBigDecimal(parametro.getNombreParametro(), (BigDecimal) parametro.getValor());
        } else if (parametro.getValor() instanceof java.lang.Double) {
          q.setDouble(parametro.getNombreParametro(), (Double) parametro.getValor());
        } else if (parametro.getValor() instanceof java.lang.Integer) {
          q.setInteger(parametro.getNombreParametro(), (Integer) parametro.getValor());
        } else if (parametro.getValor() instanceof java.lang.Byte) {
          q.setByte(parametro.getNombreParametro(), (Byte) parametro.getValor());
        } else if (parametro.getValor() instanceof java.lang.Long) {
          q.setLong(parametro.getNombreParametro(), (Long) parametro.getValor());
        } else if (parametro.getValor() instanceof java.util.Date) {
          DateFormat myDateFormat = new SimpleDateFormat(formatoFecha);
          SimpleDateFormat formato = new SimpleDateFormat(formatoFecha);
          String fechaS = formato.format(parametro.getValor());
          Date fecha = myDateFormat.parse(fechaS);
          q.setDate(parametro.getNombreParametro(), fecha);
        }
      }
      return q;
    } catch (Exception e) {
      return null;
    }

  }

  /**
   * Creado: Angel Cuenca
   *
   * @param strSelect : nombre del objeto a retornar, si desea que retorne todo
   * se debe enviar NULL
   * @param strObj: Nombre de la clase de la cual se obtendrÃ¡n los datos
   * @param strWhere: predicado de la consulta hql
   * @param tipoQuery: predicado de la consulta hql
   * @return strSql : sql listo para ser ejecutado
   */
  private static String getSqlArmado(String strSelect, String strObj, String strWhere, String tipoQuery) {
    String strSql = "";
    if (tipoQuery.equals("H")) {//H:HQL - S:SQL
            /*
       * Cuando se debe recuperar un objeto particular
       */
      if (strSelect != null) {
        strSql = String.format("select %s ", strSelect);
      }
    } else {//CUANDO ES SQL
            /*
       * Cuando se debe recuperar ciertos campos de la base de datos
       */
      if (strSelect != null) {
        strSql = String.format("select %s ", strSelect);
      } else {
        strSql = String.format("select * ");
      }
    }
    /*
     * Cuando la consulta tiene un predicado
     */
    if (strWhere != null) {
      strSql = String.format(strSql + "from %s %s", strObj, strWhere);
    } else {
      strSql = String.format(strSql + "from %s ", strObj);
    }
    return strSql;
  }

  /**
   * Creado: Angel Cuenca
   *
   * @param strSelect : nombre del objeto a retornar, si desea que retorne todo
   * se debe enviar NULL
   * @param strObj: Nombre de la clase de la cual se obtendrÃ¡n los datos
   * @param strWhere: predicado de la consulta hql
   * @param numRegistros: numero de registros a recuperar
   * @param numPagina: posicionn de la paginacion
   * @param parametros: parÃ¡metros para en enlace de las variables que se
   * usarÃ¡n con el strWhere tiene la forma tipoDato|nombre|valor
   * @return : lista de datos
   */
  public static List getListHqlPaginado(String strSelect,
          String strObj,
          String strWhere,
          int numRegistros,
          int numPagina,
          List<ParametrosConsulta> parametros) {
    try {
      if (parametros == null) {
        parametros = new ArrayList<ParametrosConsulta>();
      }
      return getList(strSelect, strObj, strWhere, numRegistros, numPagina, parametros, "S", "H", null);
    } catch (Exception e) {
      return null;
    }
  }

  public static List getListHqlPaginado(String hqlQuery, int numRegistros, int numPagina) {
    List resultado = null;
    Session s = null;
    Transaction t = null;
    try {
      s = db.abrirSesion();
      t = s.beginTransaction();
      Query query = s.createQuery(hqlQuery);
      query.setMaxResults(numRegistros);
      query.setFirstResult(numRegistros * (numPagina - 1));
      List aux = query.list();
      t.commit();
      resultado = aux;
    } catch (Exception e) {
//            System.err.println("-HQL- " + hqlQuery);
//            System.err.println("Consultas.getListHql - " + e.getMessage());
      resultado = null;
      db.rollbackTransacion(t);
    } finally {
      db.cerrarSesion();
    }
    return resultado;
  }

  /**
   * Creado: Angel Cuenca
   *
   * @param strSelect : nombre del objeto a retornar, si desea que retorne todo
   * se debe enviar null
   * @param strObj: Nombre de la clase de la cual se obtendrÃ¡n los datos
   * @param strWhere: predicado de la consulta hql
   * @param parametros: parÃ¡metros para en enlace de las variables que se
   * usarÃ¡n con el strWhere tiene la forma tipoDato|nombre|valor
   * @return
   */
  public Object getOneHql(String strSelect, String strObj, String strWhere, List<ParametrosConsulta> parametros) {
    Session conn = db.abrirSesion();
    try {
      String strSql = null;
      /*
       * Si se trata de una consulta que devuelve todos los objetos
       * encontrados, se ejecutarás la consulta desde el from, caso
       * contrario ejecuta también el comando select con su respectivo
       * objeto a retornar
       */
      strSql = getSqlArmado(strSelect, strObj, strWhere, "H");
      Query q = conn.createQuery(strSql);
      /*
       * Agrego cada uno de los valores a las variables ligadas de la
       * consulta hql
       */
      q = this.getQueryParametros(q, parametros);
      return q.uniqueResult();
    } catch (Exception e) {
      return null;
    } finally {
      db.cerrarSesion();
    }
  }

  /**
   * Creado: Edisson Tapia Metodo que hace uso de session.get(CLASE,ID) de las
   * clases de hibernate, evita tener que crear y cerrar las sessiones
   *
   * @param clase: clase del pojo que se recuperara
   * @param id: identificador del pojo
   * @return Pojo de tipo clase ó NULL.
   */
  public static Object get(Class clase, Serializable id) {
    Session conn = db.abrirSesion();
    try {
      return conn.get(clase, id);
    } catch (Exception e) {
      return null;
    } finally {
      db.cerrarSesion();
    }
  }

  //copia metodo anterior prueba, agregado parametro session
  public static Object getP(Class clase, Serializable id, Session s) {
    try {
      return s.get(clase, id);
    } catch (Exception e) {
      return null;
    }
  }

  public static boolean deletePojo(Object pojo) {
    boolean resultado = false;
    Session s = null;
    Transaction t = null;
    try {
      s = db.abrirSesion();
      t = s.beginTransaction();
      s.delete(pojo);
      t.commit();
      resultado = true;
    } catch (Exception e) {
//            System.err.println("eliminarPojo(Object pojo) - " + e.getMessage());
      db.rollbackTransacion(t);
    } finally {
      db.cerrarSesion();
    }
    return resultado;
  }

  /**
   * Creado: Angel Cuenca
   *
   * @param strCampos : nombre de los campos a retornar, si desea que retorne
   * todo se debe enviar NULL y se coloca (*) implicitamente
   * @param strTablas: Nombre de las tablas de la cual se obtendran los datos
   * @param strWhere: predicado de la consulta hql
   * @param parametros: parametros para en enlace de las variables que se usaran
   * con el strWhere tiene la forma tipoDato|nombre|valor
   * @return
   */
  public Object getOneSql(String strCampos, String strTablas, String strWhere, List<ParametrosConsulta> parametros) {
    Session conn = db.abrirSesion();
    try {
      String strSql = null;
      /*
       * Si se trata de una consulta que devuelve todos los objetos
       * encontrados, se ejecutarás la consulta desde el from, caso
       * contrario ejecuta también el comando select con su respectivo
       * objeto a retornar
       */
      strSql = getSqlArmado(strCampos, strTablas, strWhere, "S");
      Query q = conn.createSQLQuery(strSql);
      /*
       * Agrego cada uno de los valores a las variables ligadas de la
       * consulta hql
       */
      if (parametros != null) {
        q = this.getQueryParametros(q, parametros);
      }
      return q.uniqueResult();
    } catch (Exception e) {
      return null;
    } finally {
      db.cerrarSesion();
    }
  }

  //Realiza consultas SQL Directas a la base.
  public List getSql2List(Session sesion, List<ParametrosConsulta> parametros, String consulta) {

    boolean bandera = false;
    Session conn = null;
    if (sesion == null) {
      conn = db.abrirSesion();
    } else {
      bandera = true;
      conn = sesion;
    }
    try {
      String strSql = null;
      strSql = consulta;
      Query q = null;

      q = conn.createSQLQuery(strSql);
      //Parametros
      if (parametros != null) {
        q = getQueryParametros(q, parametros);
      }

      //Devuelve Listado de Objetos Genericos.
      return q.list();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    } finally {
      if (!bandera) {
        db.cerrarSesion();
      }
    }

  }

  //Realiza consultas SQL Directas a la Base.
  public List<ClaseGeneral> getSql2ListClaseGeneral(Session sesion, List<ParametrosConsulta> parametros, String consulta) {

    boolean bandera = false;
    List<ClaseGeneral> lstGeneral = new ArrayList();
    Session conn = null;

    if (sesion == null) {
      conn = db.abrirSesion();
    } else {
      bandera = true;
      conn = sesion;
    }
    try {
      String strSql = null;
      strSql = consulta;
      Query q = null;
      q = conn.createSQLQuery(strSql);
      //Parametros
      if (parametros != null) {
        q = getQueryParametros(q, parametros);
      }
      List lista = q.list();

      //Convierte en Clase General
      for (Iterator it = lista.iterator(); it.hasNext();) {
        Object[] row = (Object[]) it.next();
        ClaseGeneral objeto = new ClaseGeneral();
        Method metodo = null;
        Class[] valorParametro;
        for (int i = 0; i < row.length; i++) {
          int idAtributo = i + 1;
          valorParametro = new Class[1];
          valorParametro[0] = Class.forName("java.lang.Object");
          metodo = objeto.getClass().getMethod("setCampo" + idAtributo, valorParametro);
          metodo.invoke(objeto, row[i]);
        }
        lstGeneral.add(objeto);
      }
      return lstGeneral;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    } finally {
      if (!bandera) {
        db.cerrarSesion();
      }
    }

  }

  /**
   * Creado: Angel Cuenca
   *
   * @param strCampos : nombre de los campos a retornar, si desea que retorne
   * todo se debe enviar NULL y se coloca (*) implicitamente
   * @param strTablas: Nombre de las tablas de la cual se obtendran los datos
   * @param strWhere: predicado de la consulta hql
   * @param parametros: parametros para en enlace de las variables que se usaran
   * con el strWhere tiene la forma tipoDato|nombre|valor
   * @return
   */
  public List<ClaseGeneral> getListSql(List<ParametrosConsulta> parametros,
          String strCampos,
          String strTablas,
          String strWhere) {
    try {
      List lista = getList(strCampos, strTablas, strWhere, 0, 0, parametros, "N", "S", null);
      List<ClaseGeneral> lstGeneral = new ArrayList();
      for (Iterator it = lista.iterator(); it.hasNext();) {
        Object[] row = (Object[]) it.next();
        ClaseGeneral objeto = new ClaseGeneral();
        Method metodo = null;
        Class[] valorParametro;
        for (int i = 0; i < row.length; i++) {
          int idAtributo = i + 1;
          valorParametro = new Class[1];
          valorParametro[0] = Class.forName("java.lang.Object");
          metodo = objeto.getClass().getMethod("setCampo" + idAtributo, valorParametro);
          metodo.invoke(objeto, row[i]);
        }
        lstGeneral.add(objeto);
      }
      return lstGeneral;
    } catch (Exception e) {
      return null;
    }
  }

  /**
   * Me dice si Existen Registros Nombre de la tabla
   *
   * @param strWhere
   */
  public boolean getExistenRegistrosSql(
          String tabla,
          String strWhere) {
    Session conn = db.abrirSesion();
    boolean existe = false;
    try {
      String strSql = null;

      strSql = " select count(*) from " + tabla + " where " + strWhere + " ";
      Query q = conn.createSQLQuery(strSql);

      Object resultado = q.uniqueResult();
      int filas = ((BigDecimal) resultado).intValueExact();
      if (filas > 0) {
        existe = true;
      } else {
        existe = false;
      }
    } catch (Exception e) {
      return existe;
    } finally {
      db.cerrarSesion();
    }
    return existe;
  }

//Saca el proximo valor de la secuencia
  public Long nextSecuencia(String secuenciaNombre) {
    //NombreExquema+"."+NombreSequencia".nextcval
    //String sqlSelect = "data_usr.comun_s_codigo.nextval";
    Session conn = null;
    try {
      conn = db.abrirSesion();
      Consultas consulta = new Consultas();
      Object obj = consulta.getOneSqlSession(secuenciaNombre, "dual", null, null, conn);
      return Long.parseLong(obj.toString());
    } catch (Exception e) {
      return new Long(0);
    } finally {
      db.cerrarSesion();
    }

  }

  /**
   * Creado: Angel Cuenca
   *
   * @param strCampos : nombre de los campos a retornar, si desea que retorne
   * todo se debe enviar NULL y se coloca (*) implicitamente
   * @param strTablas: Nombre de las tablas de la cual se obtendran los datos
   * @param strWhere: predicado de la consulta hql
   * @param parametros: parametros para en enlace de las variables que se usaran
   * con el strWhere tiene la forma tipoDato|nombre|valor
   * @param sesion : sesion activa, si es q se envía la sesion implica que no se
   * la debe cerrar
   * @return
   */
  public Object getOneSqlSession(String strCampos, String strTablas, String strWhere, List<ParametrosConsulta> parametros, Session sesion) {
    Session conn = null;
    if (sesion == null) {
      conn = db.abrirSesion();
    } else {
      conn = sesion;
    }
    try {
      String strSql = null;
      /*
       * Si se trata de una consulta que devuelve todos los objetos
       * encontrados, se ejecutarás la consulta desde el from, caso
       * contrario ejecuta también el comando select con su respectivo
       * objeto a retornar
       */
      strSql = getSqlArmado(strCampos, strTablas, strWhere, "S");
      Query q = conn.createSQLQuery(strSql);
      /*
       * Agrego cada uno de los valores a las variables ligadas de la
       * consulta hql
       */
      if (parametros != null) {
        q = this.getQueryParametros(q, parametros);
      }
      return q.uniqueResult();
    } catch (Exception e) {
      return null;
    }
  }
}
