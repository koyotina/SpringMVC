package omg.myproject.service;

import omg.myproject.HibernateUtil;
import omg.myproject.dao.IBookDao;
import omg.myproject.domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.TestCase.fail;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import static org.powermock.api.mockito.PowerMockito.verifyNew;
import static org.powermock.api.mockito.PowerMockito.whenNew;

/**
 * Created by koyot on 5/10/2014.
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest({HibernateUtil.class, IBookDao.class})
public class AuthorExeptionsTest {

    @InjectMocks
    @Autowired
    BookService bookService;

    @Test
    public void testDeleteBookEx(){
        PowerMockito.mockStatic(HibernateUtil.class);
        bookService.deleteBook(1);
    }

    @Test
    public void testUpdateBookEx() {
        PowerMockito.mockStatic(HibernateUtil.class);
        bookService.updateBook(new Book());
    }

    @Test
    public void testGetTargetBookByIdEx() {
        PowerMockito.mockStatic(HibernateUtil.class);
        bookService.getTargetBookById(1);
    }

    @Test
    public void testGetAllBooksEx() {
        PowerMockito.mockStatic(HibernateUtil.class);
        bookService.getTargetBookById(1);
    }
}

