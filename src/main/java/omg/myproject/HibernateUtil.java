package omg.myproject;

import omg.myproject.domain.Author;
import omg.myproject.domain.Book;
import omg.myproject.domain.Role;
import omg.myproject.domain.User;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class HibernateUtil {
    private static final Logger log = Logger.getLogger(HibernateUtil.class);

    private static final SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new AnnotationConfiguration()
                    .configure("/hibernate.cfg.xml")
                    .addPackage("omg") //the fully qualified package name
                    .addAnnotatedClass(Book.class)
                    .addAnnotatedClass(Author.class)
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(Role.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            log.fatal("ERROR - AAAA we all will die!!!!: \n Initial SessionFactory creation failed" + ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
