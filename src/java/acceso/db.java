/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acceso;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author usuario
 */
public class db {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().
                    buildSessionFactory();
        } catch (Throwable ex) {
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public static final ThreadLocal session = new ThreadLocal();

    public static Session abrirSesion() {
        Session s = (Session) session.get();
        if (s == null) {
            s = sessionFactory.openSession();
            session.set(s);
        } else if (!s.isConnected()) {
            s = sessionFactory.openSession();
            session.set(s);
        } else if (!s.isOpen()) {
            s = sessionFactory.openSession();
            session.set(s);
        }
        return s;
    }

    public static void cerrarSesion() {
        Session s = (Session) session.get();
        if (s != null) {
            s.close();
        }
        session.set(null);
    }

    public static void rollbackTransacion(Transaction t) {
        try {
            if (t != null) {
                t.rollback();
            }
        } catch (Exception e) {
        }
    }

    
}
