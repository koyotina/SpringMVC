package omg.myproject.dao;

import omg.myproject.domain.Role;

import java.sql.SQLException;
import java.util.List;

public interface RoleDAO {

    public Role getRole(int id);

    List<Role> getAllRoles();
}
