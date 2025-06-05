package com.bnu.service;

import com.bnu.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminService {
    public List<Product> findAllProducts();//查询全部产品
    public List<Product> searchProductsByStr(String searchStr);//全局模糊查询产品
    public Product findProductById(Integer id);//根据ID查询产品
    public void addProduct(Product product);//添加一本产品
    public void updateProduct(Product product);//修改产品
    public void deleteProduct(Integer id);//删除产品
    public void deleteProducts(int[] ids);//批量删除产品
}
