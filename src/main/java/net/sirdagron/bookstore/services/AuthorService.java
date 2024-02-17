package net.sirdagron.bookstore.services;

import net.sirdagron.bookstore.domain.entities.Author;
import net.sirdagron.bookstore.domain.entities.Book;
import net.sirdagron.bookstore.domain.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public UUID createAuthor(String firstName, String lastName, String middleName)
        throws IllegalStateException {
        //Check if author exists
        boolean authorExists = authorRepository.findAuthorByFirstNameAndLastNameAndMiddleName(
                firstName, lastName, middleName).isPresent();
        if(authorExists) {
            throw new IllegalStateException("Author already exists");
        }
        //Create new author
        Author author = new Author(firstName, lastName, middleName);
        //Save and return the authors new id
        return authorRepository.save(author).getId();
    }
}
