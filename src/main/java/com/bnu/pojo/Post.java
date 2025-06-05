package com.bnu.pojo;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Date;

@NoArgsConstructor
@EntityScan
@Data
public class Post {
    private Long id;
    private String title;
    private String description;
    private Long createId;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;
    private Date createTime;
    private User user;
}
