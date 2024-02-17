package net.sirdagron.bookstore.domain.repositories;

import net.sirdagron.bookstore.domain.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PublisherRepository extends JpaRepository<Publisher, UUID> {
}
