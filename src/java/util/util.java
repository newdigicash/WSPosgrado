/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import acceso.db;
import beans.CtrSession;
//import datos.pojos.sgap.SgpEvaluacionesAportes;
import java.io.File;
import java.lang.reflect.Field;
import java.util.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
//import negocio.archivos;
import negocio.config;
import org.hibernate.Session;


/**
 *
 * @author usuario
 */
public class util {

    public static final int NUMERO_DE_PROVINCIAS = 24;//22;   
    public static final int INSERT = 50;
    public static final int UPDATE = 51;
    public static final String FORMATO_FECHA = "yyyy-MM-dd";
    public static final String FORMATO_FECHA_DMA = "dd/MM/yyyy";
    public static final String FORMATO_FECHA_HORA = "yyyy-MM-dd: HH:mm:ss";
    //public static final String ICONO_WARNING = "resources/Imagenes/iconWarning.png";
    //Llamamos a los estilos que contenen las imágenes
    //Esto soluciona el problema de los iconos en IE
    public static final String ICONO_WARNING = "iconoWarning";
    public static final String ICONO_OK = "iconoMensajeOk";
    public static final String ICONO_ERROR = "iconoError";
    public static final String ICONO_INFO = "iconoInformation";
    //Variables globales con el tipo de proceso en el SGAP
    public static final int TIPPRO_REGISTRO_CALIF_SECRETARIA = 4;
    public static final int TIPPRO_RECALIFICACION = 3;
    //Variables con la forma de evaluación
    public static final int FORAPR_ESCOLARIDAD = 1;
    //Tipos de Proceso del SGSE
    public static final int TIPPRO_SGSE_MATRICULAPOSTGRADO = 4;
    public static final int TIPPRO_SGSE_INSCRIPCIONPOSTGRADO = 3;
    
    /**
     * Funcion para transformar un
     * Double,double,int,Integer,float,Float,BigDecimal o un objecto numerico a
     * String con formato
     *
     * @param pattern = Formato ejm. 0.00$
     * @param obj = objeto a transformar
     * @return String
     */
    public static String formatDecimal(String pattern, Object obj) {
        String resultado = "";
        if (obj == null) {
            resultado = "";
        } else {
            try {
                DecimalFormat df = new DecimalFormat(pattern);
                resultado = df.format(obj);
            } catch (Exception e) {
                resultado = "";
            }
        }
        return resultado.replace(",", ".");
    }
    //PARA PROBAR LOCALMENTE UTILIZAMOS "./docroot/"
    //public static final String DIRECCION_GENERAL_ARCHIVOS = "./docroot/";
//    public static final String DIRECCION_GENERAL_ARCHIVOS = "/home/usuario/NetBeansProjects/sgap/build/web/tmp/";
    public static final String DIRECCION_GENERAL_ARCHIVOS = "C:/Users/usuario/Documents/NetBeansProjects/sgap/build/web/tmp/";
    public static final int pathEscritura = 98;
    //PARA PROBAR EN EL SERVIDOR DE PRODUCCION UTILIZAMOS "/etc/glassfish3/glassfish/domains/domain1/docroot/"
  //  public static final String DIRECCION_GENERAL_ARCHIVOS = "/etc/glassfish3/glassfish/domains/domain1/docroot/";    
    public static int anioActual = 2000;

    // Esta ubicación será la primera a probar en caso de que no exista la dirección en base de datos (pruebas locales)
    public static String DIRECCION_LOCAL_ARCHIVOS = "";
    static {
        Calendar c = Calendar.getInstance();
        anioActual = c.get(Calendar.YEAR);
    }

