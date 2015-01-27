package omg.myproject.dao;

import omg.myproject.domain.Book;
import omg.myproject.service.BookService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by koyot on 5/10/2014.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:WEB-INF/test-web-context.xml")
public class BookImplTest {

    @Mock
    BookDaoImplement bookImpl;

    @Mock
    AuthorDaoImplement authorImpl;

    @InjectMocks
    @Autowired
    BookService bookService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllBooksTest() throws Exception {
        when(bookImpl.getAllBooks()).thenReturn(new ArrayList<Book>());
        bookService.getAllBooks();
        verify(bookImpl).getAllBooks();
    }

    @Test
    public void getTargetBookByIdTest() throws SQLException {
        when(bookImpl.getAllBooks()).thenReturn(new ArrayList<Book>());
        bookService.getTargetBookById(52);
        verify(bookImpl).getAllBooks();
    }

    @Test
    public void getTargetBookByIdTest2() throws SQLException {
        ArrayList<Book> bookList = new ArrayList<Book>();
        Book b = new Book(52, "naag", 1990, "ghsk");
        b.setBookId(100);
        bookList.add(b);
        when(bookImpl.getAllBooks()).thenReturn(bookList);
        Assert.assertEquals(100, bookService.getTargetBookById(100).getBookId());
    }

    @Test
    public void testAddBook() throws Exception {
        bookService.addBook(new Book());
        verify(bookImpl).addBook(isA(Book.class));
    }

    @Test
    public void testUpdateBook() throws Exception {
        bookService.updateBook(new Book());
        verify(bookImpl).updateBook(isA(Book.class));
    }

    @Test
    public void testDeleteBook() throws Exception {
        bookService.deleteBook(1);
        verify(bookImpl).deleteBook(1);
    }
}
