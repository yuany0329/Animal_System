package com.bnu.service;

import com.bnu.mapper.ProductMapper;
import com.bnu.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<Product> findAllProducts() {
        return productMapper.findAllProducts();
    }

    @Override
    public Product findProductById(Integer id) {
        return productMapper.findProductById(id);
    }

    @Override
    public List<Product> searchProductsByStr(String searchStr) {
        return productMapper.searchProductsByStr(searchStr);
    }
}
