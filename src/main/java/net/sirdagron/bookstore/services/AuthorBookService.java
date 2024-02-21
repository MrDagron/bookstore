package net.sirdagron.bookstore.services;

import net.sirdagron.bookstore.domain.dto.AuthorDto;
import net.sirdagron.bookstore.domain.entities.Author;
import net.sirdagron.bookstore.domain.entities.Book;
import net.sirdagron.bookstore.domain.repositories.AuthorRepository;
import net.sirdagron.bookstore.domain.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
public class AuthorBookService {
    private final AuthorRepository authorRepository;
    private final AuthorService authorService;
    private final BookService bookService;

    public AuthorBookService(AuthorRepository authorRepository, BookService bookService, AuthorService authorService, BookService bookService1) {
        this.authorRepository = authorRepository;
        this.authorService = authorService;
        this.bookService = bookService1;
    }
    public Long createAuthor(AuthorDto author)
            throws IllegalStateException {
        Collection<Book> bookList = null;
        //check if we have books to add
        if(author.getBooks() != null && !author.getBooks().isEmpty()) {
            //delegate book creation to book service
            bookList = bookService.createBooks(author.getBooks());
        }
        return authorService.createAuthor(author.getFirstName(),
                author.getLastName(),
                author.getMiddleName(),
                bookList);
    }
    /*public void addBookToAuthor(Book book, Author author)
            throws IllegalStateException {
        //Check if author already owns the book
        boolean booksExists = author
                .getBooks()
                .stream()
                .anyMatch(b -> b.getId().equals(book.getId()));
        if(booksExists) {
            throw new IllegalStateException("The author already owns this book");
        }
        //Add the book to the author
        author.addBook(book);
        authorRepository.save(author);
        //Add the author to the book
        book.addAuthor(author);
        bookRepository.save(book);
    }
    public void removeBookFromAuthor(Book book, Author author)
            throws IllegalStateException {
        //make sure the book belongs to this author
        boolean bookBelongs = author
                .getBooks()
                .stream()
                .anyMatch(b -> b.getId().equals(book.getId()));
        if(!bookBelongs) {
            throw new IllegalStateException("This author does not own this book");
        }
        //remove the book from the author
        author.removeBook(book);
        authorRepository.save(author);
        //remove the author from the book
        book.removeAuthor(author);
        bookRepository.save(book);
    }*/
}
