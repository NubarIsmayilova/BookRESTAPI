package com.company.bookapi.service;

import com.company.bookapi.dto.BookDto;
import com.company.bookapi.entity.BookEntity;
import com.company.bookapi.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private  final BookRepository bookRepository;
    private  final ModelMapper modelMapper;


    public List<BookDto> getAll () {
        List<BookEntity> all = bookRepository.findAll();

       return all.stream()
                .map(bookEntity -> modelMapper.map(bookEntity,BookDto.class))
                .collect(Collectors.toList());
    }

    public BookDto getById (Long id) {
        BookEntity bookEntity = bookRepository.findById(id).orElseThrow();
        BookDto map = modelMapper.map(bookEntity, BookDto.class);
         return  map;


    }

    public void create (BookDto bookDto) {
        BookEntity map = modelMapper.map(bookDto, BookEntity.class);
         bookRepository.save(map);


    }

    public void update (Long id, BookDto updatedBook) {
        BookEntity bookEntity = bookRepository.findById(id).orElseThrow();
        modelMapper.map(updatedBook,bookEntity);
        bookRepository.save(bookEntity);


    }

    public void delete (Long id) {
        BookEntity bookEntity = bookRepository.findById(id).orElseThrow();
        bookRepository.delete(bookEntity);
    }








}
