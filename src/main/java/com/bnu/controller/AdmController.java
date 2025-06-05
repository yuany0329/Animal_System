package com.bnu.controller;

import com.bnu.pojo.Shop; // 导入 Shop 类，用于表示商品信息
import com.bnu.service.AdmService; // 导入 AdmService 类，用于调用管理员相关的业务逻辑
import com.bnu.service.BuyService; // 导入 BuyService 类，但在这段代码中并未使用
import com.github.pagehelper.PageHelper; // 导入 PageHelper 类，用于分页功能
import com.github.pagehelper.PageInfo; // 导入 PageInfo 类，用于封装分页信息
import org.springframework.beans.factory.annotation.Autowired; // 导入 Autowired 注解，用于自动注入依赖
import org.springframework.stereotype.Controller; // 导入 Controller 注解，用于标记该类为控制器
import org.springframework.ui.Model; // 导入 Model 类，用于向视图传递数据
import org.springframework.web.bind.annotation.*; // 导入相关注解，用于处理 HTTP 请求
import org.springframework.web.servlet.ModelAndView; // 导入 ModelAndView 类，用于封装模型和视图

import java.util.List; // 导入 List 类，用于表示集合

@Controller // 标记该类为控制器
public class AdmController {
    @Autowired // 自动注入 AdmService 的实例
    private AdmService admService;

    @GetMapping("/Admshops") // 定义一个 GET 请求的处理器，用于查询全部商品
    public ModelAndView AdmfindAllShops() {
        List<Shop> shops = admService.AdmfindAllShops(); // 调用 AdmService 的方法获取全部商品
        ModelAndView mv = new ModelAndView(); // 创建一个 ModelAndView 对象
        mv.addObject("shops", shops); // 将商品列表添加到模型中
        mv.setViewName("Admshoplist"); // 设置视图名为 Admshoplist
        return mv; // 返回 ModelAndView 对象
    }

    @GetMapping("/Admshop/{id}") // 定义一个 GET 请求的处理器，用于根据指定编号查找商品
    public ModelAndView AdmfindShopById(@PathVariable("id") int id) {
        Shop shop = admService.AdmfindShopById(id); // 调用 AdmService 的方法根据 id 查找商品
        ModelAndView mv = new ModelAndView(); // 创建一个 ModelAndView 对象
        mv.addObject("shop", shop); // 将商品对象添加到模型中
        mv.setViewName("Admshopdetail"); // 设置视图名为 Admshopdetail
        return mv; // 返回 ModelAndView 对象
    }

    @GetMapping("/AdmaddShop") // 定义一个 GET 请求的处理器，用于跳转至添加商品页面
    public String AdmaddShop(){
        return "AdmaddShop"; // 返回视图名为 AdmaddShop
    }

    @PostMapping("/AdmaddShop") // 定义一个 POST 请求的处理器，用于执行添加商品操作
    public ModelAndView AdmaddShop(Shop shop){
        admService.AdmaddShop(shop); // 调用 AdmService 的方法添加商品
        ModelAndView mv=new ModelAndView(); // 创建一个 ModelAndView 对象
        mv.setViewName("redirect:/Admshops"); // 设置重定向到 /Admshops
        return mv; // 返回 ModelAndView 对象
    }

    @GetMapping("/deleteShop/{id}") // 定义一个 GET 请求的处理器，用于删除商品
    public ModelAndView deleteShop(@PathVariable("id") int id){
        admService.deleteShop(id); // 调用 AdmService 的方法删除商品
        ModelAndView mv=new ModelAndView(); // 创建一个 ModelAndView 对象
        mv.setViewName("redirect:/admPage"); // 设置重定向到 /admPage
        return mv; // 返回 ModelAndView 对象
    }

    @GetMapping("/AdmsearchShops") // 定义一个 GET 请求的处理器，用于多条件查询商品
    public ModelAndView AdmsearchShops(Shop shop) {
        List<Shop> shops = admService.AdmsearchShops(shop); // 调用 AdmService 的方法进行多条件查询
        ModelAndView mv = new ModelAndView(); // 创建一个 ModelAndView 对象
        mv.addObject("shops", shops); // 将查询结果添加到模型中
        mv.setViewName("Admshoplist"); // 设置视图名为 Admshoplist
        return mv; // 返回 ModelAndView 对象
    }

    @RequestMapping("/AdmsearchShopsByStr") // 定义一个请求处理器，用于全局模糊查询商品
    public String AdmsearchShopsByStr(@RequestParam(value = "searchStr") String searchStr, Model model) {
        List<Shop> shops = admService.AdmsearchShopsByStr(searchStr); // 调用 AdmService 的方法进行全局模糊查询
        model.addAttribute("shops", shops); // 将查询结果添加到模型中
        return "Admshoplist"; // 返回视图名为 Admshoplist
    }

    @GetMapping("/AdmshopsPage") // 定义一个 GET 请求的处理器，用于分页查询商品
    public ModelAndView AdmshopsPage(@RequestParam(value = "start", defaultValue = "1") int start,
                                     @RequestParam(value = "size", defaultValue = "10") int size) {
        PageHelper.startPage(start, size, "id asc"); // 配置分页参数
        List<Shop> shops = admService.AdmfindAllShops(); // 获取全部商品
        PageInfo<Shop> page = new PageInfo<>(shops); // 创建 PageInfo 对象封装分页信息
        ModelAndView mv = new ModelAndView(); // 创建一个 ModelAndView 对象
        mv.addObject("page", page); // 将 PageInfo 对象添加到模型中
        mv.setViewName("admPage"); // 设置视图名为 admPage
        return mv; // 返回 ModelAndView 对象
    }
}