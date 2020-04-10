package com.tang.controller;

import com.tang.bean.User;
import com.tang.service.UserService;
import com.tang.util.ReturnUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Objects;

/**
 * @author LindaBlack
 */
@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ReturnUtil userInfo;

    /**
     * 通过id获取用户信息
     *
     * @param response
     * @param id
     */
    @RequestMapping(value = "/getUserById", method = RequestMethod.POST)
    public void getUserById(HttpServletResponse response, String id) {
        User user = userService.getUserById(id);
        userInfo.getUserInfo(user, response);
    }

    /**
     * 通过用户名获取用户信息
     *
     * @param response
     * @param username
     */
    @RequestMapping(value = "/getUserByName", method = RequestMethod.POST)
    public void getUserByName(HttpServletResponse response, String username) {
        User user = userService.getUserByName(username);
        userInfo.getUserInfo(user, response);
    }

    /**
     * 添加用户信息
     *
     * @param response
     * @param data
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public void addUser(HttpServletResponse response, String data) {

        if (data != null) {
            JSONObject jsonObject = JSONObject.fromObject(data);
            User user = new User();
            user.setUsername(jsonObject.getString("username"));
            user.setPassword(jsonObject.getString("password"));
            user.setNickname(jsonObject.getString("nickname"));
            user.setEmail(jsonObject.getString("email"));
            Integer integer = userService.addUser(user);
            if(integer >= 1){
                ReturnUtil.getResultCode(response);
            }

        }
    }

    /**
     * 判断用户是否存在
     *
     * @param response
     * @param username
     */
    @RequestMapping(value = "/isUser", method = RequestMethod.POST)
    public void isUser(HttpServletResponse response, String username) {
        User user = userService.isUser(username);
        if (user != null) {
            ReturnUtil.getResultCode(response);
        } else {
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter writer = null;
            JSONObject json = new JSONObject();
            try {
                writer = response.getWriter();
                json.put("resultCode", 101);
                System.out.println(json.toString());
                writer.write(json.toString());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                Objects.requireNonNull(writer).close();
            }
        }
    }

}
