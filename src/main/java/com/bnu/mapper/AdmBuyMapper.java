package com.bnu.mapper;

import com.bnu.pojo.BuyCustomer;
import com.bnu.pojo.Shop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // 标记这是一个 MyBatis 的 Mapper 接口
public interface AdmBuyMapper {
    public List<BuyCustomer> findAllcustomers(); // 查找全部购买者信息
    public BuyCustomer findCustomerById(Integer id); // 根据 ID 查找购买者信息
    //    public int insertBuy(Shop shop); // 插入购买订单
    //    public void addID(Integer id); // 把物品 ID 插入订单表中
    public List<BuyCustomer> searchCustomers(BuyCustomer buyCustomer); // 多条件查询购买者信息
    public List<BuyCustomer> searchBuyerByStr(String searchStr); // 全局模糊查询购买者信息
    public void deleteCustomers(Integer id); // 删除购买者信息
}
