package com.bnu.service;

import com.bnu.mapper.AdminMapper;
import com.bnu.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Product> findAllProducts() {
        return adminMapper.findAllProducts();
    }

    @Override
    public List<Product> searchProductsByStr(String searchStr) {
        return adminMapper.searchProductsByStr(searchStr);
    }

    @Override
    public Product findProductById(Integer id) {
        return adminMapper.findProductById(id);
    }

    @Override
    public void addProduct(Product product) {
        adminMapper.addProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        adminMapper.updateProduct(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        adminMapper.deleteProduct(id);
    }

    @Override
    public void deleteProducts(int[] ids) {
        adminMapper.deleteProducts(ids);
    }
}
