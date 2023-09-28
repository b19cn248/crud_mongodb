package com.example.crud_mongodb.controller;

import com.example.crud_mongodb.dto.request.BookRequest;
import com.example.crud_mongodb.dto.response.BookResponse;
import com.example.crud_mongodb.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

  private final BookService bookService;

  @PostMapping
  public ResponseEntity<BookResponse> create(@RequestBody BookRequest request) {
    BookResponse createdBook = bookService.create(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
  }

  @GetMapping
  public ResponseEntity<List<BookResponse>> list() {
    return ResponseEntity.ok(bookService.list());
  }

  @GetMapping("/{id}")
  public ResponseEntity<BookResponse> get(@PathVariable String id) {
    return ResponseEntity.ok(bookService.get(id));
  }
}
