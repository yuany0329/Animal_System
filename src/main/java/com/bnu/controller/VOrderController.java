package com.bnu.controller;
import org.springframework.web.servlet.ModelAndView;
import com.bnu.pojo.VOrder;
import com.bnu.service.VOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VOrderController {
    @Autowired
    private VOrderService orderService; // 自动注入 VOrderService，用于处理志愿者订单相关的业务逻辑

    @GetMapping("/adorder") // 显示所有志愿者订单信息
    public ModelAndView findALLOrders() {
        List<VOrder> orders = orderService.findALLOrders(); // 调用 VOrderService 的方法获取全部订单信息
        ModelAndView mv = new ModelAndView();
        mv.addObject("orders", orders); // 将订单信息列表添加到模型中
        mv.setViewName("adorder"); // 设置视图名为 adorder
        return mv; // 返回 ModelAndView 对象
    }

    @GetMapping("/ordersPage") // 分页显示志愿者订单信息
    public ModelAndView ordersPage(@RequestParam(value = "start", defaultValue = "1") int start,
                                   @RequestParam(value = "size", defaultValue = "5") int size) {
        PageHelper.startPage(start, size, "id asc"); // 配置分页参数，按 id 升序
        List<VOrder> orders = orderService.findALLOrders(); // 获取全部订单信息
        PageInfo<VOrder> page = new PageInfo<>(orders); // 创建 PageInfo 对象封装分页信息
        ModelAndView mv = new ModelAndView();
        mv.addObject("page", page); // 将分页信息添加到模型中
        mv.setViewName("orderPage"); // 设置视图名为 orderPage
        return mv; // 返回 ModelAndView 对象
    }

    @GetMapping("/addOrder") // 跳转到添加志愿者订单信息页面
    public String addOrder() {
        return "addOrder"; // 返回添加志愿者订单信息页面的视图名
    }

    @PostMapping("/addOrder") // 添加志愿者订单信息
    public ModelAndView addOrder(VOrder order) {
        orderService.addOrder(order); // 调用 VOrderService 的方法添加订单信息
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/ordersPage"); // 添加成功后重定向到订单分页页面
        return mv; // 返回 ModelAndView 对象
    }

    @GetMapping("/vorder/{id}") // 根据 id 查找志愿者订单信息
    public ModelAndView findOrderById(@PathVariable("id") int id) {
        VOrder order = orderService.findOrderById(id); // 调用 VOrderService 的方法根据 id 查询订单信息
        ModelAndView mv = new ModelAndView();
        mv.addObject("order", order); // 将订单信息添加到模型中
        mv.setViewName("vorderdetail"); // 设置视图名为 vorderdetail
        return mv; // 返回 ModelAndView 对象
    }

    @GetMapping("/toupdatevorder/{id}") // 跳转到修改志愿者订单信息页面
    public ModelAndView toUpdateOrder(@PathVariable("id") int id) {
        VOrder order = orderService.findOrderById(id); // 根据 id 查询订单信息
        ModelAndView mv = new ModelAndView();
        mv.addObject("order", order); // 将订单信息添加到模型中
        mv.setViewName("updateOrder"); // 设置视图名为 updateOrder
        return mv; // 返回 ModelAndView 对象
    }

    @PostMapping("/updateVOrder") // 修改志愿者订单信息
    public ModelAndView updateOrder(VOrder order) {
        orderService.updateVOrder(order); // 调用 VOrderService 的方法修改订单信息
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/ordersPage"); // 修改成功后重定向到订单分页页面
        return mv; // 返回 ModelAndView 对象
    }

    @GetMapping("/deleteVOrder/{id}") // 删除志愿者订单信息
    public ModelAndView deleteOrder(@PathVariable("id") int id) {
        orderService.deleteOrder(id); // 调用 VOrderService 的方法删除订单信息
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/ordersPage"); // 删除成功后重定向到订单分页页面
        return mv; // 返回 ModelAndView 对象
    }

    @GetMapping("/deleteVOrders") // 批量删除志愿者订单信息
    public ModelAndView deleteOrders(int[] id) {
        orderService.deleteOrders(id); // 调用 VOrderService 的方法批量删除订单信息
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/ordersPage"); // 删除成功后重定向到订单分页页面
        return mv; // 返回 ModelAndView 对象
    }

    @GetMapping("/searchVOrders") // 多条件搜索志愿者订单信息
    public ModelAndView searchOrders(VOrder order) {
        List<VOrder> orders = orderService.searchOrders(order); // 调用 VOrderService 的方法进行多条件搜索
        ModelAndView mv = new ModelAndView();
        mv.addObject("orders", orders); // 将搜索结果添加到模型中
        mv.setViewName("adorder"); // 设置视图名为 adorder
        return mv; // 返回 ModelAndView 对象
    }

    @RequestMapping("/searchVOrdersByStr") // 全局模糊搜索志愿者订单信息
    public String searchOrdersByStr(@RequestParam(value = "searchStr") String searchStr, Model model) {
        List<VOrder> orders = orderService.searchOrdersByStr(searchStr); // 调用 VOrderService 的方法进行全局模糊搜索
        model.addAttribute("orders", orders); // 将搜索结果添加到模型中
        return "adorder"; // 返回视图名为 adorder
    }
}