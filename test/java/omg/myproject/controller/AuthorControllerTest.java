package omg.myproject.controller;

import omg.myproject.domain.Author;
import omg.myproject.domain.Book;
import omg.myproject.service.AuthorService;
import omg.myproject.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
        "classpath:WEB-INF/test-web-context.xml",
        "classpath:WEB-INF/mvc-dispatcher-servlet.xml"})
public class AuthorControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Mock
    private AuthorService authorService;

    @Mock
    private BookService bookService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void testShowAllBooks() throws Exception {
        when(bookService.getAllBooks()).thenReturn(new ArrayList());

        mockMvc.perform(get("/books")
                .requestAttr("bookId", 1))
                .andExpect(status().isOk());
    }

    @Test
    public void testShowAllAuthors() throws Exception {
        when(authorService.getAllAuthors()).thenReturn(new ArrayList<Author>());

        mockMvc.perform(get("/authors"))
            .andExpect(status().isOk());
    }

    @Test
    public void testAddBook() throws Exception {
        when(authorService.getAllAuthors()).thenReturn(new ArrayList<Author>());

        mockMvc.perform(get("/add-book"))
                .andExpect(status().isOk());
    }

    @Test
    public void testSendUpdateBook() throws Exception {
        mockMvc.perform(post("/updateBook")
                .sessionAttr("books", new Book()))
                .andExpect(status().is(302));
    }

    @Test
    public void testSendBooks() throws Exception{
        mockMvc.perform(post("/books")
                .sessionAttr("books", new Book()))
                .andExpect(status().isMovedTemporarily());
    }

    @Test
    public void testUpdateBook() throws Exception {
        Book b = new Book();
        b.setBookId(1);
        when(bookService.getTargetBookById(1)).thenReturn(b);
        when(authorService.getAllAuthors()).thenReturn(new ArrayList<Author>());

        mockMvc.perform(get("/updateBook")
                .param("bookId", "1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteBook() throws  Exception{
        mockMvc.perform(get("/deleteBook")
                .param("bookId", "1"))
                .andExpect(status().isMovedTemporarily());
        verify(bookService).deleteBook(1);
    }
}
