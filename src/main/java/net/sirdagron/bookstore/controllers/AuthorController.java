package net.sirdagron.bookstore.controllers;

import jakarta.validation.Valid;
import net.sirdagron.bookstore.domain.dto.AuthorDto;
import net.sirdagron.bookstore.domain.entities.Author;
import net.sirdagron.bookstore.services.AuthorBookService;
import net.sirdagron.bookstore.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.UUID;

@Controller
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;
    private final AuthorBookService authorBookService;

    public AuthorController(AuthorService authorService, AuthorBookService authorBookService) {
        this.authorService = authorService;
        this.authorBookService = authorBookService;
    }

    @GetMapping("/api/v1/getAll")
    public Collection<Author> getAll() {
        return authorService.getAllAuthors();
    }
    @PostMapping("/api/v1/create")
    public ResponseEntity<String> create(@Valid @RequestBody AuthorDto author) {
        try {
            return new ResponseEntity<>(authorBookService.createAuthor(author).toString(), HttpStatus.CREATED);
        } catch (IllegalStateException ex) {
            //todo log
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
