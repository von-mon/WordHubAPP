package com.tang.controller;

import com.tang.bean.WordBook;
import com.tang.service.BookService;
import com.tang.util.ReturnUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;


/**
 * @author LindaBlack
 */
@Controller
@RequestMapping("/Book")
public class BookController {
    @Autowired
    private BookService service;

    @RequestMapping(value = "/getBook", method = RequestMethod.POST)
    public void getBook(HttpServletResponse response, String id) {
        if (id != null) {
            List<WordBook> book = service.getBook(id);
            response.setContentType("application/json;charset=UTF-8");
            JSONObject json = new JSONObject();
            try (PrintWriter writer = response.getWriter()) {
                json.put("bookInfo", book);
                System.out.println(json.toString());
                writer.write(json.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public void addBook(HttpServletResponse response, String data) {
        if (data != null) {
            JSONObject jsonObject = JSONObject.fromObject(data);
            WordBook book = new WordBook();
            book.setId(jsonObject.getInt("id"));
            book.setWordName(jsonObject.getString("word"));
            book.setWordMeaning(jsonObject.getString("meaning"));
            book.setWordPhonetic(jsonObject.getString("phonetic"));
            service.addBook(book);
            try (PrintWriter writer = response.getWriter()) {
                writer.write("");
                System.out.println("单词本：添加成功");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try (PrintWriter writer = response.getWriter()) {
                writer.write("");
                System.out.println("单词本：添加失败");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(value = "/isBook", method = RequestMethod.POST)
    public void isBook(HttpServletResponse response, String word) {
        if (word != null) {
            Integer book = service.isBook(word);
            if (book >= 1) {
                System.out.println("单词本：已经添加");
                ReturnUtil.getResultCode(response);
            } else {
                JSONObject json = new JSONObject();
                try (PrintWriter writer = response.getWriter()) {
                    json.put("resultCode", 101);
                    System.out.println(json.toString());
                    writer.write(json.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @RequestMapping(value = "/deleteBook",method = RequestMethod.POST)
    public void deleteBook(HttpServletResponse response){
        service.deleteBook();
        try(PrintWriter writer = response.getWriter()) {
            writer.write("");
            System.out.println("单词本:删除成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
