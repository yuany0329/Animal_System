package com.bnu.service;


import com.bnu.mapper.LoveMapper;
import com.bnu.pojo.Love;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class LoveServiceImpl implements LoveService {

    @Autowired
    private LoveMapper loveMapper;

    @Override
    public List<Love> findAllLoves() {
        return loveMapper.findAllLoves();
    }

    @Override
    public void addLove(Love love) {
        loveMapper.addLove(love);
    }
}

