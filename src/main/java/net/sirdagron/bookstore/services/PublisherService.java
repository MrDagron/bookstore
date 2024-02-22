package net.sirdagron.bookstore.services;

import lombok.AllArgsConstructor;
import net.sirdagron.bookstore.domain.dto.PublisherDto;
import net.sirdagron.bookstore.domain.entities.Publisher;
import net.sirdagron.bookstore.domain.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class PublisherService {
    private final PublisherRepository publisherRepository;
    public UUID createPublisher(PublisherDto publisherDto) {
        Publisher publisher = Publisher.fromDto(publisherDto);
        return publisherRepository.save(publisher).getId();
    }
}
