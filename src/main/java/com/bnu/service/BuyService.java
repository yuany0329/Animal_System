package com.bnu.service;

import com.bnu.pojo.BuyCustomer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BuyService {
//    BuyCustomer findBuyById(Integer id);

    public void addBuy(BuyCustomer buyCustomer);//添加一条用户购买信息


}
