package net.sirdagron.bookstore.domain.repositories;

import net.sirdagron.bookstore.domain.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
}
