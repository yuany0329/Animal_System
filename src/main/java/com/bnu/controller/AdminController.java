package com.bnu.controller;

import com.bnu.pojo.Product;
import com.bnu.service.AdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService; // 自动注入 AdminService，用于调用业务逻辑方法

    @GetMapping("/adminproduct") // 查询全部商品
    public ModelAndView findAllProducts() {
        List<Product> products = adminService.findAllProducts(); // 调用服务层方法获取全部商品
        ModelAndView mv = new ModelAndView();
        mv.addObject("products", products); // 将商品列表添加到模型中
        mv.setViewName("adminproduct"); // 设置视图名为 adminproduct
        return mv; // 返回 ModelAndView 对象
    }

    @RequestMapping("/adminsearchProductsByStr") // 根据字符串模糊查询商品
    public String searchProductsByStr(@RequestParam(value = "searchStr") String searchStr, Model model) {
        List<Product> products = adminService.searchProductsByStr(searchStr); // 调用服务层方法进行模糊查询
        model.addAttribute("products", products); // 将查询结果添加到模型中
        return "adminproduct"; // 返回视图名为 adminproduct
    }

    @GetMapping("/adminproduct/{id}") // 根据指定编号查询商品
    public ModelAndView findProductById(@PathVariable("id") Integer id) {
        Product product = adminService.findProductById(id); // 调用服务层方法根据 id 查询商品
        ModelAndView mv = new ModelAndView();
        mv.addObject("product", product); // 将商品对象添加到模型中
        mv.setViewName("productdetail"); // 设置视图名为 productdetail
        return mv; // 返回 ModelAndView 对象
    }

    @GetMapping("/addProduct") // 跳转至添加商品页面
    public String addProduct() {
        return "addproduct"; // 返回视图名为 addproduct
    }

    @PostMapping("/addProduct") // 执行添加商品操作
    public ModelAndView addProduct(Product product) {
        adminService.addProduct(product); // 调用服务层方法添加商品
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/adminProductsPage"); // 添加成功后重定向到商品列表页面
        return mv; // 返回 ModelAndView 对象
    }

    @GetMapping("/toupdateproduct/{id}") // 跳转到商品修改页面
    public ModelAndView toUpdateProduct(@PathVariable("id") int id) {
        Product product = adminService.findProductById(id); // 根据 id 查询商品
        ModelAndView mv = new ModelAndView();
        mv.addObject("product", product); // 将商品对象添加到模型中
        mv.setViewName("updateProduct"); // 设置视图名为 updateProduct
        return mv; // 返回 ModelAndView 对象
    }

    @PostMapping("/updateProduct") // 执行修改商品操作
    public ModelAndView updateProduct(Product product) {
        adminService.updateProduct(product); // 调用服务层方法修改商品
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/adminProductsPage"); // 修改成功后重定向到商品列表页面
        return mv; // 返回 ModelAndView 对象
    }

    @GetMapping("/deleteProduct/{id}") // 删除单个商品
    public ModelAndView deleteProduct(@PathVariable("id") int id) {
        adminService.deleteProduct(id); // 调用服务层方法删除商品
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/adminProductsPage"); // 删除成功后重定向到商品列表页面
        return mv; // 返回 ModelAndView 对象
    }

    @GetMapping("/adminProductsPage") // 分页查询商品
    public ModelAndView productsPage(@RequestParam(value = "start", defaultValue = "1") int start,
                                     @RequestParam(value = "size", defaultValue = "4") int size) {
        PageHelper.startPage(start, size, "id asc"); // 配置分页参数，按 id 升序
        List<Product> products = adminService.findAllProducts(); // 获取全部商品
        PageInfo<Product> page = new PageInfo<>(products); // 创建 PageInfo 对象封装分页信息
        ModelAndView mv = new ModelAndView();
        mv.addObject("page", page); // 将分页信息添加到模型中
        mv.setViewName("adminproductPage"); // 设置视图名为 adminproductPage
        return mv; // 返回 ModelAndView 对象
    }

    @GetMapping("/deleteProducts") // 批量删除商品
    public ModelAndView deleteProducts(int[] id) {
        adminService.deleteProducts(id); // 调用服务层方法批量删除商品
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/adminProductsPage"); // 删除成功后重定向到商品列表页面
        return mv; // 返回 ModelAndView 对象
    }
}