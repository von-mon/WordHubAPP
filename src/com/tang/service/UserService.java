package com.tang.service;


import com.tang.bean.User;

/**
 * @author LindaBlack
 */

public interface UserService {
    /**
     * 通过用户id，获取用户信息
     *
     * @param id 用户id
     * @return User
     */
    User getUserById(String id);

    /**
     * 根据用户姓名获取用户信息
     *
     * @param username 用户姓名
     * @return User
     */
    User getUserByName(String username);

    /**
     * 添加用户
     *
     * @param user
     * @return bool
     */
    Integer addUser(User user);

    /**
     * 判断是否有此用户
     *
     * @param username
     * @return
     */
    User isUser(String username);
}
