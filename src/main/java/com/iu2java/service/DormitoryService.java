package com.iu2java.service;

import com.iu2java.pojo.Dormitory;
import com.iu2java.pojo.PageInfo;

import java.util.List;

public interface DormitoryService {

    //分页查询
    public PageInfo<Dormitory> findPageInfo(String a_name, Integer s_dormitoryid, Integer pageIndex, Integer pageSize);

    int deleteByPrimaryKey(Integer d_id);

    int insert(Dormitory record);

    int insertSelective(Dormitory record);

    Dormitory selectByPrimaryKey(Integer d_id);

    Dormitory selectByKey(Integer s_dormitoryid);

    int updateByPrimaryKeySelective(Dormitory record);

    int updateByPrimaryKey(Dormitory record);

    List<Dormitory> getAll();

    List<Dormitory> findDormitoryStudent(Dormitory dormitory);
}
