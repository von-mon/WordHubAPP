package com.tang.service;

import com.tang.bean.Word;

import java.util.List;

/**
 * @author LindaBlack
 */
public interface WordService {

    /**
     * 获取单词全部信息
     *
     * @return list 返回单词集合
     */
    List<Word> getWordInfo();

}
