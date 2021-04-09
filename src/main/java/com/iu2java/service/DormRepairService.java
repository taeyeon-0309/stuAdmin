package com.iu2java.service;



import com.iu2java.pojo.DormRepair;
import com.iu2java.pojo.PageInfo;

import java.util.List;

public interface DormRepairService {

    //分页查询
    PageInfo<DormRepair> findPageInfo(Integer d_id, Integer pageIndex, Integer pageSize);

    int deleteByPrimaryKey(Integer r_id);

    int insert(DormRepair record);

    int insertSelective(DormRepair record);

    DormRepair selectByPrimaryKey(Integer r_id);

    int updateByPrimaryKeySelective(DormRepair record);

    int updateByPrimaryKey(DormRepair record);

    List<DormRepair> getAll();
}
