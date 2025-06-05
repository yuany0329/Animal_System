package com.bnu.service;

import com.bnu.mapper.BuyMapper;
import com.bnu.mapper.ShopMapper;
import com.bnu.pojo.BuyCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class BuyServiceImpl implements BuyService{
    @Autowired
    private BuyMapper buyMapper;

//    @Override
//    public BuyCustomer findBuyById(Integer id) {
//        return buyMapper.findBuyById(id);
//    }

    @Override
    public void addBuy(BuyCustomer buyCustomer) {
        buyMapper.addBuy(buyCustomer);//添加一条用户购买信息
    }

}
