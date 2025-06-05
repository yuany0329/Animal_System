package com.bnu.service;

import com.bnu.pojo.VOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VOrderService {
    public List<VOrder> findALLOrders();//显示所有报名的志愿者信息

    public void addOrder(VOrder vorder);

    public VOrder findOrderById(Integer id);

    public void updateVOrder(VOrder vorder);//修改志愿者信息

    public void deleteOrder(Integer id);

    public void deleteOrders(int[] ids);

    public List<VOrder> searchOrders(VOrder vorder);

    public List<VOrder> searchOrdersByStr(String searchStr);

}
