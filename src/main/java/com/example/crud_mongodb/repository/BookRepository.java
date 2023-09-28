package com.example.crud_mongodb.repository;

import com.example.crud_mongodb.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}
