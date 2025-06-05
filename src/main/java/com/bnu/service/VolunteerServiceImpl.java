package com.bnu.service;

import com.bnu.mapper.VolunteerMapper;
import com.bnu.pojo.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class VolunteerServiceImpl implements VolunteerService {
    @Autowired
    private VolunteerMapper volunteerMapper;

    @Override
    public List<Volunteer> findALLVolunteers() {//显示所有志愿者信息

        return volunteerMapper.findALLVolunteers();
    }

    @Override
    public Volunteer findVolunteerById(Integer id) {//根据id查找志愿者信息
        return volunteerMapper.findVolunteerById(id);
    }

    @Override
    public void addVolunteer(Volunteer volunteer) {//添加志愿者信息
        volunteerMapper.addVolunteer(volunteer);
    }

    @Override
    public void updateVolunteer(Volunteer volunteer) {//修改志愿者信息
        volunteerMapper.updateVolunteer(volunteer);
    }

    @Override
    public void deleteVolunteer(Integer id) {//删除志愿者信息
        volunteerMapper.deleteVolunteer(id);
    }

    @Override
    public void insertVolunteers(int[] ids) {//批量提交志愿者信息
        volunteerMapper.insertVolunteers(ids);
    }

}
