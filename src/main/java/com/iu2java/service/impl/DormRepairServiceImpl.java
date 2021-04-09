package com.iu2java.service.impl;

import com.iu2java.dao.DormRepairDao;
import com.iu2java.pojo.DormRepair;
import com.iu2java.pojo.PageInfo;
import com.iu2java.service.DormRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 1
 */
@Service("dormRepairService")
@Transactional
public class DormRepairServiceImpl implements DormRepairService {

    @Autowired
    DormRepairDao dormRepairDao;

    @Override
    public PageInfo<DormRepair> findPageInfo(Integer d_id, Integer pageIndex, Integer pageSize) {
        PageInfo<DormRepair> pi = new PageInfo<DormRepair>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = dormRepairDao.totalCount(d_id);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //每一页显示宿舍信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<DormRepair> dormRepairList =	dormRepairDao.getDormRepairList(d_id,
                    (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(dormRepairList);
        }
        return pi;
    }

    @Override
    public int deleteByPrimaryKey(Integer r_id) {
        return dormRepairDao.deleteByPrimaryKey(r_id);
    }

    @Override
    public int insert(DormRepair record) {
        return dormRepairDao.insert(record);
    }

    @Override
    public int insertSelective(DormRepair record) {
        return dormRepairDao.insertSelective(record);
    }

    @Override
    public DormRepair selectByPrimaryKey(Integer r_id) {
        return dormRepairDao.selectByPrimaryKey(r_id);
    }

    @Override
    public int updateByPrimaryKeySelective(DormRepair record) {
        return dormRepairDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(DormRepair record) {
        return dormRepairDao.updateByPrimaryKey(record);
    }

    @Override
    public List<DormRepair> getAll() {
        return dormRepairDao.getAll();
    }
}
