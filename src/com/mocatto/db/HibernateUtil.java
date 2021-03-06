package com.mocatto.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = buildFactory();
	private static final ThreadLocal session = new ThreadLocal();

    public static SessionFactory buildFactory () {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
    	return sessionFactory;
    }

    public static Session currentSession() {
        Session s = (Session) session.get();
        // Open a new Session, if this thread has none yet
        if (s == null) {
          s = sessionFactory.openSession();
          // Store it in the ThreadLocal variable
          session.set(s);
        }
       
        return s;
      }
    
    public static void closeSession() {
      Session s = (Session) session.get();
      if (s != null) {
        s.close();
      }
      session.set(null);
    }
    
}
