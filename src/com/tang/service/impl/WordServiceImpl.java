package com.tang.service.impl;

import com.tang.bean.Word;
import com.tang.mapper.WordMapper;
import com.tang.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LindaBlack
 */
@Service
public class WordServiceImpl implements WordService {

    @Autowired
    private WordMapper mapper;

    @Override
    public List<Word> getWordInfo() {
        return mapper.getWordInfo();
    }
}
