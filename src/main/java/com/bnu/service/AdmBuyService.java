package com.bnu.service;

import com.bnu.pojo.BuyCustomer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdmBuyService {
    public List<BuyCustomer> findAllcustomers();//查找全部
    public BuyCustomer findCustomerById(Integer id);//根据ID查找
    //    public int insertBuy(Shop shop);//插入购买订单
//    public void addID(Integer id);//把物品ID插入订单表中
    public List<BuyCustomer> searchCustomers(BuyCustomer buyCustomer);//多条件查询
    public List<BuyCustomer> searchBuyerByStr(String searchStr);//全局模糊查询
    public void deleteCustomers(Integer id);
}
