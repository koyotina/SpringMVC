package omg.myproject.dao;

import omg.myproject.domain.*;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import omg.myproject.HibernateUtil;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class BookDaoImplement implements IBookDao {
    private static final Logger log = Logger.getLogger(BookDaoImplement.class);

    @Transactional
    public List<Book> getAllBooks() {
        Session session = null;
        List<Book> books = new ArrayList<Book>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            books = session.createCriteria(Book.class).list();
        } catch (Exception e) {
            log.error("ERROR - getAllBooks:" + e.getMessage());
        } catch (ExceptionInInitializerError ex) {
            log.error("ERROR - getAllBooks:" + ex.getMessage());
        }
         finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return books;
    }

    @Transactional
    public void addBook(Book obj) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(obj);
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("ERROR - addBook:" + e.getMessage());
        } catch (ExceptionInInitializerError ex) {
            log.error("ERROR - addBook:" + ex.getMessage());
        }
         finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Transactional
    public void updateBook(Book obj) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(obj);
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("ERROR - updateBook:" + e.getMessage());
        } catch (ExceptionInInitializerError ex) {
            log.error("ERROR - updateBook:" + ex.getMessage());
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Transactional
    public void deleteBook(int id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Book bookToDelete = (Book)session.load(Book.class, id);
            session.delete(bookToDelete);
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("ERROR - deleteBook:" + e.getMessage());
        } catch (ExceptionInInitializerError ex) {
            log.error("ERROR - deleteBook:" + ex.getMessage());
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

}

