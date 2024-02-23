package com.company.bookapi.repository;

import com.company.bookapi.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository <BookEntity, Long> {
}
