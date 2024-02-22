package net.sirdagron.bookstore.services;

import net.sirdagron.bookstore.domain.dto.BookDto;
import net.sirdagron.bookstore.domain.entities.Book;
import net.sirdagron.bookstore.domain.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public UUID createBook(BookDto bookDto) {
        Book book = Book.fromDto(bookDto);
        return bookRepository.save(book).getId();
    }
    public Collection<Book> createBooks(Collection<BookDto> booksDto) {
        Collection<Book> books = booksDto
                .stream()
                .map(Book::fromDto)
                .collect(Collectors.toSet());
        //todo: check for duplicates
        bookRepository.saveAll(books);
        return books;
    }
}
