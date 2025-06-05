package com.bnu.service;

import com.bnu.pojo.Volunteer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VolunteerService {
    public List<Volunteer> findALLVolunteers();//显示所有志愿者信息

    public Volunteer findVolunteerById(Integer id);//根据id查找志愿者信息

    public void addVolunteer(Volunteer volunteer);//添加志愿者信息

    public void updateVolunteer(Volunteer volunteer);/*修改志愿者信息*/

    public void deleteVolunteer(Integer id);//删除志愿者信息

    public void insertVolunteers(int[] ids);//添加志愿者信息

}
