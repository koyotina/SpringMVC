package omg.myproject.dao;

import omg.myproject.HibernateUtil;
import omg.myproject.dao.RoleDAO;
import omg.myproject.domain.*;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO {
    private static final Logger log = Logger.getLogger(AuthorDaoImplement.class);

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public Role getRole(int id) {
        Role role = (Role) getCurrentSession().load(Role.class, id);
        return role;
    }


    @Transactional
    public List<Role> getAllRoles(){
        Session session = null;
        List<Role> roles = new ArrayList<Role>();
        try {
            log.fatal("Inside block 'TRY'");
            session = HibernateUtil.getSessionFactory().openSession();
            roles = session.createCriteria(Role.class).list();
        } catch (Exception e) {
            log.error("ERROR - getAllRoles:" + e.getMessage());
        } catch (ExceptionInInitializerError ex) {
            log.error("ERROR - getAllRoles:" + ex.getMessage());
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return roles;
    }

}
