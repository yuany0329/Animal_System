//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bnu.service;

import com.bnu.pojo.User;

public interface UserService {
    void register(User user);

    User login(String username, String password);

    User findByToken(String token);
}
