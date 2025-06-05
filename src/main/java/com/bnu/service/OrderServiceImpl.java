package com.bnu.service;

import com.bnu.mapper.OrderMapper;
import com.bnu.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> findAllOrders() {
        return orderMapper.findAllOrders();
    }

    @Override
    public void deleteOrder(Integer id) {
        orderMapper.deleteOrder(id);
    }

    @Override
    public List<Order> searchOrdersByStr(String searchStr) {
        return orderMapper.searchOrdersByStr(searchStr);
    }

    @Override
    public Order findOrderById(Integer id) {
        return orderMapper.findOrderById(id);
    }

    @Override
    public void addOrder(Order order) {
        orderMapper.addOrder(order);
    }
}
