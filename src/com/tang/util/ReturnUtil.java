package com.tang.util;

import com.tang.bean.User;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author LindaBlack
 */

@Component
public class ReturnUtil {

    public void getUserInfo(User user, HttpServletResponse response) {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = null;
        JSONObject json = new JSONObject();
        try {
            writer = response.getWriter();
            if (user != null) {
                json.put("userInfo", user);
                writer.write(json.toString());
                System.out.println("用户信息：" + json.toString());
            } else {
                json.put("userInfo", null);
                System.out.println("用户信息为空");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }

    public static void getResultCode(HttpServletResponse response) {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = null;
        JSONObject json = new JSONObject();
        try {
            writer = response.getWriter();
            json.put("resultCode", 100);
            System.out.println(json.toString());
            writer.write(json.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}
