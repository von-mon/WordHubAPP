package com.tang.service.impl;

import com.tang.bean.User;
import com.tang.mapper.UserMapper;
import com.tang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LindaBlack
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public User getUserById(String id) {
        return mapper.getUserById(id);
    }

    @Override
    public User getUserByName(String username) {
        return mapper.getUserByName(username);
    }

    @Override
    public Integer addUser(User user) {
        return mapper.addUser(user);
    }

    @Override
    public User isUser(String username) {
        return mapper.isUser(username);
    }
}
