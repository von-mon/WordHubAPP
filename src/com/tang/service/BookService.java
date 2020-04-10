package com.tang.service;

import com.tang.bean.WordBook;

import java.util.List;

/**
 * @author LindaBlack
 */
public interface BookService {

    /**
     * 获取单词本的全部信息
     * @param id 用户id
     * @return list
     */
    List<WordBook> getBook(String id);

    /**
     * 添加单词到单词本
     * @param book 单词本
     */
    void addBook(WordBook book);

    /**
     * 判断是否添加到单词本
     * @param word 单词
     * @return int
     */
    Integer isBook(String word);

    /**
     * 从单词本中删除单词
     */
    void deleteBook();
}