    /**
     * Creado: Angel Cuenca
     *
     * @param lstObjetos : lista de objetos que se pasarán al selectitem
     * @param metodoId : nombre del método del id que tendrá el selectitem
     * @param metodoDescripcion : nombre del método de la descripción que tendrá
     * el selectitem
     * @param idInicial : id del valor de la primera posicion de la lista, si no
     * se desea se envia NULL
     * @param descripcionInicial : descripcion del valor de la primera posicion
     * de la lista, si no se desea se envia NULL
     * @return : lista de selectitem
     */
    public static SelectItem[] cargarSelectItems(List lstObjetos, String metodoId, String metodoDescripcion, String idInicial, String descripcionInicial) {
        int size = lstObjetos.size();
        if (idInicial != null) {
            size++;
        }
        SelectItem[] select = new SelectItem[size];
        Method getId, getDescripcion;
        try {
            int cont = 0;
            if (idInicial != null) {
                select[cont] = new SelectItem(idInicial, descripcionInicial.toUpperCase());
                cont++;
            }
            for (Iterator it = lstObjetos.iterator(); it.hasNext();) {
                Object object = it.next();
                Class objeto = object.getClass();
                getId = objeto.getMethod(metodoId, new Class[0]);
                String id = getId.invoke(object, new Object[0]).toString();
                getDescripcion = objeto.getMethod(metodoDescripcion, new Class[0]);
                String descripcion = getDescripcion.invoke(object, new Object[0]).toString();
                select[cont] = new SelectItem(id, descripcion.toUpperCase());
                cont++;
            }
            return select;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Creado: Edisson Tapia / Adaptado el cargarSelectItems anterior
     *
     * @param lstObjetos : lista de objetos que se pasarán al selectitem
     * @param metodoId : nombre del método del id que tendrá el selectitem
     * @param metodoDescripcion : nombre del método de la descripción que tendrá
     * el selectitem
     * @param idInicial : id del valor de la primera posicion de la lista, si no
     * se desea se envia NULL
     * @param descripcionInicial : descripcion del valor de la primera posicion
     * de la lista, si no se desea se envia NULL
     * @return : lista de selectitem
     */
    public static List<SelectItem> cargarListSelectItems(List lstObjetos, String metodoId, String metodoDescripcion, String idInicial, String descripcionInicial) {
        List<SelectItem> select = new ArrayList<SelectItem>();
        Method getId, getDescripcion;
        try {
            if (idInicial != null) {
                select.add(new SelectItem(idInicial, descripcionInicial.toUpperCase()));
            }
            for (Iterator it = lstObjetos.iterator(); it.hasNext();) {
                Object object = it.next();
                Class objeto = object.getClass();
                getId = objeto.getMethod(metodoId, new Class[0]);
                String id = getId.invoke(object, new Object[0]).toString();
                getDescripcion = objeto.getMethod(metodoDescripcion, new Class[0]);
                String descripcion = getDescripcion.invoke(object, new Object[0]).toString();
                select.add(new SelectItem(id, descripcion.toUpperCase()));
            }
            return select;
        } catch (Exception e) {
            return null;
        }
    }

    public static String formatDate(String formato, Date fecha) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(formato);
            return df.format(fecha);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return "";
        }
    }

    public static List ordenaListaPojosTable(List lista, final String propiedad, final boolean ascending) {

        Collections.sort(lista, new Comparator() {

            @Override
            public int compare(Object obj1, Object obj2) {
                Class clase = obj1.getClass();
                StringTokenizer tokenizer = new StringTokenizer(propiedad, ".");
                List<String> props = new ArrayList<String>();
                while (tokenizer.hasMoreTokens()) {
                    String prop = tokenizer.nextToken();
                    props.add(prop);
                }
                switch (props.size()) {
                    case 1: {
                        return comparar(obj1, obj2, props.get(0), ascending);
                    }
                    case 2: {
                        String getter = "get" + Character.toUpperCase(props.get(0).charAt(0)) + props.get(0).substring(1);
                        try {
                            Method getPropiedad = clase.getMethod(getter);
                            Object o1 = getPropiedad.invoke(obj1);
                            Object o2 = getPropiedad.invoke(obj2);
                            return comparar(o1, o2, props.get(1), ascending);
                        } catch (Exception e) {
                            return 0;
                        }
                    }
                    case 3: {
                        String getter = "get" + Character.toUpperCase(props.get(0).charAt(0)) + props.get(0).substring(1);
                        try {
                            Method getPropiedad = clase.getMethod(getter);
                            Object o1 = getPropiedad.invoke(obj1);
                            Object o2 = getPropiedad.invoke(obj2);
                            getter = "get" + Character.toUpperCase(props.get(1).charAt(0)) + props.get(1).substring(1);
                            getPropiedad = clase.getMethod(getter);
                            Object oo1 = getPropiedad.invoke(o1);
                            Object oo2 = getPropiedad.invoke(o2);
                            return comparar(oo1, oo2, props.get(2), ascending);
                        } catch (Exception e) {
                            return 0;
                        }
                    }
                    default:
                }
                return 0;
            }
        });
        return lista;
    }

