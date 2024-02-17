package net.sirdagron.bookstore.domain.repositories;

import net.sirdagron.bookstore.domain.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
}
