package omg.myproject.service;

import omg.myproject.dao.IBookDao;
import omg.myproject.domain.Book;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Service
public class BookService {
    private static final Logger log = Logger.getLogger(BookService.class);

    @Autowired
    private IBookDao booksRepository;
    private Book allBooks;

    public List<Book> getAllBooks() {
        try {
            return booksRepository.getAllBooks();
        } catch (SQLException e) {
            log.error("ERROR - getAllBooks:" + e.getMessage());
        }
        return new ArrayList();
    }

    public void addBook(Book obj) {
        booksRepository.addBook(obj);
    }

    public Book getTargetBookById(int id) {
        try {
            for (Book book: booksRepository.getAllBooks()) {
                if (book.getBookId() == id) {
                    return book;
                }
            }
        } catch (Exception e) {
            log.error("ERROR - getTargetBookById:" + e.getMessage());
        }
        return null; // nothing found
    }

    public void updateBook(Book book) {
        try {
        booksRepository.updateBook(book);
        } catch (Exception e) {
            log.error("ERROR - updateBook:" + e.getMessage());
        }
    }

    public void deleteBook(int id) {
        try {
            booksRepository.deleteBook(id);
        } catch (Exception e) {
            log.error("ERROR - deleteBook:" + e.getMessage());
        }
    }
}
