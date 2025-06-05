package com.bnu.controller;

import com.bnu.pojo.User;
import com.bnu.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService; // 自动注入UserService，用于处理用户相关的业务逻辑

    public UserController() {
    }

    @GetMapping("/register") // 显示注册表单
    public String showRegisterForm() {
        return "register"; // 返回注册页面的视图名
    }

    @PostMapping("/register") // 处理用户注册
    public String register(User user, Model model) {
        this.userService.register(user); // 调用UserService的register方法进行用户注册
        model.addAttribute("message", "注册成功，欢迎登录!"); // 添加注册成功的消息到模型
        return "login"; // 注册成功后跳转到登录页面
    }

    @GetMapping("/login") // 显示登录表单
    public String showLoginForm() {
        return "login"; // 返回登录页面的视图名
    }

    @PostMapping("/login") // 处理用户登录
    public String login(@RequestParam String username, // 用户名
                        @RequestParam String password, // 密码
                        HttpSession session, // 当前会话
                        Model model) {
        User user = this.userService.login(username, password); // 调用UserService的login方法验证用户
        if (user != null) {
            session.setAttribute("currentUser", user); // 如果用户验证成功，将用户信息存入会话
            return "redirect:/Home"; // 重定向到主页
        } else {
            model.addAttribute("error", "Invalid username or password"); // 如果验证失败，添加错误信息到模型
            return "login"; // 重新显示登录页面
        }
    }

    @GetMapping("/act") // 跳转到活动页面
    public ModelAndView open(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("Activity"); // 设置视图名为Activity
        return mv;
    }

    @GetMapping("/Home") // 跳转到主页
    public String home(){
        return "Home"; // 返回主页的视图名
    }

    // 以下是一系列的页面跳转方法，每个方法都对应一个特定的页面
    @GetMapping("/A")
    public String A(){
        return "A";
    }

    @GetMapping("/B")
    public String B(){
        return "B";
    }

    @GetMapping("/C")
    public String C() {
        return "C";
    }

    @GetMapping("/Panda")
    public String Panda(){
        return "Panda";
    }

    @GetMapping("/byyG")
    public String byyG(){
        return "byyG";
    }

    @GetMapping("/anz")
    public String anz(){
        return "anz";
    }

    @GetMapping("/adminlogin")
    public String adminlogin(){
        return "adminlogin";
    }

    @GetMapping("/Science")
    public String science(){
        return "Science";
    }

    @GetMapping("/monkey")
    public String monkey(){
        return "monkey";
    }

    @GetMapping("/tusun")
    public String tusun(){
        return "tusun";
    }

    @GetMapping("/xuebao")
    public String xuebao(){
        return "xuebao";
    }

    @GetMapping("/zhbht")
    public String zhbht(){
        return "zhbht";
    }

    @GetMapping("/yze")
    public String yze(){
        return "yze";
    }

    @GetMapping("/pd")
    public String pd(){
        return "pd";
    }
}