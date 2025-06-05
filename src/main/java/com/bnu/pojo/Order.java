package com.bnu.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Order {
    private Integer id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private Integer number;
    private String time;
    private Product product;
}
