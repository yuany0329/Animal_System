//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bnu.service;

import com.bnu.mapper.PostMapper;
import com.bnu.pojo.Post;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostMapper postMapper;

    public PostService() {
    }

    public static Object getPostDetails() {
        return null;
    }

    public List<Post> findAll() {
        return this.postMapper.findAllWithUser();
    }

    public void save(Post post) {
        this.postMapper.insert(post);
    }
}
