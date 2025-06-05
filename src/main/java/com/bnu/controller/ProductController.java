package com.bnu.controller;

import com.bnu.pojo.Product;
import com.bnu.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService; // 自动注入 ProductService，用于处理商品相关的业务逻辑

    @GetMapping("/products") // 查询全部商品
    public ModelAndView findAllProducts() {
        List<Product> products = productService.findAllProducts(); // 调用 ProductService 的方法获取全部商品
        ModelAndView mv = new ModelAndView();
        mv.addObject("products", products); // 将商品列表添加到模型中
        mv.setViewName("productlist"); // 设置视图名为 productlist
        return mv; // 返回 ModelAndView 对象
    }

    @GetMapping("/product/{id}") // 根据指定编号查询商品
    public ModelAndView findProductById(@PathVariable("id") Integer id) {
        Product product = productService.findProductById(id); // 调用 ProductService 的方法根据 id 查询商品
        ModelAndView mv = new ModelAndView();
        mv.addObject("product", product); // 将商品对象添加到模型中
        mv.setViewName("productdetail"); // 设置视图名为 productdetail
        return mv; // 返回 ModelAndView 对象
    }

    @RequestMapping("/searchProductsByStr") // 根据字符串模糊查询商品
    public String searchProductsByStr(@RequestParam(value = "searchStr") String searchStr, Model model) {
        List<Product> products = productService.searchProductsByStr(searchStr); // 调用 ProductService 的方法进行模糊查询
        model.addAttribute("products", products); // 将查询结果添加到模型中
        return "productlist"; // 返回视图名为 productlist
    }

    @GetMapping("/productsPage") // 分页查询商品
    public ModelAndView productsPage(@RequestParam(value = "start", defaultValue = "1") int start,
                                     @RequestParam(value = "size", defaultValue = "4") int size) {
        PageHelper.startPage(start, size, "id asc"); // 配置分页参数，按 id 升序
        List<Product> products = productService.findAllProducts(); // 获取全部商品
        PageInfo<Product> page = new PageInfo<>(products); // 创建 PageInfo 对象封装分页信息
        ModelAndView mv = new ModelAndView();
        mv.addObject("page", page); // 将分页信息添加到模型中
        mv.setViewName("productlistPage"); // 设置视图名为 productlistPage
        return mv; // 返回 ModelAndView 对象
    }
}