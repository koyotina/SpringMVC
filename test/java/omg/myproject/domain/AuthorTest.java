package omg.myproject.domain;

    import omg.myproject.domain.Author;
    import omg.myproject.domain.Book;
    import org.junit.Assert;
    import org.junit.Test;
    import org.junit.runner.RunWith;
    import org.springframework.test.context.ContextConfiguration;
    import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

    import java.util.HashSet;
    import java.util.Set;

public class AuthorTest {

    @Test
    public void setAuthorIdTest() {
        Author a = new Author();
        a.setId(9562);
        Assert.assertEquals(9562, a.getId());
    }

    @Test
    public void setAuthorAboutTest() {
        String t = "Agrfgfd iufdvg lziufdv liu fdvdfvfoih fvdfx;kh";
        Author a = new Author();
        a.setAbout(t);
        Assert.assertEquals(t, a.getAbout());
    }

    @Test
    public void setAuthorNameTest() {
        Author a = new Author();
        a.setAuthorName("Bulgakov");
        Assert.assertEquals("Bulgakov", a.getAuthorName());
    }

    @Test
    public void setAuthorBookTest() {
        Author a = new Author();
        Set<Book> book = new HashSet<Book>(0);
        Book b = new Book(521, "Mybook", 1990, "Drama");
        book.add(b);
        a.setBook(book);
        Assert.assertTrue( a.getBook().contains(b));
    }
}
