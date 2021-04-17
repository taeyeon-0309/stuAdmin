package com.iu2java.service.impl;

import com.iu2java.dao.DClassDao;
import com.iu2java.pojo.DClass;
import com.iu2java.pojo.PageInfo;
import com.iu2java.service.DClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户Service接口实现类
 */
@Service("classService")
@Transactional
public class DClassServiceImpl implements DClassService {
	// dcDao
	@Autowired
	private DClassDao dcDao;


	//分页查询
	@Override
	public PageInfo<DClass> findPageInfo(String c_classname, String c_counsellor, Integer c_classid, Integer pageIndex, Integer pageSize) {
		PageInfo<DClass> pi = new PageInfo<DClass>();
		pi.setPageIndex(pageIndex);
		pi.setPageSize(pageSize);
		//获取总条数
		Integer totalCount = dcDao.totalCount(c_classname,c_classid,c_counsellor);
		if (totalCount>0){
			pi.setTotalCount(totalCount);
			//每一页显示班级信息数
			//currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
		List<DClass> classList =	dcDao.getClassList(c_classname,c_classid,c_counsellor,
				     (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
		  pi.setList(classList);
		}
		return pi;
	}

	@Override
	public List<DClass> getAll(){
		List<DClass> classList = dcDao.getAll();
		return  classList;
	}

	//通过id删除班级信息
	@Override
	public int deleteClass(Integer c_id) {
		return dcDao.deleteClass(c_id);
	}

	//添加班级信息
	@Override
	public int addClass(DClass uclass) {
		return dcDao.addClass(uclass);
	}

	@Override
	public DClass findClassById (Integer c_id){
		DClass c = dcDao.findClassById(c_id);
		return  c;
	}
	//修改班级信息
	@Override
	public int updateClass(DClass uclass) {
		return dcDao.updateClass(uclass);
	}

	//查询宿舍人员信息
	@Override
	public List<DClass> findClassStudent(DClass uclass) {
		List<DClass> classStudent = dcDao.findClassStudent(uclass);
		return classStudent;
	}
}
