package com.bnu.service;


import com.bnu.pojo.Love;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoveService {
    public List<Love> findAllLoves();
    public void addLove(Love love);
}
