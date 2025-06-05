package com.bnu.controller;

import com.bnu.pojo.Post;
import com.bnu.pojo.User;
import com.bnu.service.PostService;
import com.bnu.service.UserService;
import jakarta.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {
    @Autowired
    private PostService postService; // 自动注入 PostService，用于处理帖子相关的业务逻辑

    @Autowired
    private UserService userService; // 自动注入 UserService

    public PostController() {
    }

    @GetMapping({"/posts"}) // 查询全部帖子
    public String listPosts(Model model) {
        List<Post> posts = this.postService.findAll(); // 调用 PostService 的方法获取全部帖子
        model.addAttribute("posts", posts); // 将帖子列表添加到模型中
        return "posts"; // 返回视图名为 posts
    }

    @PostMapping({"/posts"}) // 创建帖子
    public String createPost(@RequestParam String title, // 帖子标题
                             @RequestParam("tag") String tag, // 帖子标签
                             @RequestParam String description, // 帖子描述
                             HttpSession session, // 当前会话
                             Model model) {
        User currentUser = (User)session.getAttribute("currentUser"); // 从会话中获取当前用户
        if (currentUser == null) {
            return "redirect:/login"; // 如果当前用户未登录，重定向到登录页面
        } else {
            Post post = new Post(); // 创建一个新的帖子对象
            post.setTitle(title); // 设置帖子标题
            post.setDescription(description); // 设置帖子描述
            post.setCreateId(currentUser.getId()); // 设置帖子创建者的用户 ID
            post.setCommentCount(0); // 初始化评论数量为 0
            post.setViewCount(0); // 初始化查看数量为 0
            post.setLikeCount(0); // 初始化点赞数量为 0
            post.setTag(tag); // 设置帖子标签
            post.setCreateTime(new Date()); // 设置帖子创建时间为当前时间
            this.postService.save(post); // 调用 PostService 的方法保存帖子
            return "redirect:/posts"; // 创建成功后重定向到帖子列表页面
        }
    }
}