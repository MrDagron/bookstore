package net.sirdagron.bookstore.domain.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.UUIDJdbcType;

import java.util.List;
import java.util.UUID;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcType(UUIDJdbcType.class)
    private UUID id;
    @Column(name="publisher_name")
    private String publisherName;
    @OneToMany(mappedBy = "publisher")
    private List<Book> books;
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    //todo: more info on publisher
}
