package com.bnu.service;

import com.bnu.mapper.ShopMapper;
import com.bnu.pojo.BuyCustomer;
import com.bnu.pojo.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class ShopServiceImpl implements ShopService{
    @Autowired
    private ShopMapper shopMapper;

    @Override
    public List<Shop> findAllShops() {
        return shopMapper.findAllShops();
    }

    @Override
    public Shop findShopById(Integer id) {
        return shopMapper.findShopById(id);
    }

    @Override
    public void addID(Integer id) {
        shopMapper.addID(id);//把物品ID插入订单表中
    }

    @Override
    public List<Shop> searchShops(Shop shop) {
        return shopMapper.searchShops(shop);//多条件查询商品
    }

    @Override
    public List<Shop> searchShopsByStr(String searchStr) {
        return shopMapper.searchShopsByStr(searchStr);//全局模糊查询商品
    }
}
