package net.sirdagron.bookstore.services;

import net.sirdagron.bookstore.domain.entities.Author;
import net.sirdagron.bookstore.domain.entities.Book;
import net.sirdagron.bookstore.domain.repositories.AuthorRepository;
import net.sirdagron.bookstore.domain.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorBookService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorBookService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }
    public void addBookToAuthor(Book book, Author author)
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
    }
}
