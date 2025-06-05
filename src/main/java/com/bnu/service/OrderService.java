package com.bnu.service;

import com.bnu.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderService {
    public List<Order> findAllOrders();//查询全部订单
    public void deleteOrder(Integer id);//删除订单
    public List<Order> searchOrdersByStr(String searchStr);//全局模糊查询订单
    public Order findOrderById(Integer id);//根据ID查询订单
    public void addOrder(Order order);//添加一个订单
}
