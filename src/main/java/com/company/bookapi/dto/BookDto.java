package com.company.bookapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {

    private String bookName;
    private String isbn;
    private  String bookYear;
    private Integer price;
    private  Integer countOfPage;

}
