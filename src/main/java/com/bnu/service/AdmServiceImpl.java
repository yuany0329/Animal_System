package com.bnu.service;

import com.bnu.mapper.AdmMapper;
import com.bnu.pojo.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class AdmServiceImpl implements AdmService{
    @Autowired
    private AdmMapper admMapper;

    @Override
    public List<Shop> AdmfindAllShops() {
        return admMapper.AdmfindAllShops();
    }

    @Override
    public Shop AdmfindShopById(Integer id) {
        return admMapper.AdmfindShopById(id);
    }

    @Override
    public void AdmaddID(Integer id) {
        admMapper.AdmaddID(id);
    }

    @Override
    public List<Shop> AdmsearchShops(Shop shop) {
        return admMapper.AdmsearchShops(shop);
    }

    @Override
    public List<Shop> AdmsearchShopsByStr(String searchStr) {
        return admMapper.AdmsearchShopsByStr(searchStr);
    }

    @Override
    public void AdmaddShop(Shop shop) {
        admMapper.AdmaddShop(shop);
    }

    @Override
    public void deleteShop(Integer id) {
        admMapper.deleteShop(id);
    }

//    @Override
//    public void updateShop(Shop shop) {
//        admMapper.updateShop(shop);
//    }
}
