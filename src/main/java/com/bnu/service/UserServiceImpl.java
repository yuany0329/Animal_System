//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bnu.service;

import com.bnu.mapper.UserMapper;
import com.bnu.pojo.User;
import com.bnu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public UserServiceImpl() {
    }

    public void register(User user) {
        this.userMapper.insertUser(user);
    }

    public User login(String username, String password) {
        return this.userMapper.findByUsernameAndPassword(username, password);
    }

    public User findByToken(String token) {
        return null;
    }
}
