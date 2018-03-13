package com.germaine.recureRobot.service;

import com.germaine.recureRobot.entity.User;

import java.util.List;

public interface UserService {
    User getUserByMobile(String mobile);

    public List<User> getUserList();

    public int add(User user);

    public int update(String mobile, User user);

    public int delete(String mobile);
}
