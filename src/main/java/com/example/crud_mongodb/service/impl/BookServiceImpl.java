package com.example.crud_mongodb.service.impl;

import com.example.crud_mongodb.dto.request.BookRequest;
import com.example.crud_mongodb.dto.response.BookResponse;
import com.example.crud_mongodb.model.Book;
import com.example.crud_mongodb.repository.BookRepository;
import com.example.crud_mongodb.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

  private final BookRepository repository;

  @Override
  public BookResponse create(BookRequest request) {
    log.info("(create) bookRequest:{}", request);

    Book savedBook = repository.save(new Book(
          UUID.randomUUID().toString(),
          request.getBookName(),
          request.getAuthorName()
    ));

    return toDTO(savedBook);
  }

  @Override
  public List<BookResponse> list() {
    log.info("(list)");

    List<Book> books = repository.findAll();
    List<BookResponse> bookResponses = new ArrayList<>();
    for (Book book: books) bookResponses.add(toDTO(book));

    return bookResponses;
  }

  @Override
  public BookResponse get(String id) {
    log.info("(get) id:{}", id);
    return toDTO(repository.findById(id).orElseThrow());
  }

  private BookResponse toDTO(Book book) {
    return BookResponse.builder()
          .id(book.getId())
          .bookName(book.getBookName())
          .authorName(book.getAuthorName())
          .build();
  }
}
