package omg.myproject.service;

import omg.myproject.dao.UserDAO;
import omg.myproject.dao.UserService;
import omg.myproject.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public User getUser(String login) {
        return userDAO.getUser(login);
    }

    public void addNewUser(User user) {
        userDAO.addUser(user);
    }

}
