package com.bnu.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Shop {
    private Integer id;
    private String name;
    private Double price;
    private String introduce;
    private String imgurl;
    private Integer pnum;
    private Integer sales;
    private String zfrom;
    private String category;


}
