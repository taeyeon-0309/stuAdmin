package com.iu2java.service;


import com.iu2java.pojo.DClass;
import com.iu2java.pojo.PageInfo;

import java.util.List;

/**
 * 用户Service层接口
 */
public interface DClassService {

	//分页查询
	PageInfo<DClass> findPageInfo(String c_classname, String c_counsellor, Integer c_classid, Integer pageIndex, Integer pageSize);

	int deleteClass(Integer c_id);   //删除班级信息
	int addClass(DClass ucalss);    //添加班级信息
	DClass findClassById(Integer c_id);
	int updateClass(DClass uclass); //修改班级信息
	List<DClass> findClassStudent(DClass uclass);//查询班级人员信息
	List<DClass> getAll();
}
