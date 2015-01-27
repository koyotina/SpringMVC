package omg.myproject.dao;

import omg.myproject.domain.User;

public interface UserDAO {

    public User getUser(String login);

    void addUser(User user);

}
