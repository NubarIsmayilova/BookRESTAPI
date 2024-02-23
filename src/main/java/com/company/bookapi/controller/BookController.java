package com.company.bookapi.controller;

import com.company.bookapi.dto.BookDto;
import com.company.bookapi.entity.BookEntity;
import com.company.bookapi.service.BookService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;



    @GetMapping("/get")
    public List<BookDto> get () {
        return bookService.getAll();
    }

    @GetMapping("/get-by-id{id}")
    public BookDto getById (@PathVariable Long id) {
        return bookService.getById(id);
    }

    @PostMapping("/post")
    public ResponseEntity <String>  create (@RequestBody BookDto addedBook) {
        bookService.create(addedBook);
        return  ResponseEntity.ok("Created");
    }

    @PutMapping("/put{id}")
    public ResponseEntity<String> update (@PathVariable Long id, @RequestBody BookDto updated) {
        bookService.update(id, updated);
         return ResponseEntity.ok("Book is updated!");
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<String> delete (@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.ok("Book is deleted!");
    }






}
