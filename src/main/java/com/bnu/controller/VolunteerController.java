package com.bnu.controller;

import com.bnu.pojo.Volunteer;
import com.bnu.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class VolunteerController {
    @Autowired
    private VolunteerService volunteerService; // 自动注入 VolunteerService，用于处理志愿者相关的业务逻辑

    @GetMapping("/volunteers") // 显示所有志愿者信息
    public ModelAndView findALLVolunteers() {
        List<Volunteer> volunteers = volunteerService.findALLVolunteers(); // 调用 VolunteerService 的方法获取全部志愿者信息
        ModelAndView mv = new ModelAndView();
        mv.addObject("volunteers", volunteers); // 将志愿者信息列表添加到模型中
        mv.setViewName("volunteerlist"); // 设置视图名为 volunteerlist
        return mv; // 返回 ModelAndView 对象
    }

    @GetMapping("/volunteer/{id}") // 根据 id 查找志愿者信息
    public ModelAndView findVolunteerById(@PathVariable("id") int id) {
        Volunteer volunteer = volunteerService.findVolunteerById(id); // 调用 VolunteerService 的方法根据 id 查询志愿者信息
        ModelAndView mv = new ModelAndView();
        mv.addObject("volunteer", volunteer); // 将志愿者信息添加到模型中
        mv.setViewName("volunteerdetail"); // 设置视图名为 volunteerdetaile
        return mv; // 返回 ModelAndView 对象
    }

    @GetMapping("/addVolunteer") // 跳转到添加志愿者信息页面
    public String addVolunteer() {
        return "addVolunteer"; // 返回添加志愿者信息页面的视图名
    }

    @PostMapping("/addVolunteer") // 添加志愿者信息
    public ModelAndView addVolunteer(Volunteer volunteer) {
        volunteerService.addVolunteer(volunteer); // 调用 VolunteerService 的方法添加志愿者信息
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/volunteers"); // 添加成功后重定向到志愿者列表页面
        return mv; // 返回 ModelAndView 对象
    }

    @GetMapping("/toupdatevolunteer/{id}") // 跳转到修改志愿者信息页面
    public ModelAndView toUpdateVolunteer(@PathVariable("id") int id) {
        Volunteer volunteer = volunteerService.findVolunteerById(id); // 根据 id 查询志愿者信息
        ModelAndView mv = new ModelAndView();
        mv.addObject("volunteer", volunteer); // 将志愿者信息添加到模型中
        mv.setViewName("updateVolunteer"); // 设置视图名为 updateVolunteer
        return mv; // 返回 ModelAndView 对象
    }

    @PostMapping("/updateVolunteer") // 修改志愿者信息
    public ModelAndView updateVolunteer(Volunteer volunteer) {
        volunteerService.updateVolunteer(volunteer); // 调用 VolunteerService 的方法修改志愿者信息
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/volunteers"); // 修改成功后重定向到志愿者列表页面
        return mv; // 返回 ModelAndView 对象
    }

    @GetMapping("/deleteVolunteer/{id}") // 删除志愿者信息
    public ModelAndView deleteVolunteer(@PathVariable("id") int id) {
        volunteerService.deleteVolunteer(id); // 调用 VolunteerService 的方法删除志愿者信息
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/volunteers"); // 删除成功后重定向到志愿者列表页面
        return mv; // 返回 ModelAndView 对象
    }

    @GetMapping("/insertVolunteers") // 跳转到批量添加志愿者信息页面
    public String insertVolunteers() {
        return "insertVolunteers"; // 返回批量添加志愿者信息页面的视图名
    }

    @PostMapping("/insertVolunteers") // 批量添加志愿者信息
    public ModelAndView insertVolunteers(@RequestParam("ids") String ids) {
        String[] stringArray = ids.split(","); // 将输入的字符串按逗号分割成数组
        int[] id = new int[stringArray.length];

        // 将字符串数组中的每个元素转换为整数
        for (int i = 0; i < stringArray.length; i++) {
            id[i] = Integer.parseInt(stringArray[i].trim());
        }
        volunteerService.insertVolunteers(id); // 调用 VolunteerService 的方法批量添加志愿者信息
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/volunteers"); // 添加成功后重定向到志愿者列表页面
        return mv; // 返回 ModelAndView 对象
    }
}