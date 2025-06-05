package com.bnu.controller;

import com.bnu.pojo.Order;
import com.bnu.pojo.Product;
import com.bnu.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService; // 自动注入 OrderService，用于处理订单相关的业务逻辑

    @GetMapping("/adminorder") // 查询全部订单
    public ModelAndView findAllOrders() {
        List<Order> orders = orderService.findAllOrders(); // 调用 OrderService 的方法获取全部订单
        ModelAndView mv = new ModelAndView();
        mv.addObject("orders", orders); // 将订单列表添加到模型中
        mv.setViewName("adminorder"); // 设置视图名为 adminorder
        return mv; // 返回 ModelAndView 对象
    }

    @GetMapping("/deleteOrder/{id}") // 删除指定编号的订单
    public ModelAndView deleteOrder(@PathVariable("id") int id) {
        orderService.deleteOrder(id); // 调用 OrderService 的方法删除订单
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/adminorder"); // 删除成功后重定向到订单列表页面
        return mv; // 返回 ModelAndView 对象
    }

    @RequestMapping("/searchOrdersByStr") // 根据字符串模糊查询订单
    public String searchOrdersByStr(@RequestParam(value = "searchStr") String searchStr, Model model) {
        List<Order> orders = orderService.searchOrdersByStr(searchStr); // 调用 OrderService 的方法进行模糊查询
        model.addAttribute("orders", orders); // 将查询结果添加到模型中
        return "adminorder"; // 返回视图名为 adminorder
    }

    @PostMapping("/product/{id}") // 添加订单
    public RedirectView addOrder(Order order) {
        orderService.addOrder(order); // 调用 OrderService 的方法添加订单
        RedirectView redirectView = new RedirectView("/order/" + order.getId()); // 重定向到订单详情页面
        return redirectView; // 返回 RedirectView 对象
    }

    @GetMapping("/order/{id}") // 根据指定编号查询订单
    public ModelAndView findOrderById(@PathVariable("id") Integer id) {
        Order order = orderService.findOrderById(id); // 调用 OrderService 的方法根据 id 查询订单
        ModelAndView mv = new ModelAndView();
        mv.addObject("order", order); // 将订单对象添加到模型中
        mv.setViewName("orderdetail"); // 设置视图名为 orderdetail
        return mv; // 返回 ModelAndView 对象
    }
}