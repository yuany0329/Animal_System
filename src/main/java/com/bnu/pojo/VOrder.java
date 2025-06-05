package com.bnu.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class VOrder {
    private Integer id;
    private String name;
    private String sex;
    private String Id_Card_Number;
    private String phone;
    private Integer age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date time;
    private String hdid;
}
