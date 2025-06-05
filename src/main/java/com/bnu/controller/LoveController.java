package com.bnu.controller;

import com.bnu.pojo.Love;
import com.bnu.service.LoveService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LoveController {
    @Autowired
    private LoveService loveService; // 自动注入 LoveService，用于处理与爱心募捐相关的业务逻辑

    @GetMapping("/loves") // 查询全部记录
    public ModelAndView findAllLoves() {
        List<Love> loves = loveService.findAllLoves(); // 调用 LoveService 的方法获取全部记录
        ModelAndView mv = new ModelAndView();
        mv.addObject("loves", loves); // 将记录列表添加到模型中
        mv.setViewName("lovelist"); // 设置视图名为 lovelist
        return mv; // 返回 ModelAndView 对象
    }

    @GetMapping("/addLove") // 跳转至添加爱心募捐记录的页面
    public String addLove() {
        return "addLove"; // 返回视图名为 addLove
    }

    @PostMapping("/addLove") // 执行添加记录的操作
    public ModelAndView addLove(Love love) {
        loveService.addLove(love); // 调用 LoveService 的方法添加记录
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/loves"); // 添加成功后重定向到记录列表页面
        return mv; // 返回 ModelAndView 对象
    }
}
