package com.bnu.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data // 使用 Lombok 的 @Data 注解自动生成 getter、setter、toString、equals 和 hashCode 方法
public class Volunteer {
    private Integer id; // 志愿者的唯一标识符
    private String name; // 志愿者的姓名
    private String sex; // 志愿者的性别
    private String Id_Card_Number; // 志愿者的身份证号码
    private String phone; // 志愿者的电话号码
    private Integer age; // 志愿者的年龄
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 指定日期格式
    private Date time; // 志愿者的注册时间或其他相关时间
    private String hdid; // 志愿者参与的活动编号或其他标识
}