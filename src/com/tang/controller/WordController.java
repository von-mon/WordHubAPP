package com.tang.controller;

import com.tang.bean.Word;
import com.tang.service.WordService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author LindaBlack
 */
@Controller
@RequestMapping("/Word")
public class WordController {

    @Autowired
    private WordService service;

    @RequestMapping(value = "/getWordInfo", method = RequestMethod.POST)
    public void getWordInfo(HttpServletResponse response) {
        List<Word> wordInfo = service.getWordInfo();
        response.setContentType("application/json;charset=UTF-8");
        try {
            PrintWriter writer = response.getWriter();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("wordInfo", wordInfo);
            writer.write(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
