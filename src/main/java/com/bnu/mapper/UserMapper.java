//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bnu.mapper;

import com.bnu.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void insertUser(User user);

    User findByUsernameAndPassword(String username, String password);
}
