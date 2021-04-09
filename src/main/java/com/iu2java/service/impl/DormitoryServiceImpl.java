package com.iu2java.service.impl;


import com.iu2java.dao.DormitoryDao;
import com.iu2java.pojo.Dormitory;
import com.iu2java.pojo.PageInfo;
import com.iu2java.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户Service接口实现类
 */
@Service("dormitoryService")
@Transactional
public class DormitoryServiceImpl implements DormitoryService {
	// classDao
	@Autowired
	private DormitoryDao dormitoryDao;


	//分页查询
	@Override
	public PageInfo<Dormitory> findPageInfo(String a_name, Integer s_dormitoryid, Integer pageIndex, Integer pageSize) {
		PageInfo<Dormitory> pi = new PageInfo<Dormitory>();
		pi.setPageIndex(pageIndex);
		pi.setPageSize(pageSize);
		//获取总条数
		Integer totalCount = dormitoryDao.totalCount(a_name,s_dormitoryid);
		if (totalCount>0){
			pi.setTotalCount(totalCount);
			//每一页显示宿舍信息数
			//currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
		List<Dormitory> dormitoryList =	dormitoryDao.getDormitoryList(a_name,s_dormitoryid,
				     (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
		  pi.setList(dormitoryList);
		}
		return pi;
	}

	@Override
	public int deleteByPrimaryKey(Integer d_id) {
		return dormitoryDao.deleteByPrimaryKey(d_id);
	}

	@Override
	public int insert(Dormitory record) {
		return dormitoryDao.insert(record);
	}

	@Override
	public int insertSelective(Dormitory record) {
		return dormitoryDao.insertSelective(record);
	}

	@Override
	public Dormitory selectByPrimaryKey(Integer d_id) {
		return dormitoryDao.selectByPrimaryKey(d_id);
	}

	@Override
	public Dormitory selectByKey(Integer s_dormitoryid) {
		return dormitoryDao.selectByKey(s_dormitoryid);
	}

	@Override
	public int updateByPrimaryKeySelective(Dormitory record) {
		return dormitoryDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Dormitory record) {
		return dormitoryDao.updateByPrimaryKey(record);
	}

	@Override
	public List<Dormitory> getAll() {
		return dormitoryDao.getAll();
	}

	@Override
	public List<Dormitory> findDormitoryStudent(Dormitory dormitory) {
		return dormitoryDao.findDormitoryStudent(dormitory);
	}

}
