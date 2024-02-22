package net.sirdagron.bookstore.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookDto {
    private String title;
    private String isbn;
    private int version;
}
