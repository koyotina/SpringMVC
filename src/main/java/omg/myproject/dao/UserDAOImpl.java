package omg.myproject.dao;

import omg.myproject.HibernateUtil;
import omg.myproject.dao.UserDAO;
import omg.myproject.domain.*;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.netbeans.lib.cvsclient.commandLine.command.log;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import omg.myproject.domain.User;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    private static final Logger log = Logger.getLogger(UserDAOImpl.class);
    Session session = null;

    public User getUser(String login) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<User> userList = new ArrayList<User>();
        Query query = session.createQuery("FROM User u WHERE u.login = :login");
        query.setParameter("login", login);
        userList = query.list();
        if (userList.size() > 0)
            return userList.get(0);
        else
            return null;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("ERROR - addUser:" + e.getMessage());
        } catch (ExceptionInInitializerError ex) {
            log.error("ERROR - addUser:" + ex.getMessage());
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
}

}
