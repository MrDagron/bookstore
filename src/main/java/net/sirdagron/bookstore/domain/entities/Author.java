package net.sirdagron.bookstore.domain.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.UUIDJdbcType;

import java.util.List;
import java.util.UUID;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcType(UUIDJdbcType.class)
    private UUID id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="middle_name")
    private String middleName;
    @ManyToMany
    @JoinTable(name="book_author",
            joinColumns = @JoinColumn(name="book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="author_id", referencedColumnName = "id"))
    private List<Book> books;
    public Author() {}
    public Author(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    public void addBook(Book book) {
        books.add(book);
    }
    public void removeBook(Book book) {
        books.remove(book);
    }
    //todo: more info about author
}
