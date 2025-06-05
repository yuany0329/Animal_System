package com.bnu.mapper;

import com.bnu.pojo.Love;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface LoveMapper {
    public List<Love> findAllLoves();
    public void addLove(Love love);
}
