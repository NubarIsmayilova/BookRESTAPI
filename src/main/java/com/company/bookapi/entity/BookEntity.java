package com.company.bookapi.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name= "book")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String bookName;
    private String isbn;
    private  String bookYear;
    private Integer price;
    private  Integer countOfPage;
}
