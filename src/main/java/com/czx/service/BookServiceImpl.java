package com.czx.service;

import com.czx.entity.Book;
import com.czx.mapper.BookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookMapper bookMapper;

    @Override
    public void saveBook(Book book) {
        bookMapper.saveBook(book);
    }

    @Override
    public List<Book> selectBookList() {
        return bookMapper.selectBookList();
    }

    @Override
    public Book selectBookDetail(Integer id) {
        return bookMapper.selectBookDetail(id);
    }

    @Override
    public void updateBook(Book book) {
        bookMapper.updateBook(book);
    }

    @Override
    public void deleteBook(Integer id) {
        bookMapper.deleteBook(id);
    }
}
