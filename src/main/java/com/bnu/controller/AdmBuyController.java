package com.bnu.controller;

// 导入所需的类
import com.bnu.pojo.BuyCustomer;
import com.bnu.pojo.Shop;
import com.bnu.service.AdmBuyService;
import com.bnu.service.ShopService;
import com.github.pagehelper.PageHelper; // 导入 MyBatis PageHelper 工具类
import com.github.pagehelper.PageInfo; // 导入 PageInfo 类，用于分页显示
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

// 定义控制器类 AdmBuyController，使用 @Controller 注解标注，表明这是一个 Spring MVC 控制器
@Controller
public class AdmBuyController {

    // 使用 @Autowired 注解自动注入 AdmBuyService 服务
    @Autowired
    private AdmBuyService admBuyService;

    // 定义一个 GET 请求处理方法，用于查询全部用户
    @GetMapping("/customers") // 查询全部用户
    public ModelAndView findAllcustomers(){
        List<BuyCustomer> buyCustomers = admBuyService.findAllcustomers(); // 调用服务层方法查询所有用户
        ModelAndView mv = new ModelAndView(); // 创建 ModelAndView 对象
        mv.addObject("buyCustomers", buyCustomers); // 将查询结果添加到模型
        mv.setViewName("AdmBuyerlist"); // 设置视图名称
        return mv; // 返回 ModelAndView 对象
    }

    // 定义一个 GET 请求处理方法，根据指定编号查找用户
    @GetMapping("/customers/{id}") // 根据指定编号查找用户
    public ModelAndView findCustomerById(@PathVariable("id") int id){ // 从路径变量中获取 id 参数
        BuyCustomer buyCustomer = admBuyService.findCustomerById(id); // 调用服务层方法根据 id 查询用户
        ModelAndView mv = new ModelAndView(); // 创建 ModelAndView 对象
        mv.addObject("buyCustomer", buyCustomer); // 将查询结果添加到模型
        mv.setViewName("AdmBuyerlist"); // 设置视图名称
        return mv; // 返回 ModelAndView 对象
    }

    // 定义一个 GET 请求处理方法，用于删除用户
    @GetMapping("/deleteCustomers/{id}") // 删除
    public ModelAndView deleteCustomers(@PathVariable("id") int id){
        admBuyService.deleteCustomers(id); // 调用服务层方法删除用户
        ModelAndView mv = new ModelAndView(); // 创建 ModelAndView 对象
        mv.setViewName("redirect:/BuyerPage"); // 设置视图名称为重定向到列表页面
        return mv; // 返回 ModelAndView 对象
    }

    // 定义一个 GET 请求处理方法，用于多条件查询用户
    @GetMapping("/searchCustomers") // 多条件查询
    public ModelAndView searchCustomers(BuyCustomer buyCustomer){ // 接收查询条件对象
        List<BuyCustomer> buyCustomers = admBuyService.searchCustomers(buyCustomer); // 调用服务层方法查询用户
        ModelAndView mv = new ModelAndView(); // 创建 ModelAndView 对象
        mv.addObject("buyCustomers", buyCustomers); // 将查询结果添加到模型
        mv.setViewName("AdmBuyerlist"); // 设置视图名称
        return mv; // 返回 ModelAndView 对象
    }

    // 定义一个请求处理方法，用于全局模糊查询用户
    @RequestMapping("/searchBuyerByStr") // 全局模糊查询
    public String searchBuyerByStr(@RequestParam(value = "searchStr") String searchStr, Model model){ // 接收搜索字符串参数
        List<BuyCustomer> buyCustomers = admBuyService.searchBuyerByStr(searchStr); // 调用服务层方法查询用户
        model.addAttribute("buyCustomers", buyCustomers); // 将查询结果添加到模型
        return "AdmBuyerlist"; // 返回视图名称
    }

    // 定义一个 GET 请求处理方法，用于分页显示用户
    @GetMapping("/BuyerPage")
    public ModelAndView BuyerPage(@RequestParam(value = "start", defaultValue = "1") int start, // 接收起始页参数，默认为1
                                  @RequestParam(value = "size", defaultValue = "10") int size){ // 接收每页显示条数参数，默认为10
        PageHelper.startPage(start, size, "id asc"); // 使用 PageHelper 工具类进行分页设置
        List<BuyCustomer> buyCustomers = admBuyService.findAllcustomers(); // 调用服务层方法查询所有用户
        PageInfo<BuyCustomer> page = new PageInfo<>(buyCustomers); // 创建 PageInfo 对象，用于分页显示
        ModelAndView mv = new ModelAndView(); // 创建 ModelAndView 对象
        mv.addObject("page", page); // 将分页结果添加到模型
        mv.setViewName("BuyerPage"); // 设置视图名称
        return mv; // 返回 ModelAndView 对象
    }
}
