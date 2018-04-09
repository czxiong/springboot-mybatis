package com.czx.service;

import com.czx.entity.Book;

import java.util.List;

public interface BookService {

    void saveBook(Book book);

    List<Book> selectBookList();

    Book selectBookDetail(Integer id);

    void updateBook(Book book);

    void deleteBook(Integer id);

}
