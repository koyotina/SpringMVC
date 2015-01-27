package omg.myproject.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author {
    @OneToMany
    @JoinTable(name = "id")
    public Set<Book> getBook() {
        return book;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = 5)
    private int id;

    @Column(name = "authorName", length = 100)
    private String authorName;

    @Column(name = "about", length = 255)
    private String about;


    private Set<Book> book = new HashSet<Book>(0);

    public Author() {
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setBook(Set<Book> book) {
        this.book = book;
    }

}