    private static int comparar(Object obj1, Object obj2, String propiedad, boolean ascending) {
        Class clase = obj1.getClass();
        int idxArray = -1;
        if (propiedad.indexOf("[") >= 0) {
            String array = "";
            array = propiedad.substring(propiedad.indexOf("[")).replace("[", "").replace("]", "");
            idxArray = Integer.valueOf(array);
            propiedad = propiedad.substring(0, propiedad.indexOf("["));
            //System.err.println("Metodo: " + propiedad);
            //System.err.println("Idx: " + idxArray);
        }
        String getter = "get" + Character.toUpperCase(propiedad.charAt(0)) + propiedad.substring(1);
        try {
            Method getPropiedad = clase.getMethod(getter);
            Object propiedad1 = null;
            Object propiedad2 = null;
            if (idxArray < 0) {
                propiedad1 = getPropiedad.invoke(obj1);
                propiedad2 = getPropiedad.invoke(obj2);
            } else {
                propiedad1 = ((Object[]) getPropiedad.invoke(obj1))[idxArray];
                propiedad2 = ((Object[]) getPropiedad.invoke(obj2))[idxArray];
            }
            if (propiedad1 instanceof Comparable && propiedad2 instanceof Comparable) {
                Comparable prop1 = (Comparable) propiedad1;
                Comparable prop2 = (Comparable) propiedad2;
                if (ascending) {
                    return prop1.compareTo(prop2);
                } else {
                    return prop2.compareTo(prop1);
                }
            }//CASO DE QUE NO SEA COMPARABLE  
            else {
                if (ascending) {
                    if (propiedad1.equals(propiedad2)) {
                        return 0;
                    } else {
                        return 1;
                    }
                } else {
                    if (propiedad2.equals(propiedad1)) {
                        return 0;
                    } else {
                        return 1;
                    }
                }

            }
        } catch (Exception e) {
            System.err.println("ERROR EN EL ORDERAN TABLE POJO: " + e.getMessage());
        }
        return 0;
    }

    public static CtrSession getSessionSistema() {
        try {
            /*CtrSession bean = (CtrSession) FacesUtils.getManagedBean("ctrSession");
            if (bean != null) {
                return bean;
            }*/
        } catch (Exception e) {
        }
        return null;

    }

