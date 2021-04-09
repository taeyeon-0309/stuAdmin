package com.iu2java.dao;

import com.iu2java.pojo.Dormitory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DormitoryDao {
    /**
     * 进行分页查询
     */

    //获取总条数
    Integer totalCount(@Param("a_name") String a_name, @Param("s_dormitoryid") Integer s_dormitoryid);
    //获取用户列表
    List<Dormitory> getDormitoryList(@Param("a_name") String a_name, @Param("s_dormitoryid") Integer s_dormitoryid, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

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