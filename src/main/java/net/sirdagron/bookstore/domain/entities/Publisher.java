package net.sirdagron.bookstore.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import net.sirdagron.bookstore.domain.dto.PublisherDto;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.UUIDJdbcType;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name="publisher")
public class Publisher {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name="publisher_name")
    @NotNull
    private String publisherName;
    @OneToMany(mappedBy = "publisher")
    private List<Book> books;
    public static Publisher fromDto(PublisherDto publisherDto) {
        Publisher publisher = new Publisher();
        publisher.setPublisherName(publisherDto.getPublisherName());
        return publisher;
    }
    //todo: more info on publisher
}
