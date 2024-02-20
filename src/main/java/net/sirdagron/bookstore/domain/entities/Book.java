package net.sirdagron.bookstore.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import net.sirdagron.bookstore.domain.dto.BookDto;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcType(VarcharJdbcType.class)
    private UUID id;
    private String title;
    private String isbn;
    private int version;
    @ManyToMany(mappedBy = "books")
    private List<Author> authors;
    @ManyToOne
    @JoinColumn(name="publisher_id")
    private Publisher publisher;

    public Book(String title, String isbn, int version) {
        this.title = title;
        this.isbn = isbn;
        this.version = version;
    }
    public void addAuthor(Author author) {
        authors.add(author);
    }
    public void removeAuthor(Author author) {
        authors.remove(author);
    }
    public static Book fromDto(BookDto bookDto) {
        return new Book(bookDto.getTitle(), bookDto.getIsbn(), bookDto.getVersion());
    }
}
