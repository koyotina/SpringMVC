package omg.myproject.service;

import omg.myproject.dao.IAuthorDao;
import omg.myproject.dao.IBookDao;
import omg.myproject.domain.Author;
import omg.myproject.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


@Service
public class AuthorService {
    private static final Logger log = Logger.getLogger(AuthorService.class);

    @Autowired
    private IAuthorDao authorRepository;

    public List<Author> getAllAuthors() {
        try {
            return authorRepository.getAllAuthors();
        } catch (Exception e) {
            log.error("ERROR - getAllAuthors:" + e.getMessage());
        }
        return new ArrayList();
    }

    public void addAuthor(Author obj) {
        authorRepository.addAuthor(obj);
    }
}
