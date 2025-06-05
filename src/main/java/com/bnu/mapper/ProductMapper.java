package com.bnu.mapper;

import com.bnu.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    public List<Product> findAllProducts();//查询全部产品
    public Product findProductById(Integer id);//根据ID查询产品
    public List<Product> searchProductsByStr(String searchStr);//全局模糊查询产品
}
