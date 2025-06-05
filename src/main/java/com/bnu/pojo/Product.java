package com.bnu.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Product {
    private Integer id;
    private String name;
    private String img;
    private String introduction;
    private Double price;
    private Integer pnum;
    private Integer sales;
    private String button;
    private String area;
    private Integer user;
    private List<Order> orderList;//产品对应的订单
}
