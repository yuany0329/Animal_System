package com.bnu.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@NoArgsConstructor
@EntityScan
@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String headpic;
}
