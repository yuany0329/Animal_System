package com.bnu.controller;

import com.bnu.pojo.BuyCustomer;
import com.bnu.pojo.Shop;
import com.bnu.service.BuyService;
import com.bnu.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BuyController {
    @Autowired
    private BuyService buyService; // 自动注入 BuyService，用于处理购买相关的业务逻辑

    @Autowired
    private ShopService shopService; // 自动注入 ShopService，用于处理商品相关的业务逻辑

    @GetMapping("/addBuy/{id}") // 跳转至购买页面
    public ModelAndView addBuy(@PathVariable("id") String id) {
        Shop shopById = shopService.findShopById(Integer.parseInt(id)); // 根据商品编号查询商品信息
        ModelAndView mv = new ModelAndView();
        mv.addObject("shop", shopById); // 将商品信息添加到模型中
        mv.setViewName("shopbuy"); // 设置视图名为 shopbuy
        return mv; // 返回 ModelAndView 对象
    }

    @PostMapping("/addBuy") // 执行购买操作
    public ModelAndView addBuy(BuyCustomer buyCustomer) {
        buyService.addBuy(buyCustomer); // 调用 BuyService 的方法添加购买记录
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/shops"); // 购买成功后重定向到商品列表页面
        return mv; // 返回 ModelAndView 对象
    }
}

