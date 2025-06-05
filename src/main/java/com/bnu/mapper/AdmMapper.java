package com.bnu.mapper;

import com.bnu.pojo.Shop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdmMapper {
    public List<Shop> AdmfindAllShops();//查找全部商品
    public Shop AdmfindShopById(Integer id);//根据ID查找商品
    //    public int insertBuy(Shop shop);//插入购买订单
    public void AdmaddID(Integer id);//把物品ID插入订单表中
    public List<Shop> AdmsearchShops(Shop shop);//多条件查询商品
    public List<Shop> AdmsearchShopsByStr(String searchStr);//全局模糊查询图书
    public void AdmaddShop(Shop shop);//添加一本图书
    //    public void updateShop(Shop shop);
    public void deleteShop(Integer id);//删除图书
}
