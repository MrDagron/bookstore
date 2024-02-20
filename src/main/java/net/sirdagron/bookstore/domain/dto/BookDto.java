package net.sirdagron.bookstore.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {
    private String title;
    private String isbn;
    private int version;
}
