package net.sirdagron.bookstore;

import net.sirdagron.bookstore.domain.dto.AuthorDto;
import net.sirdagron.bookstore.services.AuthorBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;

import java.util.UUID;

@SpringBootTest
public class AuthorBookServiceTests {
    @Autowired
    private AuthorBookService authorBookService;
    @Test
    public void createAuthorWithoutBooks_thenReturnId() {
        AuthorDto author = new AuthorDto("Bob", "Jones", "Alexander",null);
        UUID authorId = authorBookService.createAuthor(author);
        Assert.notNull(authorId, "Author Id is null");
    }

}
