package net.sirdagron.bookstore;

import net.sirdagron.bookstore.domain.dto.AuthorDto;
import net.sirdagron.bookstore.domain.dto.BookDto;
import net.sirdagron.bookstore.domain.dto.PublisherDto;
import net.sirdagron.bookstore.services.AuthorBookService;
import net.sirdagron.bookstore.services.BookService;
import net.sirdagron.bookstore.services.PublisherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.UUID;
import java.util.regex.Pattern;

@SpringBootTest
public class AuthorBookPublisherTests {
    @Autowired
    private AuthorBookService authorBookService;
    @Autowired
    private BookService bookService;
    @Autowired
    private PublisherService publisherService;
    private final Pattern pattern = Pattern.compile("^0{8}-0{4}-0{4}-0{4}-0{12}$");
    @Test
    public void createAuthorWithoutBooks_thenReturnId() {
        AuthorDto author = new AuthorDto("Bob", "Jones", "Alexander",null);
        UUID authorId = authorBookService.createAuthor(author);
        Assert.isTrue(!pattern.matcher(authorId.toString()).matches(), "Author Id is blank");
    }
    @Test
    public void createBook_thenReturnId() {
        BookDto book = new BookDto("Test Book", "isbn", 1);
        UUID bookId = bookService.createBook(book);
        Assert.isTrue(!pattern.matcher(bookId.toString()).matches(), "Book Id is blank");
    }
    @Test
    public void createPublisher_thenReturnId() {
        PublisherDto publisher = new PublisherDto("Test Publisher Name");
        UUID publisherId = publisherService.createPublisher(publisher);
        Assert.isTrue(!pattern.matcher(publisherId.toString()).matches(), "Publisher Id is blank");
    }
}
