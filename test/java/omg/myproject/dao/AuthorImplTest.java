package omg.myproject.dao;

    import omg.myproject.domain.Author;
    import omg.myproject.service.AuthorService;
    import org.junit.Before;
    import org.junit.Test;
    import org.junit.runner.RunWith;
    import org.mockito.InjectMocks;
    import org.mockito.Mock;
    import org.mockito.MockitoAnnotations;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.test.context.ContextConfiguration;
    import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
    import org.springframework.test.context.web.WebAppConfiguration;

    import java.sql.SQLException;
    import java.util.ArrayList;

    import static org.mockito.Mockito.verify;
    import static org.mockito.Mockito.when;
    import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
    import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
        "classpath:WEB-INF/test-web-context.xml",
        "classpath:WEB-INF/mvc-dispatcher-servlet.xml"})
public class AuthorImplTest {

    @Mock
    BookDaoImplement bookImpl;

    @Mock
    AuthorDaoImplement authorImpl;

    @InjectMocks
    @Autowired
    AuthorService authorService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllAuthorsTest() throws SQLException {
        when(authorImpl.getAllAuthors()).thenReturn(new ArrayList<Author>());
        authorService.getAllAuthors();
        verify(authorImpl).getAllAuthors();
    }
}
