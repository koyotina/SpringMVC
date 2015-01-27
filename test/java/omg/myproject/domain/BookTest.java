package omg.myproject.domain;

import omg.myproject.domain.Author;
import omg.myproject.domain.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:WEB-INF/test-web-context.xml")
public class BookTest {

    @Test
    public void setIdTest() {
        Book b = new Book();
        b.setId(159);
        Assert.assertEquals((Integer) 159, b.getId());
    }

    @Test
    public void setBookYearTest() {
        Book b = new Book();
        b.setYear(9159);
        Assert.assertEquals((Integer) 9159, b.getYear());
    }

    @Test
    public void setBookGenreTest() {
        Book b = new Book();
        b.setGenre("Somegenre");
        Assert.assertEquals("Somegenre", b.getGenre());
    }

    @Test
    public void setBookNameTest() {
        Book b = new Book();
        b.setName("Book name sdf");
        Assert.assertEquals("Book name sdf", b.getName());
    }

    @Test
    public void setBookAuthorTest() {
        Book b = new Book();
        Author a = new Author();
        a.setAuthorName("Pushkin");
        b.setAuthor(a);
        Assert.assertEquals("Pushkin", b.getAuthor().getAuthorName());
    }

    @Test
    public void createBookTest() {
        int id = 1999;
        String name = "Book name";
        int year = 2159;
        String genre = "mygenre";
        Book b = new Book(id, name, year, genre);
        Assert.assertEquals((Integer)id, b.getId());
        Assert.assertEquals((Integer)year, b.getYear());
        Assert.assertEquals(name, b.getName());
        Assert.assertEquals(genre, b.getGenre());
    }

    @Test
    public void setBookIdTest() {
        Book b = new Book();
        b.setBookId(100);
        Assert.assertEquals(100, b.getBookId());
    }
}
