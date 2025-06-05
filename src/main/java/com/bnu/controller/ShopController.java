package com.bnu.controller;

import com.bnu.pojo.Shop;
import com.bnu.service.ShopService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ShopController {
    @Autowired
    private ShopService shopService; // 自动注入 ShopService，用于处理商品相关的业务逻辑

    @GetMapping("/shops") // 查询全部商品
    public ModelAndView findAllShops() {
        List<Shop> shops = shopService.findAllShops(); // 调用 ShopService 的方法获取全部商品
        ModelAndView mv = new ModelAndView();
        mv.addObject("shops", shops); // 将商品列表添加到模型中
        mv.setViewName("shoplist"); // 设置视图名为 shoplist
        return mv; // 返回 ModelAndView 对象
    }

    @GetMapping("/shop/{id}") // 根据指定编号查找商品
    public ModelAndView findShopById(@PathVariable("id") int id) {
        Shop shop = shopService.findShopById(id); // 调用 ShopService 的方法根据 id 查询商品
        ModelAndView mv = new ModelAndView();
        mv.addObject("shop", shop); // 将商品对象添加到模型中
        mv.setViewName("shopdetail"); // 设置视图名为 shopdetail
        return mv; // 返回 ModelAndView 对象
    }

    @GetMapping("/searchShops") // 多条件查询商品
    public ModelAndView searchShops(Shop shop) {
        List<Shop> shops = shopService.searchShops(shop); // 调用 ShopService 的方法进行多条件查询
        ModelAndView mv = new ModelAndView();
        mv.addObject("shops", shops); // 将查询结果添加到模型中
        mv.setViewName("shoplist"); // 设置视图名为 shoplist
        return mv; // 返回 ModelAndView 对象
    }

    @RequestMapping("/searchShopsByStr") // 全局模糊查询商品
    public String searchShopsByStr(@RequestParam(value = "searchStr") String searchStr, Model model) {
        List<Shop> shops = shopService.searchShopsByStr(searchStr); // 调用 ShopService 的方法进行全局模糊查询
        model.addAttribute("shops", shops); // 将查询结果添加到模型中
        return "shoplist"; // 返回视图名为 shoplist
    }

    @GetMapping("/shopsPage") // 分页查询商品
    public ModelAndView shopsPage(@RequestParam(value = "start", defaultValue = "1") int start,
                                  @RequestParam(value = "size", defaultValue = "10") int size) {
        PageHelper.startPage(start, size, "id asc"); // 配置分页参数，按 id 升序
        List<Shop> shops = shopService.findAllShops(); // 获取全部商品
        PageInfo<Shop> page = new PageInfo<>(shops); // 创建 PageInfo 对象封装分页信息
        ModelAndView mv = new ModelAndView();
        mv.addObject("page", page); // 将分页信息添加到模型中
        mv.setViewName("shopPage"); // 设置视图名为 shopPage
        return mv; // 返回 ModelAndView 对象
    }

    @GetMapping("/admPage") // 管理员页面的分页查询商品
    public ModelAndView admPage(@RequestParam(value = "start", defaultValue = "1") int start,
                                @RequestParam(value = "size", defaultValue = "10") int size) {
        PageHelper.startPage(start, size, "id asc"); // 配置分页参数，按 id 升序
        List<Shop> shops = shopService.findAllShops(); // 获取全部商品
        PageInfo<Shop> page = new PageInfo<>(shops); // 创建 PageInfo 对象封装分页信息
        ModelAndView mv = new ModelAndView();
        mv.addObject("page", page); // 将分页信息添加到模型中
        mv.setViewName("admPage"); // 设置视图名为 admPage
        return mv; // 返回 ModelAndView 对象
    }
}