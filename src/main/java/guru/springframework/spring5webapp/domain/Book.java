package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String isbn;

    @ManyToMany
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name ="book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors;

    public Book() {
    }

    public Book(String name, String isbn, List<Author> authors) {

        this.name = name;
        this.isbn = isbn;
        this.authors = authors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
