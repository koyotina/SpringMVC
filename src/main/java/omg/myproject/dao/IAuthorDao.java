package omg.myproject.dao;

import omg.myproject.domain.Author;

import java.sql.SQLException;
import java.util.List;


public interface IAuthorDao {

    List<Author> getAllAuthors() throws SQLException;

    void addAuthor(Author obj);


}
