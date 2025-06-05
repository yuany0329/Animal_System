package com.bnu.service;

import com.bnu.mapper.VOrderMapper;
import com.bnu.pojo.VOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class VOrderServiceImpl implements VOrderService {
    @Autowired
    private VOrderMapper vorderMapper;

    @Override
    public List<VOrder> findALLOrders() {
        return vorderMapper.findALLOrders();
    }

    @Override
    public void addOrder(VOrder vorder) {
        vorderMapper.addOrder(vorder);
    }

    @Override
    public VOrder findOrderById(Integer id) {
        return vorderMapper.findOrderById(id);
    }

    @Override
    public void updateVOrder(VOrder vorder) {
        vorderMapper.updateOrder(vorder);
    }

    @Override
    public void deleteOrder(Integer id) {
        vorderMapper.deleteOrder(id);
    }

    @Override
    public void deleteOrders(int[] ids) {
        vorderMapper.deleteOrders(ids);
    }

    @Override
    public List<VOrder> searchOrders(VOrder vorder) {
        return vorderMapper.searchOrders(vorder);
    }

    @Override
    public List<VOrder> searchOrdersByStr(String searchStr) {
        return vorderMapper.searchOrdersByStr(searchStr);
    }

}
