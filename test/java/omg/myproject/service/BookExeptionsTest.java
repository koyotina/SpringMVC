package omg.myproject.service;

import omg.myproject.HibernateUtil;
import omg.myproject.dao.IBookDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by koyot on 5/10/2014.
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest({HibernateUtil.class, IBookDao.class})
public class BookExeptionsTest {

    @InjectMocks
    @Autowired
    AuthorService authorService;

    @Test
    public void testGetAllAuthors(){
        PowerMockito.mockStatic(HibernateUtil.class);
        authorService.getAllAuthors();
    }
}

