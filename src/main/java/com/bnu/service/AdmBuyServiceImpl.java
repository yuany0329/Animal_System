package com.bnu.service;

import com.bnu.mapper.AdmBuyMapper;
import com.bnu.pojo.BuyCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class AdmBuyServiceImpl implements AdmBuyService{
    @Autowired
    private AdmBuyMapper admBuyMapper;

    @Override
    public List<BuyCustomer> findAllcustomers() {
        return admBuyMapper.findAllcustomers();
    }

    @Override
    public BuyCustomer findCustomerById(Integer id) {
        return admBuyMapper.findCustomerById(id);
    }

//    @Override
//    public void addID(Integer id) {
//        admBuyMapper.addID(id);
//    }

    @Override
    public List<BuyCustomer> searchCustomers(BuyCustomer buyCustomer) {
        return admBuyMapper.searchCustomers(buyCustomer);
    }

    @Override
    public List<BuyCustomer> searchBuyerByStr(String searchStr) {
        return admBuyMapper.searchBuyerByStr(searchStr);
    }

    @Override
    public void deleteCustomers(Integer id) {
        admBuyMapper.deleteCustomers(id);
    }
}
