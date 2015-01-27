package omg.myproject.domain;


import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @ManyToOne
    @JoinColumn(name = "id",  insertable=false, updatable=false)
    public Author getAuthor() {
        return author;
    }

    @Column(name = "id", length = 5)
    private Integer id;

    @Column(name = "name", length = 150)
    private String name;

    @Column(name = "year", length = 10)
    private Integer year;

    @Column(name = "genre", length = 150)
    private String genre;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "bookId", length = 10)
    private int bookId;

    private Author author;

    public Book() {
    }

    public Book(int id, String name, int year, String genre) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    @Id
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
