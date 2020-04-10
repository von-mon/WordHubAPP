package com.tang.service.impl;

import com.tang.bean.WordBook;
import com.tang.mapper.BookMapper;
import com.tang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LindaBlack
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper mapper;

    @Override
    public List<WordBook> getBook(String id) {
        return mapper.getBook(id);
    }

    @Override
    public void addBook(WordBook book) {
        mapper.addBook(book);
    }

    @Override
    public Integer isBook(String word) {
        return mapper.isBook(word);
    }

    @Override
    public void deleteBook() {
        mapper.deleteBook();
    }
}
