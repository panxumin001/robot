package com.germaine.recureRobot.service.impl;

import com.germaine.recureRobot.entity.User;
import com.germaine.recureRobot.mapper.UserMapper;
import com.germaine.recureRobot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByMobile(Integer mobile) {
        return userMapper.getUserByMobile(mobile);
    }

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public int add(User user) {
        return userMapper.add(user);
    }

    @Override
    public int update(Integer mobile, User user) {
        return userMapper.update(mobile, user);
    }

    @Override
    public int delete(Integer mobile) {
        return userMapper.delete(mobile);
    }
}
