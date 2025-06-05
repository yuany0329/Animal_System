package com.bnu.pojo;

import lombok.Data;

import java.util.List;

@Data // 使用 Lombok 的 @Data 注解自动生成 getter、setter、toString、equals 和 hashCode 方法
public class BuyCustomer {
    private Integer id; // 购买者的唯一标识符
    private Integer c_id; // 购买者的客户编号
    private String c_name; // 购买者的姓名
    private String c_phone; // 购买者的电话号码
    private String c_address; // 购买者的地址
    private Integer bnum; // 购买数量
    private Integer t_id; // 关联的商品编号
    private List<Shop> shopList; // 购买者关联的商品列表
}
