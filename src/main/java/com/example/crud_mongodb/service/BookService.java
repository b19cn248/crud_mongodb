package com.example.crud_mongodb.service;

import com.example.crud_mongodb.dto.request.BookRequest;
import com.example.crud_mongodb.dto.response.BookResponse;

import java.util.List;

public interface BookService {
  BookResponse create(BookRequest bookRequest);

  List<BookResponse> list();

  BookResponse get(String id);
}
