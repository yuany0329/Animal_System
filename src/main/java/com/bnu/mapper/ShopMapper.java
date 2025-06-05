package com.bnu.mapper;

import com.bnu.pojo.Shop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopMapper {
    public List<Shop> findAllShops();//查找全部商品
    public Shop findShopById(Integer id);//根据ID查找商品
    //    public int insertBuy(Shop shop);//插入购买订单
    public void addID(Integer id);//把物品ID插入订单表中
    public List<Shop> searchShops(Shop shop);//多条件查询商品
    public List<Shop> searchShopsByStr(String searchStr);//全局模糊查询图书

}
