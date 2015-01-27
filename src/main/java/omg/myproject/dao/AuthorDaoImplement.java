package omg.myproject.dao;

import omg.myproject.HibernateUtil;
import omg.myproject.domain.Author;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class AuthorDaoImplement implements IAuthorDao {
    private static final Logger log = Logger.getLogger(AuthorDaoImplement.class);

    @Transactional
    public List<Author> getAllAuthors(){
        Session session = null;
        List<Author> authors = new ArrayList<Author>();
        try {
            log.fatal("Inside block 'TRY'");
            session = HibernateUtil.getSessionFactory().openSession();
            authors = session.createCriteria(Author.class).list();
        } catch (Exception e) {
            log.error("ERROR - getAllAuthors:" + e.getMessage());
        } catch (ExceptionInInitializerError ex) {
            log.error("ERROR - getAllAuthors:" + ex.getMessage());
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return authors;
    }

    @Transactional
    public void addAuthor(Author obj) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(obj);
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("ERROR - addAuthor:" + e.getMessage());
        } catch (ExceptionInInitializerError ex) {
            log.error("ERROR - addAuthor:" + ex.getMessage());
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

}

