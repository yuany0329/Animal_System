package com.bnu.mapper;

import com.bnu.pojo.BuyCustomer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BuyMapper {
//    BuyCustomer findBuyById(Integer id);

    public void addBuy(BuyCustomer buyCustomer);//添加一条用户购买信息

}