    // PARA IMPRIMIR
    public static String proGenerarPdfDeReporteDeUnListado(List lstDatos, String rutaReporte, String nombreReporte, Class clase, String nombrePdf, Map parametrosReporte) {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Date fechaActual = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy_HHmmss");
            String fechaString = formato.format(fechaActual);
            nombrePdf = fechaString + "_" + nombrePdf + ".pdf";
            //String rutaPdfTmp = archivos.path(pathEscritura);
            //String rutaPdf = getPathReporte(rutaPdfTmp);
            String pathReporte = rutaReporte + nombreReporte;
            String pathPdf = /*rutaPdf +*/ nombrePdf;
            URL url = clase.getResource(pathReporte);
            String archivo = url.getPath();//path completo
            /*JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(lstDatos);
            JasperReport reporte = (JasperReport) JRLoader.loadObject(archivo);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametrosReporte, ds);
            JasperExportManager.exportReportToPdfFile(print, pathPdf);*/
            return nombrePdf;
        } catch (Exception e) {
            System.out.println("Error: FuncionesGenericas " + e.getMessage());
            e.printStackTrace();
            return "";
        } finally {
        }
    }

    public static String proGenerarPdfDeReporte(String rutaReporte, String nombreReporte, Class clase, String nombrePdf, Map parametrosReporte) {
        String resultado = "";
        Connection conexion = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            /*conexion = DriverManager.getConnection(archivos.path(config.PARAMETRO_URL_CONEXION_JASPERREPORTS),
                    archivos.path(config.PARAMETRO_USUARIO_JASPERREPORTS),
                    archivos.path(config.PARAMETRO_PASSWORD_JASPERREPORTS));*/
            Date fechaActual = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy_HHmmss");
            String fechaString = formato.format(fechaActual);
            nombrePdf = nombrePdf + "_" + fechaString + ".pdf";
            //String rutaPdfTmp = archivos.path(pathEscritura);
            //String rutaPdf = getPathReporte(rutaPdfTmp);
            String pathReporte = rutaReporte + nombreReporte;
            String pathPdf = /*rutaPdf + */nombrePdf;
            URL url = clase.getResource(pathReporte);
            /*JasperReport reporte = (JasperReport) JRLoader.loadObject(url);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametrosReporte, conexion);
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(pathPdf));
            exporter.exportReport();*/
            resultado = nombrePdf;
        } catch (Exception e) {
            //System.out.println("Error: FuncionesGenericas "
              //      + "metodo: proGenerarPdfDeReporte() --"
                //    + "  " + e.getMessage());
            e.printStackTrace();
            resultado = "";
        } finally {
            db.cerrarSesion();
            try {
                conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: FuncionesGenericas  metodo: proGenerarPdfDeReporte al intentar cerrar Session " + ex.getMessage());
            }
        }
        return resultado;
    }
    /*Reporte de calificaciones Jose Luis*/
    /*public static String proGenerarPdfCalificaciones(LinkedList<CabeceraCalificaciones> calAlumnos, String nombrePdf,
            List<SgpEvaluacionesAportes> aportesFormaEval) {
        
        String resultado = "";
        
        try {
            
            ReporteClass reporte = new ReporteClass();
            
            Date fechaActual = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy_HHmmss");
            String fechaString = formato.format(fechaActual);
            nombrePdf = nombrePdf + "_" + fechaString + ".pdf";
            String rutaPdfTmp = archivos.path(pathEscritura);
            String rutaPdf = getPathReporte(rutaPdfTmp);
            String pathPdf = rutaPdf + nombrePdf;
            
            JasperPrint jasperPrint = reporte.informeCalificaciones(calAlumnos, aportesFormaEval);
            
            if (jasperPrint != null) {
                JRExporter exporter = new JRPdfExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(pathPdf));
                exporter.exportReport();
                resultado = nombrePdf;
            }
        } catch (Exception e) {
            //e.printStackTrace();
            resultado = "";
        } finally {
            db.cerrarSesion();
        }
        return resultado;
    }
    */
    /*Reporte de calificaciones del estudiante Jose Luis*/
    /*public static String proGenerarPdfCalEstudiante(LinkedList<CabeceraCalEstudiante> calEstudiante, 
            String nombrePdf) {
        
        String resultado = "";
        
        try {
            
            ReporteClass reporte = new ReporteClass();
            
            Date fechaActual = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy_HHmmss");
            String fechaString = formato.format(fechaActual);
            nombrePdf = nombrePdf + "_" + fechaString + ".pdf";
            String rutaPdfTmp = archivos.path(pathEscritura);
            String rutaPdf = getPathReporte(rutaPdfTmp);
            String pathPdf = rutaPdf + nombrePdf;
            
            JasperPrint jasperPrint = reporte.informeCalEstudiante(calEstudiante);
            
            if (jasperPrint != null) {
                JRExporter exporter = new JRPdfExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(pathPdf));
                exporter.exportReport();
                resultado = nombrePdf;
            }
        } catch (Exception e) {
            //e.printStackTrace();
            resultado = "";
        } finally {
            db.cerrarSesion();
        }
        return resultado;
    }
    */
    /*Reporte de calificaciones por asignatura Jose Luis*/
    /*public static String proGenerarPdfCalXAsignatura(LinkedList<CabeceraCalificaciones> calXAsignatura, 
            String nombrePdf) {
        
        String resultado = "";
        
        try {
            
            ReporteClass reporte = new ReporteClass();
            
            Date fechaActual = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy_HHmmss");
            String fechaString = formato.format(fechaActual);
            nombrePdf = nombrePdf + "_" + fechaString + ".pdf";
            String rutaPdfTmp = archivos.path(pathEscritura);
            String rutaPdf = getPathReporte(rutaPdfTmp);
            String pathPdf = rutaPdf + nombrePdf;
            
            JasperPrint jasperPrint = reporte.informeCalXAsignatura(calXAsignatura);
            
            if (jasperPrint != null) {
                JRExporter exporter = new JRPdfExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(pathPdf));
                exporter.exportReport();
                resultado = nombrePdf;
            }
        } catch (Exception e) {
            //e.printStackTrace();
            resultado = "";
        } finally {
            db.cerrarSesion();
        }
        return resultado;
    }
    */
    public static String proGenerarExcelDeReporte(String rutaReporte, String nombreReporte, Class clase, String nombrePdf, Map parametrosReporte) {
        Session sesion = db.abrirSesion();
        Connection conexion = null;
        try {

            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            /*conexion = DriverManager.getConnection(archivos.path(config.PARAMETRO_URL_CONEXION_JASPERREPORTS),
                    archivos.path(config.PARAMETRO_USUARIO_JASPERREPORTS),
                    archivos.path(config.PARAMETRO_PASSWORD_JASPERREPORTS));*/
            //Construimos el nombre del archivo excel
            Date fechaActual = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy_HHmmss");
            String fechaString = formato.format(fechaActual);

            nombrePdf = nombrePdf + "_" + fechaString + ".xlsx";

            //Definimos la ruta, generalmente va a la carpeta tmp del proyecto
            //String rutaPdfTmp = archivos.path(pathEscritura);
            //String rutaPdf = getPathReporte(rutaPdfTmp);
            String pathReporte = rutaReporte + nombreReporte;
            String pathPdf = /*rutaPdf +*/ nombrePdf;
            URL url = clase.getResource(pathReporte);
            //JasperReport reporte = (JasperReport) JRLoader.loadObject(url);

            //Creamos el archivo con el path:
            File tempFile = new java.io.File(pathPdf);
            //El archivo se elimina despues de salir de la página
            tempFile.deleteOnExit();
            
            /*JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametrosReporte, conexion);
            JRExporter exporter = new JRXlsxExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, tempFile);
            exporter.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
            exporter.exportReport();
            */
            //Devolvemos el nombre para que sea llamado a la pantalla
            return nombrePdf;

        } catch (Exception e) {
            System.out.println("Error: FuncionesGenericas "
                    + "metodo: proGenerarExcelDeReporte(String rutaReporte, String nombreReporte, Class clase, String nombrePdf) --"
                    + "  " + e.getMessage());
            e.printStackTrace();
            return "";

        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(util.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error: FuncionesGenericas  metodo: proGenerarExcelDeReporte en finally " + ex.getMessage());
            }
        }

    }
    
    public static boolean isEmail(String correo) {
        //TODO funcion validarEmail no funciona con todos los mails
//        try {
//            Pattern pat = null;
//            Matcher mat = null;
//            pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z].)+[a-zA-Z]{2,3})$");
//            mat = pat.matcher(correo);
//            if (mat.find()) {
//                return true;
//            } else {
//                return false;
//            }
//        } catch (java.lang.Exception e) {
//            return false;
//        }
        return true;
    }

    public static boolean esCedulaValida(String cedula) {
        //verifica que tenga 10 dÃ­gitos y que contenga solo valores numÃ©ricos
        if (!((cedula.length() == 10) && cedula.matches("^[0-9]{10}$"))) {
            return false;
        }
        //verifica que los dos primeros dÃ­gitos correspondan a un valor entre 1 y NUMERO_DE_PROVINCIAS
        int prov = Integer.parseInt(cedula.substring(0, 2));
        if (!((prov > 0) && (prov <= NUMERO_DE_PROVINCIAS))) {
            return false;
        }
        //verifica que el Ãºltimo dÃ­gito de la cÃ©dula sea vÃ¡lido
        int[] d = new int[10];
        //Asignamos el string a un array
        for (int i = 0; i < d.length; i++) {
            d[i] = Integer.parseInt(cedula.charAt(i) + "");
        }
        int imp = 0;
        int par = 0;
        //sumamos los duplos de posiciÃ³n impar
        for (int i = 0; i < d.length; i += 2) {
            d[i] = ((d[i] * 2) > 9) ? ((d[i] * 2) - 9) : (d[i] * 2);
            imp += d[i];
        }
        //sumamos los digitos de posiciÃ³n par
        for (int i = 1; i < (d.length - 1); i += 2) {
            par += d[i];
        }
        //Sumamos los dos resultados
        int suma = imp + par;
        //Restamos de la decena superior
        int d10 = Integer.parseInt(String.valueOf(suma + 10).substring(0, 1)
                + "0") - suma;
        //Si es diez el dÃ©cimo dÃ­gito es cero        
        d10 = (d10 == 10) ? 0 : d10;
        //si el dÃ©cimo dÃ­gito calculado es igual al digitado la cÃ©dula es correcta
        return d10 == d[9];
    }

    public static String getFechaStr(Date d) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String cadenaFecha = formato.format(d);
        return cadenaFecha;
    }

    public static Date getFecha (String d) throws Exception{
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = d;        
        try{
            Date fechaDate;
            fechaDate = formato.parse(fecha);
            return fechaDate;
        }catch(ParseException pe){
            throw new Exception("Error en conversión de fecha");            
        }            
    }
    
    public static void refresh() {
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ViewHandler viewHandler = application.getViewHandler();
        UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
        context.setViewRoot(viewRoot);
    }
    
    /**
     * Utilizado para validar si el directorio de reportes enviado como parámetro
     * es un directorio válido. En caso
     * @param pathDirectorio
     * @return 
     */
    public static String getPathReporte(String pathDirectorio)
    {
        String path = "";
        Boolean esDirectorioValido = false;
        File directorio = new File(pathDirectorio);
        if(directorio.isDirectory())
        {
            esDirectorioValido = true;
        }else{
            esDirectorioValido = false;
        }
        if (esDirectorioValido){
            path = pathDirectorio;            
        }else{
            directorio = null;
            directorio = new File(DIRECCION_LOCAL_ARCHIVOS);
            if (directorio.isDirectory()){
                path = DIRECCION_LOCAL_ARCHIVOS;
            }else{  //Envío el path de la dirección general de archivos
                path = DIRECCION_GENERAL_ARCHIVOS;
            }
        }            
        return path;
    }
    /**
     * Por JRPT Genera el pdf segun el reporte del jasper
     *
     * @param rutaReporte Es la ruta donde se encuentra el reportes
     * @param nombreReporte Es el nombre del reporte debe incluir .jasper
     * @param clase Es la clase desde donse se le esta llamando este reporte
     * @param nombrePdf Con que nombre se va a generar el pdf
     */
    /**
     * Transforma un objeto en mayúsculas
     * @param objeto
     * @return 
     */
        public Object transformarObjetoMayusculas(Object objeto) {

        try {
            Class<?> c = objeto.getClass();
            Field[] todoscampos = c.getDeclaredFields();


            for (int n = 0; n < todoscampos.length; n++) {

                Field fld = c.getDeclaredField(todoscampos[n].getName());
                String tipoDato = fld.getType().toString();

                if (tipoDato.equals("class java.lang.String")) {
                    try {
                        fld.setAccessible(true);
                        String valorant = fld.get(objeto).toString();

                        //Valido una Excepcion para los campos de email:
                        if (!(valorant.contains("@"))) {
                            valorant = valorant.toUpperCase();
                        }

                        //Valido si es un valor que no quiero que haga mayuscula
                        //Le presedo al valor de un nomayusc_
                        if (!(valorant.contains("nomay_"))) {
                            valorant = valorant.replaceAll("nomay_", "");
                        }

                        fld.set(objeto, valorant);


                    } catch (Exception e) {
                        //      System.out.println("Error Transformacion Mayusculas: "+e);
                    }
                }

            }


        } catch (Exception e) {
        }

        return objeto;
    }
    /**
     * Verificar si una fecha está en un rango. Devuelve true si la fecha está en el rango, y false si la fecha está fuera del rango.
     * Devuelve true si la fecha a comparar es igual a la fecha inicial o final.
     * José Luis
     * @param fecha java.util.Date
     * @param fechaInicio java.util.Date
     * @param fechaFin java.util.Date
     * @return true o false
     */
    public static boolean fechaEnRango(Date fecha, Date fechaInicio, Date fechaFin) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha0 = formatoFecha.parse(formatoFecha.format(fecha));
            Date fecha1 = formatoFecha.parse(formatoFecha.format(fechaInicio));
            Date fecha2 = formatoFecha.parse(formatoFecha.format(fechaFin));
            if (fecha0.before(fecha1) || fecha0.after(fecha2)) {
                return false;
            } else {
                return true;
            }
        } catch (ParseException e) {
            return false;
        }
    }
    
    /**
     * Armar un string de fecha. Ejm. 12 de Abril del 2014
     * @param fecha
     * @return 
     */
    public static String armarFechaString(Date fecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH); // Jan = 0, dec = 11
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        return armarFechaString(dayOfMonth, month, year);
    }

    /**
     * Armar fecha como String con base al dia, mes y año. Ejm. 12 de Abril del
     * 2014
     *
     * @param dia
     * @param mes
     * @param anio
     * @return
     */
    public static String armarFechaString(int dia, int mes, int anio) {
        String fecha = "";
        if (dia > 0) {
            fecha = fecha + dia + " de ";
        }
        switch (mes) {
            case 0:
                fecha = fecha + "enero del " + anio;
                break;
            case 1:
                fecha = fecha + "febrero del " + anio;
                break;
            case 2:
                fecha = fecha + "marzo del " + anio;
                break;
            case 3:
                fecha = fecha + "abril del " + anio;
                break;
            case 4:
                fecha = fecha + "mayo del " + anio;
                break;
            case 5:
                fecha = fecha + "junio del " + anio;
                break;
            case 6:
                fecha = fecha + "julio del " + anio;
                break;
            case 7:
                fecha = fecha + "agosto del " + anio;
                break;
            case 8:
                fecha = fecha + "septiembre del " + anio;
                break;
            case 9:
                fecha = fecha + "octubre del " + anio;
                break;
            case 10:
                fecha = fecha + "noviembre del " + anio;
                break;
            case 11:
                fecha = fecha + "diciembre del " + anio;
                break;
            default:
                break;
        }
        return fecha;
    }
    

    
    public static String numeroLetra(double valor) {        
        //Conversión del valor en String para analisis de parte entera y decimal        
        String valorStr = new DecimalFormat("############.00").format(valor);
        String[]valorStrSplit = valorStr.split("\\,");
        StringBuilder sbNumeroStr = new StringBuilder();
        if (valorStrSplit.length == 2  && Integer.valueOf(valorStrSplit[1]).intValue() > 0) {
            double valorEntero = Double.valueOf(valorStrSplit[0]);
            double valorDecimal;
            String valorDecimalStr = "";
            if (valorStrSplit[1].length() < 3) { //Por el momento soporte hasta 2
                valorDecimal = Double.valueOf(valorStrSplit[1]);
                valorDecimalStr = numeroLetra(valorDecimal);
            }
            String valorEnteroStr = numeroLetra(valorEntero);
            if (valorEnteroStr.equals("")) {
                sbNumeroStr.append("cero");
            } else {
                sbNumeroStr.append(valorEnteroStr);
            }
            
            if (!valorDecimalStr.equals("")) {
                sbNumeroStr.append(" con ");
                sbNumeroStr.append(valorDecimalStr);
            }
        } else {
            // Solo enteros soporte hasta 12
            int lenNumero = valorStrSplit[0].length();
            if (lenNumero > 9 && lenNumero < 13 ) {
                int mmcentenas = Integer.valueOf(valorStrSplit[0].substring(0, lenNumero - 9)).intValue(); 
                int icentenas = Integer.valueOf(valorStrSplit[0].substring(lenNumero - 9, lenNumero - 6)).intValue();
                int mcentenas = Integer.valueOf(valorStrSplit[0].substring(lenNumero - 6, lenNumero - 3)).intValue();
                int ccentenas = Integer.valueOf(valorStrSplit[0].substring(lenNumero - 3)).intValue();
                
                String milesMillones = centenaEnLetras(mmcentenas, false);
                if (!milesMillones.equals("")) {
                    if (!sbNumeroStr.toString().equals("")) {
                        sbNumeroStr.append(" ");
                    }
                    
                    sbNumeroStr.append(milesMillones);
                    sbNumeroStr.append(" ");
                    sbNumeroStr.append("mil");
                }
                
                String millonesStr = centenaEnLetras(icentenas, false);
                if (!millonesStr.equals("")) {
                    if (!sbNumeroStr.toString().equals("")) {
                        sbNumeroStr.append(" ");
                    }      
                }    
                
                sbNumeroStr.append(millonesStr);
                sbNumeroStr.append(" ");
                sbNumeroStr.append("millones");
                
                
                String milesStr;               
                if (mcentenas > 1) {
                    milesStr = centenaEnLetras(mcentenas, false);
                    
                    if (!milesStr.equals("")) {
                        if (!sbNumeroStr.toString().equals("")) {
                            sbNumeroStr.append(" ");
                        }
                        sbNumeroStr.append(milesStr);
                        sbNumeroStr.append(" ");
                        sbNumeroStr.append("mil");
                    }
                } else if (mcentenas == 1) {
                    if (!sbNumeroStr.toString().equals("")) {
                        sbNumeroStr.append(" ");
                    }
                    sbNumeroStr.append("mil");
                }               
                
                String ccentenasStr = centenaEnLetras(ccentenas, true);
                if (!ccentenasStr.trim().equals("")) {
                    sbNumeroStr.append(" ");
                }
                sbNumeroStr.append(ccentenasStr);
            } else if (lenNumero > 6 && lenNumero < 10) {
                int icentenas = Integer.valueOf(valorStrSplit[0].substring(0, lenNumero - 6)).intValue();;
                int mcentenas = Integer.valueOf(valorStrSplit[0].substring(lenNumero - 6, lenNumero - 3)).intValue();
                int ccentenas = Integer.valueOf(valorStrSplit[0].substring(lenNumero - 3)).intValue();
                
                sbNumeroStr.append(centenaEnLetras(icentenas, false));
                if (!sbNumeroStr.toString().equals("")) {
                    sbNumeroStr.append(" ");
                }
                if (icentenas > 1) {
                    sbNumeroStr.append("millones");
                } else {
                    sbNumeroStr.append("millón");
                }               
                
                String milesStr;
                
                if (mcentenas > 1) {
                    milesStr = centenaEnLetras(mcentenas, false);
                    
                    if (!milesStr.equals("")) {
                        if (!sbNumeroStr.toString().equals("")) {
                            sbNumeroStr.append(" ");
                        }
                        sbNumeroStr.append(milesStr);
                        sbNumeroStr.append(" ");
                        sbNumeroStr.append("mil");
                    }
                } else if (mcentenas == 1) {
                    if (!sbNumeroStr.toString().equals("")) {
                        sbNumeroStr.append(" ");
                    }
                    sbNumeroStr.append("mil");
                }               
                
                String ccentenasStr = centenaEnLetras(ccentenas, true);
                
                if (!ccentenasStr.trim().equals("")) {
                    sbNumeroStr.append(" ");
                }
                sbNumeroStr.append(ccentenasStr);
            } else if (lenNumero > 3 && lenNumero < 7) {
                // posición de miles
                int mcentenas = Integer.valueOf(valorStrSplit[0].substring(0, lenNumero - 3)).intValue();
                int ccentenas = Integer.valueOf(valorStrSplit[0].substring(lenNumero - 3)).intValue();
                
                if (mcentenas > 1) {
                    sbNumeroStr.append(centenaEnLetras(mcentenas, false));
                }
                
                if (!sbNumeroStr.toString().equals("")) {
                    sbNumeroStr.append(" ");
                }
                
                sbNumeroStr.append("mil");
                
                String ccentenasStr = centenaEnLetras(ccentenas, true);
                
                if (!ccentenasStr.trim().equals("")) {
                    sbNumeroStr.append(" ");
                }
                sbNumeroStr.append(ccentenasStr);
            } else if (lenNumero > 0 && lenNumero < 4){
                int numeroCentena = Integer.valueOf(valorStrSplit[0]).intValue();
                sbNumeroStr.append(centenaEnLetras(numeroCentena, true));
            } 
        }
        return sbNumeroStr.toString();
    }
    
    private static String centenaEnLetras(int valor, boolean fin) {
        final String unidades[] = new String[] {"", "un", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};
        final String decenas[] = new String[] {"", "diez", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa"};
        final String decenasUno[] = new String[] {"", "once", "doce", "trece", "catorce", "quince", "dieciseis", "diecisiete", "dieciocho", "diecinueve", "veinti"};
        final String centenas[] = new String[] {"", "ciento", "doscientos", "trescientos", "cuatrocientos", "quinientos", "seiscientos", "setecientos", "ochocientos", "novecientos"};
        StringBuilder sBCentena = new StringBuilder();
        int unidad;
        int decena;
        int centena;
        unidad = valor % 10;
        if (unidad == 1 && fin) {
            sBCentena.append("uno");
        } else {
            sBCentena.append(unidades[unidad]);
        }
        
        valor = valor / 10;
        decena = valor % 10;
        if (unidad == 0 && decena > 0) {            
            sBCentena.insert(0, decenas[decena]);
        } else if (decena == 1) {
            sBCentena.delete(0, sBCentena.length());
            sBCentena.insert(0, decenasUno[unidad]);
        } else if (decena == 2) {           
            sBCentena.insert(0, decenasUno[10]);
        } else if (decena > 2) {
            sBCentena.insert(0, " y ");
            sBCentena.insert(0, decenas[decena]);
        }
        
        valor = valor / 10;
        centena = valor % 10;
        
        if (valor > 0 && centena > 0)
        {
            if (!sBCentena.toString().equals("")) {
                sBCentena.insert(0, " ");
            }
            if (unidad == 0 && decena == 0 && centena == 1) {
                sBCentena.insert(0, "cien");
            } else {
                sBCentena.insert(0, centenas[centena]);
            }
        }
        return sBCentena.toString();
    }
}
