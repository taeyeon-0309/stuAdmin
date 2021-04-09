package com.iu2java.dao;

import com.iu2java.pojo.DormRepair;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DormRepairDao {

    /**
     * 进行分页查询
     */

    //获取总条数
    Integer totalCount(@Param("d_id") Integer d_id);
    //获取用户列表
    List<DormRepair> getDormRepairList(@Param("d_id") Integer d_id,  @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    int deleteByPrimaryKey(Integer r_id);

    int insert(DormRepair record);

    int insertSelective(DormRepair record);

    DormRepair selectByPrimaryKey(Integer r_id);

//    DormRepair selectByDid(Integer d_id);

    int updateByPrimaryKeySelective(DormRepair record);

    int updateByPrimaryKey(DormRepair record);

    List<DormRepair> getAll();
}