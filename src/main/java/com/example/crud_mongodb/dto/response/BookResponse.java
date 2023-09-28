package com.example.crud_mongodb.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookResponse {
  private String id;
  private String bookName;
  private String authorName;
}
