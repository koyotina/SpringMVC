package omg.myproject.dao;

import omg.myproject.domain.Book;

import java.sql.SQLException;
import java.util.List;


public interface IBookDao {
    List<Book> getAllBooks() throws SQLException;

    void addBook(Book obj);

    void updateBook(Book obj);

    void deleteBook(int id) throws  SQLException;

}
