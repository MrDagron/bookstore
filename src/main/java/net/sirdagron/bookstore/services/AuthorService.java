package net.sirdagron.bookstore.services;

import jakarta.annotation.Nullable;
import net.sirdagron.bookstore.domain.dto.AuthorDto;
import net.sirdagron.bookstore.domain.entities.Author;
import net.sirdagron.bookstore.domain.entities.Book;
import net.sirdagron.bookstore.domain.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public Collection<Author> getAllAuthors() {
        //todo: pagination
        return authorRepository.findAll();
    }

    public Long createAuthor(String firstName, String lastName, String middleName, @Nullable Collection<Book> books)
        throws IllegalStateException {
        //Check if author exists
        boolean authorExists = authorRepository.findAuthorByFirstNameAndLastNameAndMiddleName(
                firstName, lastName, middleName).isPresent();
        if(authorExists) {
            throw new IllegalStateException("Author already exists");
        }
        //Create new author
        Author author = new Author(firstName, lastName, middleName);
        //If we already have a list of books for this author then we should include them
        if(books != null && !books.isEmpty()) {
            author.setBooks(books.stream().toList());
        }
        //Save and return the authors new id
        return authorRepository.save(author).getId();
    }
}
